package com.game.boom;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.game.ui.DataCenter;
import com.game.ui.MainPanel;

public class BoomEffect extends JLabel {

	public BoomEffect(Rectangle xRectangle){
		
		BoomEffect ref = this;
		
		Thread bThread = new Thread(new Runnable() {
			
			@Override
			public void run() {	
				for (int i = 0; i < 10; i++) {
					
					try {
						Thread.sleep(70);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					ref.setBounds(xRectangle);
					ref.setIcon(new ImageIcon(getBulletImage(i)));
				}
				
				MainPanel.getInstance().remove(ref);
			}
		});
		
		bThread.start();
	}
	
//	准备子弹的图片
	private static Image getBulletImage(int x) { 
		Image image = null;
		try {
			image = ImageIO.read(new File("Images\\00blast.png"))
					.getSubimage(x*192, 0, 192, 192)   //先截取需要的小图片
					.getScaledInstance(40, 40, Image.SCALE_DEFAULT);   //再把这个图片设置为需要的宽高度→40*40像素的大小
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
}
