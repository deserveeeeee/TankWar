package com.game.tanks;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.game.bullet.AllBullets;
import com.game.bullet.MineBullets;
import com.game.ui.DataCenter;
import com.game.ui.GameOver;
import com.game.ui.MainPanel;

public class MineTank extends AllTanks {
//	Rectangle mineRec = new Rectangle(40 , 40);
	int direction;
	int life;
	public int lifeValue; 
	public boolean listener;   //		增加一个是否监听的属性，并且作为判断条件，在游戏结束的时候，让它变成false
	
	public MineTank(){
		
//		设置好一些基本属性值
		direction = KeyEvent.VK_W;
		life =2;
		lifeValue = 2;
		listener = true;
		
//		在DataCenter里面我方坦克的图片已经准备好了，现在需要把这个图片部署带JLable上
//		先设置我方坦克的lable大小和位置
		this.setBounds(40*12, 40*16, 40, 40);
//		再把图片部署上去
		this.setIcon(new ImageIcon(DataCenter.getMineTankImage(0, 0)));
		
//		设置监听事件，一定要用这个来设置焦点
//		 一个程序的监听事件当下只会被一个对象抓捕
	//  panel是可以作为焦点的
//		如果都设置了this.setFocusable(true);那么最先作为焦点的视图，最先抓捕到这个监听事件，然后后面的监听事件就会无效
		this.setFocusable(true);
		final MineTank ref = this;
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
//				todo-list
//				如果listener变为false，则下面的这一段代码都不会执行了。
				if (listener) {
					if (e.getKeyCode() == KeyEvent.VK_SPACE) {
						ref.shoot();
					}else if (e.getKeyCode() == KeyEvent.VK_W ||
							e.getKeyCode() == KeyEvent.VK_S ||
							e.getKeyCode() == KeyEvent.VK_A ||
							e.getKeyCode() == KeyEvent.VK_D) {
						ref.move(e.getKeyCode());
						direction = reDirection(e.getKeyCode());
					}else {}	
				}
			}
			
		});
	
	}
	
	
	int reDirection(int e ){  //传入的参数是抓捕到的key值
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
		this.setIcon(new ImageIcon(DataCenter.getMineTankImage(0, b)));
		return e;
	}
	
//	先写我方坦克发子弹的方法，然后再分局设计弄到父类里面
	void shoot(){
//		改动三：我方坦克发射子弹类中的我方子弹类
		AllBullets xAllBullets = new MineBullets(this.getBounds(), this.direction);
		MainPanel.getInstance().add(xAllBullets);
	}
	
	
//	死亡方法
	public void dead(){
		this.life -- ;
		
		if (this.life < 0) {
//			todo-list:
//			如果我方坦克没命了，就会出现游戏结束
//			GameOver over = new GameOver();
//			MainPanel.getBounds().add(over);
		}else{
			this.setBounds(40*12, 40*16, 40, 40);
			this.lifeValue = 2;
		}
	}
}