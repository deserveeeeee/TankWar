package com.game.tanks;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.game.ui.DataCenter;

public abstract class AllTanks extends JLabel {
	
//	增加这个方法是为了把构造方法变得更加单纯。
//	abstract void nextBehavoir();
//	public AllTanks(){
//		nextBehavoir();
//	}
	
//	移动的方法
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
	
}
