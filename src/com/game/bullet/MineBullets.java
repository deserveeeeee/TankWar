package com.game.bullet;

import java.awt.Rectangle;

import javax.lang.model.element.Element;
import javax.swing.ImageIcon;

import com.game.specialEffect.BoomEffect;
import com.game.tanks.AllTanks;
import com.game.tanks.EnemyTank01;
import com.game.tanks.EnemyTanks;
import com.game.tanks.TanksManager;
import com.game.ui.DataCenter;
import com.game.ui.GameOver;
import com.game.ui.MainPanel;

public class MineBullets extends AllBullets {
	
	public MineBullets(Rectangle rec, int c) {
		super(rec, c);
		
	}
	
	@Override
	void destroy(){
		MainPanel.getInstance().remove(this);
		MainPanel.getInstance().repaint();
		MainPanel.getInstance().add(new BoomEffect(this.getBounds()));
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
			
//			��������˵з�̹�ˣ�Vector�ķ���
			for (EnemyTanks xTank : TanksManager.tanksManager1.enemyTanks) {
				if (rec.x == xTank.getBounds().x && rec.y == xTank.getBounds().y) {
								xTank.lifeValue --;
								if (xTank.lifeValue < 0) {
									TanksManager.tanksManager1.dead(xTank,this);
								}
					xThread.interrupt();	
				}
			}		
			
			for (EnemyTanks xTank : TanksManager.tanksManager2.enemyTanks) {
				if (rec.x == xTank.getBounds().x && rec.y == xTank.getBounds().y) {
								xTank.lifeValue --;
								if (xTank.lifeValue < 0) {
									TanksManager.tanksManager2.dead(xTank,this);
								}
						xThread.interrupt();
					}
			}	
			
			for (EnemyTanks xTank : TanksManager.tanksManager3.enemyTanks) {
				if (rec.x == xTank.getBounds().x && rec.y == xTank.getBounds().y) {
								xTank.lifeValue --;
								if (xTank.lifeValue < 0) {
									TanksManager.tanksManager3.dead(xTank,this);
								}
						xThread.interrupt();
					}
			}	
//					todo-list�������̹�˱����һ�ȼ���̹��
//					else if (xTank.lifeValue == 0) {
//						xTank.setIcon(new ImageIcon(DataCenter.getEnemyTankImage(4, 0)));
//					}else if (xTank.lifeValue == 1) {
//						xTank.setIcon(new ImageIcon(DataCenter.getEnemyTankImage(0, 0)));
//					}else {
//						
//					}

		}
	}
}

