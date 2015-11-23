package com.henry.tanks.entities;

import static com.henry.tanks.base.Constants.BULLET_MAX_DISTANCE;
import static com.henry.tanks.base.Constants.BULLET_ROTATION_SPEED;
import static com.henry.tanks.base.Constants.BUL_SIZE;
import static com.henry.tanks.base.Constants.BUL_SPEED;

import java.util.Random;

import com.henry.tanks.base.Level;
import com.henry.tanks.utils.Draw;
import com.henry.tanks.utils.Physics;
import com.henry.tanks.utils.Tex;

/**
 * This class is the main class for bullets
 * that fire from the different tank tanks.
 * It controls the direction, movement, rotation,
 * and rendering of the bullet.
 * @author Samuel Henry
 * @version 1.0
 * @since March 14, 2014
 */
public class Bullet extends Entity {
	
	protected float direction;
	protected float speed;
	protected float totalDistance = 0;
	protected float maxDistance = BULLET_MAX_DISTANCE;
	protected float texRotation = new Random().nextInt(360);
	protected float rotationSpeed = BULLET_ROTATION_SPEED;
	protected Level level;
	protected Entity shotFrom;
	
	/**
	 * Create a bullet entity at the given location and direction to be shot
	 * @param x Starting x position of bullet
	 * @param y Starting y position of bullet
	 * @param direction The angle direction to be shot
	 */
	public Bullet(float x, float y, float direction, Level level, Entity shotFrom) {
		this(x, y, direction, BUL_SPEED, level, shotFrom);
	}

	/**
	 * Create a bullet entity at the given location and direction and speed to be shot
	 * @param x Starting x position of bullet
	 * @param y Starting y Position of bullet
	 * @param direction The angle direction to be shot
	 * @param speed The speed of the bullet
	 */
	public Bullet(float x, float y, float direction, float speed, Level level, Entity shotFrom) {
		this(x, y, BUL_SIZE, BUL_SIZE, direction, speed, level, shotFrom);
	}

	/**
	 * Create a bullet entity at the given location with width and height and direction to be shot
	 * @param x Starting x position of bullet
	 * @param y Starting y position of bullet
	 * @param width Width of bullet
	 * @param height Height of bullet
	 * @param direction The angle direction to be shot
	 * @param speed The speed of the bullet
	 */
	public Bullet(float x, float y, float width, float height, float direction, float speed, Level level, Entity shotFrom) {
		super(x, y, width, height);
		this.direction = direction;
		this.speed = speed;
		this.level = level;
		this.shotFrom = shotFrom;
	}
	
	/**
	 * Update the bullet
	 */
	@Override
	public void update() {
		//***********************************************************************************
		/* Bullet movement */
		x += speed * Math.cos(Math.toRadians(direction));
		y += speed * Math.sin(Math.toRadians(direction));
		totalDistance += speed;
		if(totalDistance >= maxDistance && maxDistance >= 0) {
			level.bullets.remove(this);
		}
		
		texRotation += rotationSpeed;
		
		//************************************************************************************
		/* Collision detection */
		for(int i = 0; i < level.tanks.size(); i++) {
			if(level.tanks.get(i) != shotFrom) {
				if(Physics.checkCollides(this, level.tanks.get(i))) {
					level.tanks.get(i).getHurt();
					level.bullets.remove(this);
				}
			}
		}
		if(level.player != shotFrom) {
			if(Physics.checkCollides(this, level.player)) {
				level.player.getHurt();
				level.bullets.remove(this);
			}
		}
		
		if(level.collides((int) x, (int) y)) {
			level.bullets.remove(this);
		}
		//*******************************************************************************
	}
	
	/**
	 * Render the bullet
	 */
	@Override
	public void render() {
		Tex.bind(Tex.bullet);
		Draw.drawTexWithOffs(x, y, width, height, texRotation);
	}
}
