package com.game.tanks;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.game.bullet.AllBullets;
import com.game.bullet.EnemyBullets;
import com.game.bullet.MineBullets;
import com.game.ui.DataCenter;
import com.game.ui.GameWin;
import com.game.ui.MainPanel;

public abstract class EnemyTanks extends AllTanks {
	public int lifeValue;
	public int direction;
	boolean alive;
	Thread run;
	
	public EnemyTanks(int x, int y, int m , int n){
		this.setBounds(40*m, 40*n, 40, 40);
		this.setIcon(new ImageIcon(DataCenter.getEnemyTankImage(x, y)));
		this.alive = true;
		
//		�Ķ�һ�����������ʱ��Ͱ�����Ž�ȥ
//		Rectangle c = this.getBounds();
//		EnemyTanksManager.enemyTanksLocations.put(c, this);
//		TanksManager.enemyTanks.add(this);
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
////			�Ķ�������λ�óɹ������仯�Ժ��
////			���Ƴ�ԭλ�ã�ԭ���������
////			EnemyTanksManager.enemyTanksLocations.remove(this.getBounds(), this);
//			TanksManager.enemyTanks.remove(this);
////			�ٰ��µ�λ�ã�ԭ����װ��ȥ
////			EnemyTanksManager.enemyTanksLocations.put(c, this);
//			TanksManager.enemyTanks.add(this);
			
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
	
	void shoot(){
		AllBullets xAllBullets = new EnemyBullets(this.getBounds(), this.direction);
		MainPanel.getInstance().add(xAllBullets);
	}
	
	
////	�Ķ��ţ����������¼�
//	public void dead(){
////		����ͼ�Ͻ����Ƴ�
//		MainPanel.getInstance().remove(this);
//		this.alive = false;
//		MainPanel.getInstance().repaint();
////		���Ƴ����map�ж�Ӧ�ļ�ֵ��
//		TanksManager.enemyTanks.remove(this);
//		System.out.println("�ұ��Ƴ�����");
////		�ж��Ƿ���Ҫ�����µ�̹��
//		if(TanksManager.enemyTanksSum <= 20){
//			TanksManager.enemyTanksSum
//			MainPanel.getInstance().add(createRamEnemyTanks());
//			System.out.println("���ֳ�����");
//			TanksManager.enemyTanksSum ++;
//		}else if(TanksManager.enemyTanksSum > 20 /*&& enemyTanks.size() <= 0*/) {
////			todo-list���������û�гɹ����úá�
////			����з�̹��û���� �� ��������Ҳû�ез�̹���ˡ�
//			GameWin.getInstance().floatPic();
//		}
//	}
}
