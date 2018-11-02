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
		//红色坦克初始生命值为2，
		//被普通子弹打一次就-1。
		// 特殊子弹攻击值为一次性-3.
		
		direction = KeyEvent.VK_S;
		final EnemyTank03 ref = this;
		
		run = new Thread(new Runnable() {
				@Override
				public void run() {
					while(true){
						try {
							Thread.sleep(1000);
//							每2秒就产生一个新的方向
//							每一秒就产生一个新的移动的动作
//							每移动不了就产生新的方向
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
