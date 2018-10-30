package com.game.tanks;

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
