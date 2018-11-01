package com.game.bullet;

import java.awt.Rectangle;

import com.game.tanks.EnemyTank01;
import com.game.tanks.EnemyTanks;
import com.game.tanks.EnemyTanksManager;
import com.game.ui.DataCenter;
import com.game.ui.MainPanel;

public class MineBullets extends AllBullets {

	public MineBullets(Rectangle rec, int c) {
		super(rec, c);
		
	}
	
	@Override
//  �ӵ�����������Ʒ�ķ������ҷ��ӵ��͵з��ӵ���ͬ�ĵз��������ҷ��ӵ�ֻ��з�̹��
	void collision(Rectangle rec) {
		int i = rec.y / 40; // �Ǿ��ε�y���Ƕ�ά���������
		int j = rec.x / 40; // �Ǿ��ε�x���Ƕ�ά���������

		// �Ȳ�Ҫ�����߽�
		if (i >= DataCenter.map.length || j >= DataCenter.map[0].length) {
			xThread.interrupt();
		}else {
			int k = DataCenter.map[i][j];
//			���������שͷ����שͷ��ʧ
			if (k == 1) {
				DataCenter.brickDisappear(rec);
				xThread.interrupt();
			}
//			��������˸�
			if (k == 8) {
				xThread.interrupt();
			}
			
//			��������˵з�̹�ˣ�����ֻ��ʱд�˵ط���ɫ̹�ˣ�
			if(EnemyTanksManager.enemyTanksLocations.containsKey(rec)){
				EnemyTanks x = EnemyTanksManager.enemyTanksLocations.get(rec);
				EnemyTanksManager.dead(x);
				xThread.interrupt();
			}
			
		}
	}

}
