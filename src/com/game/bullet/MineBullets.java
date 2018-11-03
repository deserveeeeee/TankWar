package com.game.bullet;

import java.awt.Rectangle;

import javax.lang.model.element.Element;

import com.game.specialEffect.BoomEffect;
import com.game.tanks.AllTanks;
import com.game.tanks.EnemyTank01;
import com.game.tanks.EnemyTanks;
import com.game.tanks.EnemyTanksManager;
import com.game.ui.DataCenter;
import com.game.ui.GameOver;
import com.game.ui.MainPanel;

public class MineBullets extends AllBullets {
	
	boolean kill;
	EnemyTanks killedTank;
	
	public MineBullets(Rectangle rec, int c) {
		super(rec, c);
		
	}
	
	@Override
	void destroy(){
		MainPanel.getInstance().remove(this);
		MainPanel.getInstance().repaint();
		MainPanel.getInstance().add(new BoomEffect(this.getBounds()));
		
		if (kill) {
			EnemyTanksManager.dead(killedTank,this);
		}else {
			
		}
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
			
// 			���������boss�ϴ����ֱ������Ϸ������ֱ�ӵ���GameOver������todo-list
			if (rec.x == 14*40 && rec.y==16*40) {
				System.out.println("���ϴ���");
				GameOver.getInstance().floatPic();
				xThread.interrupt();
			}
			
//			���������שͷ����שͷ��ʧ
			if (k == 1) {
				DataCenter.brickDisappear(rec);
				xThread.interrupt();
			}
//			��������˸�
			if (k == 8) {
				xThread.interrupt();
			}
			
//			��������˵з�̹�ˣ�Map�ķ���
			/*
			if(EnemyTanksManager.enemyTanksLocations.containsKey(rec)){
				EnemyTanks x = EnemyTanksManager.enemyTanksLocations.get(rec);
				x.lifeValue --;
				if (x.lifeValue < 0) {
					EnemyTanksManager.dead(x);
				}
				xThread.interrupt();
			}
			*/
//			��������˵з�̹�ˣ�Vector�ķ���
			for (EnemyTanks xTank : EnemyTanksManager.enemyTanks) {
				if (rec.x == xTank.getBounds().x && rec.y == xTank.getBounds().y) {
					
					xTank.lifeValue --;

					if (xTank.lifeValue < 0) {
						kill = true;
						killedTank= xTank;
					}
					
					xThread.interrupt();
				}
			}
		}
	}

}
