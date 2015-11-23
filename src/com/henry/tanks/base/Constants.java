package com.henry.tanks.base;

/**
 * This class contains all the constants needed for the game.
 * @author Samuel Henry
 * @version 1.0
 * @since March 14, 2014
 */
public class Constants { //Constants for the game
	
	//Game startup constants
	public static int WINDOW_WIDTH = 800; //Width of window on startup
	public static int WINDOW_HEIGHT = 600; //Height of window on startup
	public static boolean FULLSCREEN = false; //Fullscreen on startup
	public static boolean VSYNC = true; //VSync enabled on startup
	public static boolean RESIZABLE = true; //If window is resizable
	public static int FPS = 60; //Preferred fps of game
	
	//Standard size of objects drawn to screen
	public static int STD_SIZE = 64; //Standard size of most objects in game
	public static int STD_SPEED = (int) ((float) STD_SIZE / 16.0f);
	
	//Root directory of files
	public static String ROOT_DIR = "res/";
	
	//Item constants
	public static int AMMO_ITEM_INCREASE = 40;
	
	//Player tank constants
	public static int PLAYER_REFRESH_RATE = 0;
	public static int PLAYER_HEALTH = 100;
	public static int PLAYER_SPEED = 4;
	public static int PLAYER_TOTAL_BULLETS = 20000;
	
	//Enemy tank constants
	public static int ENEMY_REFRESH_RATE = 8;
	public static int ENEMY_HEALTH = 5;
	public static int ENEMY_SPEED = 4;
	
	//Bullet constants
	public static int BULLET_ROTATION_SPEED = 20;
	public static int BUL_SIZE = STD_SIZE / 3; //Standard bullet size
	public static int BUL_SPEED = (int) Math.sqrt(STD_SIZE); //Standard bullet speed;
	public static int BULLET_MAX_DISTANCE = 600;
}
