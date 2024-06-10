package org.vedu.datastructure.impl;

import org.vedu.datastructure.service.Stack;

public class StackList<E> implements Stack<E> {

    private Node top;
    private int height;

    public StackList() {
        this.top = null;
        this.height = 0;
    }

    public StackList(E value) {
        Node node = new Node(value);
        this.top = node;
        this.height = 1;
    }

    @Override
    public void push(E value) {
        Node node = new Node(value);
        if (height == 0) {
            this.top = node;
        } else {
            node.next = this.top;
            this.top = node;
        }
        this.height++;
    }

    @Override
    public E pop() {
        if (height == 0) 
            return null;
        Node temp = this.top;
        this.top = this.top.next;
        temp.next = null;
        this.height--;
        
        return temp.value;
    }

    @Override
    public E getTop() {
        if (top == null)
            return null;
        return top.value;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public Stack<E> reverse(E[] list) {
        StackList<E> reversedStack = new StackList<>();
        for (E element : list) {
            reversedStack.push(element);
        }
        return reversedStack;
    }

    @Override
    public Stack<E> reverse(Stack<E> list) {
        StackList<E> reversedStack = new StackList<>();
        while (list.getHeight() > 0) {
            reversedStack.push(list.pop());
        }
        return reversedStack;
    }

    @Override
    public Stack<E> reverse() {
        StackList<E> reversedStack = new StackList<>();
        while (this.height > 0) {
            reversedStack.push(this.pop());
        }
        return reversedStack;
    }

    private class Node {
        E value;
        Node next;

        Node(E value) {
            this.value = value;
        }
    }
}
