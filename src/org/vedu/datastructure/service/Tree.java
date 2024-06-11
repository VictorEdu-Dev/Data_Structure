package org.vedu.datastructure.service;

public interface Tree<E> {
	public void initialize();
	public void insert(E value);
	public E preOrder();
	public E inOrder();
	public E postOrder();
	public E find();
}
