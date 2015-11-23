package com.henry.tanks.base;

/**
 * This class contains all the level maps to be
 * used for the game. The letter codes are as
 * follows.
 * <p>b: Instance of the wall class
 * <p>a: Open space
 * <p>p: Player tank
 * <p>e: Enemy tank
 * @author Samuel Henry
 * @version 1.0
 * @since March 14, 2014
 */
public class Maps {
	
	public static String[][] maps = {
		//Level 1
		{
			"b b b b b b b b b b b b b b b b b b b b",
			"b a a a a a a a a a a a a a a a a a a b",
			"b a a a a a a a a a a a a a a a a a a b",
			"b a a a e a a a a a a a a a a a a a a b",
			"b a a a a a a a a a p a a a a a a a a b",
			"b a a a a a a a a a a a a a a a a a a b",
			"b a a a a a a a a a a a a a a e a a a b",
			"b a a a a a a a a a a a a a a a a a a b",
			"b b b b b b b b b b b b b b b b b b b b"
		},
		//Level 2
		{
			"b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b",
			"b b b a a a a a a a a a a b a a a a a a a a a a a a a a a a a b",
			"b a b b b b a a a a a a a b a a a a a a a a a a a a a a a a a b",
			"b a b a a b a a e a a a a b a a a a a a a a a a a a a a a a a b",
			"b a b a a b a a a a a a a b a a a b a a a b b b b b b b b b b b",
			"b a b b a a a a a a a a a p a a a b a a a b b b b b b b b b b b",
			"b a a a a a a a a a a a a a a a a b a a a a a a a a a a a a a b",
			"b a a a a a a a a a a a a a a a a b a a a a a a a a a e a a a b",
			"b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b"
		},
		//Level 3
		{
			"b b b b b b b b b b b b b b b b b b b d b b b b b b b b b a a b b b b b b b b b b b b b b",
			"b a a a a a a b a e a a a a a a a a a a b a a a a a a a a a a a a a a a a a a a a a a a b",
			"b a e a a a a b a a a a a a a a a a a a b a a a a a a a a a a a a a a a a a a b b a e a b",
			"b a a a a a a b b b b b b a a a b b b b b a a a a a a a a a a b b b b a a a a a a a a a b",
			"b b b b b a a a a a a a b a d a b a a a a a a a a a a a a a a a a a a a a a a a a a b a b",
			"b a a a a a a a a a a a b a a a b a a a a a a a a a a a a a a a a a a a a a a a a a b a b",
			"b a a a a a a a a a a a b a a a b a a a a a a a a a a a a a a a a b b b b b a a a a b a b",
			"b a a a a a a a e a a a a a a a b a a a b b b a a b b b a a a a a a a a a a a a a a b a b",
			"b a a a a a a a a a a a a a a a b a a a b a a a a a a b a a a a a a a a a a a a a a a a b",
			"b a a a a a a a a a a a a a a a b a a a b a a a a a a b a a a a a b b b b b b a a a a a a",
			"d a a a b b b b b b b b b b b b b a a a b a a p a a a a a a a d a a a a a a a a a a b a a",
			"b a a a a a a a a a a a a a a a a a a a b a a a a a a a a a a a a a a a a a a a a a b a b",
			"b a a a a a a a a a a a a a a a a a a a b a a a a a a b a a a a a a a a b b b b b b b a b",
			"b a a a b a a a a a a e a a a a a a a a b a b b b a a b a a a a a e a a b a a a a a a a b",
			"b a a a b a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a b a a a a a a a b",
			"b a a a b a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a b a a b a a b a b",
			"b a a a b a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a b b a a b",
			"b a a a b b b b b b a a a a a a a b b b b b b b b b b b a a b b b a a a a a a a b b a a b",
			"b a a a a a a a a a a a a a a a a b a b a b a b a b a b a a b a a a a a b a a b a a b a b",
			"b a e a a a a a a a a a a e a a a a a a a a a a a a a a a a b a a a a a b a a a a e a a b",
			"b a a a a a a a a a a a a a a a a a a a a a a a a a a a a a b a a a a a b a a a a a a a b",
			"b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b b"
		}
	};
	
}