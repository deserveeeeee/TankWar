package com.game.bullet;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.game.specialEffect.BoomEffect;
import com.game.tanks.EnemyTanksManager;
import com.game.ui.DataCenter;
import com.game.ui.GameOver;
import com.game.ui.MainPanel;

public class AllBullets extends JLabel {
	Thread xThread;
	
	Map<Integer, Image> dirImages = new HashMap<Integer, Image>();
//  敌方子弹和我方子弹不同的地方就只在于它们能使得对方的生命值-1（普通子弹）。
//	其实子弹的构造方法就是发生子弹的方法，而这个方法必须要弄到接口里面
	public AllBullets(Rectangle rec, int c) {
//		新建的时候get子弹的图片
		dirImages.put(KeyEvent.VK_W ,DataCenter.getBulletImage(3));
		dirImages.put(KeyEvent.VK_S ,DataCenter.getBulletImage(1));
		dirImages.put(KeyEvent.VK_A ,DataCenter.getBulletImage(2));
		dirImages.put(KeyEvent.VK_D ,DataCenter.getBulletImage(0));
		this.setIcon(new ImageIcon(dirImages.get(c)));
//		设置要去的坐标位置。
		this.setBounds(rec);
//		新建线程
		final AllBullets ref = this;
		xThread = new Thread(new Runnable() {
			@Override
			public void run() {
				// 让这个线程每隔0.1秒就执行一次位置变化
				while(true){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						break;
					}
					Rectangle r = ref.getBounds();
					if (c == KeyEvent.VK_W) {  //w是前进
						r.y -= 40;
					}
					if (c == KeyEvent.VK_S) {  //S是后退
						r.y += 40;
					}
					if (c == KeyEvent.VK_A) {  //A是往左
						r.x -= 40;
					}
					if (c == KeyEvent.VK_D) {  //D是往右
						r.x += 40;
					}
					

					ref.collision(r);
					ref.flyStep(r);
					
				}
				
				ref.destroy();
				
			}
		});
		xThread.start();
	}
	
	
//	让子弹被移除的方法
	void destroy(){
		MainPanel.getInstance().remove(this);
		MainPanel.getInstance().repaint();
		MainPanel.getInstance().add(new BoomEffect(this.getBounds()));	
	}
	
	
//	子弹移动的方法
	void flyStep(Rectangle rec) {
		int i = rec.y / 40; // 是矩形的y，是二维数组的行数
		int j = rec.x / 40; // 是矩形的x，是二维数组的列数
		// 子弹碰到水的方法
		// 先不要超出边界
		if (i >= DataCenter.map.length || j >= DataCenter.map[0].length) {
			xThread.interrupt();
		}else{
			if (DataCenter.map[i][j] == 9) {
				// 当碰到水的时候，就把它移除，然后移动子弹，再重新布置水
				JLabel xJLabel = MainPanel.getInstance().waterJLabels.get(rec);
				MainPanel.getInstance().remove(xJLabel);
				this.setBounds(rec);
				MainPanel.getInstance().add(xJLabel);
				MainPanel.getInstance().repaint();
			} else {
				this.setBounds(rec);
			}
		}
	}
	
	
	// 子弹碰到场景物品的方法
	void collision(Rectangle rec) {
		int i = rec.y / 40; // 是矩形的y，是二维数组的行数
		int j = rec.x / 40; // 是矩形的x，是二维数组的列数

		// 先不要超出边界
		if (i >= DataCenter.map.length || j >= DataCenter.map[0].length) {
//			alive = false;
			xThread.interrupt();
		} else {
			int k = DataCenter.map[i][j];
			
// 			如果碰到了boss老大，则会直接让游戏结束。直接调用GameOver方法。todo-list
			if (rec.x == 14*40 && rec.y==16*40) {
				System.out.println("打到老大了");
				GameOver.getInstance().floatPic();
				xThread.interrupt();
			}
			// 如果碰到了砖头则让砖头消失
			if (k == 1) {
				DataCenter.brickDisappear(rec);
				xThread.interrupt();
			}
			// 如果碰到了钢
			if (k == 8) {
				xThread.interrupt();
			}
		}
	}
} 
