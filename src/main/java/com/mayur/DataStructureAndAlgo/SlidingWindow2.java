package com.mayur.DataStructureAndAlgo;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by MAYUR on 11/10/20.
 */
public class SlidingWindow2 {

  /**
   *
   * sliding window using dequeue, complexity O(n)
   *
   */

  public static void main(String[] args) {
    List<Integer> list = Stream.of(1, 3, -1, -3, 5, 3, 6, 7).collect(Collectors.toList());
    System.out.println(slidingMaximum(list,3));
  }

  public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
    Deque<Integer> deque = new LinkedList<>();
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < B; i++) {
      if (!deque.isEmpty() && A.get(deque.peekFirst()) > A.get(i))
        deque.addLast(i);
      if (deque.isEmpty())
        deque.addLast(i);
    }
    for (int i = 0; i < A.size(); i++) {


    }
    return null;
  }
}
