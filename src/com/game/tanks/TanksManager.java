package com.game.tanks;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

import com.game.bullet.AllBullets;
import com.game.ui.GameOver;
import com.game.ui.GameWin;
import com.game.ui.MainPanel;


public class TanksManager {
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
	private EnemyTanks createRamEnemyTanks(){
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
	

//	ÿһ��̹�˹����������̹������
	int enemyTanksSum;
//	�ܵ�̹�˹����������
	static int TanksManagerNum = 3;
//	static int enemyTanksSum = 3;
//	���̹�˹���������װ��̹����
	public Vector<EnemyTanks> enemyTanks = new Vector<>();
//	public static Vector<EnemyTanks> enemyTanks = new Vector<>();
	
//  ���췽�������췽�����Ǵ���һ������ĵз�̹��
	public TanksManager(){
		MainPanel.getInstance().add(createRamEnemyTanks());
		
		enemyTanksSum = 6;
	} 
	
//	����̹��
	public void createAdd(){
//		
		EnemyTanks xEnemyTanks = this.createRamEnemyTanks();
		MainPanel.getInstance().add(xEnemyTanks);
		this.enemyTanks.add(xEnemyTanks);
		enemyTanksSum --;
		if (enemyTanksSum <= 0) {
			TanksManagerNum --;
		}
	}
	
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
		x.alive = false;
		
		
		
		Thread wait = new Thread(new Runnable() {
			public void run() {
//				��0.5�����ж��Ƿ�����µ�̹��
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(enemyTanksSum <= 20){
					MainPanel.getInstance().add(createRamEnemyTanks());
					System.out.println("���ֳ�����");
					enemyTanksSum ++;
				}else if(enemyTanksSum > 20 && enemyTanks.size() <= 0) {
//					todo-list���������û�гɹ����úá�
//					����з�̹��û���� �� ��������Ҳû�ез�̹���ˡ�
					GameWin.getInstance().floatPic();
				}
			}
		});
		
	}
	

}
