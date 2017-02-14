package com.java.initBT;

import com.java.BTN.BinaryTreeNode;
import com.java.OpsExecutor.BinaryTreeExecutor;

public class BinaryTreeInitializer {

	public static void main(String[] args) {
		BinaryTreeInitializer bti = new BinaryTreeInitializer();
		BinaryTreeNode root = bti.btinit();
		BinaryTreeExecutor btExecutor =  new BinaryTreeExecutor();
		btExecutor.preOrderTraversalTester(root);
		btExecutor.inOrderTraversalTester(root);
		btExecutor.postOrderTraversalTester(root);
		btExecutor.levelOrderTraversalTester(root);
	}
	
	public BinaryTreeNode btinit(){
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		BinaryTreeNode node6 = new BinaryTreeNode(6);
		BinaryTreeNode node7 = new BinaryTreeNode(7);
		BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
		BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
		BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);
		return node1;
	}
}
