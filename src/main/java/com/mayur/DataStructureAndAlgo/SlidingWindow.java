package com.mayur.DataStructureAndAlgo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by MAYUR on 11/10/20.
 */
public class SlidingWindow {

  public static void main(String[] args) {
    List<Integer> list = Stream.of(1, 3, -1, -3, 5, 3, 6, 7).collect(Collectors.toList());
    System.out.println(slidingMaximum(list,3));
  }

  public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
    int i = 0;
    int j = B-1;
    ArrayList<Integer> result = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    for (int k = 0; k < B; k++) {
      max = max < A.get(k) ? A.get(k) : max;
    }
    result.add(max);
    for (i = 1, j++ ; i <= A.size()-B; j++,i++) {

    }
    return result;
  }
}
