package com.game.tanks;

import java.awt.event.KeyEvent;
import java.util.Random;


public class EnemyTank01 extends EnemyTanks {

	public EnemyTank01(int x, int y, int m, int n) {
		super(x, y, m, n);
		lifeValue = 0;
		//��ɫ̹������ֵΪ0������ͨ�ӵ���һ�ξ��군�ˡ�
		// �����ӵ�����ֵΪһ����-3.
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
						ref.move(dirs[ram]);
						direction = reDirection(4,dirs[ram]);
					}
				}
			});
		
		run.start();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

}
