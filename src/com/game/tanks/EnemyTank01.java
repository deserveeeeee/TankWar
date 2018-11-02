package com.game.tanks;

import java.awt.event.KeyEvent;
import java.util.Random;

import com.game.bullet.AllBullets;
import com.game.bullet.EnemyBullets;
import com.game.ui.MainPanel;


public class EnemyTank01 extends EnemyTanks {

	public EnemyTank01(int x, int y, int m, int n) {
		super(x, y, m, n);
		lifeValue = 0;
		//��ɫ̹������ֵΪ0������ͨ�ӵ���һ�ξ��군�ˡ�
		// �����ӵ�����ֵΪһ����-3.
//		EnemyTanks.enemyTanks[0] = this;
		
		direction = KeyEvent.VK_S;
		final EnemyTank01 ref = this;
		
		run = new Thread(new Runnable() {
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
							break;
						}
						
						int ram = new Random().nextInt(4);
						char [] dirs = {'W','A','S','D'};
						ref.move(dirs[ram]);
						direction = reDirection(4,dirs[ram]);
						
						if (ref.alive) {
							ram = new Random().nextInt(2);
							if (ram == 1) {
								ref.shoot();
							}
						}else{
							run.interrupt();
							break;
						}
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
