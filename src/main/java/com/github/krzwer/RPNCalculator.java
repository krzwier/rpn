package com.github.krzwer;

import java.util.Stack;

/**
 * Hello world!
 *
 */
public class RPNCalculator {

    private Stack<Integer> argStack = new Stack();

    public int calculate(String input) {
        String[] items = input.split(" ");
        for (int i = 0; i < items.length; i++) {
            if (items[i].matches("\\d+")) {
                int num = Integer.parseInt(items[i]);
                argStack.push(num);
            } else if (items[i].equals("+")) {
                int num1 = argStack.pop();
                int num2 = argStack.pop();
                argStack.push(num1 + num2);
            }
        }
        if (input == "") {
            return 0;
        }
        return argStack.pop();

    }
}
