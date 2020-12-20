package com.mayur.DataStructureAndAlgo.DataStructure.Queue.Theory;

/**
 * Created by MAYUR on 9/22/20.
 */
public class QueueUsingLinkedList {

  public static void main(String[] args) {

    QueueLL queue = new QueueLL();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    System.out.println(queue.isEmpty());
    queue.dequeue();
    System.out.println(queue.front());
    queue.dequeue();
    queue.dequeue();
    System.out.println(queue.toString());
    System.out.println(queue.isEmpty());
    queue.enqueue(6);
    queue.enqueue(7);
    System.out.println(queue.front());
    System.out.println(queue.toString());
  }
}


class QueueLL {

  private Node front;
  private Node rear;

  public QueueLL() {
    this.front = new Node(null);
    this.rear = new Node(null);
  }

  public void enqueue(Object x) {
    Node node = new Node(x);
    if (front.getNext()!=null && rear.getNext()!=null) {
      rear.getNext().setNext(node);
    } else {
      front.setNext(node);
    }
    rear.setNext(node);
  }

  public void dequeue() {
    if (front.getNext()!=null && rear.getNext()!=null && front.getNext()!=rear.getNext()) {
      Node temp = front.getNext();
      front.setNext(temp.getNext());
    } else if (front.getNext()==rear.getNext()) {
      front.setNext(null);
      rear.setNext(null);
    } else {
      System.out.println("Queue is Empty !!");
    }
  }

  public Object front() {
    return front.getNext()!=null?front.getNext().getData():"Empty Queue";
  }

  public boolean isEmpty() {
    return front.getNext()==null;
  }

  @Override
  public String toString() {
    String result = "Queue : ";
    Node node = front.getNext();
    while (node != null) {
      result += node.getData().toString() + " ";
      node = node.getNext();
    }
    return result;
  }
}


class Node {

  private Object data;
  private Node next;

  public Node(Object data) {
    this.data = data;
    this.next = null;
  }

  public Object getData() {
    return data;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }
}
