package com.java.OpsExecutor;

import com.java.BTN.BinaryTreeNode;
import com.java.BasicOps.Traversal;

public class BinaryTreeExecutor {
	Traversal tr = new Traversal();
	public void preOrderTraversalTester(BinaryTreeNode root){
		
		System.out.println("========= preorder : Recursive ========");
		tr.recursivePreOrder(root);
		System.out.println();
		System.out.println("========= preorder : StackBased =======");
		tr.stackBasedPreOrder(root);
	}
	
	public void inOrderTraversalTester(BinaryTreeNode root){
		
		System.out.println("========= Inorder : Recursive ========");
		tr.recursiveInOrder(root);
		System.out.println();
		System.out.println("========= Inorder : StackBased =======");
		tr.stackBasedInOrder(root);
	}
	
	public void postOrderTraversalTester(BinaryTreeNode root){
		
		System.out.println("========= Postorder : Recursive ========");
		tr.recursivePostOrder(root);
		System.out.println();
		System.out.println("========= Postorder : StackBased =======");
		tr.stackBasedPostOrder(root);
	}
	
	public void levelOrderTraversalTester(BinaryTreeNode root){
		
		System.out.println("========= Levelorder : Queuebased ========");
		tr.levelOrderTraversal(root);
	}
}
