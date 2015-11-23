package com.henry.tanks.items;

import static com.henry.tanks.base.Constants.AMMO_ITEM_INCREASE;

import com.henry.tanks.base.Level;
import com.henry.tanks.solids.AmmoDispenser;
import com.henry.tanks.utils.Draw;
import com.henry.tanks.utils.Physics;
import com.henry.tanks.utils.Tex;

public class Ammo extends Item {
	
	private AmmoDispenser comeFrom;
	
	/**
	 * Creates an Ammo object at specified location
	 * @param x X position of ammo
	 * @param y Y position of ammo
	 * @param level Current level in
	 */
	public Ammo(float x, float y, AmmoDispenser comeFrom, Level level) {
		super(x, y, level);
		this.comeFrom = comeFrom;
	}
	
	/**
	 * Creates and Ammo at a specified location
	 * and size
	 * @param x X position of ammo
	 * @param y Y position of ammo
	 * @param width Width of ammo
	 * @param height Height of ammo
	 * @param level Current level in
	 */
	public Ammo(float x, float y, float width, float height, AmmoDispenser comeFrom, Level level) {
		super(x, y, width, height, level);
		this.comeFrom = comeFrom;
	}
	
	/**
	 * Update method for Ammo object
	 */
	@Override
	public void update() {
		if(Physics.checkCollides(this, level.player)) {
			level.player.increaseBullets(AMMO_ITEM_INCREASE);
			comeFrom.setSpawned(false);
			level.items.remove(this);
		}
	}
	
	/**
	 * Render method for Ammo object
	 */
	@Override
	public void render() {
		Tex.bind(Tex.bullet);
		Draw.drawTexWithOffs(x, y, width, height);
	}
}