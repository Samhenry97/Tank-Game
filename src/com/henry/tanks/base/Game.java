package com.henry.tanks.base;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/**
 * This class is the framework of the whole game.
 * It holds all the different levels, and controls
 * updating and drawing objects to the screen.
 * @author Samuel Henry
 * @version 1.0
 * @since March 14, 2014
 */
public class Game {
	public static float xOffs = 0, yOffs = 0; //X and Y offsets for 2D scrolling

	public static int totalLevels = Maps.maps.length; //The number of levels in the game
	public static int currentLevel = 2; //The level currently being played
	
	public Level[] levels = new Level[totalLevels]; //The array holding the levels
	
	/**
	 * Game constructor
	 */
	public Game() {
		for(int i = 0; i < totalLevels; i++) { //Read and create each level
			levels[i] = new Level(Maps.maps[i], this);
		}
	}
	
	/**
	 * Update characters and such
	 */
	public void update() {
		levels[currentLevel].update(); //Update the current level
	}
	
	/**
	 * Render everything to the screen/buffer
	 */
	public void render() {
		levels[currentLevel].render(); //Draw the current level
	}
	
	/**
	 * Get input from player
	 */
	public void getInput() {
		while(Keyboard.next()) {
			if(Keyboard.getEventKeyState()) {
				
			} else {
				
			}
		}
		if(Mouse.isButtonDown(1)) {
			levels[currentLevel].addBlock((int) (Mouse.getX() + xOffs), (int) (Mouse.getY() + yOffs));
		}
	}
}