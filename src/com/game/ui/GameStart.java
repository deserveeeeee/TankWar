package com.game.ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.WindowConstants;



public class GameStart {
	
	void start(){
//		JFrame������
//		JPanel����ͼ
//		JLabel����ǩ���ı���ͼƬ��
//		JButton����ť
		
//		��С��λ�ã�
//		Bounds��size��position
//		Color:��ɫ
//		text������
//		Font������
		
//		����һ�����ڣ��������Ĵ�С������ɫ����
		JFrame jFrame = new JFrame("Tank War");
		jFrame.setBounds(0,0,1024,768);
		jFrame.setBackground(Color.black);
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		��������������panel
		MainPanel panel = MainPanel.getInstance();
		jFrame.setContentPane(panel);
//      ��ʾ����
		jFrame.setVisible(true);
		
	}

	
	public static void main(String[] args) {
		new GameStart().start();
	}

}
