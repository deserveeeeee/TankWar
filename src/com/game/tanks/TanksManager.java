package com.game.tanks;


import java.util.Random;
import java.util.Vector;

import com.game.bullet.AllBullets;
import com.game.ui.GameWin;
import com.game.ui.MainPanel;


public class TanksManager {
//	我只有这么一个我方坦克的对象
	public static MineTank mineTank;
	
//	改动六，设计一个数组里面装有敌方坦克的图片截取情况和初始化位置情况（这个可以游戏设计者在后台进行修改和设置）
	private static int[][] enemyTanksData = {
			{4,	2,	1,	1},
			{0,	2,	29,	1},
			{6,	2,	15,	1},
			{4,	2,	12,	1},
			{4,	2,	1,	1},
			{4,	2,	29,	8},
			{4,	2,	2,	4},
			{4,	2,	5,	1},
			{4,	2,	1,	1},
			{0,	2,	7,	3},
			{4,	2,	1,	1},
			{0,	2,	29,	1},
			{4,	2,	5,	2},
			{4,	2,	19,	2},
			{4,	2,	20,	1},
			{4,	2,	1,	1},
			{0,	2,	21,	7},
			{0,	2,	19,	2},
			{6,	2,	29,	1},
			{6,	2,	23,	4},

	};
	
//	随机产生一个坦克
	private EnemyTanks createRamEnemyTanks(){
		int i = new Random().nextInt(20);
//			j即列数为第一列（下标为0）的时候，得到的是它的不同Level的坦克
			switch (enemyTanksData[i][0]) {
			case 4:   //灰色坦克
				EnemyTanks xEnemyTank1 = new EnemyTank01(enemyTanksData[i][0],enemyTanksData[i][1],enemyTanksData[i][2],enemyTanksData[i][3]);
				return xEnemyTank1;
			case 0:   //绿色坦克
				EnemyTanks xEnemyTank2 = new EnemyTank02(enemyTanksData[i][0],enemyTanksData[i][1],enemyTanksData[i][2],enemyTanksData[i][3]);
				return xEnemyTank2;
			case 6:    //红色坦克
				EnemyTanks xEnemyTank3 = new EnemyTank03(enemyTanksData[i][0],enemyTanksData[i][1],enemyTanksData[i][2],enemyTanksData[i][3]);
				return xEnemyTank3;
		}
			return null;
	}
	

//	每一个坦克管理类里面的坦克数量
	int enemyTanksSum;
//	这个坦克管理类里面装的坦克们
	public Vector<EnemyTanks> enemyTanks = new Vector<>();
	
//	这个类的三个坦克管理类的对象
	public static TanksManager tanksManager1;
	public static TanksManager tanksManager2;
	public static TanksManager tanksManager3;
//	总的坦克管理类的数量
	public static int TanksManagerNum = 3;
	
	
//  构造方法→构造方法就是创建一个随机的敌方坦克
	public TanksManager(){
		this.enemyTanksSum = 7;
	} 
	
//	制造坦克
	public void createAdd(){
//		随机新建一个
		EnemyTanks xEnemyTanks = this.createRamEnemyTanks();
//		放到地图上
		MainPanel.getInstance().add(xEnemyTanks);
//		放入数组
		this.enemyTanks.add(xEnemyTanks);
//		剩余的敌方坦克少一个
		enemyTanksSum --;
//		如果剩余坦克数量用完了，这个坦克制造类就没有了
		if (enemyTanksSum <= 0) {
			TanksManagerNum --;
		}
	}
	
//	改动九：制造死亡事件
	public void dead(EnemyTanks x,AllBullets y){
//		移除这个坦克
		x.alive = false;
		MainPanel.getInstance().remove(x);
//		移除这个子弹
		MainPanel.getInstance().remove(y);
		MainPanel.getInstance().repaint();
//		再移除Vector里面装的这个敌方坦克对象
		this.enemyTanks.remove(x);
		System.out.println("我被移除掉了");
		
		if (enemyTanksSum > 0) {
//			如果还有坦克数量可以使用，那么就创建一个。
			this.createAdd();
		}else if (TanksManagerNum <= 0) {
//			如果要是敌方坦克类没有了，那么就可以结束游戏了。
			GameWin.getInstance().floatPic();
		}
		
		
//		Thread wait = new Thread(new Runnable() {
//			public void run() {
////				等0.5秒再判断是否产生新的坦克
//				try {
//					Thread.sleep(50);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				if(enemyTanksSum <= 20){
//					MainPanel.getInstance().add(createRamEnemyTanks());
//					System.out.println("我又出生了");
//					enemyTanksSum ++;
//				}else if(enemyTanksSum > 20 && enemyTanks.size() <= 0) {
////					todo-list：这个需求并没有成功设置好。
////					如果敌方坦克没有了 且 数组里面也没有敌方坦克了。
//					GameWin.getInstance().floatPic();
//				}
//			}
//		});
	}
}
