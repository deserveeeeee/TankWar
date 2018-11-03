package com.game.bgm;


import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URI;
import java.net.URL;

public class StartSound {
	File f;
	URI uri;
	URL url;
	
	public StartSound(String path) {
		try {
			f = new File(path);
			uri = f.toURI();
			url = uri.toURL(); // 解析地址
			AudioClip aau;
			aau = Applet.newAudioClip(url);
			aau.play(); // 循环播放
			System.out.println("我开始播放背景音乐了");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


