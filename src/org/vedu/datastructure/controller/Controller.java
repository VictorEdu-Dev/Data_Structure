package org.vedu.datastructure.controller;

import org.vedu.datastructure.impl.StackList;
import org.vedu.datastructure.service.Stack;

public class Controller {
    public static void main(String... strings) {
        Stack<String> st = new StackList<>();
        st.push("Victor");
        st.push("Clara");
        st.push("Camille");
        
        

        Stack<String> reversedStack = st.reverse();

        while (reversedStack.getHeight() > 0) {
            System.out.println(reversedStack.pop());
        }
    }
}
