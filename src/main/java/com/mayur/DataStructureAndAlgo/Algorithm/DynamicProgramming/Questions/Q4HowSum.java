package com.mayur.DataStructureAndAlgo.Algorithm.DynamicProgramming.Questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MAYUR on 12/30/20.
 */
public class Q4HowSum {

  /**
   * Write a function that takes in target number and an array of integers as input. The function
   * should return an array that contains all the numbers that exactly sum up to the target number.
   * If there is no such combination then return null.
   * <p>
   * If there are multiple combination you can return any one.
   */

  public static void main(String[] args) {

//    int target = 7;
//    int[] array = {5,3,4,7};
    int target = 300;
    int[] array = {14,7};
    System.out.println(Arrays.toString(howSumDP(target,array)));
    System.out.println(Arrays.toString(howSumRecursion(target,array)));
  }


  /**
   *
   * let target = n
   * and array.length = m
   *
   * at max height of tree can be n, that will be when we reduce 1 at each level
   * at max max nodes at each level can be m, that will be when we check for all the negatives
   *
   * Time Complexity : O(m^n * n) ,extra n for copying operation
   * Space Complexity : O(n)
   *
   */
  private static int[] howSumRecursion(int target, int[] array) {
    //base condition
    if (target == 0)
      return new int[] {};
    if (target < 0)
      return null;
    int[] newArray;
    for (int num : array) {
      int[] temp = howSumRecursion(target - num, array);
      if (temp != null) {
        newArray = Arrays.copyOf(temp, temp.length + 1);
        newArray[temp.length] = num;
        return newArray;
      }
    }
    return null;
  }


  /**
   *
   * let target = n
   * and array.length = m
   *
   * at max height of tree can be n, that will be when we reduce 1 at each level
   * at max max nodes at each level can be m, that will be when we check for all the negatives
   *
   * Time Complexity : O(m*n * n) ,extra n for copying operation
   * Space Complexity : O(n^2), extra space because of memoization
   *
   */
  private static int[] howSumDP(int target, int[] array) {
    Map<Integer,Object> memo = new HashMap<>();
    return howSumDPUtil(target,array,memo);
  }

  private static int[] howSumDPUtil(int target, int[] array, Map<Integer, Object> memo) {
    if (memo.containsKey(target))
      return (int[]) memo.get(target);
    //base condition
    if (target == 0)
      return new int[] {};
    if (target < 0)
      return null;
    int[] newArray;
    for (int num : array) {
      int[] temp = howSumDPUtil(target - num, array, memo);
      if (temp != null) {
        newArray = Arrays.copyOf(temp, temp.length + 1);
        newArray[temp.length] = num;
        memo.put(target, newArray); //memoization
        return newArray;
      }
    }
    return null;
  }
}
