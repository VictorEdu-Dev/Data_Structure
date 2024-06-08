package org.vedu.datastructure.service;

public interface List<E> {
	public E getFirst();
	public E getLast();
	public int getSize();
	public void makeEmpty();
	public void append(E e);
	public E removeLast();
	public E removeFirst();
	public E remove(int index);
	public E get(int index);
	public boolean append(int index, E e);
	public void addFirst(E e);
}
