package com.mayur.DataStructureAndAlgo.DataStructure.Queue.Theory;

/**
 * Created by MAYUR on 9/22/20.
 */
public class QueueUsingArray {

  public static void main(String[] args) {
    Queue queue = new Queue();
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


class Queue {

  private Object[] array;
  private int front;
  private int rear;

  public Queue() {
    this.front = -1;
    this.rear = -1;
    this.array = new Object[4];
  }

  public void enqueue(Object x) {
    if (front == -1 && rear == -1) {
      front = 0;
      rear = 0;
      array[front] = x;
    } else if ((rear - front + 1) % array.length == 0) {
      System.out.println("queue is full");
    } else {
      rear = (rear + 1) % array.length;
      array[rear] = x;
    }
  }

  public void dequeue() {
    if (front == -1 && rear == -1) {
      System.out.println("queue is empty");
    } else if (front == rear) {
      front = -1;
      rear = -1;
    } else {
      front = (front + 1) % array.length;
    }
  }

  public Object front() {
    return array[front];
  }

  public boolean isEmpty() {
    return (front == -1 && rear == -1);
  }

  @Override
  public String toString() {
    String result = "[ ";
    if (front == -1 || rear == -1) {
      result += "EMPTY ";
    } else if (rear == front) {
      result += array[front] + " ";
    } else {
      int j = 0;
      int length = rear > front ? rear - front + 1 : array.length - (front - rear) + 1;
      for (int i = front; j < length; i = (i + 1) % array.length,j++) {
        result += array[i] + " ";
      }
    }
    result += "]";
    return result;
  }
}

