package com.player.interfaces;

import java.io.File;

public interface PlayerInterface {
	public void open();
	public void play(File file);
	public void pause();
	public void stop();
}
