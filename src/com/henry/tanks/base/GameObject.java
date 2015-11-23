package com.henry.tanks.base;

/**
 * This is the main class for each object in the game.
 * It includes the basic variables for the objects,
 * x (x position), y (y position), width, and height.
 * It also contains the abstract methods for rendering
 * and updating the objects.
 * @author Samuel Henry
 * @version 1.0
 * @since March 14, 2014
 */
public abstract class GameObject {
	protected float x; //X Position
	protected float y; //Y Position
	protected float width; //Width
	protected float height;//Height
	
	/**
	 * Render the object
	 */
	public abstract void render(); //Method for rendering to screen
	
	/**
	 * Update the object
	 */
	public abstract void update(); //Method for updating position

	/**
	 * Get the x position of the GameObject
	 * @return X position of the object
	 */
	public float getX() {
		return x;
	}

	/**
	 * Set the x position of the GameObject
	 * @param x X position to be set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Get the y position of the GameObject
	 * @return Y position of the object
	 */
	public float getY() {
		return y;
	}
	
	/**
	 * Set the y position of the GameObject
	 * @param y Y position to be set
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * Get the width of the GameObject
	 * @return Width of the object
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * Set the width of the GameObject
	 * @param width Width to be set
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * Get the height of the GameObject
	 * @return Height of the object
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * Set the height of the GameObject
	 * @param height Height to be set
	 */
	public void setHeight(float height) {
		this.height = height;
	}
}