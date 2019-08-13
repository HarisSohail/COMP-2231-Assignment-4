/**
 * BalancingLinkedBinarySearchTreeTests.java
 *
 * 
 * COMP 2231 Assignment 4 Question 2
 * 
 * Testing an unbalanced tree using brute force method
 */
package assignment_4b;

import java.io.*;

public class BalancingLinkedBinarySearchTreeTests 
{
    /**
     * Assisting in balancing trees.
     * @param args
     * @throws java.io.FileNotFoundException
     */    
    public static void main(String[] args) throws FileNotFoundException 
    {
        System.out.println("Brute Force Balance Test.\n");
        BalancingLinkedBinarySearchTree Tree = new BalancingLinkedBinarySearchTree("tree.txt");

        Tree.evaluate();
        Tree.rebalance();
        Tree.evaluate();
    }//end main
    
}//end BalancingLinkedBinarySearchTreeTests 
