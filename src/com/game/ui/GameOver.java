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
//	静态对象不释放
	public static GameOver getInstance(){
		if (gameOverPic == null) {   //如果对象为空，则完成构造
			gameOverPic = new GameOver();   // 这个动作就让static静态的这个mainPanel属性装那个唯一的东西
		}
		return gameOverPic;   //不管是否有新建，static的属性都是固定的那个对象
	}

	
	 private GameOver() {
		this.setIcon(new ImageIcon(this.getGameOverImage()));
		this.setBounds(40 * 10, 40 * 18, 9 * 40, 8 * 40);
		this.setVisible(false);
	}
	 
//	 游戏结束，就会浮动图片
	 public void floatPic(){
			// 1、游戏结束让我方坦克解除监听事件  
		 EnemyTanksManager.mineTank.listener = false;
//		 2、游戏结束让图片浮动起来
				this.setVisible(true);
				GameOver ref = this;
				
				Thread RunPic = new Thread(new Runnable() {
					@Override
					public void run() {
					// 3、todo-list：播放GameOver音效 
						for (int i = 18; i > 2; i--) {
							System.out.println("游戏真正结束了！");
							ref.setBounds(40 * 10, 40 * i, 9 * 40, 8 * 40);
							
//							每 毫秒向上移动一格，表示一种移动
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
