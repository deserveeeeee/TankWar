package com.game.tanks;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.game.map.DataCenter;

public abstract class AllTanks extends JLabel {
	
//	�������������Ϊ�˰ѹ��췽����ø��ӵ�����
//	abstract void nextBehavoir();
//	public AllTanks(){
//		nextBehavoir();
//	}
	
//	�ƶ��ķ���
	Rectangle move(int e){
		Rectangle c = this.getBounds();
		if (e == KeyEvent.VK_W) {  //w��ǰ��
			c.y -= 40;
		}
		if (e == KeyEvent.VK_S) {  //S�Ǻ���
			c.y += 40;
		}
		if (e == KeyEvent.VK_A) {  //A������
			c.x -= 40;
		}
		if (e == KeyEvent.VK_D) {  //D������
			c.x += 40;
		}
		
		if(DataCenter.map[c.y/40][c.x/40] == 5 || DataCenter.map[c.y/40][c.x/40] == -1){
			this.setBounds(c);
		}
		return c;
	}
	
}
