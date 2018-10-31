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
//	�ñ����ļ��еķ�ʽ��ֱ��ͨ��·������img�ļ��У�������������ļ�����Ȼ��ȫ�����ձ�ŷ���map
//  ���ԾͰ������ֶ���ӵ�map������ΪΪ��ȡ�ķ�ʽ
//	�����map���������ҲҪ�����޸�
	

	static Map<Integer, String> keyImgNames = new TreeMap<Integer, String>();
	
	// ��̬���췽��������key��ֵ�ҳ�����
	static {
		// �Զ����õķ���
		File imagesFile = new File("Images");
		File[] images = imagesFile.listFiles();
		for (int i = 0; i < images.length; i++) {
			keyImgNames.put(i, images[i].getName());
		}
		/*
		 �����key��Ӧ��ͼƬΪ
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
		/*  �ֹ����õķ���
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

	
//	׼�������ǵ�ͼƬ��שͷ�����顢ˮ����
	public static Image getImage(int key) {  //���������쳡���������ᶯ����Щ
		// ��׼����һ�Ÿı��С����ȡ�����ص�ͼƬ
		// ��һ��ͼƬ�Ĵ�С���н�ȡ
		Image image = null;
		try {
			image = ImageIO.read(new File("Images\\" + keyImgNames.get(key)))
					.getScaledInstance(40, 40,Image.SCALE_DEFAULT);
			// ���ǰ�ͼƬ������Ϊ40*40���صĴ�С��
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
	
//	׼���ҷ�̹�˵�ͼƬ
	public static Image getMineTankImage(int x ,int y) { 
		Image image = null;
		try {
			image = ImageIO.read(new File("Images\\07MineTank.gif"))
					.getSubimage(x*28, y*28, 28, 28)    //�Ƚ�ȡ��Ҫ��СͼƬ
					.getScaledInstance(40, 40, Image.SCALE_DEFAULT);   //�ٰ����ͼƬ����Ϊ��Ҫ�Ŀ�߶ȡ�40*40���صĴ�С
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
	
	
//	׼���ϴ�̹�˵�ͼƬ
	public static Image getHomeBossImage() { 
		Image image = null;
		try {
			image = ImageIO.read(new File("Images\\06home.jpg"))
					.getScaledInstance(40, 40, Image.SCALE_DEFAULT);   //�����ͼƬ����Ϊ��Ҫ�Ŀ�߶ȡ�40*40���صĴ�С
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
	
//	׼���з�̹�˵�ͼƬ
	public static Image getEnemyTankImage(int x ,int y) { 
		Image image = null;
		try {
			image = ImageIO.read(new File("Images\\03Enemytanks.bmp"))
					.getSubimage(x*28, (y+4)*28, 28, 28)    //�Ƚ�ȡ��Ҫ��СͼƬ
					.getScaledInstance(40, 40, Image.SCALE_DEFAULT);   //�ٰ����ͼƬ����Ϊ��Ҫ�Ŀ�߶ȡ�40*40���صĴ�С
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
	
	
	
//	׼���ӵ���ͼƬ
	public static Image getBulletImage(int x) { 
		Image image = null;
		try {
			image = ImageIO.read(new File("Images\\02bullet.png"))
					.getSubimage(x*32, 0, 32, 32)    //�Ƚ�ȡ��Ҫ��СͼƬ
					.getScaledInstance(40, 40, Image.SCALE_DEFAULT);   //�ٰ����ͼƬ����Ϊ��Ҫ�Ŀ�߶ȡ�40*40���صĴ�С
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}

//	�ӵ�����שͷ���ӵ���ʧ��שͷ��ʧ�ķ���
	public static void brickDisappear(Rectangle rec){
		map[rec.y/40][rec.x/40] = -1;
		MainPanel.getInstance().remove(
				MainPanel.getInstance().brickJLabels.get(rec));
		MainPanel.getInstance().brickJLabels.remove(rec);
//		Rectangle imageLable = imageLable.getBounds();
//		��ֻ������ط����-1����שͷͼƬ�ܷ���ʧ
//		MainPanel.getInstance().remove(comp);
	}
}
