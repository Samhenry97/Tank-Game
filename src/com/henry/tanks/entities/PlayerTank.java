package com.henry.tanks.entities;

import static com.henry.tanks.base.Constants.PLAYER_HEALTH;
import static com.henry.tanks.base.Constants.PLAYER_REFRESH_RATE;
import static com.henry.tanks.base.Constants.PLAYER_SPEED;
import static com.henry.tanks.base.Constants.PLAYER_TOTAL_BULLETS;
import static com.henry.tanks.base.Constants.STD_SIZE;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.henry.tanks.base.Game;
import com.henry.tanks.base.Level;
import com.henry.tanks.base.Main;
import com.henry.tanks.utils.Draw;
import com.henry.tanks.utils.Tex;

/**
 * The player's tank. This tank will respond to key presses, 
 * specifically right, left, up, down, and wasd. Mouse clicking
 * will make it shoot a bullet in the direction of the mouse.
 * @author Samuel Henry
 * @since March 14, 2014
 * @version 1.0
 */
public class PlayerTank extends Tank {
	
	private int totalBullets = PLAYER_TOTAL_BULLETS;
	
	/**
	 * Create the tank for the player with x and y but default width and height
	 * Responds to input unlike enemy tanks
	 * @param x X Position of tank
	 * @param y Y Position of tank
	 */
	public PlayerTank(float x, float y, Level level) {
		this(x, y, STD_SIZE, STD_SIZE, level);
	}
	
	/**
	 * Create the tank for the player width set values for x, y, width, height
	 * Responds to input unlike enemy tanks
	 * @param x X Position of tank
	 * @param y Y Position of tank
	 * @param width Width of tank
	 * @param height Height of tank
	 */
	public PlayerTank(float x, float y, float width, float height, Level level) {
		super(x, y, width, height, level); //Call the Tank constructor
		health = PLAYER_HEALTH;
		refreshRate = PLAYER_REFRESH_RATE;
		refresh = refreshRate + 1;
		speed = PLAYER_SPEED;
	}
	
	/**
	 * Draw the tank with texture to buffer
	 */
	@Override
	public void render() {
		Tex.bind(Tex.playerOneTank);
		Draw.drawTexWithOffs(x, y, width, height, rotation);
		Tex.bind(Tex.turret);
		Draw.drawTexWithOffs(x, y, width, height, turretRotation);
	}
	
	/**
	 * Update the tank based on input and such
	 */
	@Override
	public void update() {
		
		//********************************************************************************************
		/* Movement code */
		int hDir = 0;
		int vDir = 0;
		
		//Direction to move based on key press
		boolean right = Keyboard.isKeyDown(Keyboard.KEY_RIGHT) || Keyboard.isKeyDown(Keyboard.KEY_D);
		boolean left = Keyboard.isKeyDown(Keyboard.KEY_LEFT) || Keyboard.isKeyDown(Keyboard.KEY_A);
		boolean up = Keyboard.isKeyDown(Keyboard.KEY_UP) || Keyboard.isKeyDown(Keyboard.KEY_W);
		boolean down = Keyboard.isKeyDown(Keyboard.KEY_DOWN) || Keyboard.isKeyDown(Keyboard.KEY_S);
		
		//Set the directions to move based on key press
		if(!(left && right)) {
			if(left) hDir = -1;
			else if(right) hDir = 1;
		}
		if(!(up && down)) {
			if(up) vDir = -1;
			else if(down) vDir = 1;
		}
		
		/* Collision detection */
		//Left and right
		int i = 2;
		if(hDir < 0) {
			if(level.collides((int) (x - width / 2 - i), (int) (y - height / 2 + i))) hDir = 0;
			else if(level.collides((int) (x - width / 2 - i), (int) (y + height / 2 - i))) hDir = 0;
		} else if(hDir > 0) {
			if(level.collides((int) (x + width / 2 + i), (int) (y + height / 2 - i))) hDir = 0;
			else if(level.collides((int) (x + width / 2 + i), (int) (y - height / 2 + i))) hDir = 0;
		}
		
		//Up and down
		if(vDir < 0) {
			if(level.collides((int) (x - width / 2 + i), (int) (y - height / 2 - i))) vDir = 0;
			else if(level.collides((int) (x + width / 2 - i), (int) (y - height / 2 - i))) vDir = 0;
		} else if(vDir > 0) {
			if(level.collides((int) (x - width / 2 + i), (int) (y + height / 2 + 1))) vDir = 0;
			else if(level.collides((int) (x + width / 2 - i), (int) (y + height / 2 + i))) vDir = 0;
		}
		
		//Now actually do the moving and rotate the tank
		move(hDir, vDir, speed);
		rotate(hDir, vDir);
		
		//****************************************************************************************
		/* X and Y Offset updating */
		//Update the x and y offsets based on the tank position after movement
		Game.xOffs = x - Main.WindowWidth / 2;
		Game.yOffs = y - Main.WindowHeight / 2;
		
		//****************************************************************************************
		/* Turret rotation code */
		float xDis = Mouse.getX() + Game.xOffs - x;
		float yDis = Mouse.getY() + Game.yOffs - y;
		
		float rot = (float) Math.toDegrees(Math.atan2(yDis, xDis));

		turretRotation = -rot;
		//****************************************************************************************
		/* Bullet firing code */
		if(Mouse.isButtonDown(0) && totalBullets > 0) {
			if(refresh <= refreshRate) {
				refresh++;
			} else {
				shoot(turretRotation);
				totalBullets--;
				refresh = 0;
			}
		} else {
			if(refresh != refreshRate + 1) refresh = refreshRate + 1;
		}
		//****************************************************************************************
	}

	/**
	 * Rotate the actual tank based on the direction it's going
	 * @param xAxis The direction tank is going horizontally. Accepted values (-1, 0, 1)
	 * @param yAxis The direction tank is going vertically. Accepted valuse (-1, 0, 1)
	 */
	private void rotate(int xAxis, int yAxis) {
		float rot = 0;
		if(!(xAxis == 0 && yAxis == 0)) {
			if(xAxis < 0) {
				if(yAxis < 0) rot = 225;
				else if(yAxis > 0) rot = 135;
				else rot = 180;
			}
			else if(xAxis > 0) {
				if(yAxis < 0) rot = 315;
				else if(yAxis > 0) rot = 45;
				else rot = 0;
			}
			else {
				if(yAxis < 0) rot = 270;
				else if(yAxis > 0) rot = 90;
			}
			
			float rot1 = rotation - rot;
			
			float rot2 = rot - rotation;
			
			if(rot1 <= rot2) {
				rotation -= 4;
			} else {
				rotation += 4;
			}
			rotation = rot;
		}
	}
	
	/**
	 * If the player gets hurt or dies
	 */
	@Override
	public void getHurt() {
		health--;
		if(health <= 0) {
			System.out.println("DEAD");
			health = 100;
		}
	}
	
	/**
	 * Increase the total bullets by the specified amount
	 * @param amount Amount to increase bullets by
	 */
	public void increaseBullets(int amount) {
		totalBullets += amount;
		System.out.println(totalBullets);
	}
}