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
	public boolean listener;   //		����һ���Ƿ���������ԣ�������Ϊ�ж�����������Ϸ������ʱ���������false
	
	public MineTank(){
		
//		���ú�һЩ��������ֵ
		direction = KeyEvent.VK_W;
		life =2;
		lifeValue = 2;
		listener = true;
		
//		��DataCenter�����ҷ�̹�˵�ͼƬ�Ѿ�׼�����ˣ�������Ҫ�����ͼƬ�����JLable��
//		�������ҷ�̹�˵�lable��С��λ��
		this.setBounds(40*12, 40*16, 40, 40);
//		�ٰ�ͼƬ������ȥ
		this.setIcon(new ImageIcon(DataCenter.getMineTankImage(0, 0)));
		
//		���ü����¼���һ��Ҫ����������ý���
//		 һ������ļ����¼�����ֻ�ᱻһ������ץ��
	//  panel�ǿ�����Ϊ�����
//		�����������this.setFocusable(true);��ô������Ϊ�������ͼ������ץ������������¼���Ȼ�����ļ����¼��ͻ���Ч
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
//				���listener��Ϊfalse�����������һ�δ��붼����ִ���ˡ�
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
//		�Ķ������ҷ�̹�˷����ӵ����е��ҷ��ӵ���
		AllBullets xAllBullets = new MineBullets(this.getBounds(), this.direction);
		MainPanel.getInstance().add(xAllBullets);
	}
	
	
//	��������
	public void dead(){
		this.life -- ;
		
		if (this.life < 0) {
//			todo-list:
//			����ҷ�̹��û���ˣ��ͻ������Ϸ����
//			GameOver over = new GameOver();
//			MainPanel.getBounds().add(over);
		}else{
			this.setBounds(40*12, 40*16, 40, 40);
			this.lifeValue = 2;
		}
	}
}