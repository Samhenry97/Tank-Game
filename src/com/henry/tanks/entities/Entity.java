package com.henry.tanks.entities;

import com.henry.tanks.base.GameObject;
import com.henry.tanks.utils.Draw;

import static com.henry.tanks.base.Constants.*;

/**
 * This class provides the basic structure for entities
 * in the game. It provides the basic constructors, then
 * the rendering code, and the code to remove an entity
 * from the game.
 * @author Samuel Henry
 * @since March 14, 2014
 * @version 1.0
 */
public class Entity extends GameObject {
	
	/**
	 * Create an entity at location 0,0, width and height STD_SIZE
	 */
	public Entity() {
		this(0, 0); //Call second constructor
	}
	
	/**
	 * Create an entity with x and y position, default width and height
	 * @param x X Position of entity
	 * @param y Y Position of entity
	 */
	public Entity(float x, float y) {
		this(x, y, STD_SIZE, STD_SIZE); //Call third constructor
	}
	
	/**
	 * Create an entity with set values for x, y, width, and height
	 * @param x X Position of entity
	 * @param y Y Position of entity
	 * @param width Width of entity
	 * @param height Height of entity
	 */
	public Entity(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * Render the entity
	 */
	@Override
	public void render() {
		Draw.drawTexWithOffs(x, y, width, height);
	}
	
	/**
	 * Update the entity
	 */
	@Override
	public void update() {
		
	}

}