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
	
//	绿色坦克，放在右角落
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
						direction = reDirection(0,dirs[ram]);
					}
				}
			});
		
		run.start();
	}
	
	
}
