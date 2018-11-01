package com.game.tanks;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.game.ui.DataCenter;
import com.game.ui.MainPanel;

public abstract class EnemyTanks extends AllTanks {
	public int lifeValue;
	public int direction;
	
	public EnemyTanks(int x, int y, int m , int n){
		this.setBounds(40*m, 40*n, 40, 40);
		this.setIcon(new ImageIcon(DataCenter.getEnemyTankImage(x, y)));
		
//		�Ķ�һ�����������ʱ��Ͱ�����Ž�ȥ
		Rectangle c = this.getBounds();
		EnemyTanksManager.enemyTanksLocations.put(c, this);
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
//			�Ķ�������λ�óɹ������仯�Ժ��
//			���Ƴ�ԭλ�ã�ԭ���������
			EnemyTanksManager.enemyTanksLocations.remove(this.getBounds(), this);
//			�ٰ��µ�λ�ã�ԭ����װ��ȥ
			EnemyTanksManager.enemyTanksLocations.put(c, this);
			
//			��λ�ø��£���λ�ơ�
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
}
