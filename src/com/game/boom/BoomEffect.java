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
	
//	׼���ӵ���ͼƬ
	private static Image getBulletImage(int x) { 
		Image image = null;
		try {
			image = ImageIO.read(new File("Images\\00blast.png"))
					.getSubimage(x*192, 0, 192, 192)   //�Ƚ�ȡ��Ҫ��СͼƬ
					.getScaledInstance(40, 40, Image.SCALE_DEFAULT);   //�ٰ����ͼƬ����Ϊ��Ҫ�Ŀ�߶ȡ�40*40���صĴ�С
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
}
