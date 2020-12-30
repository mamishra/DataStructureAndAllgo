package com.mayur.DataStructureAndAlgo.BitMasking.Questions;

/**
 * Created by MAYUR on 12/27/20.
 */
public class NonRepeatingNumber {
  /**
   * This array contains all the numbers that occurs twice, except one.
   * Fine the number that occurs only once.
   */

  public static void main(String[] args) {
    int[] arr = {1, 1, 2, 3, 4, 5, 3, 4, 5};
    System.out.println(printNonRepeating(arr));
  }

  private static int printNonRepeating(int[] arr) {
    int result = arr[0];
    for (int i = 1; i < arr.length; i++) {
      result ^= arr[i]; // since X^X = 0
    }
    return result;
  }
}
