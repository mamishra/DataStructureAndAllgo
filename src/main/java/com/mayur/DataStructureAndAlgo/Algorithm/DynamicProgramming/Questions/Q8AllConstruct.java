package com.mayur.DataStructureAndAlgo.Algorithm.DynamicProgramming.Questions;

import java.util.Arrays;

/**
 * Created by MAYUR on 1/2/21.
 */
public class Q8AllConstruct {//Incomplete

  /**
   * Write a function that takes in a target string and an array of strings.
   * <p>
   * The function should return a 2D array containing all of the ways that the target can be
   * constructed by concatenating the elements of the array. Each element of the 2D array should
   * contain a combination that can be used to construct the target array.
   */

  public static void main(String[] args) {
    String target = "abcdef";
    String[] wordBank = {"ab","abc","cd","def","abcd","ef","c"};
    String[][] res = allConstructRecursion(target,wordBank);
    for (int i = 0; i < res.length; i++) {
      System.out.println("[");
      for (int j = 0; j < res[i].length; j++) {
        System.out.print(res[i][j]+" ");
      }
      System.out.println("]");
    }
  }

  private static String[][] allConstructRecursion(String target, String[] wordBank) {
    String[][] finalArray = new String[0][];
    return allConstructRecursionUtil(target,wordBank,finalArray);
  }

  private static String[][] allConstructRecursionUtil(String target, String[] wordBank,
      String[][] finalArray) {
    if (target.length() == 0) {
      return new String[0][];
    }
    for (String word : wordBank) {
      if (target.startsWith(word)) {
        String[][] array =
            allConstructRecursionUtil(target.replaceFirst(word, ""), wordBank, finalArray);
        finalArray = Arrays.copyOf(finalArray, finalArray.length + array.length);
        for (int i = 0; i < array.length; i++) {
          finalArray[finalArray.length - array.length + i] = array[i];
        }
        for (String[] strings : array) {
          strings = Arrays.copyOf(strings, strings.length + 1);
          strings[strings.length - 1] = word;
        }
        if (finalArray.length == 0) {
          finalArray = Arrays.copyOf(finalArray, 1);
          finalArray[0] = new String[] {word};
        }
      }
    }
    return finalArray;
  }
}
