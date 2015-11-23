package com.henry.tanks.solids;

import com.henry.tanks.base.Level;
import com.henry.tanks.utils.Draw;
import com.henry.tanks.utils.Tex;

/**
 * This class is the main class for all the walls
 * that the entities can run into.
 * @author Samuel Henry
 * @version 1.0
 * @since March 14, 2014
 */
public class Wall extends Solids {
	
	/**
	 * Creates a wall at the given location with the standard width and height
	 * @param x X position of wall
	 * @param y Y position of wall
	 */
	public Wall(float x, float y, Level level) {
		super(x, y, level);
	}
	
	/**
	 * Creates a wall at the given location, width, and height
	 * @param x X position of wall
	 * @param y Y position of wall
	 * @param width Width of wall
	 * @param height Height of wall
	 */
	public Wall(float x, float y, float width, float height, Level level) {
		super(x, y, width, height, level);
	}

	/**
	 * Render the wall with its texture
	 */
	@Override
	public void render() {
		Tex.bind(Tex.wall);
		Draw.drawTexWithOffs(x, y, width, height);
	}

	/**
	 * Update the wall
	 */
	@Override
	public void update() {
		
	}

}
