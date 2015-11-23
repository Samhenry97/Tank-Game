package com.henry.tanks.utils;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import com.henry.tanks.base.Game;

/**
 * This class contains all the code needed to draw
 * things to the screen. It can draw textures with 
 * or without game offsets. The methods contain the 
 * opengl code making it look more simple.
 * @author Samuel Henry
 * @version 1.0
 * @since March 14, 2014
 */
public class Draw {

	/**
	 * Draws the bound texture at a given location and size
	 * @param x X location relative to screen
	 * @param y Y location relative to screen
	 * @param width Width of the rendering
	 * @param height Height of the rendering
	 */
	public static void drawTex(float x, float y, float width, float height) {
		drawTex(x, y, width, height, 0);
	}
	
	/**
	 * Draws the bound texture at a given location, size, and rotation
	 * @param x X location relative to screen
	 * @param y Y location relative to screen
	 * @param width Width of the rendering
	 * @param height Height of the rendering
	 * @param rot Rotation - amount to rotate texture, in degrees
	 */
	public static void drawTex(float x, float y, float width, float height, float rot) {
		glPushMatrix();
		{
			glTranslatef(x, y, 0);
			glRotatef(rot, 0, 0, 1);
			glBegin(GL_QUADS);
			{
				glTexCoord2f(0, 0); glVertex2f(-width / 2, -height / 2);
				glTexCoord2f(0, 1); glVertex2f(-width / 2, height / 2);
				glTexCoord2f(1, 1); glVertex2f(width / 2, height / 2);
				glTexCoord2f(1, 0); glVertex2f(width / 2, -height / 2);
			}
			glEnd();
		}
		glPopMatrix();
	}
	
	/**
	 * Draws the bound texture at a given location and size, including the scrolling offsets
	 * @param x X position relative to offsets
	 * @param y Y position relative to offsets
	 * @param width Width of the rendering
	 * @param height Height of the rendering
	 */
	public static void drawTexWithOffs(float x, float y, float width, float height) {
		drawTexWithOffs(x, y, width, height, 0);
	}
	
	/**
	 * Draws the bound texture at a given location, size, and rotation, including the scrolling offsets
	 * @param x X position relative to offsets
	 * @param y Y position relative to offsets
	 * @param width Width of the rendering
	 * @param height Height of the rendering
	 * @param rot Rotation - amount to rotate texture, in degrees
	 */
	public static void drawTexWithOffs(float x, float y, float width, float height, float rot) {
		glPushMatrix();
		{
			glTranslatef(x - Game.xOffs, y - Game.yOffs, 0);
			glRotatef(rot, 0, 0, 1);
			glBegin(GL_QUADS);
			{
				glTexCoord2f(0, 0); glVertex2f(-width / 2, -height / 2);
				glTexCoord2f(0, 1); glVertex2f(-width / 2, height / 2) ;
				glTexCoord2f(1, 1); glVertex2f(width / 2, height / 2);
				glTexCoord2f(1, 0); glVertex2f(width / 2, -height / 2);
			}
			glEnd();
		}
		glPopMatrix();
	}
	
	/**
	 * Draws a rectangle with the color at hand with given location and size
	 * @param x X position of rectangle
	 * @param y Y position of rectangle
	 * @param width Width of rectangle
	 * @param height Height of rectangle
	 */
	public static void drawRectWithOffs(float x, float y, float width, float height) {
		drawRectWithOffs(x, y, width, height, 0);
	}
	
	/**
	 * Draws a rectangle with the color at hand with given location, size, and rotation
	 * @param x X position of rectangle
	 * @param y Y position of rectangle
	 * @param width Width of rectangle
	 * @param height Height of rectangle
	 * @param rot Rotation of rectangle
	 */
	public static void drawRectWithOffs(float x, float y, float width, float height, float rot) {
		glPushMatrix();
		{
			glTranslatef(x - Game.xOffs, y - Game.yOffs, 0);
			glRotatef(rot, 0, 0, 1);
			glBegin(GL_QUADS);
			{
				glVertex2f(-width / 2, -height / 2);
				glVertex2f(-width / 2, height / 2) ;
				glVertex2f(width / 2, height / 2);
				glVertex2f(width / 2, -height / 2);
			}
			glEnd();
		}
		glPopMatrix();
	}
	
	/**
	 * Change the color currently being drawn with
	 * @param color The color to change to
	 */
	public static void changeColor(Color color) {
		glColor4f(color.r, color.g, color.b, color.a);
	}
}