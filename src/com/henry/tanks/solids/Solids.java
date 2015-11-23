package com.henry.tanks.solids;

import static com.henry.tanks.base.Constants.STD_SIZE;

import com.henry.tanks.base.GameObject;
import com.henry.tanks.base.Level;
import com.henry.tanks.utils.Draw;

/**
 * This class is the main class for all the solid
 * objects that the entities can run into.
 * @author Samuel Henry
 * @version 1.0
 * @since March 21, 2014
 */
public class Solids extends GameObject {
	
	protected Level level;
	
	/**
	 * Creates a solid object at the given location 
	 * with the standard width and height
	 * @param x X position of wall
	 * @param y Y position of wall
	 */
	public Solids(float x, float y, Level level) {
		this(x, y, STD_SIZE, STD_SIZE, level);
	}
	
	/**
	 * Creates a wall at the given location, width, and height
	 * @param x X position of wall
	 * @param y Y position of wall
	 * @param width Width of wall
	 * @param height Height of wall
	 */
	public Solids(float x, float y, float width, float height, Level level) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.level = level;
	}

	/**
	 * Render the object
	 */
	@Override
	public void render() {
		Draw.drawTexWithOffs(x, y, width, height);
	}

	/**
	 * Update the object
	 */
	@Override
	public void update() {
		
	}

}
