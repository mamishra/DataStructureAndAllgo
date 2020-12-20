package com.mayur.DataStructureAndAlgo.DataStructure.Array.Questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by MAYUR on 12/3/20.
 */
public class FindPairs {

  /**
   * This is an intermediate level of array coding question, it's neither too easy nor too
   * difficult. You have given an integer array and a number, you need to write a program to find
   * all elements in the array whose sum is equal to the given number. Remember, the array may
   * contain both positive and negative numbers, so your solution should consider that. Don't forget
   * to write unit test though, even if the interviewer is not asked for it, that would separate you
   * from a lot of developers. Unit testing is always expected from a professional developer.
   */

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 6, 7, 8, 4, 2, 1};
    printAllPairs(array, 4);
    printPairsApproach1(array, 4);
    printPairsApproach2(array, 4);
  }

  //time complexity O(n.logn) because of sorting
  //space complexity constant
  private static void printPairsApproach2(int[] array, int sum) {
    Arrays.sort(array);
    int first = 0;
    int last = array.length - 1;

    while (first < last) {
      if (sum == array[first] + array[last]) {
        System.out.println(array[first] + " + " + array[last]);
        first++;
        last--;
      } else if (sum < array[first] + array[last])
        last--;
      else
        first++;
    }
  }

  //time complexity O(n), space complexity O(n)
  private static void printPairsApproach1(int[] array, int sum) {
    Set set = new HashSet();
    for (int value : array) {
      int target = sum - value;
      if (set.contains(target)) {
        System.out.println(value + " + " + target);
      } else
        set.add(value);
    }
  }

  //brute force
  //time complexity O(n^2)
  private static void printAllPairs(int[] array, int sum) {
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] + array[j] == sum)
          System.out.println(array[i] + " + " + array[j]);
      }
    }
  }

}
