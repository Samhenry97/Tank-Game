package com.henry.tanks.entities;

import com.henry.tanks.base.Level;
import com.henry.tanks.utils.Draw;
import com.henry.tanks.utils.Tex;

import static com.henry.tanks.base.Constants.*;

/**
 * The enemy tank class
 * @author Samuel Henry
 * @since March 15, 2014
 * @version 1.0
 */
public class EnemyTank extends Tank {

	/**
	 * Create the tank for an enemy with x and y but default width and height
	 * @param x X Position of tank
	 * @param y Y Position of tank
	 * @param level Level methods
	 */
	public EnemyTank(float x, float y, Level level) {
		this(x, y, STD_SIZE, STD_SIZE, level);
	}

	/**
	 * Create the tank for an enemy with x and y but default width and height
	 * @param x X Position of tank
	 * @param y Y Position of tank
	 * @param width Width of tank
	 * @param height Height of tank
	 * @param level Level methods
	 */
	public EnemyTank(float x, float y, float width, float height, Level level) {
		super(x, y, width, height, level);
		health = ENEMY_HEALTH;
		refreshRate = ENEMY_REFRESH_RATE;
		refresh = refreshRate + 1;
		speed = ENEMY_SPEED;
	}
	
	/**
	 * Draw the tank with texture to buffer
	 */
	@Override
	public void render() {
		Tex.bind(Tex.enemyTank);
		Draw.drawTexWithOffs(x, y, width, height, rotation);
		Tex.bind(Tex.enemyTurret);
		Draw.drawTexWithOffs(x, y, width, height, turretRotation);
	}
	
	/**
	 * Update the tank based on input and such
	 */
	@Override
	public void update() {
		
		//****************************************************************************************
		/* Turret rotation code */
		float xDis = level.player.getX() - x;
		float yDis = level.player.getY() - y;
		
		float rot = (float) Math.toDegrees(Math.atan2(yDis, xDis));

		turretRotation = rot;
		//****************************************************************************************
		
		/* Bullet firing code */
		if(refresh <= refreshRate) {
			refresh++;
		} else {
			shoot(turretRotation);
			refresh = 0;
		}
	}
}
