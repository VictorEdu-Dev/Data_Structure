package org.vedu.datastructure.impl;

import java.util.LinkedList;
import java.util.Queue;

import org.vedu.datastructure.service.Tree;

public class ArrayTree<E> implements Tree<E> {
	private Node root;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(E value) {
		if(root == null)
			root = new Node(value);
		else {
			Node node = new Node(value);
			Queue<Node> queue = new LinkedList<>();
			queue.add(root);
			while(queue.size() > 0) {
				Node temp = queue.remove();
				if(temp.left == null) {
					temp.left = node;
					break;
				} else {
					queue.add(temp.left);
				}
				if(temp.right == null) {
					temp.right = node;
					break;
				} else {
					queue.add(temp.right);
				}
			}
		}
	}

	@Override
	public E preOrder() {
		return preOrder(root);
	}
	
	private E preOrder(Node node) {
		if(node == null) 
			return null;
		preOrder(node.left);
		preOrder(node.right);
		return node.getValue();
	}

	@Override
	public E inOrder() {
		return inOrder(root);
	}
	
	private E inOrder(final Node node) {
		if(node == null)
			return null;
		inOrder(node.left);
		inOrder(node.right);
		return node.getValue();
	}
	
	@Override
	public E postOrder() {
		return postOrder(root);
	}
	
	private E postOrder(final Node node) {
		if(node == null)
			return null;
		postOrder(node.left);
		postOrder(node.right);
		return node.getValue();
	}

	@Override
	public E find() {
		if(root == null)
			return null;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node node = queue.remove();
			if(node.left != null) queue.add(node.left);
			if(node.right != null) queue.add(node.right);
			
			return node.getValue();
		}
		return null;
	}
	
	public class Node {
		private E value;
		private Node left;
		private Node right;
		
		public Node(E value) {
			this.value = value;
		}
		
		public E getValue() {
			return value;
		}
		
		public Node getLeft() {
			return left;
		}
		
		public void setLeft(Node left) {
			this.left = left;
		}
		
		public Node getRight() {
			return right;
		}
		
		public void setRight(Node right) {
			this.right = right;
		}
		
		public boolean isLeaf() {
			return (this.left == null) && (this.right == null);
		}
	}
}
