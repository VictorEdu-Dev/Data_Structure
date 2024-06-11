package org.vedu.datastructure.service;

public interface Queue<E> {
	public void enqueue(E value);
	public E dequeue();
	public E getFirst();
	public E getLast();
	public int getSize();
}
