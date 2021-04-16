package com.mayur.DataStructureAndAlgo.Algorithm.DynamicProgramming.Questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MAYUR on 12/31/20.
 */
public class Q5BestSum {

  /**
   * Write a function that takes in an array and tragetsum as the number of arguments. The function
   * return an array that adds up to the targetsum and that should be the shortest possible
   * combination. If there is a tie of the combination you may return any of the combination.
   */

  public static void main(String[] args) {
    int target = 7;
    int[] array = {5, 3, 4, 7};
    System.out.println(Arrays.toString(bestSumDP(target, array)));
    System.out.println(Arrays.toString(bestSumRecursion(target, array)));
  }


  /**
   *
   * n = target
   * m = array.length
   *
   * Time Complexity = O(m^n * m), extra m because of copy operation
   * Space complexity = O(n^2), n for method stack, and n for managing array
   *
   */
  private static int[] bestSumRecursion(int target, int[] array) {
    //base cases
    if (target == 0)
      return new int[] {};
    if (target < 0)
      return null;
    int[] resultArray = null;
    int[] temp;
    for (int num : array) {
      temp = bestSumRecursion(target - num, array);//recursive call
      if (temp != null) {
        temp = Arrays.copyOf(temp, temp.length + 1);
        temp[temp.length - 1] = num;
        if (resultArray == null || temp.length < resultArray.length) {
          resultArray = temp;
        }
      }
    }
    return resultArray;
  }

  /**
   *
   * n = target
   * m = array.length
   *
   * Time Complexity = O(m*n * m), extra m because of copy operation
   * Space complexity = O(n^2), n for method stack, and n for managing array
   *
   */
  private static int[] bestSumDP(int target, int[] array) {
    Map<Integer, Object> memo = new HashMap<>();
    return bestSumDPUtil(target, array, memo);
  }

  private static int[] bestSumDPUtil(int target, int[] array, Map<Integer, Object> memo) {
    if (memo.containsKey(target))
      return (int[]) memo.get(target);
    // base condition
    if (target == 0)
      return new int[] {};
    if (target < 0)
      return null;
    int[] temp;
    int[] resultArray = null;
    for (int num : array) {
      temp = bestSumDPUtil(target - num, array, memo);
      if (temp != null) {
        temp = Arrays.copyOf(temp, temp.length + 1);
        temp[temp.length - 1] = num;
        if (resultArray == null || temp.length < resultArray.length) {
          memo.put(target, temp);
          resultArray = temp;
        }
      }
    }
    return resultArray;
  }
}
