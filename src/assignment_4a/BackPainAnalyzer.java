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
 * BackPainAnaylyzer demonstrates the use of a binary decision tree to 
 * diagnose back pain.
 */
public class BackPainAnalyzer
{
	/**
	 * Asks questions of the user to diagnose a medical problem.
         * @param args
         * @throws java.io.FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println("So, you're having back pain.");

		DecisionTree expert = new DecisionTree("Input1.txt");
		expert.evaluate();
	}
}
