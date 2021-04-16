package com.mayur.DataStructureAndAlgo.Algorithm.DynamicProgramming.Questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MAYUR on 12/31/20.
 */
public class Q6CanConstruct {

  /**
   * Write a function that accepts target string and an array of strings. Return a boolean stating
   * if the 'targetsum' can be constructed using the elements of the 'wordBank' array. You may reuse
   * the elements of word bank as many times as needed.
   */

  public static void main(String[] args) {
    String target = "abcdef";
    String[] wordBank = {"ab", "abc", "cd", "def", "abcd"};
    System.out.println(canConstructDP(target,wordBank));
    System.out.println(canConstructRecursion(target,wordBank));
  }


  /**
   *
   * n = target.length
   * m = array.length
   *
   * Time Complexity : O(m^n * n), extra m because of replaceFirst method worst case it will copy target
   * Space Complexity : O(n^2), extra n space for copied target
   *
   */
  private static boolean canConstructRecursion(String target, String[] array) {
    //base cases
    if (target.length()==0)
      return true;
    for (String element : array) {
      if (target.startsWith(element)) {
        if (canConstructRecursion(target.replaceFirst(element,""),array)) {
          return true;
        }
      }
    }
    return false;
  }


  /**
   *
   * n = target.length
   * m = array.length
   *
   * Time Complexity : O(m*n * n), extra m because of replaceFirst method worst case it will copy target
   * Space Complexity : O(n^2), extra n space for copied target
   *
   */
  private static boolean canConstructDP(String target, String[] wordBank) {
    Map<String, Boolean> memo = new HashMap<>();
    return canConstructDPUtil(target,wordBank,memo);
  }

  private static boolean canConstructDPUtil(String target, String[] wordBank,
      Map<String, Boolean> memo) {
    if (memo.containsKey(target))
      return memo.get(target);
    //base cases
    if (target.length()==0)
      return true;
    for (String element : wordBank) {
      if (target.startsWith(element)) {
        if (canConstructDPUtil(target.replaceFirst(element,""),wordBank,memo)) {
          memo.put(target,true);
          return true;
        }
      }
    }
    memo.put(target,false);
    return false;
  }
}
