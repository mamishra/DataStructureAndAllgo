package com.mayur.DataStructureAndAlgo.Algorithm.DynamicProgramming.Questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MAYUR on 1/2/21.
 */
public class Q9MaximumRobbery {

  /**
   * There are n number of house in a row. Each house contains some amount of money. A thief has to
   * rob from that colony keeping in mind that he must not rob from two adjacent houses. Find the
   * maximum amount he can rob.
   */

  public static void main(String[] args) {
    int[] colonyMoney = {10, 20, 1, 45, 80, 6, 38};
    System.out.println(getMaximumRobberyAmountDP(colonyMoney));
    System.out.println(getMaximumRobberyAmountRecursive(colonyMoney));
  }

  /**
   *
   * n = colonyMoney.length
   *
   * Time complexity : O(n^n)
   * Space complexity : O(n)
   *
   */
  private static int getMaximumRobberyAmountRecursive(int[] colonyMoney) {
    //base condition
    if (colonyMoney.length == 1)
      return colonyMoney[0];
    if (colonyMoney.length == 2)
      return Math.max(colonyMoney[0], colonyMoney[1]);
    if (colonyMoney.length == 3)
      return Math.max(colonyMoney[0] + colonyMoney[2], colonyMoney[1]);
    //recursive call
    return colonyMoney.length != 0 ?
        Math.max(colonyMoney[0] + getMaximumRobberyAmountRecursive(
            Arrays.copyOfRange(colonyMoney, 2, colonyMoney.length)),
            colonyMoney[1] + getMaximumRobberyAmountRecursive(
                Arrays.copyOfRange(colonyMoney, 3, colonyMoney.length))) :
        0;
  }

  /**
   *
   * n = colonyMoney.length
   *
   * Time complexity : O(n^2)
   * Space complexity : O(n)
   *
   */
  private static int getMaximumRobberyAmountDP(int[] colonyMoney) {
    Map<String, Integer> memo = new HashMap<>();
    return getMaximumRobberyAmountDPUtil(colonyMoney, memo);
  }

  private static int getMaximumRobberyAmountDPUtil(int[] colonyMoney, Map<String, Integer> memo) {
    //base condition
    //memoization in each stage
    if (colonyMoney.length == 1) {
      if (memo.containsKey(Arrays.toString(colonyMoney))) {
        return memo.get(Arrays.toString(colonyMoney));
      }
      memo.put(Arrays.toString(colonyMoney), colonyMoney[0]);
      return colonyMoney[0];
    }
    if (colonyMoney.length == 2) {
      if (memo.containsKey(Arrays.toString(colonyMoney))) {
        return memo.get(Arrays.toString(colonyMoney));
      }
      memo.put(Arrays.toString(colonyMoney), Math.max(colonyMoney[0], colonyMoney[1]));
      return Math.max(colonyMoney[0], colonyMoney[1]);
    }
    if (colonyMoney.length == 3) {
      if (memo.containsKey(Arrays.toString(colonyMoney))) {
        return memo.get(Arrays.toString(colonyMoney));
      }
      memo.put(Arrays.toString(colonyMoney),
          Math.max(colonyMoney[0] + colonyMoney[2], colonyMoney[1]));
      return Math.max(colonyMoney[0] + colonyMoney[2], colonyMoney[1]);
    }
    if (colonyMoney.length != 0) {
      if (memo.containsKey(Arrays.toString(colonyMoney))) {
        return memo.get(Arrays.toString(colonyMoney));
      }
      memo.put(Arrays.toString(colonyMoney), Math.max(
          colonyMoney[0] + getMaximumRobberyAmountDPUtil(
              Arrays.copyOfRange(colonyMoney, 2, colonyMoney.length), memo),
          colonyMoney[1] + getMaximumRobberyAmountDPUtil(
              Arrays.copyOfRange(colonyMoney, 3, colonyMoney.length), memo)));
      return memo.get(Arrays.toString(colonyMoney));
    }
    return 0;
  }
}
