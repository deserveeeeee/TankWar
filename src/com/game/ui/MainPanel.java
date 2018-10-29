package com.game.ui;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.crypto.Data;

import com.game.map.DataCenter;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainPanel() {
		this.setBounds(0, 0, 1024, 768); // ֱ������Ļ��С��Ϊ��ǰ��ͼ
		// this.setBackground(Color.blue);
		this.setLayout(null); // �Զ����֣���Լ���ķ�ʽ��ȷ�����������λ�úͿ��

		this.addChild(); // ��ӷ����������������ͼ
		this.addChildHome();
		this.addChildMine();
		this.addChildEnemy1();
		this.addChildEnemy2();
	}

	public void addChild() {
		// �����panel�������Ԫ��
		// ÿһ��imageLableԪ������excel��ƺõ�ͼƬ
		
		// ����λ�ú�imageLable��С
		for (int i = 0; i < 33; i++) {
			for (int j = 0; j < 18; j++) {
//				�����panel���½�һ��imageLable
				JLabel imageLable = new JLabel();
				// ��i��j�����һ����СΪ40*40��С��lable
				imageLable.setBounds(40 * i, 40 * j, 40, 40);
				// �����lable�ֱ��ͼƬ��
				if (DataCenter.map[j][i] == 0) {
					continue;
				}
				imageLable.setIcon(new ImageIcon(DataCenter.getImage(DataCenter.map[j][i])));
				this.add(imageLable); // �����ÿؼ�֮�󣬲�Ҫ�������
			}
		}
	}
	
	public void addChildHome(){
		JLabel imageLable = new JLabel();
		imageLable.setBounds(40 * 15, 40 * 16, 40, 40);
		imageLable.setIcon(new ImageIcon(DataCenter.getImage(0)));
		this.add(imageLable);
	}
	
	
	public void addChildMine(){
		JLabel imageLable = new JLabel();
		imageLable.setBounds(40 * 13, 40 * 16, 40, 40);
		imageLable.setIcon(new ImageIcon(DataCenter.getImage(3)));
		this.add(imageLable);
	}
	
	public void addChildEnemy1(){
		JLabel imageLable = new JLabel();
		imageLable.setBounds(40 * 2, 40 * 1, 40, 40);
		imageLable.setIcon(new ImageIcon(DataCenter.getImage(1)));
		this.add(imageLable);
	}
	
	public void addChildEnemy2(){
		JLabel imageLable = new JLabel();
		imageLable.setBounds(40 * 28, 40 * 1, 40, 40);
		imageLable.setIcon(new ImageIcon(DataCenter.getImage(2)));
		this.add(imageLable);
	}
}
