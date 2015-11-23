package com.henry.tanks.items;

import static com.henry.tanks.base.Constants.STD_SIZE;

import com.henry.tanks.base.GameObject;
import com.henry.tanks.base.Level;
import com.henry.tanks.utils.Draw;

/**
 * This class is the base class for items,
 * or things you can pick up in the game.
 * @author Samuel Henry
 * @since March 21, 2014
 * @version 1.0
 */
public class Item extends GameObject {
	
	protected Level level; //Current level item is in

	/**
	 * Create an item at a specified location and standard size,
	 * with a Level object for methods
	 * @param x X position of item
	 * @param y Y position of item
	 * @param level The current level for methods
	 */
	public Item(float x, float y, Level level) {
		this(x, y, STD_SIZE, STD_SIZE, level);
	}
	
	/**
	 * Create an item at a specified location and size,
	 * with a Level object for methods
	 * @param x X position of item
	 * @param y Y position of item
	 * @param width Width of item
	 * @param height Height of item
	 * @param level The current level for methods
	 */
	public Item(float x, float y, float width, float height, Level level) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.level = level;
	}

	/**
	 * Render method - overrides GameObject render
	 */
	@Override
	public void render() {
		Draw.drawTexWithOffs(x, y, width, height);
	}

	/**
	 * Update method - overrides GameObject update
	 */
	@Override
	public void update() {
		
	}

}
