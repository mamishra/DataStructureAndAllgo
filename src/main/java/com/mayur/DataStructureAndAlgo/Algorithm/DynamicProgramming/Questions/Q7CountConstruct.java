package com.mayur.DataStructureAndAlgo.Algorithm.DynamicProgramming.Questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MAYUR on 1/2/21.
 */
public class Q7CountConstruct {

  /**
   * Write a function that takes a target string and an array of string. The function should return
   * the number of ways possible to construct the target string from the array of strings. You may
   * reuse the elements of the array.
   */

  public static void main(String[] args) {
    String target = "abcdef";
    String[] wordBank = {"ab", "abc", "cd", "def", "abcd", "ef"};
    System.out.println(countConstructDP(target, wordBank));
    System.out.println(countConstructRecursion(target, wordBank));
  }


  /**
   *
   * n = target.length
   * m = wordBank.length
   *
   * Time Complexity : O(m^n * n), extra m because of replaceFirst method worst case it will copy target
   * Space Complexity : O(n^2), extra n space for copied target
   *
   */
  private static int countConstructRecursion(String target, String[] wordBank) {
    int sum = 0;
    if (target.length() == 0)
      return 1;
    for (String word : wordBank) {
      if (target.startsWith(word)) {
        sum += countConstructRecursion(target.replaceFirst(word, ""), wordBank);
      }
    }
    return sum;
  }


  /**
   *
   * n = target.length
   * m = wordBank.length
   *
   * Time Complexity : O(m*n * n), extra m because of replaceFirst method worst case it will copy target
   * Space Complexity : O(n^2), extra n space for copied target
   *
   */
  private static int countConstructDP(String target, String[] wordBank) {
    Map<String,Integer> memo = new HashMap<>();
    return countConstructDPUtil(target,wordBank,memo);
  }

  private static int countConstructDPUtil(String target, String[] wordBank,
      Map<String, Integer> memo) {
    int sum = 0;
    if (memo.containsKey(Arrays.toString(wordBank)))
      return memo.get(Arrays.toString(wordBank));
    if (target.length() == 0)
      return 1;
    for (String word : wordBank) {
      if (target.startsWith(word)) {
        sum += countConstructDPUtil(target.replaceFirst(word, ""), wordBank,memo);
      }
    }
    memo.put(Arrays.toString(wordBank),sum);
    return sum;
  }

}
