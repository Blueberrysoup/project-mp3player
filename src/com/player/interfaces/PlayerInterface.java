/***
* PlayerInterface - Interface for MP3player
* @author: Carina Ekström
* @version: 1.0
**/
package com.player.interfaces;

import java.io.File;

public interface PlayerInterface {

	/**
	 * Open and play an MP3-file
	 * @param file MP3-file to open
	 */
	public void open(File file);
	
	/**
	 * Play an MP3-file
	 */	
	public void play();
	
	/**
	 * Pause the playing of an MP3-file
	 */
	public void pause();
	
	/**
	 * Stop the playing of an MP3-file
	 */
	public void stop();
}
