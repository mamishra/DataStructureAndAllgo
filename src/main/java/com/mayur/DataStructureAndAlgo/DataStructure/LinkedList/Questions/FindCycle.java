package com.mayur.DataStructureAndAlgo.DataStructure.LinkedList.Questions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by MAYUR on 12/6/20.
 */
public class FindCycle {

  /**
   * How do you check if a given linked list contains a cycle?
   * How do you find the starting node of the cycle
   */

  public static void main(String[] args) {
    Node head = new Node(0,null);

    Node n1 = new Node(1,null);
    head.setNext(n1);

    Node n2 = new Node(2,null);
    n1.setNext(n2);

    Node n3 = new Node(3,null);
    n2.setNext(n3);

    Node n4 = new Node(4,null);
    n3.setNext(n4);

    //cyclic
    Node n5 = new Node(5,n2);
    n4.setNext(n5);

    System.out.println(null!=getHeadOfCycle(head)? getHeadOfCycle(head).getValue() : "No cycle");

  }

  private static Node getHeadOfCycle(Node head) {
    Set<Node> set = new HashSet<>();
    Node temp = head;
    while (temp!=null) {
      if (set.contains(temp))
        break;
      else
        set.add(temp);
      temp=temp.getNext();
    }
    return temp;
  }

}

class Node {

  private int value;
  private Node next;

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public Node(int value, Node next) {
    this.value = value;
    this.next = next;
  }
}
