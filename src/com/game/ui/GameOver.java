package com.game.ui;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.game.tanks.EnemyTanksManager;
import com.game.tanks.MineTank;

public class GameOver extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static GameOver gameOverPic = null;
//	��̬�����ͷ�
	public static GameOver getInstance(){
		if (gameOverPic == null) {   //�������Ϊ�գ�����ɹ���
			gameOverPic = new GameOver();   // �����������static��̬�����mainPanel����װ�Ǹ�Ψһ�Ķ���
		}
		return gameOverPic;   //�����Ƿ����½���static�����Զ��ǹ̶����Ǹ�����
	}

	
	 private GameOver() {
		this.setIcon(new ImageIcon(this.getGameOverImage()));
		this.setBounds(40 * 10, 40 * 18, 9 * 40, 8 * 40);
		this.setVisible(false);
	}
	 
//	 ��Ϸ�������ͻḡ��ͼƬ
	 public void floatPic(){
			// 1����Ϸ�������ҷ�̹�˽�������¼�  
		 EnemyTanksManager.mineTank.listener = false;
//		 2����Ϸ������ͼƬ��������
				this.setVisible(true);
				GameOver ref = this;
				
				Thread RunPic = new Thread(new Runnable() {
					@Override
					public void run() {
					// 3��todo-list������GameOver��Ч 
						for (int i = 18; i > 2; i--) {
							System.out.println("��Ϸ���������ˣ�");
							ref.setBounds(40 * 10, 40 * i, 9 * 40, 8 * 40);
							
//							ÿ ���������ƶ�һ�񣬱�ʾһ���ƶ�
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
