/**
 * BackPainAnalyzer.java
 *
 * 
 * COMP 2231 Assignment 4 Question 1
 * 
 * 
 */
package assignment_4a;

import java.io.*;
import jsjf.DecisionTree;

/**
 * WhatAnimalAnaylyzer demonstrates the use of a binary decision tree to 
 * determine what to eat.
 */
public class WhatAnimalAnalyzer
{
	/**
	 * Asks questions of the user to determine what it is.
         * @param args
         * @throws java.io.FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println("So, what animal is it");

		DecisionTree expert = new DecisionTree("Input2.txt");
		expert.evaluate();
	}
}
