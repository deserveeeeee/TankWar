package com.game.tanks;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.game.map.DataCenter;

public class MineTank extends AllTanks {
	Rectangle mineRec = new Rectangle(40 , 40);
	int mineC;
	
	public MineTank(){
//		在DataCenter里面我方坦克的图片已经准备好了，现在需要把这个图片部署带JLable上
//		先设置我方坦克的lable大小和位置
		
		this.setBounds(40*12, 40*16, 40, 40);
		
//		初始坐标设置
		mineRec.setLocation(40*12, 40*16);
		
//		再把图片部署上去
		this.setIcon(new ImageIcon(DataCenter.getMineTankImage(0, 0)));
		mineC = KeyEvent.VK_W;
		
		final MineTank ref = this;
//		设置监听事件，一定要用这个来设置焦点
//		 一个程序的监听事件当下只会被一个对象抓捕
	//  panel是可以作为焦点的
//		如果都设置了this.setFocusable(true);那么最先作为焦点的视图，最先抓捕到这个监听事件，然后后面的监听事件就会无效
		this.setFocusable(true);
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
				mineRec = move(e.getKeyCode());
//				ref.move(e.getKeyCode());
//				ref.reDirection(e.getKeyCode());
				mineC = reDirection(e.getKeyCode());
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
	
	
//	我方坦克死亡的话，那么设置3次生命值，每次死亡就会导致这个生命值-1。
//	初始生命值为2（设置为minetank的属性）
//	如果生命值为-1则不执行了
//	不会影响map的设置，比如消失了的brick仍然是消失状态。
//	也就是DataCenter的map数组就保持被处理以后的数据
//	子弹碰到我方坦克的话，其逻辑仍然是子弹的下一步坐标是否和minetank当前坐标重合
//	那么，是否就可以设置一个我方坦克的坐标属性和敌方坦克的坐标属性
//	每次移动完成以后，就让这个属性值进行更新
//	被打的次数，最开始为0,1,2.
//	被打3次以后，就会造成我方坦克的死亡事件
//	而灰色子弹造成被打次数减1，绿色子弹造成被打次数减2，红色子弹造成被打次数减3.
//	如果<0，则造成我方坦克的死亡事件了。
//	同理，敌方坦克也可以这样设置。
//	我方子弹每次与敌方坦克的碰面，会造成敌方坦克的被打次数-1
//	敌方红色坦克初始值为2。同样，如果<0，则造成敌方坦克的死亡事件了。
//	敌方绿色坦克初始值为1。同样，如果<0，则造成敌方坦克的死亡事件了。
//	敌方灰色坦克初始值为0。同样，如果<0，则造成敌方坦克的死亡事件了。
//	
}