package com.mayur.DataStructureAndAlgo.Algorithm.BackTracking.Questions;

import java.util.Collections;
import java.util.Set;

/**
 * Created by MAYUR on 1/4/21.
 */
public class Q3AllSubSets {

  /**
   * Given a set of integers find all the subsets of the array. Dont print the duplicate subsets.
   */

  public static void main(String[] args) {
    int[] array = {1,2,3};
    System.out.println(getAllSubsets(array));
  }

  private static Set<Set<Integer>> getAllSubsets(int[] array) {
    if (array.length==0)
      return Collections.EMPTY_SET;
    int current = array[0];
    return getAllSubsetsUtil(current,array);
  }

  private static Set<Set<Integer>> getAllSubsetsUtil(int current, int[] array) {

    return null;
  }
}
