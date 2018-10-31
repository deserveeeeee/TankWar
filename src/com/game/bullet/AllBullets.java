package com.game.bullet;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.game.map.DataCenter;
import com.game.map.MainPanel;

public class AllBullets extends JLabel {
	
//	其实子弹的构造方法就是发生子弹的方法，而这个方法必须要弄到接口里面
	public AllBullets(Rectangle rec, int c) {
//		新建的时候get子弹的图片
		int x = 0;
		if (c == KeyEvent.VK_W) {  //w是前进
			x = 3;
		}
		if (c == KeyEvent.VK_S) {  //S是后退
			x = 1;
		}
		if (c == KeyEvent.VK_A) {  //A是往左
			x = 2;
		}
		if (c == KeyEvent.VK_D) {  //D是往右
			x = 0;
		}
		this.setIcon(new ImageIcon(DataCenter.getBulletImage(x)));
		this.setBounds(rec);
		
//		新建线程
		AllBullets ref = this;
		Thread fly = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// 让这个线程每隔0.1秒就执行一次位置变化
				while(true){
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ref.oneStep(ref.getBounds(), c);
//					如果发生碰撞则移除子弹对象，并且跳出while循环。
//					并且发生爆炸的行为（爆发还没有写出来，等写出来以后再添加上）
//					todo-list
//					并且发生被移除的行为
					if (ref.collision()) {
						ref.destroy();
						break;
					}
				}
			}
		});
		fly.start();
	}
	
	
//	让子弹被移除的方法
	void destroy(){
		MainPanel.getInstance().remove(this);
		MainPanel.getInstance().repaint();
	}
	
//	判断子弹未来移动坐标的方法（并没有实际产生移动行为，
//	这个需要在调用的时候产生一下移动行为）
	void oneStep(Rectangle rec, int c) {
		
		if (c == KeyEvent.VK_W) {  //w是前进
			rec.y -= 40;
		}
		if (c == KeyEvent.VK_S) {  //S是后退
			rec.y += 40;
		}
		if (c == KeyEvent.VK_A) {  //A是往左
			rec.x -= 40;
		}
		if (c == KeyEvent.VK_D) {  //D是往右
			rec.x += 40;
		}
		this.setBounds(rec);
	}

	

//  子弹碰到场景物品的方法
	boolean collision() {
		int i = this.getBounds().y / 40; // 是矩形的y，是二维数组的行数
		int j = this.getBounds().x / 40; // 是矩形的x，是二维数组的列数
		int k = DataCenter.map[i][j];
		if (i >=  DataCenter.map.length || j >= DataCenter.map[0].length) {
			return true; 
		}
		if (k == 1 || k == 8) {
			return true; 
		}
		// int rows = DataCenter.map.length;//行数，也就是y
		// int columns = DataCenter.map[0].length;//列数，也就是x
		return false;
	}
} 
