package com.game.bullet;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.game.map.DataCenter;
import com.game.map.MainPanel;

public class AllBullets extends JLabel {
	
//	��ʵ�ӵ��Ĺ��췽�����Ƿ����ӵ��ķ������������������ҪŪ���ӿ�����
	public AllBullets(Rectangle rec, int c) {
//		�½���ʱ��get�ӵ���ͼƬ
		int x = 0;
		if (c == KeyEvent.VK_W) {  //w��ǰ��
			x = 3;
		}
		if (c == KeyEvent.VK_S) {  //S�Ǻ���
			x = 1;
		}
		if (c == KeyEvent.VK_A) {  //A������
			x = 2;
		}
		if (c == KeyEvent.VK_D) {  //D������
			x = 0;
		}
		this.setIcon(new ImageIcon(DataCenter.getBulletImage(x)));
		this.setBounds(rec);
		
//		�½��߳�
		AllBullets ref = this;
		Thread fly = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// ������߳�ÿ��0.1���ִ��һ��λ�ñ仯
				while(true){
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ref.oneStep(ref.getBounds(), c);
//					���������ײ���Ƴ��ӵ����󣬲�������whileѭ����
//					���ҷ�����ը����Ϊ��������û��д��������д�����Ժ�������ϣ�
//					todo-list
//					���ҷ������Ƴ�����Ϊ
					if (ref.collision()) {
						ref.destroy();
						break;
					}
				}
			}
		});
		fly.start();
	}
	
	
//	���ӵ����Ƴ��ķ���
	void destroy(){
		MainPanel.getInstance().remove(this);
		MainPanel.getInstance().repaint();
	}
	
//	�ж��ӵ�δ���ƶ�����ķ�������û��ʵ�ʲ����ƶ���Ϊ��
//	�����Ҫ�ڵ��õ�ʱ�����һ���ƶ���Ϊ��
	void oneStep(Rectangle rec, int c) {
		
		if (c == KeyEvent.VK_W) {  //w��ǰ��
			rec.y -= 40;
		}
		if (c == KeyEvent.VK_S) {  //S�Ǻ���
			rec.y += 40;
		}
		if (c == KeyEvent.VK_A) {  //A������
			rec.x -= 40;
		}
		if (c == KeyEvent.VK_D) {  //D������
			rec.x += 40;
		}
		this.setBounds(rec);
	}

	

//  �ӵ�����������Ʒ�ķ���
	boolean collision() {
		int i = this.getBounds().y / 40; // �Ǿ��ε�y���Ƕ�ά���������
		int j = this.getBounds().x / 40; // �Ǿ��ε�x���Ƕ�ά���������
		int k = DataCenter.map[i][j];
		if (i >=  DataCenter.map.length || j >= DataCenter.map[0].length) {
			return true; 
		}
		if (k == 1 || k == 8) {
			return true; 
		}
		// int rows = DataCenter.map.length;//������Ҳ����y
		// int columns = DataCenter.map[0].length;//������Ҳ����x
		return false;
	}
} 
