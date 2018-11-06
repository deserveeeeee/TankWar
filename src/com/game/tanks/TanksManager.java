package com.game.tanks;


import java.util.Random;
import java.util.Vector;

import com.game.bullet.AllBullets;
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
//	���̹�˹���������װ��̹����
	public Vector<EnemyTanks> enemyTanks = new Vector<>();
	
//	����������̹�˹�����Ķ���
	public static TanksManager tanksManager1;
	public static TanksManager tanksManager2;
	public static TanksManager tanksManager3;
//	�ܵ�̹�˹����������
	public static int TanksManagerNum = 3;
	
	
//  ���췽�������췽�����Ǵ���һ������ĵз�̹��
	public TanksManager(){
		this.enemyTanksSum = 7;
	} 
	
//	����̹��
	public void createAdd(){
//		����½�һ��
		EnemyTanks xEnemyTanks = this.createRamEnemyTanks();
//		�ŵ���ͼ��
		MainPanel.getInstance().add(xEnemyTanks);
//		��������
		this.enemyTanks.add(xEnemyTanks);
//		ʣ��ĵз�̹����һ��
		enemyTanksSum --;
//		���ʣ��̹�����������ˣ����̹���������û����
		if (enemyTanksSum <= 0) {
			TanksManagerNum --;
		}
	}
	
//	�Ķ��ţ����������¼�
	public void dead(EnemyTanks x,AllBullets y){
//		�Ƴ����̹��
		x.alive = false;
		MainPanel.getInstance().remove(x);
//		�Ƴ�����ӵ�
		MainPanel.getInstance().remove(y);
		MainPanel.getInstance().repaint();
//		���Ƴ�Vector����װ������з�̹�˶���
		this.enemyTanks.remove(x);
		System.out.println("�ұ��Ƴ�����");
		
		if (enemyTanksSum > 0) {
//			�������̹����������ʹ�ã���ô�ʹ���һ����
			this.createAdd();
		}else if (TanksManagerNum <= 0) {
//			���Ҫ�ǵз�̹����û���ˣ���ô�Ϳ��Խ�����Ϸ�ˡ�
			GameWin.getInstance().floatPic();
		}
		
		
//		Thread wait = new Thread(new Runnable() {
//			public void run() {
////				��0.5�����ж��Ƿ�����µ�̹��
//				try {
//					Thread.sleep(50);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				if(enemyTanksSum <= 20){
//					MainPanel.getInstance().add(createRamEnemyTanks());
//					System.out.println("���ֳ�����");
//					enemyTanksSum ++;
//				}else if(enemyTanksSum > 20 && enemyTanks.size() <= 0) {
////					todo-list���������û�гɹ����úá�
////					����з�̹��û���� �� ��������Ҳû�ез�̹���ˡ�
//					GameWin.getInstance().floatPic();
//				}
//			}
//		});
	}
}
