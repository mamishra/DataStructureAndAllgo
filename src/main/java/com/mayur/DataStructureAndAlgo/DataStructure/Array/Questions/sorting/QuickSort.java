package com.mayur.DataStructureAndAlgo.DataStructure.Array.Questions.sorting;

import java.util.Arrays;

/**
 * Created by MAYUR on 12/4/20.
 */
public class QuickSort {

  public static void main(String[] args) {
    int[] array = {9, 7, 8, 6, 4, 5, 2, 3, 1, 3, 4, 2};
    quickSort(array, 0, array.length - 1);
    System.out.println(Arrays.toString(array));
  }

  /**
   * This method implements in-place quicksort algorithm recursively.
   */

  private static void quickSort(int[] array, int start, int end) {
    int pivot = array[start + (end - start) / 2];
    int i = start;
    int j = end;

    while (i < j) {

      /** * In each iteration, we will identify a
       * * number from left side which is greater then the pivot value, and
       * * a number from right side which is less then the pivot value. Once
       * * search is complete, we can swap both numbers.
       * */

      while (array[i] < pivot)
        i++;
      while (array[j] > pivot)
        j--;

      if (i <= j) {

        //swapping
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        i++;
        j--;
      }
    }

    // calls quickSort() method recursively
    if (start < j) {
      quickSort(array, start, j);
    }
    if (end > i) {
      quickSort(array, i, end);
    }
  }


}
