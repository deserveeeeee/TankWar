package com.game.ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.WindowConstants;



public class GameStart {
	
	void start(){
//		JFrame：窗口
//		JPanel：视图
//		JLabel：标签（文本或图片）
//		JButton：按钮
		
//		大小、位置：
//		Bounds：size、position
//		Color:颜色
//		text：文字
//		Font：字体
		
//		先有一个窗口，设置它的大小、背景色还有
		JFrame jFrame = new JFrame("Tank War");
		jFrame.setBounds(0,0,1024,768);
		jFrame.setBackground(Color.black);
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		在这个窗口里面放panel
		MainPanel panel = MainPanel.getInstance();
		jFrame.setContentPane(panel);
//      显示窗口
		jFrame.setVisible(true);
		
	}

	
	public static void main(String[] args) {
		new GameStart().start();
	}

}
