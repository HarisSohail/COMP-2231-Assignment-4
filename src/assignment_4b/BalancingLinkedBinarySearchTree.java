/**
 * BalancingLinkedBinarySearchTree.java
 *
 * 
 * COMP 2231 Assignment 4 Question 2
 * 
 * Implementing a balance tree method for the linked 
 * implementation using the brute force method described 
 * in Section 20.4 of the textbook.
 */
package assignment_4b;

import java.io.*;
import java.util.*;

import jsjf.BinaryTreeNode;
import jsjf.LinkedBinaryTree;

public class BalancingLinkedBinarySearchTree 
{
    private final LinkedBinaryTree<Integer> tree;

   /**
    * Builds the binary tree based on the contents of the given file
    *
    * @param filename the name of the input file
    * @throws FileNotFoundException if the input file is not found
    */
    public BalancingLinkedBinarySearchTree(String filename) throws FileNotFoundException 
    {
        File inputFile = new File(filename);
        Scanner scan = new Scanner(inputFile);
        int numberNodes = scan.nextInt();
        scan.nextLine();
        int root = 0, left, right;

        List<LinkedBinaryTree<Integer>> nodes = new java.util.ArrayList<>();

        for(int i=0; i < numberNodes; i++) 
        {
            nodes.add(i, new LinkedBinaryTree<>(scan.nextInt()));
            scan.nextLine();
        }

        while(scan.hasNext()) 
        {
            root = scan.nextInt();
            left = scan.nextInt();
            right = scan.nextInt();
            scan.nextLine();

            nodes.set(root, new LinkedBinaryTree<>((nodes.get(root)).getRootElement(),
                nodes.get(left), nodes.get(right)));
        }
        tree = nodes.get(root);
    }

   /**
    * Follows the decision tree based on user responses.
    */
    public void evaluate() 
    {
        LinkedBinaryTree<Integer> current = tree;
        Scanner scan = new Scanner(System.in);

        while (current.size() > 1) 
        {
            System.out.println(current.getRootElement());
            if(scan.nextLine().equalsIgnoreCase("N"))
                current = current.getLeft();
            else
                current = current.getRight();
        }
        
        System.out.println(current.getRootElement());
    }

   /**
    * creates list for tree to be copied into.
    */
    public void rebalance() 
    {
        //creating list
        Iterator itr = tree.iteratorInOrder();
        List<Integer> list = new ArrayList<>(tree.size());
        
        while(itr.hasNext())
        {//copying tree
            list.add((Integer)itr.next());
        }//end while
        
        //balance tree
        tree.setRoot(buildBalancedTree(list));
        buildBalancedTree(list);
    }//end rebalance

   /**
    * Takes middle element of the list from tree and sets as root, then 
    * recursively builds balanced left and right subtree.
    *
    * @param list copy of the tree.
    */
    private BinaryTreeNode buildBalancedTree(List list) 
    {
        if(list.isEmpty()) 
        {//if empty list
            return null;
        }//end if 
        else 
        {
            int middle = list.size() / 2;//finds middle
            BinaryTreeNode node = new BinaryTreeNode(list.get(middle));
            //creates subtrees
            node.setLeft(buildBalancedTree(list.subList(0, middle)));
            node.setRight(buildBalancedTree(list.subList(middle + 1, list.size())));
            return node;
        }//end else
    }//end buildBalancedTree  
    
}//end BalancingLinkedBinarySearchTree Class 

/*
Assistance from source code (DecisionTree.java)
Assistance from: www.stackoverflow.com/questions/36097236/java-balance-a-binary-tree-with-brute-force
*/