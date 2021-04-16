package com.mayur.DataStructureAndAlgo.Algorithm.DynamicProgramming.Questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MAYUR on 12/30/20.
 */
public class Q3CanSum {

  /**
   * Here we are provided with a target number and an array. We have to figure out if we can make
   * the value of target sum using the values in the array. We can use a single value as many times
   * as we want.
   * <p>
   * If we can construct the target sum we have to return true, else return false.
   */

  public static void main(String[] args) {
//    int target = 7;
//    int[] array = {5,3,4,7};
    int target = 300;
    int[] array = {14,7};
    System.out.println(canSumDP(target,array));
    System.out.println(canSumRecursion(target,array));
  }


  /**
   *
   * let target = n
   * and array.length = m
   *
   * at max height of tree can be n, that will be when we reduce 1 at each level
   * at max max nodes at each level can be m, that will be when we check for all the negatives
   *
   * Time Complexity : O(m^n)
   * Space Complexity : O(n)
   *
   */
  private static boolean canSumRecursion(int target, int[] array) {
    //base condition
    if (target == 0)
      return true;
    if (target < 0)
      return false;
    for (int num : array) {
      if (canSumRecursion(target - num, array)) // recusrive call
        return true;
    }
    return false;
  }


  /**
   *
   * let target = n
   * and array.length = m
   *
   * at max height of tree can be n, that will be when we reduce 1 at each level
   * at max max nodes at each level can be m, that will be when we check for all the negatives
   *
   * at max we need to check for memo object m*n times
   * Time Complexity : O(m*n)
   * Space Complexity : O(n)
   *
   */
  private static boolean canSumDP(int target, int[] array) {
    Map<Integer, Boolean> memo = new HashMap<>();
    return canSumDPUtil(target, array, memo);
  }

  private static boolean canSumDPUtil(int target, int[] array, Map<Integer, Boolean> memo) {
    if (memo.containsKey(target))
      return memo.get(target);
    //base condition
    if (target == 0)
      return true;
    if (target < 0)
      return false;
    for (int num : array) {
      memo.put(target, canSumDPUtil(target - num, array, memo));
      if (memo.get(target)) // recusrive call
        return true;
    }
    return false;
  }
}
