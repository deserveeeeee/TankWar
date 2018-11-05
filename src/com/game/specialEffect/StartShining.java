package com.game.specialEffect;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.game.tanks.EnemyTank01;
import com.game.tanks.EnemyTank02;
import com.game.tanks.EnemyTank03;
import com.game.tanks.TanksManager;
import com.game.tanks.MineTank;
import com.game.ui.MainPanel;

public class StartShining extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StartShining(int x,int y ){
		
		StartShining ref = this;
		
		Thread sThread = new Thread(new Runnable() {
			
			@Override
			public synchronized void run() {
				for (int i = 0; i < 4; i++) {
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					ref.setBounds(x*40,y*40,40,40);
					ref.setIcon(new ImageIcon(getStarsImage(i)));
				}
				
				MainPanel.getInstance().remove(ref);
				
				switch (x) {
				case 1:
//					第一个敌方坦克
					MainPanel.getInstance().tanksManager1 = new TanksManager();
					MainPanel.getInstance().add(new EnemyTank01(4,	2,	1,	1));
					break;

				case 15:
//					第二个敌方坦克
					MainPanel.getInstance().tanksManager2 = new TanksManager();
					MainPanel.getInstance().add(new EnemyTank03(6,	2,	15,	1));
					break;
					
				case 29:
//					第三个敌方坦克
					MainPanel.getInstance().tanksManager3 = new TanksManager();
					MainPanel.getInstance().add(new EnemyTank02(0,	2,	29,	1));
					break;
				}
			}
		});
		
		sThread.start();
	}
	
//	准备星星的图片
	public static Image getStarsImage(int x) { 
		Image image = null;
		try {
			image = ImageIO.read(new File("Images\\10star.bmp"))
					.getSubimage(x*32, 0, 32, 32)    //先截取需要的小图片
					.getScaledInstance(40, 40, Image.SCALE_DEFAULT);   //再把这个图片设置为需要的宽高度→40*40像素的大小
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
	
}
