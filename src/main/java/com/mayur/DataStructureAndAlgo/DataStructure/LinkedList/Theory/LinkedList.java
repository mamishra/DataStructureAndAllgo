package com.mayur.DataStructureAndAlgo.DataStructure.LinkedList.Theory;

/**
 * Created by MAYUR on 12/6/20.
 */
public class LinkedList {

  private Node head = null;
  private int length = 0;

  public LinkedList() {
    head = new Node(0);
    head.setNext(null);
  }

  public void add(int val) {
    Node node = new Node(val);
    if (length==0) {
      head.setNext(node);
    }
    else {
      Node temp = head;
      for (int i = 0; i < length; i++) {
        temp=temp.getNext();
      }
      temp.setNext(node);
    }
    length++;
  }

  public boolean remove(int index) {
    if (index>length-1)
      return false;
    Node temp = head.getNext();
    Node previous = head;
    int i = 0;
    while (i!=index) {
      previous = previous.getNext();
      temp=temp.getNext();
      i++;
    }
    previous.setNext(temp.getNext());
    length--;
    return true;
  }

  public void print() {
    Node temp = head.getNext();
    System.out.print("[ ");
    for (int i = 0; i < length; i++) {
      System.out.print(temp.getValue()+" ");
      temp=temp.getNext();
    }
    System.out.println("]");
  }

  public int size() {
    return length;
  }

}

class Node {

  private int value;
  private Node next;

  public Node(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public Node getNext() {
    return next;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public void setNext(Node next) {
    this.next = next;
  }
}

class Driver{

  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    linkedList.print();
    System.out.println(linkedList.size());
    linkedList.remove(0);
    linkedList.remove(1);
    System.out.println(linkedList.size());
    linkedList.print();
  }
}
