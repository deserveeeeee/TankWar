 package com.game.tanks;

import java.util.Random;

public class EnemyTank03 extends EnemyTanks {

	public EnemyTank03(int x, int y, int m, int n) {
		super(x, y, m, n);
		// TODO Auto-generated constructor stub
	}
//	��ɫ̹�ˣ������м�
	public EnemyTank03() {
		super(6, 2, 15, 1);
		
		final EnemyTank03 ref = this;
		
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
						ref.reDirection(6,dirs[ram]);
//						ref.move(Integer.valueOf(dirs[ram]));
//						int e = Integer.valueOf(dirs[ram]);
					}
				}
			});
		
		run.start();
	}

}
