package com.game.tanks;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

public class EnemyTank02 extends EnemyTanks {
	int direction;
	int lifeValue = 1;
	
	public EnemyTank02(int x, int y, int m, int n) {
		super(x, y, m, n);
		// TODO Auto-generated constructor stub
	}
	
//	��ɫ̹�ˣ������ҽ���
	public EnemyTank02() {
		super(0, 2, 29, 1);
		direction = KeyEvent.VK_S;
		final EnemyTank02 ref = this;
		
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
						ref.move(dirs[ram]);
						direction = reDirection(0,dirs[ram]);
					}
				}
			});
		
		run.start();
	}
	
	
}
