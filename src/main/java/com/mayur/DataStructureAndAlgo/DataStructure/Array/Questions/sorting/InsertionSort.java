package com.mayur.DataStructureAndAlgo.DataStructure.Array.Questions.sorting;

import java.util.Arrays;

/**
 * Created by MAYUR on 12/5/20.
 */
public class InsertionSort {

  /**
   * walk through the array
   * check the element and put it at the place where no other bigger element is after that index
   * move all elements one step back
   */

  public static void main(String[] args) {
    int[] array = {9, 7, 8, 6, 4, 5, 2, 3, 1, 3, 4, 2};
    insertionSort(array);
    System.out.println(Arrays.toString(array));
  }

  // Time complexity in worst case is O(n^2)
  private static void insertionSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int j = i - 1;
      int val = array[i];
      //move all elements a step forward if value is smaller
      while (j >= 0 && array[j] > val) {
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = val;
    }
  }
}
