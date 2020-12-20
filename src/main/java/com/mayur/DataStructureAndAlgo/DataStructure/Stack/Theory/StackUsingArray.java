package com.mayur.DataStructureAndAlgo.DataStructure.Stack.Theory;

/**
 * Created by MAYUR on 9/17/20.
 */
public class StackUsingArray {
  public static void main(String[] args) {
    Stack stack = new Stack();
    System.out.println(stack.isEmpty());
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    System.out.println(stack);
    stack.push(6);
    System.out.println(stack.top());
    System.out.println(stack);
    System.out.println(stack.isEmpty());
    for (int i = 0; i < 7; i++) {
      stack.pop();
    }
    System.out.println(stack.isEmpty());
  }

}



class Stack {
  private int top;
  private int[] array;

  public Stack() {
    this.top = -1;
    this.array = new int[5];
  }

  public void push(int x) {
    if (top + 1 >= array.length) {
      int[] newArray = new int[2 * array.length];
      for (int i = 0; i < array.length; i++) {
        newArray[i] = array[i];
      }
      array = newArray;
    }
    top++;
    array[top] = x;
  }

  public void pop() {
    if (!isEmpty()) {
      top--;
    }
  }

  public int top() {
    return array[top];
  }

  public boolean isEmpty() {
    return top == -1;
  }

  @Override
  public String toString() {
    String stack = "[ ";
    for (int i = 0; i < top + 1; i++) {
      stack += array[i] + " ";
    }
    stack += "]";
    return stack;
  }
}
