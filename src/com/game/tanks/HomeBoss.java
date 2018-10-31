package com.game.tanks;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.xml.crypto.Data;

import com.game.ui.DataCenter;

public class HomeBoss extends JLabel {
	public HomeBoss(){
		this.setBounds(40*14, 40*16, 40, 40);
		this.setIcon(new ImageIcon(DataCenter.getHomeBossImage()));
	}
}
