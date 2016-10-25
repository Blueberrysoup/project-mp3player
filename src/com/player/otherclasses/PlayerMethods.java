/***
* PlayerMethods - Methods for MP3player application
* Uses external API JACo MP3 Player
* @author: Carina Ekström
* @version: 1.0
**/
package com.player.otherclasses;

import java.io.File;

import com.player.interfaces.PlayerInterface;

import jaco.mp3.player.MP3Player;

public class PlayerMethods implements PlayerInterface{
	private MP3Player mp3player;
	boolean isRunning = false;
	
	/**
	 * Get mp3player 
	 * @return mp3player
	 */
	public MP3Player getMp3player() {
		return mp3player;
	}

	/**
	 * Set mp3player 
	 * @param mp3player MP3-player
	 */
	public void setMp3player(MP3Player mp3player) {
		this.mp3player = mp3player;
	}

	/**
	 * Open and play an MP3-file
	 * @param file MP3-file to open and play
	 */
	public void open(File file){
		if (isRunning)
			mp3player.stop();
		try{
			mp3player = new MP3Player(file);
			play();
		} catch(NullPointerException e){
			e.getMessage();
		} catch(Exception e){
			e.getMessage();
		}
	}

	/**
	 * Play an MP3-file
	 */	
	public void play(){
		try{
			isRunning = true;
			mp3player.play();
		} catch(NullPointerException e){
			e.getMessage();
		} catch(Exception e){
			e.getMessage();
		}
	}

	/**
	 * Pause the playing of an MP3-file
	 */
	public void pause(){
		try{
			isRunning = true;
			mp3player.pause();
		} catch(NullPointerException e){
			e.getMessage();
		} catch(Exception e){
			e.getMessage();
		}
	}

	/**
	 * Stop the playing of an MP3-file
	 */
	public void stop(){
		try{
			isRunning = false;
			mp3player.stop();
		} catch(NullPointerException e){
			e.getMessage();
		} catch(Exception e){
			e.getMessage();
		}
	}
}
