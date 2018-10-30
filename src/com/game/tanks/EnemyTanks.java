package com.game.tanks;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import com.game.map.DataCenter;

public abstract class EnemyTanks extends AllTanks {
// 有三个level的敌方坦克
// 不同颜色的图片
//	不同的地点：两边都是level01的坦克，中间是level02（7）个，level03（3）个。
//	敌方坦克1:4,4
//	敌方坦克2:0,4
//	敌方坦克3:6,4
//	如果是随机生成，则设置m和n的值
//	x和y是这个小图片在大图片里面的坐标位置
//	m和n是这个JLable的位置
	public EnemyTanks(int x, int y, int m , int n){
		this.setBounds(40*m, 40*n, 40, 40);
		this.setIcon(new ImageIcon(DataCenter.getEnemyTankImage(x, y+4)));
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
			this.setBounds(c);
		}
	}
	
	void reDirection(int e){
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
		
		this.setIcon(new ImageIcon(DataCenter.getEnemyTankImage(0, b)));
	}
}
