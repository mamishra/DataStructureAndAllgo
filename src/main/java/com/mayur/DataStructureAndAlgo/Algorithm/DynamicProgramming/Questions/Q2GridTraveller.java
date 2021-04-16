package com.mayur.DataStructureAndAlgo.Algorithm.DynamicProgramming.Questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MAYUR on 12/30/20.
 */
public class Q2GridTraveller {

  /**
   * You have a traveler in a 2-D grid. You begin at the top left corner and your goal is to go to
   * the bottom right corner. You can only move down or right.
   * <p>
   * In how many ways you can travel through the grid to the goal, if the grid is of size m*n ?
   */

  public static void main(String[] args) {
    int m = 20;
    int n = 30;
    System.out.println(gridTravelerDP(m, n));
    //System.out.println(gridTravelerRecursion(m,n));
    System.out.println(gridTravelerTabulation(m, n));
  }

  /**
   *
   * array[i][j] represents the number of possible ways to travel a grid of size mxn
   *
   * Time Complexity : O(m*n)
   * Space Complexity : O(m*n)
   *
   */
  private static long gridTravelerTabulation(int m, int n) {
    long[][] array = new long[m + 1][n + 1];
    array[1][1] = 1;
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i + 1 <= m) {
          array[i + 1][j] += array[i][j];
        }
        if (j + 1 <= n) {
          array[i][j + 1] += array[i][j];
        }
      }
    }
    return array[m][n];
  }


  /**
   *
   * Here the method stack will be similar as fibonacci
   *
   * Time Complexity : O(2^(m+n))
   * Space Complexity : O(m+n)
   *
   */
  private static long gridTravelerRecursion(int m, int n) {
    //base condition
    if (m <= 0 || n <= 0)
      return 0;
    if (m == 1 && n == 1)
      return 1;
    return gridTravelerRecursion(m - 1, n) + gridTravelerRecursion(m, n - 1); // recursive call
  }


  /**
   *
   * Here the method stack will be similar as fibonacci
   *
   * Time Complexity : O(m*n)
   * Space Complexity : O(m+n)
   *
   */
  private static long gridTravelerDP(int m, int n) {
    Map<String,Long> memo = new HashMap<>();
    return gridTravelerDPUtil(m,n,memo);
  }


  private static long gridTravelerDPUtil(int m, int n, Map<String, Long> memo) {
    String key = String.valueOf(m).concat("-").concat(String.valueOf(n));
    //base condition
    if (memo.containsKey(key))
      return memo.get(key);
    if (m <= 0 || n <= 0)
      return 0;
    if (m == 1 && n == 1)
      return 1;
    memo.put(key,
        gridTravelerDPUtil(m - 1, n, memo) + gridTravelerDPUtil(m, n - 1, memo)); // recursive call
    return memo.get(key);
  }

}
