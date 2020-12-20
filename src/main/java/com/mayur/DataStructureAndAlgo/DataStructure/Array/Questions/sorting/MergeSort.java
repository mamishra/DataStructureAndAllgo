package com.mayur.DataStructureAndAlgo.DataStructure.Array.Questions.sorting;

import java.util.Arrays;

/**
 * Created by MAYUR on 12/5/20.
 */
public class MergeSort {

  /**
   * MergeSort(arr[], l,  r)
   * If r > l
   *      1. Find the middle point to divide the array into two halves:
   *              middle m = (l+r)/2
   *      2. Call mergeSort for first half:
   *              Call mergeSort(arr, l, m)
   *      3. Call mergeSort for second half:
   *              Call mergeSort(arr, m+1, r)
   *      4. Merge the two halves sorted in step 2 and 3:
   *              Call merge(arr, l, m, r)
   */

  public static void main(String[] args) {
    int[] array = {9, 7, 8, 6, 4, 5, 2, 3, 1, 3, 4, 2};
    mergeSort(array, 0, array.length - 1);
    System.out.println(Arrays.toString(array));
  }

  private static void mergeSort(int[] array, int left, int right) {
    if (left >= right) {
      return;
    }
    //getting middle element
    int mid = (left + right) / 2;
    //sorting two halves
    mergeSort(array, 0, mid);
    mergeSort(array, mid + 1, right);
    //merging
    merge(array, left, mid, right);
  }

  //Time complexity O(n.logn)
  //Auxilary space O(n)
  private static void merge(int[] arr, int l, int m, int r) {
    // Find sizes of two subarrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;

    /* Create temp arrays */
    int L[] = new int[n1];
    int R[] = new int[n2];

    /*Copy data to temp arrays*/
    for (int i = 0; i < n1; ++i)
      L[i] = arr[l + i];
    for (int j = 0; j < n2; ++j)
      R[j] = arr[m + 1 + j];

    /* Merge the temp arrays */

    // Initial indexes of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarry array
    int k = l;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      }
      else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }

    /* Copy remaining elements of L[] if any */
    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    /* Copy remaining elements of R[] if any */
    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }
}
