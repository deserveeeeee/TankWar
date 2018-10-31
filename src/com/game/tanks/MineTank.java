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
import com.game.ui.MainPanel;

public class MineTank extends AllTanks {
//	Rectangle mineRec = new Rectangle(40 , 40);
	int direction;
	int lifeValue = 2;
	
	public MineTank(){
//		��DataCenter�����ҷ�̹�˵�ͼƬ�Ѿ�׼�����ˣ�������Ҫ�����ͼƬ�����JLable��
//		�������ҷ�̹�˵�lable��С��λ��
		
		this.setBounds(40*12, 40*16, 40, 40);
		
//		��ʼ��������
//		mineRec.setLocation(40*12, 40*16);
		
//		�ٰ�ͼƬ������ȥ
		this.setIcon(new ImageIcon(DataCenter.getMineTankImage(0, 0)));
		direction = KeyEvent.VK_W;
		
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
			
		});
	}
	
	
	int reDirection(int e ){  //����Ĳ�����ץ������keyֵ
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
		return e;
	}
	
//	��д�ҷ�̹�˷��ӵ��ķ�����Ȼ���ٷ־����Ū����������
	void shoot(){
			AllBullets xAllBullets = new AllBullets(this.getBounds(), this.direction);
			MainPanel.getInstance().add(xAllBullets);
	}
	
//	�ҷ������¼�
	void dead(){
		MainPanel.getInstance().remove(this);
		MainPanel.getInstance().repaint();
	}
	
}