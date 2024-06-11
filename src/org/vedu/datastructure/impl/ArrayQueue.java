package org.vedu.datastructure.impl;

import org.vedu.datastructure.service.Queue;

public class ArrayQueue<E> implements Queue<E> {

    private Node first;
    private Node last;
    private int size;
    
    public ArrayQueue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    public ArrayQueue(E data) {
        Node node = new Node(data);
        this.first = node;
        this.last = node;
        this.size = 1;
    }
    
    @Override
    public void enqueue(E value) {
        Node node = new Node(value);
        if (size == 0) {
            this.first = node;
            this.last = node;
        } else {
            last.next = node;
            last = node;
        }
        this.size++;
    }

    @Override
    public E dequeue() {
        if (size == 0)
            return null;
        Node temp = this.first;
        if (size == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.next;
            temp.next = null;
        }
        this.size--;
        return temp.getValue();
    }

    @Override
    public E getFirst() {
        if (first == null)
            return null;
        return first.getValue();
    }

    @Override
    public E getLast() {
        if (last == null)
            return null;
        return last.getValue();
    }

    @Override
    public int getSize() {
        return size;
    }
    
    private class Node {
        E value;
        Node next;
        
        Node(E value) {
            this.value = value;
        }
        
        public E getValue() {
            return value;
        }
    }
}
