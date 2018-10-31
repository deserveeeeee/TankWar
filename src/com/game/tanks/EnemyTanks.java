package com.game.tanks;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.game.ui.DataCenter;
import com.game.ui.MainPanel;

public abstract class EnemyTanks extends AllTanks {
	public int lifevalue;
// ������level�ĵз�̹��
// ��ͬ��ɫ��ͼƬ
//	��ͬ�ĵص㣺���߶���level01��̹�ˣ��м���level02��7������level03��3������
//	�з�̹��1:4,4
//	�з�̹��2:0,4
//	�з�̹��3:6,4
//	�����������ɣ�������m��n��ֵ
//	x��y�����СͼƬ�ڴ�ͼƬ���������λ��
//	m��n�����JLable��λ��
//	public static EnemyTanks [] enemyTanks = new  EnemyTanks [3];
	public EnemyTanks(int x, int y, int m , int n){
		this.setBounds(40*m, 40*n, 40, 40);
		this.setIcon(new ImageIcon(DataCenter.getEnemyTankImage(x, y)));
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
	
	int reDirection(int a,int e){
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
		
		this.setIcon(new ImageIcon(DataCenter.getEnemyTankImage(a, b)));
		return e;
	}
	
	
	void dead(){
		MainPanel.getInstance().remove(this);
		MainPanel.getInstance().repaint();
	}
}
