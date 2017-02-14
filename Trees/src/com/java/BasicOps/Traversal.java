package com.java.BasicOps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

import com.java.BTN.BinaryTreeNode;

public class Traversal {

	public void recursivePreOrder(BinaryTreeNode root){
		/**
		 * space : O(n)
		 * Time : O(n)
		 */
		if(root !=null){
			System.out.print(root.getData()+" ");
			recursivePreOrder(root.getLeft());
			recursivePreOrder(root.getRight());
		}
	}
	
	public void recursiveInOrder(BinaryTreeNode root){
		/**
		 * space : O(n)
		 * Time : O(n)
		 */
		if(root !=null){
			recursiveInOrder(root.getLeft());
			System.out.print(root.getData()+" ");
			recursiveInOrder(root.getRight());
		}
	}
	
	public void recursivePostOrder(BinaryTreeNode root){
		/**
		 * space : O(n)
		 * Time : O(n)
		 */
		if(root !=null){
			recursivePostOrder(root.getLeft());
			recursivePostOrder(root.getRight());
			System.out.print(root.getData()+" ");
		}
	}
	
	public void stackBasedPreOrder(BinaryTreeNode root){
		/**
		 * space : O(n)
		 * Time : O(n)
		 */
		ArrayList<Integer> res = new ArrayList<Integer>(); 
		if(root!=null){
			Stack<BinaryTreeNode> nodeStack = new Stack<BinaryTreeNode>();
			nodeStack.push(root);
			while(!nodeStack.isEmpty()){
				BinaryTreeNode temp = nodeStack.pop();
				res.add(temp.getData());
				if(temp.getRight()!=null){
					nodeStack.push(temp.getRight());
				}
				if(temp.getLeft()!=null){
					nodeStack.push(temp.getLeft());
				}
			}	
			System.out.println(res);
		}else{
			System.out.println(res);
		}
	}
	
	public void stackBasedInOrder(BinaryTreeNode root){
		/**
		 * space : O(n)
		 * Time : O(n)
		 */
		ArrayList<Integer> res = new ArrayList<Integer>(); 
		if(root!=null){
			Stack<BinaryTreeNode> nodeStack = new Stack<BinaryTreeNode>();
			BinaryTreeNode currentNode = root;
			boolean done = false;
			while(!done){
				if(currentNode != null){
					nodeStack.push(currentNode);
					currentNode = currentNode.getLeft();
				}else{
					if(nodeStack.isEmpty()){
						done = true;
					}else{
						currentNode = nodeStack.pop();
						res.add(currentNode.getData());
						currentNode = currentNode.getRight();
					}
				}
			}	
		}
		System.out.println(res);
	}
	
	public void stackBasedPostOrder(BinaryTreeNode root){
		/**
		 * space : O(n)
		 * Time : O(n)
		 */
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null){
			System.out.println(res);
		}
		Stack<BinaryTreeNode> nodeStack = new Stack<BinaryTreeNode>();
		nodeStack.push(root);
		
		BinaryTreeNode prev = null;
		while(!nodeStack.isEmpty()){
			BinaryTreeNode curr = nodeStack.peek();
			
			if(prev == null|| prev.getLeft() == curr || prev.getRight() == curr){
				//Traverse from top to bottom , and if the curr has left or right child,
				// push into nodeStack , otherwise just pop it .
				if(curr.getLeft()!=null){
					nodeStack.push(curr.getLeft());
				}else if(curr.getRight()!=null){
					nodeStack.push(curr.getRight());
				}
			}else if(curr.getLeft() == prev){
				// this condition will be true , once you have visited the child nodes
				// and now with child as "prev" , next peek is the parent "curr".
				
				if(curr.getRight()!=null){
					nodeStack.push(curr.getRight());
				}
			}else{
				res.add(curr.getData());
				nodeStack.pop();
			}
			prev = curr;
		}
		System.out.println(res);
	}
	
	public void levelOrderTraversal(BinaryTreeNode root){
		/**
		 * space : O(n)
		 * Time : O(n)
		 */
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(root == null){
			System.out.println(res);
		}
		//Initialization 
		Queue<BinaryTreeNode> nodeQueue =  new LinkedList<BinaryTreeNode>();
		nodeQueue.offer(root);
		nodeQueue.offer(null);
		ArrayList<Integer> curr = new ArrayList<Integer>();
		while(!nodeQueue.isEmpty()){
			BinaryTreeNode tmp = nodeQueue.poll();
			if(tmp!=null){
				curr.add(tmp.getData());
				if(tmp.getLeft()!=null){
					nodeQueue.offer(tmp.getLeft());
				}
				if(tmp.getRight()!=null){
					nodeQueue.offer(tmp.getRight());
				}
			}else{
				ArrayList<Integer> c_curr = new ArrayList<Integer>(curr);
				res.add(c_curr);
				curr.clear();
				//completion of a level
				if(!nodeQueue.isEmpty()){
					nodeQueue.offer(null);
				}
			}
		}
		ListIterator<ArrayList<Integer>> li = res.listIterator();
		while(li.hasNext()){
			ArrayList<Integer> dataList = (ArrayList<Integer>) li.next();
			for(Integer data :dataList){
				System.out.print(data+" ");
			}
		}
		System.out.println();
	}
}
 