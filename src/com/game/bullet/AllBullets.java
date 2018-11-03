package com.game.bullet;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.game.specialEffect.BoomEffect;
import com.game.tanks.EnemyTanksManager;
import com.game.ui.DataCenter;
import com.game.ui.GameOver;
import com.game.ui.MainPanel;

public class AllBullets extends JLabel {
	Thread xThread;
	
	Map<Integer, Image> dirImages = new HashMap<Integer, Image>();
//  �з��ӵ����ҷ��ӵ���ͬ�ĵط���ֻ����������ʹ�öԷ�������ֵ-1����ͨ�ӵ�����
//	��ʵ�ӵ��Ĺ��췽�����Ƿ����ӵ��ķ������������������ҪŪ���ӿ�����
	public AllBullets(Rectangle rec, int c) {
//		�½���ʱ��get�ӵ���ͼƬ
		dirImages.put(KeyEvent.VK_W ,DataCenter.getBulletImage(3));
		dirImages.put(KeyEvent.VK_S ,DataCenter.getBulletImage(1));
		dirImages.put(KeyEvent.VK_A ,DataCenter.getBulletImage(2));
		dirImages.put(KeyEvent.VK_D ,DataCenter.getBulletImage(0));
		this.setIcon(new ImageIcon(dirImages.get(c)));
//		����Ҫȥ������λ�á�
		this.setBounds(rec);
//		�½��߳�
		final AllBullets ref = this;
		xThread = new Thread(new Runnable() {
			@Override
			public void run() {
				// ������߳�ÿ��0.1���ִ��һ��λ�ñ仯
				while(true){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						break;
					}
					Rectangle r = ref.getBounds();
					if (c == KeyEvent.VK_W) {  //w��ǰ��
						r.y -= 40;
					}
					if (c == KeyEvent.VK_S) {  //S�Ǻ���
						r.y += 40;
					}
					if (c == KeyEvent.VK_A) {  //A������
						r.x -= 40;
					}
					if (c == KeyEvent.VK_D) {  //D������
						r.x += 40;
					}
					

					ref.collision(r);
					ref.flyStep(r);
					
				}
				
				ref.destroy();
				
			}
		});
		xThread.start();
	}
	
	
//	���ӵ����Ƴ��ķ���
	void destroy(){
		MainPanel.getInstance().remove(this);
		MainPanel.getInstance().repaint();
		MainPanel.getInstance().add(new BoomEffect(this.getBounds()));	
	}
	
	
//	�ӵ��ƶ��ķ���
	void flyStep(Rectangle rec) {
		int i = rec.y / 40; // �Ǿ��ε�y���Ƕ�ά���������
		int j = rec.x / 40; // �Ǿ��ε�x���Ƕ�ά���������
		// �ӵ�����ˮ�ķ���
		// �Ȳ�Ҫ�����߽�
		if (i >= DataCenter.map.length || j >= DataCenter.map[0].length) {
			xThread.interrupt();
		}else{
			if (DataCenter.map[i][j] == 9) {
				// ������ˮ��ʱ�򣬾Ͱ����Ƴ���Ȼ���ƶ��ӵ��������²���ˮ
				JLabel xJLabel = MainPanel.getInstance().waterJLabels.get(rec);
				MainPanel.getInstance().remove(xJLabel);
				this.setBounds(rec);
				MainPanel.getInstance().add(xJLabel);
				MainPanel.getInstance().repaint();
			} else {
				this.setBounds(rec);
			}
		}
	}
	
	
	// �ӵ�����������Ʒ�ķ���
	void collision(Rectangle rec) {
		int i = rec.y / 40; // �Ǿ��ε�y���Ƕ�ά���������
		int j = rec.x / 40; // �Ǿ��ε�x���Ƕ�ά���������

		// �Ȳ�Ҫ�����߽�
		if (i >= DataCenter.map.length || j >= DataCenter.map[0].length) {
//			alive = false;
			xThread.interrupt();
		} else {
			int k = DataCenter.map[i][j];
			
// 			���������boss�ϴ����ֱ������Ϸ������ֱ�ӵ���GameOver������todo-list
			if (rec.x == 14*40 && rec.y==16*40) {
				System.out.println("���ϴ���");
				GameOver.getInstance().floatPic();
				xThread.interrupt();
			}
			// ���������שͷ����שͷ��ʧ
			if (k == 1) {
				DataCenter.brickDisappear(rec);
				xThread.interrupt();
			}
			// ��������˸�
			if (k == 8) {
				xThread.interrupt();
			}
		}
	}
} 
