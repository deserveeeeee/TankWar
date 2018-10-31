package com.game.map;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class DataCenter {
	public static int[][] map = { 
			{8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8},
			{8,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	9,	9,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	8},
			{8,	1,	1,	1,	1,	-1,	-1,	-1,	9,	-1,	-1,	-1,	-1,	5,	5,	5,	-1,	-1,	-1,	-1,	9,	9,	9,	1,	1,	1,	1,	-1,	-1,	-1,	8},
			{8,	-1,	-1,	1,	1,	1,	1,	-1,	-1,	1,	1,	1,	1,	-1,	-1,	5,	5,	5,	-1,	-1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	8},
			{8,	-1,	-1,	1,	1,	8,	8,	1,	1,	1,	1,	1,	1,	1,	-1,	5,	5,	5,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	8},
			{8,	-1,	-1,	-1,	-1,	8,	8,	1,	1,	8,	8,	5,	1,	1,	-1,	-1,	-1,	9,	9,	9,	9,	-1,	-1,	1,	1,	1,	1,	-1,	-1,	-1,	8},
			{8,	-1,	9,	9,	9,	1,	1,	1,	1,	8,	8,	5,	1,	1,	-1,	1,	1,	9,	9,	9,	9,	-1,	1,	1,	1,	1,	1,	1,	1,	1,	8},
			{8,	-1,	9,	9,	9,	1,	1,	1,	1,	1,	1,	1,	1,	1,	-1,	1,	1,	-1,	-1,	-1,	-1,	-1,	1,	1,	-1,	-1,	1,	1,	1,	1,	8},
			{8,	-1,	9,	9,	9,	-1,	-1,	-1,	1,	1,	1,	1,	-1,	-1,	-1,	-1,	-1,	-1,	1,	1,	-1,	-1,	1,	1,	-1,	1,	1,	-1,	-1,	-1,	8},
			{8,	-1,	9,	9,	9,	-1,	8,	8,	-1,	-1,	-1,	8,	8,	8,	8,	8,	8,	8,	8,	-1,	-1,	-1,	-1,	-1,	-1,	1,	1,	-1,	-1,	-1,	8},
			{8,	-1,	9,	-1,	-1,	-1,	-1,	8,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	5,	5,	5,	5,	5,	5,	5,	5,	5,	5,	5,	5,	5,	8},
			{8,	-1,	9,	-1,	-1,	-1,	-1,	8,	8,	-1,	9,	9,	9,	9,	9,	9,	-1,	5,	5,	5,	5,	5,	5,	5,	5,	5,	5,	5,	5,	5,	8},
			{8,	5,	5,	5,	5,	5,	-1,	-1,	-1,	-1,	9,	9,	9,	9,	9,	9,	-1,	5,	5,	5,	5,	-1,	-1,	8,	8,	8,	8,	-1,	-1,	-1,	8},
			{8,	5,	5,	5,	5,	5,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	-1,	5,	5,	5,	5,	-1,	8,	8,	-1,	-1,	-1,	-1,	-1,	-1,	8},
			{8,	-1,	-1,	-1,	-1,	-1,	1,	1,	-1,	8,	5,	5,	-1,	-1,	-1,	-1,	-1,	1,	1,	1,	-1,	8,	8,	-1,	1,	1,	5,	5,	5,	5,	8},
			{8,	-1,	1,	1,	1,	1,	1,	1,	-1,	5,	5,	5,	-1,	1,	1,	1,	-1,	5,	5,	1,	1,	1,	1,	1,	1,	1,	-1,	-1,	-1,	-1,	8},
			{8,	-1,	-1,	-1,	1,	-1,	1,	1,	-1,	-1,	5,	5,	-1,	1,	-1,	1,	-1,	5,	5,	-1,	-1,	1,	-1,	-1,	8,	8,	-1,	-1,	-1,	-1,	8},
			{8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8,	8},
	};
	
//	todo-list
//	用遍历文件夹的方式，直接通过路径访问img文件夹，获得其下所有文件名，然后全部按照编号放入map
//  所以就把下面手动添加的map方法修为为读取的方式
//	上面的map数组的数字也要进行修改
	

	static Map<Integer, String> keyImgNames = new TreeMap<Integer, String>();
	
	// 静态构造方法：根据key的值找出名字
	static {
		// 自动设置的方法
		File imagesFile = new File("Images");
		File[] images = imagesFile.listFiles();
		for (int i = 0; i < images.length; i++) {
			keyImgNames.put(i, images[i].getName());
		}
		/*
		 具体的key对应的图片为
		0	blast
		1	brick
		2	bullet
		3	Enemytanks
		4	gameover
		5	grass
		6	home
		7	MineTank
		8	steels
		9	water
		 * */
		/*  手工设置的方法
		keyImgNames.put(4, "grass.png");
		keyImgNames.put(6, "brick.png");
		keyImgNames.put(7, "water.png");
		keyImgNames.put(9, "steels.png");
		keyImgNames.put(0, "home.jpg");
		keyImgNames.put(1, "tankD.gif");
		keyImgNames.put(2, "tankR.gif");
		keyImgNames.put(3, "mine.png");
		*/
	}

	
//	准备场景们的图片：砖头、铁块、水、草
	public static Image getImage(int key) {  //仅用来构造场景：即不会动的那些
		// 先准备好一张改变大小、截取过像素的图片
		// 把一张图片的大小进行截取
		Image image = null;
		try {
			image = ImageIO.read(new File("Images\\" + keyImgNames.get(key)))
					.getScaledInstance(40, 40,Image.SCALE_DEFAULT);
			// 这是把图片都设置为40*40像素的大小。
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
	
//	准备我方坦克的图片
	public static Image getMineTankImage(int x ,int y) { 
		Image image = null;
		try {
			image = ImageIO.read(new File("Images\\07MineTank.gif"))
					.getSubimage(x*28, y*28, 28, 28)    //先截取需要的小图片
					.getScaledInstance(40, 40, Image.SCALE_DEFAULT);   //再把这个图片设置为需要的宽高度→40*40像素的大小
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
	
	
//	准备老大坦克的图片
	public static Image getHomeBossImage() { 
		Image image = null;
		try {
			image = ImageIO.read(new File("Images\\06home.jpg"))
					.getScaledInstance(40, 40, Image.SCALE_DEFAULT);   //把这个图片设置为需要的宽高度→40*40像素的大小
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
	
//	准备敌方坦克的图片
	public static Image getEnemyTankImage(int x ,int y) { 
		Image image = null;
		try {
			image = ImageIO.read(new File("Images\\03Enemytanks.bmp"))
					.getSubimage(x*28, (y+4)*28, 28, 28)    //先截取需要的小图片
					.getScaledInstance(40, 40, Image.SCALE_DEFAULT);   //再把这个图片设置为需要的宽高度→40*40像素的大小
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
	
	
	
//	准备子弹的图片
	public static Image getBulletImage(int x) { 
		Image image = null;
		try {
			image = ImageIO.read(new File("Images\\02bullet.png"))
					.getSubimage(x*32, 0, 32, 32)    //先截取需要的小图片
					.getScaledInstance(40, 40, Image.SCALE_DEFAULT);   //再把这个图片设置为需要的宽高度→40*40像素的大小
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}

//	子弹碰到砖头，子弹消失、砖头消失的方法
	public static void brickDisappear(Rectangle rec){
		map[rec.y/40][rec.x/40] = -1;
		MainPanel.getInstance().remove(
				MainPanel.getInstance().brickJLabels.get(rec));
		MainPanel.getInstance().brickJLabels.remove(rec);
//		Rectangle imageLable = imageLable.getBounds();
//		先只让这个地方变成-1，看砖头图片能否消失
//		MainPanel.getInstance().remove(comp);
	}
}
