package com.mayur.DataStructureAndAlgo.DataStructure.Heap.Questions;

import java.util.PriorityQueue;

/**
 * Created by MAYUR on 12/17/20.
 */
public class FirstKElements {

  public void firstKElements(int[] array, int size, int k) {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int i = 0; i < k; i++) {
      minHeap.add(array[i]);
    }

    for (int i = k; i < size; i++) {
      if (minHeap.peek() <= array[i]) {
        minHeap.poll();
        minHeap.add(array[i]);
      }
    }

    for (Integer integer : minHeap) {
      System.out.print(integer + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] array = new int[] {11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45};
    FirstKElements firstKElements = new FirstKElements();
    firstKElements.firstKElements(array, array.length, 3);
  }

}


