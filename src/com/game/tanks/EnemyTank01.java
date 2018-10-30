package com.game.tanks;

import java.util.Random;

public class EnemyTank01 extends EnemyTanks {

	public EnemyTank01(int x, int y, int m, int n) {
		
//		敌方坦克1:4,4
//		如果是随机生成，则设置m和n的值
		super(x, y, m , n);
	}
	
	public EnemyTank01() {
		
//		敌方坦克1:4,4
//		如果是随机生成，则设置m和n的值
		super(4, 2, 1 , 1);
		reDirection();
	}
	
	public void reDirection(){   //每三秒就产生一个新的方向
		final EnemyTank01 ref = this;
		
		Thread run = new Thread(new Runnable() {
				@Override
				public void run() {
					while(true){
						try {
							Thread.sleep(2000);
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
						ref.move(Integer.valueOf(dirs[ram]));
//						int e = Integer.valueOf(dirs[ram]);
					}
				}
			});
	}
	
}
