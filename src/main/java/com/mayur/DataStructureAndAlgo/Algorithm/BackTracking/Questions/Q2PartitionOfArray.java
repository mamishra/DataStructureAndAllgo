package com.mayur.DataStructureAndAlgo.Algorithm.BackTracking.Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by MAYUR on 1/3/21.
 */
public class Q2PartitionOfArray {

  /**
   * Given an array, return a subarray that has the sum of elements equals to half of the sum of
   * elements of original array.
   */

  public static void main(String[] args) {
    int[] array = {2,1,8,3,4,2};
    List<Integer> list = getPartition(array);
    list.forEach(ele -> System.out.print(ele+" "));
  }

  private static List<Integer> getPartition(int[] array) {
    int sum = 0;
    for (int val : array) {
      sum += val;
    }
    if ((sum&1)!=0)
      return Collections.EMPTY_LIST;
    List<Integer> result = new ArrayList<>();
    if (getPartitionUtil(sum / 2, array, result)) {
      return result;
    }
    return Collections.EMPTY_LIST;
  }

  private static boolean getPartitionUtil(int i, int[] array, List<Integer> result) {
    if (i == 0)
      return true;
    if (array.length==0)
      return false;
    for (int num : array) {
      int[] arr = new int[array.length-1];
      for (int j = 0, k = 0; j < array.length; j++) {
        if (array[j]!=num) {
          arr[k]=array[j];
          k++;
        }

      }
      result.add(num);
      if (getPartitionUtil(i - num, arr,result)) {
        return true;
      }
      //this line is making backtracking work
      result.remove((Integer) num);
    }
    return false;
  }
}
