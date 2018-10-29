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
		this.setBounds(0, 0, 1024, 768); // 直接以屏幕大小作为当前视图
		// this.setBackground(Color.blue);
		this.setLayout(null); // 自动布局，用约束的方式，确定界面组件的位置和宽高

		this.addChild(); // 添加放在自身上面的子视图
		this.addChildHome();
		this.addChildMine();
		this.addChildEnemy1();
		this.addChildEnemy2();
	}

	public void addChild() {
		// 在这个panel里面添加元素
		// 每一个imageLable元素是用excel设计好的图片
		
		// 设置位置和imageLable大小
		for (int i = 0; i < 33; i++) {
			for (int j = 0; j < 18; j++) {
//				在这个panel上新建一个imageLable
				JLabel imageLable = new JLabel();
				// 在i、j坐标放一个大小为40*40大小的lable
				imageLable.setBounds(40 * i, 40 * j, 40, 40);
				// 在这个lable分别放图片。
				if (DataCenter.map[j][i] == 0) {
					continue;
				}
				imageLable.setIcon(new ImageIcon(DataCenter.getImage(DataCenter.map[j][i])));
				this.add(imageLable); // 构建好控件之后，不要忘记添加
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
