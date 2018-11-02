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
			aau.play();; // 循环播放
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

// private BuildPlayerOne player; // 播放对象
//
// public PlayerBGM() {
// }
//
// // 播放方法
// public void playBGM(){
// try {
// player = Manager.createPlayer(new File("sound/start.wav").toURI().toURL());
// }catch(IOException e) {
// e.printStackTrace();
// return;
// }
// if (player == null) {
// System.out.println("播放文件为空");
// return;
// }
// }
// }

