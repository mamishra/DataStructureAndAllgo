package com.mayur.DataStructureAndAlgo.DataStructure.Heap.Theory;

import java.util.Arrays;

/**
 * Created by MAYUR on 12/16/20.
 */
public class MaxHeap {

  int CAPACITY;
  int[] array;
  int size;

  public MaxHeap() {
    this.size = -1;
    this.CAPACITY = 10;
    this.array = new int[CAPACITY];
  }

  private int getParent(int i) {
    if (i >= 0 && i <= size) {
      return (i - 1) / 2;
    }
    return -1;
  }

  private int getLeftChild(int i) {
    if (i >= 0 && i <= size - 1) {
      return 2 * i + 1;
    }
    return -1;
  }

  private int getRightChild(int i) {
    if (i >= 0 && i <= size - 1) {
      return 2 * i + 2;
    }
    return -1;
  }

  public void insert(int val) {
    if (size == CAPACITY) {
      array = Arrays.copyOf(array, 2 * CAPACITY);
    }
    array[++size] = val;
    heapUp();
  }

  public void print() {
    for (int i = 0; i <= size; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }

  public int delete() {
    if (size == -1) {
      return -1;
    }
    int val = array[size];
    int popped = array[0];
    array[0] = val;
    array[size] = popped;
    size--;
    heapDown();
    return popped;
  }

  private void heapDown() {
    int i = 0;
    int swapIndex;
    while (i <= size) {
      if (getLeftChild(i) <= size && getRightChild(i) <= size) {
        if (array[i] < array[getLeftChild(i)] || array[i] < array[getRightChild(i)]) {
          if (array[getLeftChild(i)] > array[getRightChild(i)]) {
            swapIndex = getLeftChild(i);
          } else
            swapIndex = getRightChild(i);
          swap(i, swapIndex);
          i = swapIndex;
        }
      } else
        break;
    }
  }

  private void heapUp() {
    int i = size;
    while (i > 0) {
      if (array[i] > array[getParent(i)]) {
        swap(i, getParent(i));
        i = getParent(i);
      } else
        break;
    }
  }

  private void swap(int fromIndex, int toIndex) {
    int temp = array[fromIndex];
    array[fromIndex] = array[toIndex];
    array[toIndex] = temp;
  }

  private void swapHeapify(int[] array, int fromIndex, int toIndex) {
    int temp = array[fromIndex];
    array[fromIndex] = array[toIndex];
    array[toIndex] = temp;
  }

  //heapify to make array into heap
  public void heapify(int[] arr) {
    size = arr.length-1;
    for (int i = arr.length-1; i >=0; i--) {
      heapifyRecursive(arr, i);
    }
    array = Arrays.copyOf(arr,arr.length);
  }

  private void heapifyRecursive(int[] arr, int i) {
    if (getLeftChild(i)!=-1 || getRightChild(i)!=-1) {
      if (getLeftChild(i)!=-1 && getLeftChild(i)<=size && arr[getLeftChild(i)]>arr[i]) {
        swapHeapify(arr,i,getLeftChild(i));
        heapifyRecursive(arr,getLeftChild(i));
      }

      if (getRightChild(i)!=-1 && getRightChild(i)<=size && arr[getRightChild(i)]>arr[i]) {
        swapHeapify(arr,i,getRightChild(i));
        heapifyRecursive(arr,getRightChild(i));
      }
    }
  }
}


class Driver {
  public static void main(String[] args) {
    MaxHeap maxHeap = new MaxHeap();
    maxHeap.insert(10);
    maxHeap.insert(2);
    maxHeap.insert(13);
    maxHeap.insert(46);
    maxHeap.insert(35);
    maxHeap.insert(61);
    maxHeap.print();
    System.out.println(maxHeap.delete());
    System.out.println(maxHeap.delete());
    System.out.println(maxHeap.delete());
    maxHeap.print();

    MaxHeap maxHeap1 = new MaxHeap();
    maxHeap1.heapify(new int[] {1,2,3,4,5,6,7});
    maxHeap1.print();
  }
}
