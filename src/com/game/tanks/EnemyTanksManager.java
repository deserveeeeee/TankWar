package com.game.tanks;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.game.ui.MainPanel;


public class EnemyTanksManager {

//	最重要的逻辑是：如何让一个坦克的死亡导致另外一个坦克的产生？
//	设置一个静态下标数，每次下标数+1，就会让mainPaneladd一个JLable，而这个JLable对象是早就预设好了的（游戏设计者也可以在后台改）
	
	
	/*  这是实时监控坦克对象们的生命值，让它们生命值小于零，就会造成死亡事件
	Thread killed = new Thread(new Runnable() {
		
		@Override
		public void run() {
			while(true){
				if (ref.lifeValue < 0) {
					ref.dead();
				}
			}
			
		}
	});
	
	killed.start();
	*/
	
	

//	改动四：
//  敌方坦克们的对象和初始位置的数组
	public static ArrayList<EnemyTanks> enemyTanks = new ArrayList<EnemyTanks>();

//	改动六，设计一个数组里面装有敌方坦克的图片截取情况和初始化位置情况（这个可以游戏设计者在后台进行修改和设置）
	private static int[][] enemyTanksData = {
			{4,	2,	1,	1},
			{0,	2,	29,	1},
			{6,	2,	15,	1},
	};
	
//	改动八：把所有的对象建立好，并且放进对象数组里面
	private static void createAllEnemyTanks(){
		for (int i = 0; i < enemyTanksData.length; i++) {
//			j即列数为第一列（下标为0）的时候，得到的是它的不同类型颜色的坦克
			switch (enemyTanksData[i][0]) {
			case 4:   //灰色坦克
				EnemyTanks xEnemyTank1 = new EnemyTank01(enemyTanksData[i][0],enemyTanksData[i][1],enemyTanksData[i][2],enemyTanksData[i][3]);
				enemyTanks.add(xEnemyTank1);
				break;
			case 0:   //绿色坦克
				EnemyTanks xEnemyTank2 = new EnemyTank02(enemyTanksData[i][0],enemyTanksData[i][1],enemyTanksData[i][2],enemyTanksData[i][3]);
				enemyTanks.add(xEnemyTank2);
				break;
			case 6:    //红色坦克
				EnemyTanks xEnemyTank3 = new EnemyTank03(enemyTanksData[i][0],enemyTanksData[i][1],enemyTanksData[i][2],enemyTanksData[i][3]);
				enemyTanks.add(xEnemyTank3);
				break;
			}

		}
	}
	

//	改动八：当前对象的数组下标数
	int enemyTanksScript;
	public static Map<Rectangle, EnemyTanks> enemyTanksLocations = new HashMap<Rectangle, EnemyTanks>();
	
//  构造方法
	public EnemyTanksManager(){
//		改动七：所有敌方的数据数组，准备好所有的对方坦克对象
		createAllEnemyTanks();
		enemyTanksScript = 3;
	}
	
//	改动九：制造死亡事件
	
	public static void dead(EnemyTanks x){
//		让MainPanel里面这个被移除，然后刷新页面
		MainPanel.getInstance().remove(x);
		MainPanel.getInstance().repaint();
//		再移除这个map中对应的键值对
		enemyTanksLocations.remove(x);
	}
	

}
