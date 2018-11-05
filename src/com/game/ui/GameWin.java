package com.game.ui;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.game.tanks.TanksManager;

public class GameWin extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static GameWin gameWinPic = null;
//	��̬�����ͷ�
	public static GameWin getInstance(){
		if (gameWinPic == null) {   //�������Ϊ�գ�����ɹ���
			gameWinPic = new GameWin();   // �����������static��̬�����mainPanel����װ�Ǹ�Ψһ�Ķ���
		}
		return gameWinPic;   //�����Ƿ����½���static�����Զ��ǹ̶����Ǹ�����
	}

	
	 private GameWin() {
		this.setIcon(new ImageIcon(this.getGameWinImage()));
		this.setBounds(40 * 10, 40 * 3, 9 * 40, 8 * 40);
		this.setVisible(false);
	}
	 
//	 ��Ϸ�������ͻḡ��ͼƬ
	 public void floatPic(){
// 1����Ϸ�������ҷ�̹�˽�������¼�  
		TanksManager.mineTank.listener = false;
//		 2����Ϸ������ͼƬ��������
		this.setVisible(true);
	 }

	// ׼��ͼƬ��Ϸ���������GameWin��ͼƬ
	public Image getGameWinImage() {
		Image image = null;
		try {
			image = ImageIO.read(new File("Images\\11win.jpg")).
					getScaledInstance(9 * 40, 8 * 40,Image.SCALE_DEFAULT); // �����ͼƬ����Ϊ��Ҫ�Ŀ�߶�
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
}
