package com.player.otherclasses;

import java.io.File;

import com.player.interfaces.PlayerInterface;

import jaco.mp3.player.MP3Player;

public class PlayerMethods implements PlayerInterface{
	private MP3Player mp3player;
	
	public MP3Player getMp3player() {
		return mp3player;
	}

	public void setMp3player(MP3Player mp3player) {
		this.mp3player = mp3player;
	}


	public void open(File file){
		mp3player = new MP3Player(file);		
	}

	public void play(){
		mp3player.play();
	}

	public void pause(){
		mp3player.pause();
	}

	public void stop(){
		mp3player.stop();
	}

	
}
