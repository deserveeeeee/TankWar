package com.game.bullet;

import java.awt.Rectangle;

import com.game.tanks.EnemyTanks;
import com.game.tanks.EnemyTanksManager;
import com.game.ui.DataCenter;
import com.game.ui.MainPanel;

public class EnemyBullets extends AllBullets {

	public EnemyBullets(Rectangle rec, int c) {
		super(rec, c);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
//  子弹碰到场景物品的方法→敌方子弹和普通子弹不同的敌方就在于敌方子弹只打敌方坦克
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
			
//			普通子弹，是会造成伤害值-1.
			if (rec.x == EnemyTanksManager.mineTank.getBounds().x &&
					rec.y == EnemyTanksManager.mineTank.getBounds().y) {
				EnemyTanksManager.mineTank.lifeValue --;
				if (EnemyTanksManager.mineTank.lifeValue < 0) {
					EnemyTanksManager.mineTank.dead();
				}
				xThread.interrupt();
			}
		}
	}
// 普通子弹让生命值掉1，即-1.
}
