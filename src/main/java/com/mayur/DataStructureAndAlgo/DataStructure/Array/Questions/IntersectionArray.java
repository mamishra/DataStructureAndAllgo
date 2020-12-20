package com.mayur.DataStructureAndAlgo.DataStructure.Array.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by MAYUR on 12/5/20.
 */
public class IntersectionArray {

  /**
   * Your task is to write a function to return the intersection of two sorted arrays.
   *
   */

  public static void main(String[] args) {
    int[] array1 = {21, 34, 41, 22, 35};
    int[] array2 = {61, 34, 45, 21, 11};

    System.out.println(Arrays.toString(getIntersectionBetter(array1,array2)));
  }

  //brute force
  // Time complexity O(n^2)
  private static int[] getIntersection(int[] array1, int[] array2) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < array1.length; i++) {
      for (int j = 0; j < array2.length; j++) {
        if (array1[i]==array2[j])
          list.add(array1[i]);
      }
    }
    int[] array = new int[list.size()];
    AtomicInteger i = new AtomicInteger();
    list.stream().forEach(integer -> {
      array[i.get()] = integer;
      i.getAndIncrement();
    });
    return array;
  }

  //Time complexity O(n.logn) i.e. the time complexity of sorting
  private static int[] getIntersectionBetter(int[] array1, int[] array2) {
    int i = 0;
    int j = 0;
    Arrays.sort(array1);
    Arrays.sort(array2);
    List<Integer> list = new ArrayList<>();
    while (i < array1.length && j < array2.length) {
      if (array1[i] == array2[j]) {
        list.add(array1[i]);
        i++;
        j++;
      } else if (array1[i]<array2[j]) {
        i++;
      } else if (array1[i]>array2[j]) {
        j++;
      }
    }
    int[] result = new int[list.size()];
    for (int k = 0; k < list.size(); k++) {
      result[k] = list.get(k);
    }
    return result;
  }
}
