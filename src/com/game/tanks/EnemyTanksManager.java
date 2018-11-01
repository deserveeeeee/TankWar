package com.game.tanks;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

import com.game.ui.MainPanel;


public class EnemyTanksManager {
	public static MineTank mineTank;
//	�Ķ��������һ����������װ�ез�̹�˵�ͼƬ��ȡ����ͳ�ʼ��λ����������������Ϸ������ں�̨�����޸ĺ����ã�
	private static int[][] enemyTanksData = {
			{4,	2,	1,	1},
			{0,	2,	29,	1},
			{6,	2,	15,	1},
			{4,	2,	12,	1},
			{4,	2,	1,	1},
			{4,	2,	29,	8},
			{4,	2,	2,	4},
			{4,	2,	5,	1},
			{4,	2,	1,	1},
			{0,	2,	7,	3},
			{4,	2,	1,	1},
			{0,	2,	29,	1},
			{4,	2,	5,	2},
			{4,	2,	19,	2},
			{4,	2,	20,	1},
			{4,	2,	1,	1},
			{0,	2,	21,	7},
			{0,	2,	19,	2},
			{6,	2,	29,	1},
			{6,	2,	23,	4},

	};
	
//	�������һ��̹��
	private static EnemyTanks createRamEnemyTanks(){
		int i = new Random().nextInt(20);
//			j������Ϊ��һ�У��±�Ϊ0����ʱ�򣬵õ��������Ĳ�ͬ������ɫ��̹��
			switch (enemyTanksData[i][0]) {
			case 4:   //��ɫ̹��
				EnemyTanks xEnemyTank1 = new EnemyTank01(enemyTanksData[i][0],enemyTanksData[i][1],enemyTanksData[i][2],enemyTanksData[i][3]);
				MainPanel.getInstance().add(xEnemyTank1);
				enemyTanksSum --;
				return xEnemyTank1;
			case 0:   //��ɫ̹��
				EnemyTanks xEnemyTank2 = new EnemyTank02(enemyTanksData[i][0],enemyTanksData[i][1],enemyTanksData[i][2],enemyTanksData[i][3]);
				MainPanel.getInstance().add(xEnemyTank2);
				enemyTanksSum --;
				return xEnemyTank2;
			case 6:    //��ɫ̹��
				EnemyTanks xEnemyTank3 = new EnemyTank03(enemyTanksData[i][0],enemyTanksData[i][1],enemyTanksData[i][2],enemyTanksData[i][3]);
				MainPanel.getInstance().add(xEnemyTank3);
				enemyTanksSum --;
				return xEnemyTank3;
		}
			return null;
	}
	

//	�Ķ��ˣ���ǰ����������±���
	static int enemyTanksSum = 20;
	public static Map<Rectangle, EnemyTanks> enemyTanksLocations = new Hashtable<>();
	
//  ���췽��
	public EnemyTanksManager(){
		for (int i = 0; i < 3; i++) {
			createRamEnemyTanks();
		}
		
	} 
	
//	�Ķ��ţ����������¼�
	
	public static void dead(EnemyTanks x){
//		��MainPanel����������Ƴ���Ȼ��ˢ��ҳ��
		MainPanel.getInstance().remove(x);
		MainPanel.getInstance().repaint();
//		���Ƴ����map�ж�Ӧ�ļ�ֵ��
		enemyTanksLocations.remove(x);
		x.alive = false;
		if(enemyTanksSum > 0){
			createRamEnemyTanks();
		}
	}
	

}
