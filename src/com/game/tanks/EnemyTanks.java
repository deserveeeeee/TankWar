package com.game.tanks;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import com.game.map.DataCenter;

public abstract class EnemyTanks extends AllTanks {
// ������level�ĵз�̹��
// ��ͬ��ɫ��ͼƬ
//	��ͬ�ĵص㣺���߶���level01��̹�ˣ��м���level02��7������level03��3������
//	�з�̹��1:4,4
//	�з�̹��2:0,4
//	�з�̹��3:6,4
//	�����������ɣ�������m��n��ֵ
//	x��y�����СͼƬ�ڴ�ͼƬ���������λ��
//	m��n�����JLable��λ��
	public EnemyTanks(int x, int y, int m , int n){
		this.setBounds(40*m, 40*n, 40, 40);
		this.setIcon(new ImageIcon(DataCenter.getEnemyTankImage(x, y+4)));
	}
	
	
	void move(int e){
		Rectangle c = this.getBounds();
		if (e == KeyEvent.VK_W) {  //w��ǰ��
			c.y -= 40;
		}
		if (e == KeyEvent.VK_S) {  //S�Ǻ���
			c.y += 40;
		}
		if (e == KeyEvent.VK_A) {  //A������
			c.x -= 40;
		}
		if (e == KeyEvent.VK_D) {  //D������
			c.x += 40;
		}
		
		if(DataCenter.map[c.y/40][c.x/40] == 5 || DataCenter.map[c.y/40][c.x/40] == -1){
			this.setBounds(c);
		}
	}
	
	void reDirection(int e){
		int b = 0 ;
		if (e == KeyEvent.VK_W) {  //w��ǰ��
			b = 0;
		}
		if (e == KeyEvent.VK_S) {  //S�Ǻ���
			b = 2;
		}
		if (e == KeyEvent.VK_A) {  //A������
			b = 3;
		}
		if (e == KeyEvent.VK_D) {  //D������
			b = 1;
		}
		
		this.setIcon(new ImageIcon(DataCenter.getEnemyTankImage(0, b)));
	}
}
