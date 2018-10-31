 package com.game.tanks;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

public class EnemyTank03 extends EnemyTanks {
	Rectangle enemy03Rec = new Rectangle(40 , 40);
	int enemy03C;

	public EnemyTank03(int x, int y, int m, int n) {
		super(x, y, m, n);
		// TODO Auto-generated constructor stub
	}
//	红色坦克，放在中间
	public EnemyTank03() {
		super(6, 2, 15, 1);
		enemy03Rec.setLocation(40*15, 40*1);
		enemy03C = KeyEvent.VK_S;
		final EnemyTank03 ref = this;
		
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
						enemy03Rec = move(dirs[ram]);
						enemy03C = reDirection(6,dirs[ram]);
//						ref.move(dirs[ram]);
//						ref.reDirection(6,dirs[ram]);
//						ref.move(Integer.valueOf(dirs[ram]));
//						int e = Integer.valueOf(dirs[ram]);
					}
				}
			});
		
		run.start();
	}

}
