package com.mayur.DataStructureAndAlgo.DataStructure.LinkedList.Questions;

import java.util.Stack;

/**
 * Created by MAYUR on 12/6/20.
 */
public class NumberSumShownByLL {

  /**
   * How do you find the sum of two linked lists using Stack
   */

  public static void main(String[] args) {

    // list 1 represents 5->6->7
    Node n3 = new Node(7,null);
    Node n2 = new Node(6,n3);
    Node n1 = new Node(5,n2);
    Node head1 = new Node(0,n1);

    //list 2 represents 1->8
    Node m2 = new Node(8,null);
    Node m1 = new Node(1,m2);
    Node head2 = new Node(0,m1);

    Node result = getSum(head1,head2);
    System.out.print("Number 1 : ");
    printResult(head1);
    System.out.print(" Number 2 : ");
    printResult(head2);
    System.out.print("\nSum :");
    printResult(result);
  }

  private static void printResult(Node result) {
    if (result==null)
      System.out.println("EMPTY !!!");
    result = result.getNext();
    while (result!=null) {
      System.out.print(result.getValue());
      result = result.getNext();
    }
  }

  private static Node getSum(Node head1, Node head2) {

    Node temp = null != head1 ? head1.getNext() : null;
    Stack<Integer> stack1 = new Stack<>();
    while (temp != null) {
      stack1.push(temp.getValue());
      temp = temp.getNext();
    }

    temp = null != head2 ? head2.getNext() : null;
    Stack<Integer> stack2 = new Stack<>();
    while (temp != null) {
      stack2.push(temp.getValue());
      temp = temp.getNext();
    }

    int carry = 0;
    int sum = 0;
    Node result = new Node(0,null);
    while (!stack1.isEmpty() || !stack2.isEmpty()) {
      int val1 = !stack1.isEmpty() ? stack1.pop() : 0;
      int val2 = !stack2.isEmpty() ? stack2.pop() : 0;
      sum = carry + val1 + val2;
      carry = sum/10;
      sum = sum%10;
      Node newNode = new Node(sum,result.getNext());
      result.setNext(newNode);
    }
    if (carry>0) {
      Node newNode = new Node(carry,result.getNext());
      result.setNext(newNode);
    }
    return result;
  }

}

