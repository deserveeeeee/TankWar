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

}
