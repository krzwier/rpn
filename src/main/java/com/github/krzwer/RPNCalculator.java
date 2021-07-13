package com.github.krzwer;

import java.util.Stack;

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
         } else if (items[i].equals("+")) {
            argStack.push(add(getTopTwoNumbers()));
         } else if (items[i].equals("-")) {
            argStack.push(subtract(getTopTwoNumbers()));
         } else if (items[i].equals("*")) {
            argStack.push(multiply(getTopTwoNumbers()));
         } else if (items[i].equals("/")) {
            argStack.push(divide(getTopTwoNumbers()));
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

   private int add(int[] nums) {
      return nums[0] + nums[1];
   }

   private int subtract(int[] nums) {
      return nums[0] - nums[1];
   }

   private int multiply(int[] nums) {
      return nums[0] * nums[1];
   }

   private int divide(int[] nums) {
      return nums[0] / nums[1];
   }


}
