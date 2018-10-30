package com.game.tanks;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.game.map.DataCenter;

public class MineTank extends AllTanks {
	
	public MineTank(){
//		在DataCenter里面我方坦克的图片已经准备好了，现在需要把这个图片部署带JLable上
//		先设置我方坦克的lable大小和位置
		this.setBounds(40*12, 40*16, 40, 40);
//		再把图片部署上去
		this.setIcon(new ImageIcon(DataCenter.getMineTankImage(0, 0)));
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
				ref.move(e.getKeyCode());
				ref.reDirection(e.getKeyCode());
			}
		});
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
		
		this.setIcon(new ImageIcon(DataCenter.getMineTankImage(0, b)));
	}
}