package com.game.tanks;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

import com.game.bullet.AllBullets;
import com.game.ui.MainPanel;


public class EnemyTanksManager {
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
	private static EnemyTanks createRamEnemyTanks(){
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
	

//	剩余的敌方坦克数量
	static int enemyTanksSum = 17;
	public static Vector<EnemyTanks> enemyTanks = new Vector<>();
	
//  构造方法
	public EnemyTanksManager(){} 
	
//	改动九：制造死亡事件
	
	public static void dead(EnemyTanks x,AllBullets y){
//		让MainPanel里面这个被移除，然后刷新页面
		MainPanel.getInstance().remove(x);
		MainPanel.getInstance().remove(y);
		MainPanel.getInstance().repaint();
//		再移除这个map中对应的键值对
//		enemyTanksLocations.remove(x);
//		再移除Vector里面装的这个敌方坦克对象
		enemyTanks.remove(x);
		System.out.println("我被移除掉了");
		enemyTanksSum --;
//		System.out.println(enemyTanksSum);
		x.alive = false;
		if(enemyTanksSum > 0){
			MainPanel.getInstance().add(createRamEnemyTanks());
			System.out.println("我又出生了");
		}
		
	}
	

}
