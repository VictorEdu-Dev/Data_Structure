package org.vedu.datastructure.impl;

import org.vedu.datastructure.service.List;

public class ArrayList<E> implements List<E> {
	private Node head;
	private Node tail;
	private int size;
	
	public ArrayList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public ArrayList(E e) {
		Node node = new Node(e);
		this.head = node;
		this.tail = node;
		this.size = 1;
	}

	@Override
	public E getFirst() {
		if(this.head == null) {
			return null;
		} else {
			return head.getData();	
		}
	}

	@Override
	public E getLast() {
		if(this.tail == null) {
			return null;
		} else  {
			return tail.getData();
		}
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void makeEmpty() {
		this.head = null;
		this.tail = null;
		setSize(0);
	}

	@Override
	public void append(E e) {
		Node node = new Node(e);
		if(getSize() == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.setNext(node);
			this.tail = node;
		}
		this.size++;
	}

	@Override
	public E removeLast() {
		if(this.size == 0)
			return null;
		
		Node temp = this.head;
		Node prev = null;
		
		while(temp.getNext() != null) {
			prev = temp;
			temp = temp.getNext();
		}
		prev.setNext(null);
		this.tail = prev;
		this.size--;
		return temp.getData();
	}

	@Override
	public E removeFirst() {
		if(this.size == 0)
			return null; 
		
		Node temp = this.head;
		this.head = this.head.getNext();
		this.size--;
		return temp.getData();
	}

	@Override
	public E remove(int index) {
		if(index >= this.size || index < 0)
			return null;
		
		Node temp = this.head;
		Node prev = null;
		for(int i = 0; i < index; i++) {
			prev = temp;
			temp = temp.getNext();
		}
		if(prev == null) {
			this.head = this.head.getNext();
		} else {
			prev.setNext(temp.getNext());
			 if (temp.getNext() == null)
		            this.tail = prev;
		}
		this.size--;
		return temp.getData();
	}

	@Override
	public E get(int index) {
		if(index >= this.size || index < 0)
			return null;
		Node temp = this.head;
		for(int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		return temp.getData();
	}

	@Override
	public boolean append(int index, E e) {
	    if (index > this.size || index < 0)
	        return false;

	    Node node = new Node(e); 
	    Node current = this.head;
	    Node prev = null;

	    for (int i = 0; i < index; i++) {
	        prev = current;
	        current = current.getNext();
	    }

	    if (prev == null) {
	        node.setNext(this.head);
	        this.head = node;
	    } else {
	        prev.setNext(node);
	        node.setNext(current);
	    }

	    this.size++;
	    return true;
	}

	@Override
	public void addFirst(E e) {
		Node node = new Node(e);
		if(this.size == 0) {
			this.head = node;
			this.tail = node;
		} else {
			node.setNext(this.head);
			this.head = node;
		}
		this.size++;
	}
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public void setSize(int size) {
		this.size = size;
	}

	protected class Node {
		private E data;
		private Node next;

		public Node(E data) {
			this.data = data;
			this.next = null;
		}

		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

}
