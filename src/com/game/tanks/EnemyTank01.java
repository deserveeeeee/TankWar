package com.game.tanks;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

public class EnemyTank01 extends EnemyTanks {
	Rectangle enemy01Rec = new Rectangle(40 , 40);
	int enemy01C;
	
	public EnemyTank01(int x, int y, int m, int n) {
		
//		�з�̹��1:4,4
//		�����������ɣ�������m��n��ֵ
		super(x, y, m , n);
	}
	
	public EnemyTank01() {
		
//		��ɫ̹�ˣ����������
//		�з�̹��1:4,4
//		�����������ɣ�������m��n��ֵ
		super(4, 2, 1 , 1);
		enemy01Rec.setLocation(40*1, 40*1);
		enemy01C = KeyEvent.VK_S;
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
						enemy01Rec = move(dirs[ram]);
//						ref.move(dirs[ram]);
						enemy01C = reDirection(4,dirs[ram]);
//						ref.reDirection(4,dirs[ram]);
//						ref.move(Integer.valueOf(dirs[ram]));
//						int e = Integer.valueOf(dirs[ram]);
					}
				}
			});
		
		run.start();
	}
	
}
