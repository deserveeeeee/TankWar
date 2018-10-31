package com.game.bullet;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.game.map.DataCenter;
import com.game.map.MainPanel;

public class AllBullets extends JLabel {
	int direction;
	
//	��ʵ�ӵ��Ĺ��췽�����Ƿ����ӵ��ķ������������������ҪŪ���ӿ�����
	public AllBullets(Rectangle rec, int c) {
//		�½���ʱ��get�ӵ���ͼƬ
		if (c == KeyEvent.VK_W) {  //w��ǰ��
			direction = 3;
		}
		if (c == KeyEvent.VK_S) {  //S�Ǻ���
			direction = 1;
		}
		if (c == KeyEvent.VK_A) {  //A������
			direction = 2;
		}
		if (c == KeyEvent.VK_D) {  //D������
			direction = 0;
		}
		this.setIcon(new ImageIcon(DataCenter.getBulletImage(direction)));
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
					ref.oneStep(rec, c);
//					ref.flyStep(ref.getBounds(), direction);
//					���������ײ���Ƴ��ӵ����󣬲�������whileѭ����
//					���ҷ�����ը����Ϊ��������û��д��������д�����Ժ�������ϣ�
//					todo-list
//					���ҷ������Ƴ�����Ϊ
					if (ref.collision()) {
						ref.destroy();
						Thread.interrupted();
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
	

/*
//  �ӵ�����������Ʒ�ķ���
	boolean collision() {
		int i = this.getBounds().y / 40; // �Ǿ��ε�y���Ƕ�ά���������
		int j = this.getBounds().x / 40; // �Ǿ��ε�x���Ƕ�ά���������
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
	
//  �ӵ�����������Ʒ�ķ���
	boolean collision() {
		/*
		int i = nextStep(this.getBounds(), direction).y /40;
		int j = nextStep(this.getBounds(), direction).x /40;
		*/
		int i = this.getBounds().y / 40; // �Ǿ��ε�y���Ƕ�ά���������
		int j = this.getBounds().x / 40; // �Ǿ��ε�x���Ƕ�ά���������
		
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
	
	/*
//	�ӵ���һ��������
	Rectangle nextStep(Rectangle rec, int c) {
		
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
		return rec;
	}
	
//	�ӵ��ƶ��ķ���
	void flyStep(Rectangle rec, int c){
		this.nextStep(rec, c);
		//  �ӵ�����ˮ�ķ���
		if (DataCenter.map[rec.y / 40][rec.x / 40] == 9) {
//			������ˮ��ʱ�򣬾Ͱ����Ƴ���Ȼ���ƶ��ӵ��������²���ˮ
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
		/*
		//  �ӵ�����ˮ�ķ���
		if (DataCenter.map[rec.y / 40][rec.x / 40] == 9) {
//			������ˮ��ʱ�򣬾Ͱ����Ƴ���Ȼ���ƶ��ӵ��������²���ˮ
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
