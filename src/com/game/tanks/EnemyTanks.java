package com.game.tanks;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.game.bullet.AllBullets;
import com.game.bullet.EnemyBullets;
import com.game.bullet.MineBullets;
import com.game.ui.DataCenter;
import com.game.ui.GameWin;
import com.game.ui.MainPanel;

public abstract class EnemyTanks extends AllTanks {
	public int lifeValue;
	public int direction;
	boolean alive;
	Thread run;
	
	public EnemyTanks(int x, int y, int m , int n){
		this.setBounds(40*m, 40*n, 40, 40);
		this.setIcon(new ImageIcon(DataCenter.getEnemyTankImage(x, y)));
		this.alive = true;
		
//		改动一：创建对象的时候就把数组放进去
//		Rectangle c = this.getBounds();
//		EnemyTanksManager.enemyTanksLocations.put(c, this);
//		TanksManager.enemyTanks.add(this);
	}
	
	
	void move(int e){
		Rectangle c = this.getBounds();
		if (e == KeyEvent.VK_W) {  //w是前进
			c.y -= 40;
		}
		if (e == KeyEvent.VK_S) {  //S是后退
			c.y += 40;
		}
		if (e == KeyEvent.VK_A) {  //A是往左
			c.x -= 40;
		}
		if (e == KeyEvent.VK_D) {  //D是往右
			c.x += 40;
		}
		
		if(DataCenter.map[c.y/40][c.x/40] == 5 || DataCenter.map[c.y/40][c.x/40] == -1){
////			改动二：当位置成功发生变化以后就
////			先移除原位置，原对象的数组
////			EnemyTanksManager.enemyTanksLocations.remove(this.getBounds(), this);
//			TanksManager.enemyTanks.remove(this);
////			再把新的位置，原对象装进去
////			EnemyTanksManager.enemyTanksLocations.put(c, this);
//			TanksManager.enemyTanks.add(this);
			
//			让位置更新，即位移。
			this.setBounds(c);
		}
	}
	
	int reDirection(int a,int e){
		int b = 0 ;
		if (e == KeyEvent.VK_W) {  //w是前进
			b = 0;
		}
		if (e == KeyEvent.VK_S) {  //S是后退
			b = 2;
		}
		if (e == KeyEvent.VK_A) {  //A是往左
			b = 3;
		}
		if (e == KeyEvent.VK_D) {  //D是往右
			b = 1;
		}
		
		this.setIcon(new ImageIcon(DataCenter.getEnemyTankImage(a, b)));
		return e;
	}
	
	void shoot(){
		AllBullets xAllBullets = new EnemyBullets(this.getBounds(), this.direction);
		MainPanel.getInstance().add(xAllBullets);
	}
	
	
////	改动九：制造死亡事件
//	public void dead(){
////		从视图上将它移除
//		MainPanel.getInstance().remove(this);
//		this.alive = false;
//		MainPanel.getInstance().repaint();
////		再移除这个map中对应的键值对
//		TanksManager.enemyTanks.remove(this);
//		System.out.println("我被移除掉了");
////		判断是否需要增加新的坦克
//		if(TanksManager.enemyTanksSum <= 20){
//			TanksManager.enemyTanksSum
//			MainPanel.getInstance().add(createRamEnemyTanks());
//			System.out.println("我又出生了");
//			TanksManager.enemyTanksSum ++;
//		}else if(TanksManager.enemyTanksSum > 20 /*&& enemyTanks.size() <= 0*/) {
////			todo-list：这个需求并没有成功设置好。
////			如果敌方坦克没有了 且 数组里面也没有敌方坦克了。
//			GameWin.getInstance().floatPic();
//		}
//	}
}
