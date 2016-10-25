package com.player.otherclasses;

import java.io.File;

import com.player.interfaces.PlayerInterface;

import jaco.mp3.player.MP3Player;

public class PlayerMethods implements PlayerInterface{
	private MP3Player mp3player;
	boolean isRunning = false;
	
	public MP3Player getMp3player() {
		return mp3player;
	}

	public void setMp3player(MP3Player mp3player) {
		this.mp3player = mp3player;
	}


	public void open(File file){
		if (isRunning)
			mp3player.stop();
		try{
			mp3player = new MP3Player(file);
			play();
		} catch(Exception e){
			e.getMessage();
		}
	}

	public void play(){
		try{
			isRunning = true;
			mp3player.play();
		} catch(NullPointerException e){
			e.getMessage();
		}
	}

	public void pause(){
		try{
			isRunning = true;
			mp3player.pause();
		} catch(NullPointerException e){
			e.getMessage();
		}
	}

	public void stop(){
		try{
			isRunning = false;
			mp3player.stop();
		} catch(NullPointerException e){
			e.getMessage();
		}
	}
}
