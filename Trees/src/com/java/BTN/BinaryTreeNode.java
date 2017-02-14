package com.java.BTN;

public class BinaryTreeNode {

	private int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	
	public BinaryTreeNode(int data){
		this.data = data;
		left = null;
		right = null;
	}
	public BinaryTreeNode(int data , BinaryTreeNode left , BinaryTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}
	public BinaryTreeNode getLeft() {
		return left;
	}
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	public BinaryTreeNode getRight() {
		return right;
	}
}
