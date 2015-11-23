package com.henry.tanks.base;

import static com.henry.tanks.base.Constants.STD_SIZE;

import java.util.ArrayList;
import java.util.List;

import com.henry.tanks.entities.Bullet;
import com.henry.tanks.entities.EnemyTank;
import com.henry.tanks.entities.Entity;
import com.henry.tanks.entities.PlayerTank;
import com.henry.tanks.entities.Tank;
import com.henry.tanks.items.Item;
import com.henry.tanks.solids.AmmoDispenser;
import com.henry.tanks.solids.Solids;
import com.henry.tanks.solids.Wall;
import com.henry.tanks.utils.Draw;
import com.henry.tanks.utils.Tex;

/**
 * This class is the class that controls each level
 * of the game. It interprets the string array into 
 * a level, then updates and renders it.
 * @author Samuel Henry
 * @version 1.0
 * @since March 14, 2014
 */
public class Level {
	
	public Solids[][] solids; //All the solid solids in the game
	public PlayerTank player; //The player tank
	public int levelWidth; //The width of the level
	public int levelHeight; //The height of the level
	public List<Tank> tanks; //All the entities in the game
	public List<Bullet> bullets; //All the bullets in the game
	public List<Item> items; //All the items in the game
	
	/**
	 * Constructor for each level
	 * @param map The level map
	 * @param game The game - for methods
	 */
	public Level(String[] map, Game game) {
		
		levelWidth = (map[0].length() / 2 + 1) * STD_SIZE;
		levelHeight = map.length * STD_SIZE;
		
		solids = new Solids[map.length][map[0].length() / 2 + 1];
		tanks = new ArrayList<Tank>();
		bullets = new ArrayList<Bullet>();
		items = new ArrayList<Item>();
		
		for(int y = 0; y < map.length; y++) {
			for(int x = 0; x < map[y].length(); x++) {
				switch(map[y].charAt(x)) {
					case 'b' : solids[y][x / 2] = new Wall((x / 2) * STD_SIZE, y * STD_SIZE, this); break;
					case 'p' : player = new PlayerTank((x / 2) * STD_SIZE, y * STD_SIZE, this); break;
					case 'e' : tanks.add(new EnemyTank((x / 2) * STD_SIZE, y * STD_SIZE, this)); break;
					case 'd' : solids[y][x / 2] = new AmmoDispenser((x / 2) * STD_SIZE, y * STD_SIZE, this); break;
					case 'a' : break;
					case ' ' : break;
					default : System.out.println("Unknown character in map");
				}
			}
		}
	}
	
	/**
	 * Method to update all the solids in the game
	 */
	public void update() {
			player.update();
			
			for(GameObject go1[] : solids) {
				for(GameObject go2 : go1) {
					if(go2 != null) {
						go2.update();
					}
				}
			}
			
			for(int i = 0; i < tanks.size(); i++) {
				if(tanks.get(i) != null) {
					tanks.get(i).update();
				}
			}
			
			for(int i = 0; i < bullets.size(); i++) {
				if(bullets.get(i) != null) {
					bullets.get(i).update();
				}
			}
			
			for(int i = 0; i < items.size(); i++) {
				if(items.get(i) != null) {
					items.get(i).update();
				}
			}
	}
	
	/**
	 * Method for rendering all the solids of the level to the screen
	 */
	public void render() {
			Tex.bind(Tex.wall);
			Draw.drawTexWithOffs(levelWidth / 2 - STD_SIZE / 2, levelHeight / 2 - STD_SIZE / 2, levelWidth, levelHeight);
			
			for(GameObject go1[] : solids) {
				for(GameObject go2 : go1) {
					if(go2 != null) {
						go2.render();
					}
				}
			}
			
			for(Bullet bullet : bullets) {
				bullet.render();
			}
			
			for(Item item : items) {
				item.render();
			}
			
			for(Entity tank : tanks) {
				tank.render();
			}
			
			player.render();
	}
	
	/**
	 * Checks whether a point is inside any solid object
	 * @param x X coord inside object
	 * @param y Y coord of object
	 * @return True if point is inside a solid object, false if not
	 */
	public boolean collides(int x, int y) {
		x += STD_SIZE / 2;
		y += STD_SIZE / 2;
		
		while(x % STD_SIZE != 0) x--;
		while(y % STD_SIZE != 0) y--;
		
		int retX = x / STD_SIZE;
		int retY = y / STD_SIZE;
		
		if(retX < 0 || retX >= levelWidth / STD_SIZE) return false;
		if(retY < 0 || retY >= levelHeight / STD_SIZE) return false;
		
		return solids[retY][retX] != null;
	}
	
	public void addBlock(int x, int y) {
		x += STD_SIZE / 2;
		y += STD_SIZE / 2;
		
		while(x % STD_SIZE != 0) x--;
		while(y % STD_SIZE != 0) y--;
		
		int retX = x / STD_SIZE;
		int retY = y / STD_SIZE;
		
		if((retX < 0 || retX >= levelWidth / STD_SIZE) && (retY < 0 || retY >= levelHeight / STD_SIZE)) {
			solids[retY][retX] = new Wall(x, y, this);
		}
		
	}
}
