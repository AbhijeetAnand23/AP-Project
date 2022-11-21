package com.mygame.taskstars;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(1900, 915);
		config.setForegroundFPS(60);
		config.setTitle("Tank Stars");
		new Lwjgl3Application(new TankStars(), config);
	}
}
