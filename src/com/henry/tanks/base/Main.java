package com.henry.tanks.base;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glScissor;
import static org.lwjgl.opengl.GL11.glViewport;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static com.henry.tanks.base.Constants.*;

/**
 * This class is the game engine. It holds the code
 * for the window, all the opengl initialization,
 * main game loop, and clean up.
 * @author Samuel Henry
 * @version 1.0
 * @since March 14, 2014
 */
public class Main {
	
	public static boolean fullscreen = FULLSCREEN; //If fullscreen
	private static boolean vSyncEnabled = VSYNC;//If vSync is wanted
	private static boolean resizable = RESIZABLE;   //If window is resizable
	private static Game game;				   //The main game
	private static int fps = FPS;			   //Fps
	public static int WindowWidth = WINDOW_WIDTH, WindowHeight = WINDOW_HEIGHT; //Window size
	
	/**
	 * Main method of the whole game
	 * @param args Arguments sent from console
	 */
	public static void main(String[] args) {
		initDisplay(); 	//Initialize the Display (create and show)
		glInit(); 		//Initialize the OpenGL to be utilized in the game
		initInput(); 	//Initialize the Keyboard and Mouse input
		
		mainLoop(); 	//Game Loop
		
		cleanUp(); 		//Destroy mouse, keyboard, and display
	}
	
	/**
	 * Game loop
	 */
	private static void mainLoop() {
		game = new Game(); 						//Create a new instance of the game object, which controls just about everything
		
		while(!Display.isCloseRequested()) { 	//While the user hasn't exited the game
			game.getInput(); 					//Get input  (mouse/keyboard)
			update();							//Update everything
			render(); 							//Draw everything to the Display
		}
	}

	/**
	 * Update everything that needs to be updated
	 */
	private static void update() {
		if(Display.wasResized()) { //If user resizes window, keep everything up to date
			WindowWidth = Display.getWidth();
			WindowHeight = Display.getHeight();

			glMatrixMode(GL_PROJECTION); //Load projection matrix
	        glLoadIdentity();	//Load projection identity
	        glViewport(0, 0, WindowWidth, WindowHeight);
	        glScissor(0, 0, WindowWidth, WindowHeight);
	        glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1); //Set the clipping
	        glMatrixMode(GL_MODELVIEW); //Load modelview matrix
		}
		
		game.update(); //Update everything in the actual game
	}
	
	/**
	 * Draw everything to the screen
	 */
	private static void render() {
		glClear(GL_COLOR_BUFFER_BIT);		//Clear buffers to presets
        glLoadIdentity();					//Load the identity matrix for drawing
        
		game.render();						//Draw everything from the game to the buffer
		
		Display.update();					//Display the actual screen
		if(vSyncEnabled) Display.sync(fps);	//Try to go at desired fps (only if vSync enabled)
	}
	
	/**
	 * Initialize OpenGl
	 */
	private static void glInit() {
        glClearColor(0, 0, 0, 1);	//Set background color
        
        glDisable(GL_DEPTH_TEST);	//Don't allow depth testing
        glEnable(GL_TEXTURE_2D);	//Enable 2 dimensional textures
        
        glEnable(GL_BLEND);			//Enable alpha or transparency
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);	//Finish enabling alpha
        
        glMatrixMode(GL_PROJECTION); //Load projection matrix
        glLoadIdentity();	//Load projection identity
        glViewport(0, 0, WindowWidth, WindowHeight);
        glScissor(0, 0, WindowWidth, WindowHeight);
        glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1); //Set the clipping
        glMatrixMode(GL_MODELVIEW); //Load modelview matrix
	}
	
	/**
	 * Initialize the Display
	 */
	private static void initDisplay() {
		try {
			if(fullscreen) {
				Display.setFullscreen(fullscreen);
			} else {
				Display.setDisplayMode(new DisplayMode(WindowWidth, WindowHeight)); //Set Display size
				Display.setResizable(resizable); //If window is resizable, make it resizable
			}
			Display.setVSyncEnabled(vSyncEnabled);		//Allow for vSync 
			Display.setTitle("Tank wars | Version 1.0");//Set the title
			Display.create();	//Actually make it visible
		} catch(LWJGLException e) { //If there's an error
			e.printStackTrace();
			System.out.println("Error creating Display");
			System.exit(1);
		}
	}
	
	/**
	 * Initialize keyboard and mouse
	 */
	private static void initInput() {
		try { //Create keyboard and mouse
			Keyboard.create();
			Mouse.create();
		} catch(LWJGLException e) { //If there's and error
			e.printStackTrace();
			System.out.println("Error loading mouse/keyboard");
			System.exit(1);
		}
	}
	
	/**
	 * Destroy mouse, game, keyboard, display
	 */
	private static void cleanUp() {
		game = null; //Destroy the game
		Display.destroy(); //Destroy Display
		Keyboard.destroy();//Destroy Keyboard
		Mouse.destroy();   //Destroy Mouse
	}
}