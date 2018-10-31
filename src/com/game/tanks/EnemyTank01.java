package com.game.tanks;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

import com.game.ui.MainPanel;

public class EnemyTank01 extends EnemyTanks {
	int direction;
	int lifeValue = 0;   //��ɫ̹������ֵΪ0������ͨ�ӵ���һ�ξ��군�ˡ�
						// �����ӵ�����ֵΪһ����-3.
	
	public EnemyTank01(int x, int y, int m, int n) {
		
//		�з�̹��1:4,4
//		�����������ɣ�������m��n��ֵ
		super(x, y, m , n);
	}
	
	public EnemyTank01() {
		
//		��ɫ̹�ˣ����������
//		�з�̹��1:4,4
//		�����������ɣ�������m��n��ֵ
		super(4, 2, 1 , 1);
//		EnemyTanks.enemyTanks[0] = this;
		
		direction = KeyEvent.VK_S;
		final EnemyTank01 ref = this;
		
		Thread run = new Thread(new Runnable() {
				@Override
				public void run() {
					while(true){
						try {
							Thread.sleep(1000);
//							ÿ2��Ͳ���һ���µķ���
//							ÿһ��Ͳ���һ���µ��ƶ��Ķ���
//							ÿ�ƶ����˾Ͳ����µķ���
//							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						int ram = new Random().nextInt(4);
						char [] dirs = {'W','A','S','D'};
						direction = reDirection(4,dirs[ram]);
					}
				}
			});
		
		run.start();
		
		
		
		/*
		Thread killed = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					if (ref.lifeValue < 0) {
						ref.dead();
					}
				}
				
			}
		});
		
		killed.start();
		*/
	}
	
	@Override
	void dead(){
		MainPanel.getInstance().remove(this);
		MainPanel.getInstance().repaint();
//		EnemyTanks.enemyTanks[0] = null;
	}
	
}
