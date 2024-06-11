package org.vedu.datastructure.controller;

import org.vedu.datastructure.impl.ArrayQueue;
import org.vedu.datastructure.service.Queue;

public class Controller {
    public static void main(String... strings) {
    	Queue<String> queue = new ArrayQueue<>();

        queue.enqueue("Victor");
        queue.enqueue("Camille");
        queue.enqueue("Clara");
        queue.enqueue("Gislene");
        
        while(queue.getLast() != null) {
        	System.out.println(queue.dequeue());
        }
        
    }
}
