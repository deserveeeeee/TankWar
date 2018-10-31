package com.game.bullet;

import java.awt.Rectangle;

import com.game.tanks.EnemyTank01;
import com.game.tanks.EnemyTanks;
import com.game.ui.DataCenter;
import com.game.ui.MainPanel;

public class MineBullets extends AllBullets {

	public MineBullets(Rectangle rec, int c) {
		super(rec, c);
		
	}
	
	@Override
//  子弹碰到场景物品的方法
	void collision(Rectangle rec) {
		int i = rec.y / 40; // 是矩形的y，是二维数组的行数
		int j = rec.x / 40; // 是矩形的x，是二维数组的列数

		// 先不要超出边界
		if (i >= DataCenter.map.length || j >= DataCenter.map[0].length) {
			xThread.interrupt();
		}else {
			int k = DataCenter.map[i][j];
//			如果碰到了砖头则让砖头消失
			if (k == 1) {
				DataCenter.brickDisappear(rec);
				xThread.interrupt();
			}
//			如果碰到了钢
			if (k == 8) {
				xThread.interrupt();
			}
			/*
//			如果碰到了敌方坦克（现在只暂时写了地方灰色坦克）
			if (rec == EnemyTanks.enemyTanks[0].getBounds()) {
				EnemyTanks.enemyTanks[0].lifevalue -= 1;
				System.out.println(EnemyTanks.enemyTanks[0].lifevalue);
				xThread.interrupt();
			}
			*/
		}
	}

}
