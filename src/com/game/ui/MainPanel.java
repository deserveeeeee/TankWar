package com.game.ui;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.game.tanks.*;

public class MainPanel extends JPanel {
	public Map<Rectangle, JLabel> brickJLabels = new HashMap<Rectangle, JLabel>();
	public Map<Rectangle, JLabel> waterJLabels = new HashMap<Rectangle, JLabel>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
//	这就是作为的场景类对所有类进行开放
//	单例
//	单例模式：保证当前类有且仅有一个对象，不能创建新对象，因此所有其他类新new的对象都是这个对象（因为只有一个）、构造、产生和返回
//	单例模式的优势：穿透层级、降低类的周期性、降低类的创建（维护）难度
//	优势二：获取对象非常方便，不需要考虑耦合度、交叉、传值等问题
//	优势三：降低项目架构复杂度
	
	private static MainPanel mainPanel = null;
//	静态对象不释放
	public static MainPanel getInstance(){
		if (mainPanel == null) {   //如果对象为空，则完成构造
			mainPanel = new MainPanel();   // 这个动作就让static静态的这个mainPanel属性装那个唯一的东西
		}
		return mainPanel;   //不管是否有新建，static的属性都是固定的那个对象
	}
	
	
//  构造方法
//	单例模式要求，把构造方法私有→避免外部的类去new一个不相关的新
	private MainPanel() {
		this.setBounds(0, 0, 1024, 768); // 直接以屏幕大小作为当前视图
		this.setBackground(Color.black);
		this.setLayout(null); // 自动布局，用约束的方式，确定界面组件的位置和宽高

		this.addChild(); // 把设计的场景布局放入panel里面。
		
//		todo-list：
//		这里只是暂时这样写，然后看看能否把坦克给放上去
		this.add(new MineTank()); //最好不要这样写
		this.add(new HomeBoss());
//		敌方坦克暂时这样设置，后面需要动起来再修改
		/*
		EnemyTanks xEnemyTank1 = new EnemyTank01(4,	2,	1,	1);
		EnemyTanks xEnemyTank2 = new EnemyTank02(0,	2,	29,	1);
		EnemyTanks xEnemyTank3 = new EnemyTank03(6,	2,	15,	1);
		this.add(xEnemyTank1);
		this.add(xEnemyTank2);
		this.add(xEnemyTank3);
		*/
//		新建所有的坦克
		EnemyTanksManager xCreator = new EnemyTanksManager();
		for (EnemyTanks e : EnemyTanksManager.enemyTanks) {
			this.add(e);
		}
	}
	
	public void addChild() {   //设计布局场景：包括砖块、铁块、水块和草块等不移动的场景
		// 在这个panel里面添加元素
		// 每一个imageLable元素是用excel设计好的图片
		// 设置位置和imageLable大小
		for (int i = 0; i < 31; i++) {
			for (int j = 0; j < 18; j++) {
//				在这个panel上新建一个imageLable
				JLabel imageLable = new JLabel();
				// 在i、j坐标放一个大小为40*40大小的lable
				imageLable.setBounds(40 * i, 40 * j, 40, 40);
				// 在这个lable分别放图片。
				if (DataCenter.map[j][i] == -1) {
					continue;
				}
//				配置图片
				imageLable.setIcon(new ImageIcon(DataCenter.getImage(DataCenter.map[j][i])));
//				如果是砖头就把它加到这个砖头数组里面
				if (DataCenter.map[j][i] == 1) {
					brickJLabels.put(imageLable.getBounds(), imageLable);
				}
//				如果是水就把它加到这个水数组里面
				if (DataCenter.map[j][i] == 9) {
					waterJLabels.put(imageLable.getBounds(), imageLable);
				}
				this.add(imageLable); // 构建好控件之后，不要忘记添加
			}
		}
	}
}
