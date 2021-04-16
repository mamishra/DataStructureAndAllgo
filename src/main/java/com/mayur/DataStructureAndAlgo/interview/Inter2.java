package com.mayur.DataStructureAndAlgo.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by MAYUR on 2/19/21.
 */
public class Inter2 {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);
    int k = 5;
    getTopKElements(list,k);
  }


  private static void getTopKElements(List<Integer> list, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>(k);
    for (Integer val : list) {
      if (heap.size()==k ) {
        if (heap.peek() < val) {
          heap.poll();
          heap.add(val);
        }
      }else {
        heap.add(val);
      }
    }
    heap.forEach(a -> System.out.println(a));
  }

}
