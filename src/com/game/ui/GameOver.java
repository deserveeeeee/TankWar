package com.game.ui;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.game.tanks.EnemyTanksManager;

public class GameOver extends JLabel {

	public GameOver() {

		// 1����Ϸ�������ҷ�̹�˽�������¼�  ??�������ò��ɹ�
		EnemyTanksManager.mineTank.requestFocusInWindow();
//		ref.getKeyListeners(); �����Ƿ����ȡ�ü��̼���Ȩ�ޣ�Ȼ������������һ�أ�
		// 2������GameOverͼƬ�߳�
//		this.setBounds(0, 0, 1024, 768); // ֱ������Ļ��С��Ϊ��ǰ��ͼ
//		this.setBackground(Color.black);
//		this.setLayout(null); // �Զ����֣���Լ���ķ�ʽ��ȷ�����������λ�úͿ��
//		������³��ֵ�JLable�������ϲ㣬��������һ�������ƶ���JPanel�������Ƿ��������������ϲ㣿
		this.setIcon(new ImageIcon(this.getGameOverImage()));
		GameOver ref = this;
		Thread RunPic = new Thread(new Runnable() {
			@Override
			public void run() {
			// 3��todo-list������GameOver��Ч 
				for (int i = 18; i > 2; i--) {
					System.out.println("��Ϸ���������ˣ�");
					ref.setBounds(40 * 10, 40 * i, 9 * 40, 8 * 40);
					
//					ÿ ���������ƶ�һ�񣬱�ʾһ���ƶ�
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		RunPic.start();
	}

	// ׼��ͼƬ��Ϸ���������GameOver��ͼƬ
	public Image getGameOverImage() {
		Image image = null;
		try {
			image = ImageIO.read(new File("Images\\04gameOver.png")).
					getScaledInstance(9 * 40, 8 * 40,Image.SCALE_DEFAULT); // �����ͼƬ����Ϊ��Ҫ�Ŀ�߶�
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
}
