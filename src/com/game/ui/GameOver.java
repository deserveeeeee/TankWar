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

		// 1、游戏结束让我方坦克解除监听事件  ??这里设置不成功
		EnemyTanksManager.mineTank.requestFocusInWindow();
//		ref.getKeyListeners(); 这样是否可以取得键盘监听权限？然后用于做到下一关？
		// 2、出现GameOver图片线程
//		this.setBounds(0, 0, 1024, 768); // 直接以屏幕大小作为当前视图
//		this.setBackground(Color.black);
//		this.setLayout(null); // 自动布局，用约束的方式，确定界面组件的位置和宽高
//		如何让新出现的JLable处于最上层，或者设置一个可以移动的JPanel，这样是否能让它处于最上层？
		this.setIcon(new ImageIcon(this.getGameOverImage()));
		GameOver ref = this;
		Thread RunPic = new Thread(new Runnable() {
			@Override
			public void run() {
			// 3、todo-list：播放GameOver音效 
				for (int i = 18; i > 2; i--) {
					System.out.println("游戏真正结束了！");
					ref.setBounds(40 * 10, 40 * i, 9 * 40, 8 * 40);
					
//					每 毫秒向上移动一格，表示一种移动
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

	// 准备图片游戏结束会出现GameOver的图片
	public Image getGameOverImage() {
		Image image = null;
		try {
			image = ImageIO.read(new File("Images\\04gameOver.png")).
					getScaledInstance(9 * 40, 8 * 40,Image.SCALE_DEFAULT); // 把这个图片设置为需要的宽高度
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
}
