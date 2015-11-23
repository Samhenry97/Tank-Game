package com.henry.tanks.utils;

import org.lwjgl.util.Rectangle;

import com.henry.tanks.base.GameObject;

public class Physics {
	
	public static boolean checkCollides(GameObject go1, GameObject go2) {
		Rectangle rect1 = new Rectangle((int) go1.getX(), (int) go1.getY(), (int) go1.getWidth(), (int) go1.getHeight());
		Rectangle rect2 = new Rectangle((int) go2.getX(), (int) go2.getY(), (int) go2.getWidth(), (int) go2.getHeight());
		
		return rect1.intersects(rect2);
	}
}
