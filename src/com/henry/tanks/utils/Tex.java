package com.henry.tanks.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import static com.henry.tanks.base.Constants.*;

/**
 * This class holds all the textures for the game.
 * It includes the tanks, floors, walls, background,
 * and bullets. It allows you to load a texture
 * specified by a file location, and also allows
 * to bind a texture.
 * @author Samuel Henry
 * @version 1.0
 * @since March 14, 2014
 */
public class Tex {
	public static String directory = ROOT_DIR + "images/"; //Directory where textures are located
	
	public static Texture playerOneTank = loadTexture("diamond.png"); //Player tank texture
	public static Texture wall = loadTexture("wall.png"); //Wall texture
	public static Texture background = loadTexture("background.jpg"); //Background texture
	public static Texture turret = loadTexture("turret.png"); //Turret of player tank
	public static Texture bullet = loadTexture("bullet.png"); //Texture of a plain bullet
	public static Texture enemyTank = loadTexture("enemy_tank.png");
	public static Texture enemyTurret = loadTexture("enemy_turret.png");
	public static Texture bulletDispenser = loadTexture("bullet_dispenser.png");
	
    /**
     * Load a picture/texture for rendering
     * @param key The path to the file in the source folder
     * @return The texture to be rendered
     */
    public static Texture loadTexture(String key) {
        String fileExtension = ""; //File extension of file
        
        if(key.contains("png")) { //Decide what file type it is
            fileExtension = "png";
        } else if(key.contains("jpg")) {
            fileExtension = "jpg";
        }
        
        try { //Try to load texture.. If error, exit
            return TextureLoader.getTexture(fileExtension, new FileInputStream(new File(directory + key)));
        } catch(IOException e) {
            System.out.println("Error loading Texture: " + key);
            System.exit(2);
        }
        
        return null; //Required for method
    }
    
    /**
     * Bind a specified texture
     * @param tex Texture to be bound
     */
    public static void bind(Texture tex) {
        tex.bind();
    }
}