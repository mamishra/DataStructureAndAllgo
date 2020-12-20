package com.mayur.DataStructureAndAlgo.DataStructure.Stack.Questions;

import java.util.Stack;

/**
 * Created by MAYUR on 9/27/20.
 */
public class GenerateAllParenthesis {

  public static void main(String[] args) {
    //String string = "(1+2)*[3+{2/3(1+1)}]";
    String string = "}]";
    System.out.println(isValid(string));
  }

  public static int isValid(String A) {
    char[] chars = A.toCharArray();
    Stack stack = new Stack<>();
    int count = 0;
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
        stack.push(chars[i]);
      } else if (chars[i] == ')' || chars[i] == '}' || chars[i] == ']') {
        count++;
        if (chars[i] == ')') {
          if (!stack.isEmpty()) {
            if (stack.peek().toString().charAt(0) == '(') {
              stack.pop();
              count--;
            } else {
              return 0;
            }
          }
        } else if (chars[i] == '}') {
          if (!stack.isEmpty()) {
            if (stack.peek().toString().charAt(0) == '{') {
              stack.pop();
              count--;
            } else {
              return 0;
            }
          }
        } else if (chars[i] == ']') {
          if (!stack.isEmpty()) {
            if (stack.peek().toString().charAt(0) == '[') {
              stack.pop();
              count--;
            } else {
              return 0;
            }
          }
        }
      }
    }
    return stack.isEmpty() && count == 0 ? 1 : 0;
  }

}
