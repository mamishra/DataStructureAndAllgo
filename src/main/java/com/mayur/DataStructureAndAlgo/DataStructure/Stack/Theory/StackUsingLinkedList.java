package com.mayur.DataStructureAndAlgo.DataStructure.Stack.Theory;

import java.util.StringJoiner;

/**
 * Created by MAYUR on 9/20/20.
 */
public class StackUsingLinkedList {

  public static void main(String[] args) {
    StackLL stack = new StackLL();
    System.out.println(stack.isEmpty());
    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println(stack.isEmpty());
    System.out.println(stack.top());
    System.out.println(stack.toString());
    stack.pop();
    System.out.println(stack.top());
    stack.pop();
    stack.pop();
    System.out.println(stack.isEmpty());
  }

}


class StackLL {
  private Node top;

  public StackLL() {
    this.top = new Node(null);
  }

  public void push(Object x) {
    Node node = new Node(x);
    node.setNext(top.getNext());
    top.setNext(node);
  }

  public void pop() {
    if (top == null) {
      System.out.println("Stack is empty");
    } else {
      Node node = top.getNext();
      top.setNext(node.getNext());
    }
  }

  public Object top() {
    return top.getNext().getData();
  }

  public boolean isEmpty() {
    try {
      return top.getNext() == null;
    } catch (Exception e) {
      return true;
    }
  }

  @Override
  public String toString() {
    String result = "Stack : ";
    Node node = top.getNext();
    while (node != null) {
      result += node.getData().toString() + " ";
      node = node.getNext();
    }
    return result;
  }
}


class Node {
  private Node next;
  private Object data;

  public Node(Object data) {
    this.next = null;
    this.data = data;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public Node getNext() {
    return next;
  }

  public Object getData() {
    return data;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "[", "]").add("data : " + data).toString();
  }
}
