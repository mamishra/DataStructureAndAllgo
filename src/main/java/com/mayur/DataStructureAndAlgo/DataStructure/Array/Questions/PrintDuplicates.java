package com.mayur.DataStructureAndAlgo.DataStructure.Array.Questions;

import java.util.Arrays;

/**
 * Created by MAYUR on 12/2/20.
 */
public class PrintDuplicates {

  public static void main(String[] args) {
    int[] array = {1,2,3,4,5,5,6,7,8,1,9};
    printMultipleDuplicates(array,array.length);
    int[] array2 = {1,2,3,4,5,7,6,7,8,1,9};
    System.out.println();
    printSingleDuplicate(array2,array2.length);
  }

  //Arrays.sort use dual pivotal quicksort
  //hence this code time complexity will be
  //           average case : O(n.logn)
  //           worst case   : O(n^2)
  private static void printSingleDuplicate(int[] array, int length) {
    Arrays.sort(array);
    for (int i = 0; i < length; i++) {
      if (i + 1 < length && array[i] == array[i + 1]) {
        System.out.print(array[i] + " ");
      }
    }
  }


  //O(n) time complexity, O(1) extra space
  static void printMultipleDuplicates(int arr[], int n)
  {
    int i;

    // Flag variable used to
    // represent whether repeating
    // element is found or not.
    int fl = 0;

    for (i = 0; i < n; i++)
    {

      // Check if current element is
      // repeating or not. If it is
      // repeating then value will
      // be greater than or equal to n.
      if (arr[arr[i] % n] >= n)
      {

        // Check if it is first
        // repetition or not. If it is
        // first repetition then value
        // at index arr[i] is less than
        // 2*n. Print arr[i] if it is
        // first repetition.
        /**
         *  2n is always less than 2^n
         *  arr[arr[i] % n] will always be less than 2n if n is added once
         *  if added more this will not work
         *  so if more duplicates we are printing only once
         */
        if (arr[arr[i] % n] < 2 * n)
        {
          System.out.print( arr[i] % n + " ");
          fl = 1;
        }
      }

      // Add n to index arr[i] to mark
      // presence of arr[i] or to
      // mark repetition of arr[i].
      arr[arr[i] % n] += n;
    }

    // If flag variable is not set
    // then no repeating element is
    // found. So print -1.
    if (!(fl > 0))
      System.out.println("-1");
  }
}
