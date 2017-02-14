package com.java.BasicOps;

import com.java.BTN.BinaryTreeNode;

public class MaxElementFinder {

	public int recursiveApproach(BinaryTreeNode root){
		int maxElement = Integer.MIN_VALUE;
		if(root!=null){
			int leftGroupMax = recursiveApproach(root.getLeft()); 
			int rightGroupMax = recursiveApproach(root.getRight());
		}
		return 0;
	}
}
