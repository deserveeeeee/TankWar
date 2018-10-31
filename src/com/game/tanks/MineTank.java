package com.game.tanks;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.game.map.DataCenter;

public class MineTank extends AllTanks {
	Rectangle mineRec = new Rectangle(40 , 40);
	int mineC;
	
	public MineTank(){
//		��DataCenter�����ҷ�̹�˵�ͼƬ�Ѿ�׼�����ˣ�������Ҫ�����ͼƬ�����JLable��
//		�������ҷ�̹�˵�lable��С��λ��
		
		this.setBounds(40*12, 40*16, 40, 40);
		
//		��ʼ��������
		mineRec.setLocation(40*12, 40*16);
		
//		�ٰ�ͼƬ������ȥ
		this.setIcon(new ImageIcon(DataCenter.getMineTankImage(0, 0)));
		mineC = KeyEvent.VK_W;
		
		final MineTank ref = this;
//		���ü����¼���һ��Ҫ����������ý���
//		 һ������ļ����¼�����ֻ�ᱻһ������ץ��
	//  panel�ǿ�����Ϊ�����
//		�����������this.setFocusable(true);��ô������Ϊ�������ͼ������ץ������������¼���Ȼ�����ļ����¼��ͻ���Ч
		this.setFocusable(true);
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				mineRec = move(e.getKeyCode());
//				ref.move(e.getKeyCode());
//				ref.reDirection(e.getKeyCode());
				mineC = reDirection(e.getKeyCode());
			}
		});
	}
	
	
	int reDirection(int e ){  //����Ĳ�����ץ������keyֵ
		int b = 0 ;
		if (e == KeyEvent.VK_W) {  //w��ǰ��
			b = 0;
		}
		if (e == KeyEvent.VK_S) {  //S�Ǻ���
			b = 2;
		}
		if (e == KeyEvent.VK_A) {  //A������
			b = 3;
		}
		if (e == KeyEvent.VK_D) {  //D������
			b = 1;
		}
		this.setIcon(new ImageIcon(DataCenter.getMineTankImage(0, b)));
		return e;
	}
	
	
//	�ҷ�̹�������Ļ�����ô����3������ֵ��ÿ�������ͻᵼ���������ֵ-1��
//	��ʼ����ֵΪ2������Ϊminetank�����ԣ�
//	�������ֵΪ-1��ִ����
//	����Ӱ��map�����ã�������ʧ�˵�brick��Ȼ����ʧ״̬��
//	Ҳ����DataCenter��map����ͱ��ֱ������Ժ������
//	�ӵ������ҷ�̹�˵Ļ������߼���Ȼ���ӵ�����һ�������Ƿ��minetank��ǰ�����غ�
//	��ô���Ƿ�Ϳ�������һ���ҷ�̹�˵��������Ժ͵з�̹�˵���������
//	ÿ���ƶ�����Ժ󣬾����������ֵ���и���
//	����Ĵ������ʼΪ0,1,2.
//	����3���Ժ󣬾ͻ�����ҷ�̹�˵������¼�
//	����ɫ�ӵ���ɱ��������1����ɫ�ӵ���ɱ��������2����ɫ�ӵ���ɱ��������3.
//	���<0��������ҷ�̹�˵������¼��ˡ�
//	ͬ���з�̹��Ҳ�����������á�
//	�ҷ��ӵ�ÿ����з�̹�˵����棬����ɵз�̹�˵ı������-1
//	�з���ɫ̹�˳�ʼֵΪ2��ͬ�������<0������ɵз�̹�˵������¼��ˡ�
//	�з���ɫ̹�˳�ʼֵΪ1��ͬ�������<0������ɵз�̹�˵������¼��ˡ�
//	�з���ɫ̹�˳�ʼֵΪ0��ͬ�������<0������ɵз�̹�˵������¼��ˡ�
//	
}