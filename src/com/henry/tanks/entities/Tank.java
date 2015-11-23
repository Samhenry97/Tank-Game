package com.henry.tanks.entities;

import static com.henry.tanks.base.Constants.STD_SPEED;

import com.henry.tanks.base.Level;

public class Tank extends Entity {
	
	protected Level level;
	protected float turretRotation = 0; //The rotation for the turret on the tank
	protected float rotation = 0; //The actual rotation of the tank
	protected float speed = STD_SPEED;    //The tank's speed
	protected int refreshRate = 0;//The space of time allowed between firing
	protected int refresh = 0; //The amount of time elapsed between firing
	protected int health;

	/**
	 * Create the tank with x and y but default width and height
	 * @param x X Position of tank
	 * @param y Y Position of tank
	 */
	public Tank(float x, float y, Level level) {
		super(x, y); //Call the Entity constructor
		this.level = level;
	}
	
	/**
	 * Create the tank with set values for x, y, width, height
	 * @param x X Position of tank
	 * @param y Y Position of tank
	 * @param width Width of tank
	 * @param height Height of tank
	 */
	public Tank(float x, float y, float width, float height, Level level) {
		super(x, y, width, height); //Call the Entity constructor
		this.level = level;
	}
	
	/**
	 * Move the tank left or right then up or down
	 * @param xAxis The direction on the x axis to move. Accepted values (-1, 0, 1)
	 * @param yAxis The direction on the y axis to move. Accepted values (-1, 0, 1)
	 * @param amt The amount to move
	 */
	protected void move(int xAxis, int yAxis, float amt) {
		x += xAxis * amt;
		y += yAxis * amt;
	}
	
	/**
	 * Create a bullet from the tank at the given angle
	 * @param angle Angle to shoot the bullet at
	 */
	protected void shoot(float angle) {
		level.bullets.add(new Bullet(x, y, angle, level, this));
	}
	
	/**
	 * If a tank gets hurt, if dead, then remove it from the level
	 */
	protected void getHurt() {
		health--;
		if(health <= 0) {
			level.tanks.remove(this);
		}
	}
	
	/**
	 * The render method for the tank class - overrides Entity render method
	 */
	@Override
	public void render() {
		
	}
	
	/**
	 * The update method for the tank class - overrides Entity update method
	 */
	@Override
	public void update() {
		
	}
}