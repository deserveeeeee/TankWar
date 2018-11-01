package com.game.tanks;

import java.awt.event.KeyEvent;
import java.util.Random;


public class EnemyTank01 extends EnemyTanks {

	public EnemyTank01(int x, int y, int m, int n) {
		super(x, y, m, n);
		lifeValue = 0;
		//灰色坦克生命值为0，被普通子弹打一次就完蛋了。
		// 特殊子弹攻击值为一次性-3.
//		EnemyTanks.enemyTanks[0] = this;
		
		direction = KeyEvent.VK_S;
		final EnemyTank01 ref = this;
		
		Thread run = new Thread(new Runnable() {
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
