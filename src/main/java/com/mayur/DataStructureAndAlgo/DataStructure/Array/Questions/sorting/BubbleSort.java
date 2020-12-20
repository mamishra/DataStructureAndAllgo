package com.mayur.DataStructureAndAlgo.DataStructure.Array.Questions.sorting;

import java.util.Arrays;

/**
 * Created by MAYUR on 12/5/20.
 */
public class BubbleSort {

  /**
   * Here we swap the adjacent elements untill the array is totally sorted.
   * We run two loops and freeze the maximum value at the end.
   * In the next run we dont consider that value as part of array.
   * I this case we are just taking the maximum value and adding at the end or array.
   */

  public static void main(String[] args) {
    int[] array = {9, 7, 8, 6, 4, 5, 2, 3, 1, 3, 4, 2};
    bubbleSort(array);
    System.out.println(Arrays.toString(array));
  }

  //Time Complexity O(n^2)
  private static void bubbleSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length - i -1; j++) {
        if (array[j]>array[j+1]) {
          swap(array,j,j+1);
        }
      }
    }
  }

  //Time Complexity O(n^2)
  //Here we have added a check if the array is sorted even before running through the array entirely
  // In that case we will not get any values swapped and we can just break
  private static void bubbleSortImproved(int[] array) {
    for (int i = 0; i < array.length; i++) {
      boolean swapped = false;
      for (int j = 0; j < array.length - i -1; j++) {
        if (array[j]>array[j+1]) {
          swap(array,j,j+1);
          swapped = true;
        }
      }
      if (!swapped)
        break;
    }
  }

  private static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
