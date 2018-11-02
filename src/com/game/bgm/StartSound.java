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
			url = uri.toURL(); // ������ַ
			AudioClip aau;
			aau = Applet.newAudioClip(url);
			aau.play();; // ѭ������
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

// private BuildPlayerOne player; // ���Ŷ���
//
// public PlayerBGM() {
// }
//
// // ���ŷ���
// public void playBGM(){
// try {
// player = Manager.createPlayer(new File("sound/start.wav").toURI().toURL());
// }catch(IOException e) {
// e.printStackTrace();
// return;
// }
// if (player == null) {
// System.out.println("�����ļ�Ϊ��");
// return;
// }
// }
// }

