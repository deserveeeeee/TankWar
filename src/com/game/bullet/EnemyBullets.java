package com.game.bullet;

import java.awt.Rectangle;

import com.game.tanks.EnemyTanks;
import com.game.tanks.EnemyTanksManager;
import com.game.ui.DataCenter;
import com.game.ui.MainPanel;

public class EnemyBullets extends AllBullets {

	public EnemyBullets(Rectangle rec, int c) {
		super(rec, c);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
//  �ӵ�����������Ʒ�ķ������з��ӵ�����ͨ�ӵ���ͬ�ĵз������ڵз��ӵ�ֻ��з�̹��
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
			
//			��ͨ�ӵ����ǻ�����˺�ֵ-1.
			if (rec.x == EnemyTanksManager.mineTank.getBounds().x &&
					rec.y == EnemyTanksManager.mineTank.getBounds().y) {
				EnemyTanksManager.mineTank.lifeValue --;
				if (EnemyTanksManager.mineTank.lifeValue < 0) {
					EnemyTanksManager.mineTank.dead();
				}
				xThread.interrupt();
			}
		}
	}
// ��ͨ�ӵ�������ֵ��1����-1.
}
