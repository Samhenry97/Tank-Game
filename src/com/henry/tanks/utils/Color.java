package com.henry.tanks.utils;

/**
 * This class contains color constants for 
 * r, g, b, and a values. You can also create
 * your own color using the color constructor.
 * @author Samuel Henry
 * @since March 20, 2014
 * @version 1.0
 */
public class Color {
	// Color constants
	public static Color BLACK = new Color(0.0f, 0.0f, 0.0f);
	public static Color WHITE = new Color(1.0f, 1.0f, 1.0f);
	public static Color RED = new Color(1.0f, 0.0f, 0.0f);
	public static Color BLUE = new Color(0.0f, 1.0f, 0.0f);
	public static Color GREEN = new Color(0.0f, 0.0f, 1.0f);
	public static Color YELLOW = new Color(1.0f, 1.0f, 0.0f);
	public static Color PURPLE = new Color(1.0f, 0.0f, 1.0f);
	public static Color AQUA = new Color(0.0f, 1.0f, 1.0f);
	public static Color ORANGE = new Color(1.0f, 0.5f, 0.0f);
	public static Color LIGHT_GREEN = new Color(0.5f, 1.0f, 0.0f);
	
	
	public float r; //For red value
	public float g; //For green value
	public float b; //For blue value
	public float a; //For alpha value

	/**
	 * Create a color using rgb
	 * @param r Red value
	 * @param g Green value
	 * @param b Blue value
	 */
	public Color(float r, float g, float b) {
		this(r, g, b, 1);
	}
	
	/**
	 * Create a color using rgba
	 * @param r Red value
	 * @param g Green value
	 * @param b Blue value
	 * @param a Alpha value
	 */
	public Color(float r, float g, float b, float a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
}
