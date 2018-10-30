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
//		��DataCenter�����ҷ�̹�˵�ͼƬ�Ѿ�׼�����ˣ�������Ҫ�����ͼƬ�����JLable��
//		�������ҷ�̹�˵�lable��С��λ��
		this.setBounds(40*12, 40*16, 40, 40);
//		�ٰ�ͼƬ������ȥ
		this.setIcon(new ImageIcon(DataCenter.getMineTankImage(0, 0)));
		final MineTank ref = this;
//		���ü����¼���һ��Ҫ����������ý���
//		 һ������ļ����¼�����ֻ�ᱻһ������ץ��
	//  panel�ǿ�����Ϊ�����
//		�����������this.setFocusable(true);��ô������Ϊ�������ͼ������ץ������������¼���Ȼ�����ļ����¼��ͻ���Ч
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
		if (e == KeyEvent.VK_W) {  //w��ǰ��
			b = 0;
		}
		if (e == KeyEvent.VK_S) {  //S�Ǻ���
			b = 2;
		}
		if (e == KeyEvent.VK_A) {  //A������
			b = 3;
		}
		if (e == KeyEvent.VK_D) {  //D������
			b = 1;
		}
		
		this.setIcon(new ImageIcon(DataCenter.getMineTankImage(0, b)));
	}
}