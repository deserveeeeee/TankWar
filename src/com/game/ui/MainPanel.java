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

	
//	�������Ϊ�ĳ��������������п���
//	����
//	����ģʽ����֤��ǰ�����ҽ���һ�����󣬲��ܴ����¶������������������new�Ķ��������������Ϊֻ��һ���������졢�����ͷ���
//	����ģʽ�����ƣ���͸�㼶��������������ԡ�������Ĵ�����ά�����Ѷ�
//	���ƶ�����ȡ����ǳ����㣬����Ҫ������϶ȡ����桢��ֵ������
//	��������������Ŀ�ܹ����Ӷ�
	
	private static MainPanel mainPanel = null;
//	��̬�����ͷ�
	public static MainPanel getInstance(){
		if (mainPanel == null) {   //�������Ϊ�գ�����ɹ���
			mainPanel = new MainPanel();   // �����������static��̬�����mainPanel����װ�Ǹ�Ψһ�Ķ���
		}
		return mainPanel;   //�����Ƿ����½���static�����Զ��ǹ̶����Ǹ�����
	}
	
	
//  ���췽��
//	����ģʽҪ�󣬰ѹ��췽��˽�С������ⲿ����ȥnewһ������ص���
	private MainPanel() {
		this.setBounds(0, 0, 1024, 768); // ֱ������Ļ��С��Ϊ��ǰ��ͼ
		this.setBackground(Color.black);
		this.setLayout(null); // �Զ����֣���Լ���ķ�ʽ��ȷ�����������λ�úͿ��

		this.addChild(); // ����Ƶĳ������ַ���panel���档
		
//		todo-list��
//		����ֻ����ʱ����д��Ȼ�󿴿��ܷ��̹�˸�����ȥ
		this.add(new MineTank()); //��ò�Ҫ����д
		this.add(new HomeBoss());
//		�з�̹����ʱ�������ã�������Ҫ���������޸�
		/*
		EnemyTanks xEnemyTank1 = new EnemyTank01(4,	2,	1,	1);
		EnemyTanks xEnemyTank2 = new EnemyTank02(0,	2,	29,	1);
		EnemyTanks xEnemyTank3 = new EnemyTank03(6,	2,	15,	1);
		this.add(xEnemyTank1);
		this.add(xEnemyTank2);
		this.add(xEnemyTank3);
		*/
//		�½����е�̹��
		EnemyTanksManager xCreator = new EnemyTanksManager();
		for (EnemyTanks e : EnemyTanksManager.enemyTanks) {
			this.add(e);
		}
	}
	
	public void addChild() {   //��Ʋ��ֳ���������ש�顢���顢ˮ��Ͳݿ�Ȳ��ƶ��ĳ���
		// �����panel�������Ԫ��
		// ÿһ��imageLableԪ������excel��ƺõ�ͼƬ
		// ����λ�ú�imageLable��С
		for (int i = 0; i < 31; i++) {
			for (int j = 0; j < 18; j++) {
//				�����panel���½�һ��imageLable
				JLabel imageLable = new JLabel();
				// ��i��j�����һ����СΪ40*40��С��lable
				imageLable.setBounds(40 * i, 40 * j, 40, 40);
				// �����lable�ֱ��ͼƬ��
				if (DataCenter.map[j][i] == -1) {
					continue;
				}
//				����ͼƬ
				imageLable.setIcon(new ImageIcon(DataCenter.getImage(DataCenter.map[j][i])));
//				�����שͷ�Ͱ����ӵ����שͷ��������
				if (DataCenter.map[j][i] == 1) {
					brickJLabels.put(imageLable.getBounds(), imageLable);
				}
//				�����ˮ�Ͱ����ӵ����ˮ��������
				if (DataCenter.map[j][i] == 9) {
					waterJLabels.put(imageLable.getBounds(), imageLable);
				}
				this.add(imageLable); // �����ÿؼ�֮�󣬲�Ҫ�������
			}
		}
	}
}
