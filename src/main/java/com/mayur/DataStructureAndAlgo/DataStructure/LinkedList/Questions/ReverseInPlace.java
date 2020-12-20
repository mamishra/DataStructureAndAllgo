package com.mayur.DataStructureAndAlgo.DataStructure.LinkedList.Questions;

/**
 * Created by MAYUR on 12/6/20.
 */
public class ReverseInPlace {

  /**
   * How do you reverse a linked list in place
   */

  public static void main(String[] args) {
    Node n7 = new Node(7,null);
    Node n6 = new Node(6,n7);
    Node n5 = new Node(5,n6);
    Node n4 = new Node(4,n5);
    Node n3 = new Node(3,n4);
    Node n2 = new Node(2,n3);
    Node n1 = new Node(1,n2);
    Node head = new Node(0,n1);
    printList(head);
    head = reverseList(head);
    printList(head);
  }

  private static Node reverseList(Node head) {
    Node prev = null;
    Node current = head.getNext();
    Node next;
    while (current != null) {
      next = current.getNext();
      current.setNext(prev);
      prev = current;
      current = next;
    }
    head.setNext(prev);
    return head;
  }

  private static void printList(Node head) {
    Node temp = head != null ? head.getNext() : null;
    if (temp==null) {
      System.out.println("EMPTY !!!");
      return;
    }
    while (temp!=null) {
      System.out.print(temp.getValue()+" ");
      temp=temp.getNext();
    }
    System.out.println();
  }
}
