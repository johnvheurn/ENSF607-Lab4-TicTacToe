/*
 *  RandomGenerator.java
 *  ENSF 607 - Fall 2020 Lab 4
 *  Completed by: John Van Heurn #30001886
 *  Date: October 22nd 2020
 */

package exercise3;

import java.util.Random;

class RandomGenerator {

/**
 * creates a random number ranging between lo and hi,  
 * @param lo
 * @param hi
 * @return
 */
	public static int discrete(int lo, int hi)
	{
		if(lo >= hi){
			System.out.println("Error discrete, lo >= hi");
			System.exit(0);
		}
		
		Random r = new Random();
		int d = r.nextInt(hi - lo + 1) + lo;
		return d;
	}	
}
