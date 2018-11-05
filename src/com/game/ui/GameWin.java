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
//	静态对象不释放
	public static GameWin getInstance(){
		if (gameWinPic == null) {   //如果对象为空，则完成构造
			gameWinPic = new GameWin();   // 这个动作就让static静态的这个mainPanel属性装那个唯一的东西
		}
		return gameWinPic;   //不管是否有新建，static的属性都是固定的那个对象
	}

	
	 private GameWin() {
		this.setIcon(new ImageIcon(this.getGameWinImage()));
		this.setBounds(40 * 10, 40 * 3, 9 * 40, 8 * 40);
		this.setVisible(false);
	}
	 
//	 游戏结束，就会浮动图片
	 public void floatPic(){
// 1、游戏结束让我方坦克解除监听事件  
		TanksManager.mineTank.listener = false;
//		 2、游戏结束让图片浮动起来
		this.setVisible(true);
	 }

	// 准备图片游戏结束会出现GameWin的图片
	public Image getGameWinImage() {
		Image image = null;
		try {
			image = ImageIO.read(new File("Images\\11win.jpg")).
					getScaledInstance(9 * 40, 8 * 40,Image.SCALE_DEFAULT); // 把这个图片设置为需要的宽高度
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
}
