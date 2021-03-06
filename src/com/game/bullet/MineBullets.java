package com.game.bullet;

import java.awt.Rectangle;

import javax.lang.model.element.Element;
import javax.swing.ImageIcon;

import com.game.specialEffect.BoomEffect;
import com.game.tanks.AllTanks;
import com.game.tanks.EnemyTank01;
import com.game.tanks.EnemyTanks;
import com.game.tanks.TanksManager;
import com.game.ui.DataCenter;
import com.game.ui.GameOver;
import com.game.ui.MainPanel;

public class MineBullets extends AllBullets {
	
	public MineBullets(Rectangle rec, int c) {
		super(rec, c);
		
	}
	
	@Override
	void destroy(){
		MainPanel.getInstance().remove(this);
		MainPanel.getInstance().repaint();
		MainPanel.getInstance().add(new BoomEffect(this.getBounds()));
	}
	
	@Override
//  子弹碰到场景物品的方法→我方子弹和敌方子弹不同的敌方就在于我方子弹只打敌方坦克
	void collision(Rectangle rec) {
		int i = rec.y / 40; // 是矩形的y，是二维数组的行数
		int j = rec.x / 40; // 是矩形的x，是二维数组的列数

		// 先不要超出边界
		if (i >= DataCenter.map.length || j >= DataCenter.map[0].length) {
			xThread.interrupt();
		}else {
			int k = DataCenter.map[i][j];
			
// 			如果碰到了boss老大，则会直接让游戏结束。直接调用GameOver方法。todo-list
			if (rec.x == 14*40 && rec.y==16*40) {
				System.out.println("打到老大了");
				GameOver.getInstance().floatPic();
				xThread.interrupt();
			}
			
//			如果碰到了砖头则让砖头消失
			if (k == 1) {
				DataCenter.brickDisappear(rec);
				xThread.interrupt();
			}
//			如果碰到了钢
			if (k == 8) {
				xThread.interrupt();
			}
			
//			如果碰到了敌方坦克：Vector的方法
			for (EnemyTanks xTank : TanksManager.tanksManager1.enemyTanks) {
				if (rec.x == xTank.getBounds().x && rec.y == xTank.getBounds().y) {
								xTank.lifeValue --;
								if (xTank.lifeValue < 0) {
									TanksManager.tanksManager1.dead(xTank,this);
								}
					xThread.interrupt();	
				}
			}		
			
			for (EnemyTanks xTank : TanksManager.tanksManager2.enemyTanks) {
				if (rec.x == xTank.getBounds().x && rec.y == xTank.getBounds().y) {
								xTank.lifeValue --;
								if (xTank.lifeValue < 0) {
									TanksManager.tanksManager2.dead(xTank,this);
								}
						xThread.interrupt();
					}
			}	
			
			for (EnemyTanks xTank : TanksManager.tanksManager3.enemyTanks) {
				if (rec.x == xTank.getBounds().x && rec.y == xTank.getBounds().y) {
								xTank.lifeValue --;
								if (xTank.lifeValue < 0) {
									TanksManager.tanksManager3.dead(xTank,this);
								}
						xThread.interrupt();
					}
			}	
//					todo-list：让这个坦克变成下一等级的坦克
//					else if (xTank.lifeValue == 0) {
//						xTank.setIcon(new ImageIcon(DataCenter.getEnemyTankImage(4, 0)));
//					}else if (xTank.lifeValue == 1) {
//						xTank.setIcon(new ImageIcon(DataCenter.getEnemyTankImage(0, 0)));
//					}else {
//						
//					}

		}
	}
}

