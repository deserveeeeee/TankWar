package com.game.bullet;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.game.ui.DataCenter;
import com.game.ui.MainPanel;

public class Tmp extends JLabel {
//	Thread xThread;
	
//	其实子弹的构造方法就是发生子弹的方法，而这个方法必须要弄到接口里面
	public Tmp(Rectangle rec, int c) {
//		新建的时候get子弹的图片
		int direction = 0;
		if (c == KeyEvent.VK_W) {  //w是前进
			direction = 3;
		}
		if (c == KeyEvent.VK_S) {  //S是后退
			direction = 1;
		}
		if (c == KeyEvent.VK_A) {  //A是往左
			direction = 2;
		}
		if (c == KeyEvent.VK_D) {  //D是往右
			direction = 0;
		}
//		根据初始方向设置它的图片，而这个图片是不会被改变的。
		this.setIcon(new ImageIcon(DataCenter.getBulletImage(direction)));
		this.setBounds(rec);
		
//		新建线程
		Tmp ref = this;
		Thread fly = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// 让这个线程每隔0.1秒就执行一次位置变化
				while(true){
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						break;
					}
					
//					ref.flyStep(ref.getBounds(), direction);
//					如果发生碰撞则移除子弹对象，并且跳出while循环。
//					并且发生爆炸的行为（爆发还没有写出来，等写出来以后再添加上）
//					todo-list
//					并且发生被移除的行为
					if (ref.collision()) {
						ref.destroy();
						Thread.interrupted();
						break;
					}
					ref.oneStep(rec, c);
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
	

/*
//  子弹碰到场景物品的方法
	boolean collision() {
		int i = this.getBounds().y / 40; // 是矩形的y，是二维数组的行数
		int j = this.getBounds().x / 40; // 是矩形的x，是二维数组的列数
		int k = DataCenter.map[i][j];
		if (i >= DataCenter.map.length || j >= DataCenter.map[0].length) {
			return true;
		}
		if (k == 1) {
			DataCenter.brickDisappear(this.getBounds());
			return true;
		}

		if (k == 8) {
			return true;
		}
		return false;
	}
*/
	
//  子弹碰到场景物品的方法
	boolean collision() {
		/*
		int i = nextStep(this.getBounds(), direction).y /40;
		int j = nextStep(this.getBounds(), direction).x /40;
		*/
		int i = this.getBounds().y / 40; // 是矩形的y，是二维数组的行数
		int j = this.getBounds().x / 40; // 是矩形的x，是二维数组的列数
		

//		DataCenter.map.length  是二维数组的行数
//		DataCenter.map[0].length 是二维数组的列数
		if (i >= DataCenter.map.length || j >= DataCenter.map[0].length) {
			return true;
		}
		
		int k = DataCenter.map[i][j];
		if (k == 1) {
			DataCenter.brickDisappear(this.getBounds());
			return true;
		}

		if (k == 8) {
			return true;
		}
		return false;
	}
	
	/*
//	子弹下一步的坐标
	Rectangle nextStep(Rectangle rec, int c) {
		
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
		return rec;
	}
	
//	子弹移动的方法
	void flyStep(Rectangle rec, int c){
		this.nextStep(rec, c);
		//  子弹碰到水的方法
		if (DataCenter.map[rec.y / 40][rec.x / 40] == 9) {
//			当碰到水的时候，就把它移除，然后移动子弹，再重新布置水
			JLabel xJLabel = MainPanel.getInstance(). waterJLabels.get(rec);
			MainPanel.getInstance().remove(xJLabel);
			this.setBounds(rec);
			MainPanel.getInstance().add(xJLabel);
			MainPanel.getInstance().repaint();
		}else{
			this.setBounds(rec);
		}
	}
	
	*/
	
	void oneStep(Rectangle rec, int c){
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
		/*
		//  子弹碰到水的方法
		if (DataCenter.map[rec.y / 40][rec.x / 40] == 9) {
//			当碰到水的时候，就把它移除，然后移动子弹，再重新布置水
			JLabel xJLabel = MainPanel.getInstance(). waterJLabels.get(rec);
			MainPanel.getInstance().remove(xJLabel);
			this.setBounds(rec);
			MainPanel.getInstance().add(xJLabel);
			MainPanel.getInstance().repaint();
		}else{
			this.setBounds(rec);
//			MainPanel.getInstance().repaint();
		}
		*/
		this.setBounds(rec);
	}
	
} 
