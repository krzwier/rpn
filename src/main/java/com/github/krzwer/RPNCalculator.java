package com.github.krzwer;

import java.util.HashMap;
import java.util.Stack;
import java.util.function.BinaryOperator;

public class RPNCalculator {

   private Stack<Integer> argStack = new Stack<Integer>();

   public int calculate(String input) {
      if (input == "") {
         return 0;
      }
      String[] items = input.split(" ");
      for (int i = 0; i < items.length; i++) {
         if (items[i].matches("\\d+")) {
            int num = Integer.parseInt(items[i]);
            argStack.push(num);
         } else {
            argStack.push(Op.perform(items[i], getTopTwoNumbers()));
         }
      }
      return argStack.pop();
   }

   private int[] getTopTwoNumbers() {
      int[] nums = new int[2];
      nums[1] = argStack.pop();
      nums[0] = argStack.pop();
      return nums;
   }

   static class Op {
      static final HashMap<String, BinaryOperator<Integer>> operators =
            new HashMap<String, BinaryOperator<Integer>>() {
               {
                  put("+", (a, b) -> a + b);
                  put("-", (a, b) -> a - b);
                  put("*", (a, b) -> a * b);
                  put("/", (a, b) -> a / b);
               }
            };

      public static int perform(String operatorSymbol, int[] nums) {
         return operators.get(operatorSymbol).apply(nums[0], nums[1]);
      };

   }

}
