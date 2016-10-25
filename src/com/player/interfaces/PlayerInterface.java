package com.player.interfaces;

import java.io.File;

public interface PlayerInterface {
	public void open(File file);
	public void play();
	public void pause();
	public void stop();
}
