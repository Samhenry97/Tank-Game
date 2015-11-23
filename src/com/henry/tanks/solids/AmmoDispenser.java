package com.henry.tanks.solids;

import java.util.Random;

import com.henry.tanks.base.Level;
import com.henry.tanks.items.Ammo;
import com.henry.tanks.utils.Draw;
import com.henry.tanks.utils.Tex;

import static com.henry.tanks.base.Constants.STD_SIZE;

/**
 * This class is the main class for all the ammo
 * dispensers that the entities can run into. It
 * spawns bullets beside it at random times.
 * @author Samuel Henry
 * @version 1.0
 * @since March 14, 2014
 */
public class AmmoDispenser extends Solids {
	public static Random random = new Random();
	
	private boolean spawned;
	private int time = 300;
	private int timeToSpawn = random.nextInt(time) + time;
	private int timeElapsed = 0;
	
	/**
	 * Creates a ammo dispenser at the given location with the standard width and height
	 * @param x X position of wall
	 * @param y Y position of wall
	 */
	public AmmoDispenser(float x, float y, Level level) {
		super(x, y, level);
	}
	
	/**
	 * Creates a ammo dispenser at the given location, width, and height
	 * @param x X position of wall
	 * @param y Y position of wall
	 * @param width Width of wall
	 * @param height Height of wall
	 */
	public AmmoDispenser(float x, float y, float width, float height, Level level) {
		super(x, y, width, height, level);
	}

	/**
	 * Render the ammo dispenser with its texture
	 */
	@Override
	public void render() {
		Tex.bind(Tex.bulletDispenser);
		Draw.drawTexWithOffs(x, y, width, height);
	}

	/**
	 * Update the ammo dispenser
	 */
	@Override
	public void update() {
		if(!spawned) {
			timeElapsed++;
			if(timeElapsed > timeToSpawn) {
				int xory = random.nextInt(2);
				if(xory == 0) { //On X axis
					xory = random.nextInt(2);
					if(xory == 0) level.items.add(new Ammo(x - STD_SIZE, y, this, level));
					else level.items.add(new Ammo(x + STD_SIZE, y, this, level));
				} else { //On Y axis
					xory = random.nextInt(2);
					if(xory == 0) level.items.add(new Ammo(x, y - STD_SIZE, this, level));
					else level.items.add(new Ammo(x, y + STD_SIZE, this, level));
				}
				spawned = true;
				timeElapsed = 0;
				timeToSpawn = random.nextInt(time) + time;
			}
		}
	}

	/**
	 * If the ammoDispenser has spawned an ammo object
	 * @return If it has spawned yet
	 */
	public boolean isSpawned() {
		return spawned;
	}

	/**
	 * Set if the dispenser has spawned
	 * @param spawned the boolean spawned
	 */
	public void setSpawned(boolean spawned) {
		this.spawned = spawned;
	}
}