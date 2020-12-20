package com.mayur.DataStructureAndAlgo.DataStructure.Array.Questions.sorting;

import java.util.Arrays;

/**
 * Created by MAYUR on 12/5/20.
 */
public class SelectionSort {

  /**
   * Sorting is done in three parts:
   *
   * 0. Array is in two parts, sorted and unsorted
   * 1. Find the minimum.
   * 2. Swap it with first element.
   * 3. Move the sorted array counter
   */

  public static void main(String[] args) {
    int[] array = {9, 7, 8, 6, 4, 5, 2, 3, 1, 3, 4, 2};
    selectionSort(array);
    System.out.println(Arrays.toString(array));
  }

  //Time complexity O(n^2)
  private static void selectionSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int min = array[i];
      int minIndex = i;
      // finding minimum
      for (int j = i + 1; j < array.length; j++) {
        if (min > array[j]) {
          min = array[j];
          minIndex = j;
        }
      }
      //swapping
      swap(array, i, minIndex);

      //incrementing with loop
    }
  }

  private static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
