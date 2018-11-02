package com.game.tanks;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

import com.game.bullet.AllBullets;
import com.game.ui.MainPanel;


public class EnemyTanksManager {
//	��ֻ����ôһ���ҷ�̹�˵Ķ���
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
//			j������Ϊ��һ�У��±�Ϊ0����ʱ�򣬵õ��������Ĳ�ͬLevel��̹��
			switch (enemyTanksData[i][0]) {
			case 4:   //��ɫ̹��
				EnemyTanks xEnemyTank1 = new EnemyTank01(enemyTanksData[i][0],enemyTanksData[i][1],enemyTanksData[i][2],enemyTanksData[i][3]);
				return xEnemyTank1;
			case 0:   //��ɫ̹��
				EnemyTanks xEnemyTank2 = new EnemyTank02(enemyTanksData[i][0],enemyTanksData[i][1],enemyTanksData[i][2],enemyTanksData[i][3]);
				return xEnemyTank2;
			case 6:    //��ɫ̹��
				EnemyTanks xEnemyTank3 = new EnemyTank03(enemyTanksData[i][0],enemyTanksData[i][1],enemyTanksData[i][2],enemyTanksData[i][3]);
				return xEnemyTank3;
		}
			return null;
	}
	

//	ʣ��ĵз�̹������
	static int enemyTanksSum = 17;
	public static Vector<EnemyTanks> enemyTanks = new Vector<>();
	
//  ���췽��
	public EnemyTanksManager(){} 
	
//	�Ķ��ţ����������¼�
	
	public static void dead(EnemyTanks x,AllBullets y){
//		��MainPanel����������Ƴ���Ȼ��ˢ��ҳ��
		MainPanel.getInstance().remove(x);
		MainPanel.getInstance().remove(y);
		MainPanel.getInstance().repaint();
//		���Ƴ����map�ж�Ӧ�ļ�ֵ��
//		enemyTanksLocations.remove(x);
//		���Ƴ�Vector����װ������з�̹�˶���
		enemyTanks.remove(x);
		System.out.println("�ұ��Ƴ�����");
		enemyTanksSum --;
//		System.out.println(enemyTanksSum);
		x.alive = false;
		if(enemyTanksSum > 0){
			MainPanel.getInstance().add(createRamEnemyTanks());
			System.out.println("���ֳ�����");
		}
		
	}
	

}
