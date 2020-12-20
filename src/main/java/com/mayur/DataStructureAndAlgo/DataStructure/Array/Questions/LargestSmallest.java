package com.mayur.DataStructureAndAlgo.DataStructure.Array.Questions;

import java.util.Arrays;

/**
 * Created by MAYUR on 12/3/20.
 */
public class LargestSmallest {

  /**
   * This is a rather simple array interview question.
   * You have given an unsorted integer array and you need to find the largest and smallest element in the array.
   * Of course, you can sort the array and then pick the top and bottom element but that would cost you O(NLogN)
   * because of sorting, getting element in array with index is O(1) operation.
   *
   */

  public static void main(String[] args) {
    int[] array = {9,6,7,2,3,5,1,6,2,2};
    System.out.println(getSmallest(array));
    System.out.println(getLargest(array));
  }

  private static int getLargest(int[] array) {
    Arrays.sort(array);
    return array[array.length-1];
  }

  private static int getSmallest(int[] array) {
    Arrays.sort(array);
    return array[0];
  }
}
