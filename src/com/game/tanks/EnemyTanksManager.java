package com.game.tanks;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.game.ui.MainPanel;


public class EnemyTanksManager {

//	����Ҫ���߼��ǣ������һ��̹�˵�������������һ��̹�˵Ĳ�����
//	����һ����̬�±�����ÿ���±���+1���ͻ���mainPaneladdһ��JLable�������JLable���������Ԥ����˵ģ���Ϸ�����Ҳ�����ں�̨�ģ�
	
	
	/*  ����ʵʱ���̹�˶����ǵ�����ֵ������������ֵС���㣬�ͻ���������¼�
	Thread killed = new Thread(new Runnable() {
		
		@Override
		public void run() {
			while(true){
				if (ref.lifeValue < 0) {
					ref.dead();
				}
			}
			
		}
	});
	
	killed.start();
	*/
	
	

//	�Ķ��ģ�
//  �з�̹���ǵĶ���ͳ�ʼλ�õ�����
	public static ArrayList<EnemyTanks> enemyTanks = new ArrayList<EnemyTanks>();

//	�Ķ��������һ����������װ�ез�̹�˵�ͼƬ��ȡ����ͳ�ʼ��λ����������������Ϸ������ں�̨�����޸ĺ����ã�
	private static int[][] enemyTanksData = {
			{4,	2,	1,	1},
			{0,	2,	29,	1},
			{6,	2,	15,	1},
	};
	
//	�Ķ��ˣ������еĶ������ã����ҷŽ�������������
	private static void createAllEnemyTanks(){
		for (int i = 0; i < enemyTanksData.length; i++) {
//			j������Ϊ��һ�У��±�Ϊ0����ʱ�򣬵õ��������Ĳ�ͬ������ɫ��̹��
			switch (enemyTanksData[i][0]) {
			case 4:   //��ɫ̹��
				EnemyTanks xEnemyTank1 = new EnemyTank01(enemyTanksData[i][0],enemyTanksData[i][1],enemyTanksData[i][2],enemyTanksData[i][3]);
				enemyTanks.add(xEnemyTank1);
				break;
			case 0:   //��ɫ̹��
				EnemyTanks xEnemyTank2 = new EnemyTank02(enemyTanksData[i][0],enemyTanksData[i][1],enemyTanksData[i][2],enemyTanksData[i][3]);
				enemyTanks.add(xEnemyTank2);
				break;
			case 6:    //��ɫ̹��
				EnemyTanks xEnemyTank3 = new EnemyTank03(enemyTanksData[i][0],enemyTanksData[i][1],enemyTanksData[i][2],enemyTanksData[i][3]);
				enemyTanks.add(xEnemyTank3);
				break;
			}

		}
	}
	

//	�Ķ��ˣ���ǰ����������±���
	int enemyTanksScript;
	public static Map<Rectangle, EnemyTanks> enemyTanksLocations = new HashMap<Rectangle, EnemyTanks>();
	
//  ���췽��
	public EnemyTanksManager(){
//		�Ķ��ߣ����ез����������飬׼�������еĶԷ�̹�˶���
		createAllEnemyTanks();
		enemyTanksScript = 3;
	}
	
//	�Ķ��ţ����������¼�
	
	public static void dead(EnemyTanks x){
//		��MainPanel����������Ƴ���Ȼ��ˢ��ҳ��
		MainPanel.getInstance().remove(x);
		MainPanel.getInstance().repaint();
//		���Ƴ����map�ж�Ӧ�ļ�ֵ��
		enemyTanksLocations.remove(x);
	}
	

}
