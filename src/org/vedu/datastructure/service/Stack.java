package org.vedu.datastructure.service;

public interface Stack<E> {
	public void push(E value);
	public E pop();
	public E getTop();
	public int getHeight();
	public Stack<E> reverse(E[] list);
	public Stack<E> reverse(Stack<E> list);
	public Stack<E> reverse();
}
