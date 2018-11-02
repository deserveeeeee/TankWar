 package com.game.tanks;

import java.awt.event.KeyEvent;
import java.util.Random;

import com.game.bullet.AllBullets;
import com.game.bullet.EnemyBullets;
import com.game.ui.MainPanel;


public class EnemyTank03 extends EnemyTanks {

	public EnemyTank03(int x, int y, int m, int n) {
		super(x, y, m, n);
		lifeValue = 2;
		//��ɫ̹�˳�ʼ����ֵΪ2��
		//����ͨ�ӵ���һ�ξ�-1��
		// �����ӵ�����ֵΪһ����-3.
		
		direction = KeyEvent.VK_S;
		final EnemyTank03 ref = this;
		
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
						direction = reDirection(6,dirs[ram]);
						
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
