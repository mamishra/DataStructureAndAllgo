package com.mayur.DataStructureAndAlgo.DataStructure.Array.Questions;

/**
 * Created by MAYUR on 12/5/20.
 */
public class SmallestPositiveSum {

  /**
   * Given a sorted array (sorted in non-decreasing order) of positive numbers,
   * find the smallest positive integer value
   * that cannot be represented as sum of elements of any subset of given set.
   * Expected time complexity is O(n).
   */

  public static void main(String[] args) {
    int[] array = {1, 3, 6, 10, 11, 15};
    System.out.println(getMinSum(array));
  }

  //Time complexity O(n)
  private static int getMinSum(int[] array) {
    //value initialized as 1
    int res = 1;
    //checking if next sum can be less than or equal to next element
    for (int i = 0; i < array.length && array[i] <= res; i++) {
      res+=array[i];
    }
    return res;
  }
}
