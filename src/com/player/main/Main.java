/***
* Main class för MP3player application
* @author: Carina Ekström
* @version: 1.0
**/
package com.player.main;

import com.player.otherclasses.PlayerGUI;

public class Main {

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		PlayerGUI window = new PlayerGUI();
		window.getFrmMpplayer().setVisible(true);
	}

}
