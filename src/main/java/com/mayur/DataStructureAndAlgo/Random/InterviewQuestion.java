package com.mayur.DataStructureAndAlgo.Random;

import java.util.Arrays;

/**
 * Created by MAYUR on 2/22/21.
 */
public class InterviewQuestion {

  public static void main(String[] args) {
    int[] ints = {7,8,9,0,5,4,3};
    Arrays.stream(findNumber(ints)).forEach(System.out::print);
  }

  private static int[] findNumber(int[] ints) {
    int i;
    for (i = ints.length-1; i > 0; i--) {
      if (ints[i]>ints[i-1])
        break;
    }
    if (i==0){
      Arrays.sort(ints);
      return ints;
    } else {
      int x = ints[i - 1], min = i;
      for (int j = i + 1; j < ints.length; j++)
      {
        if (ints[j] > x && ints[j] < ints[min])
        {
          min = j;
        }
      }
      swap(ints, i - 1, min);
      Arrays.sort(ints, i, ints.length);
    }
    return ints;
  }

  private static void swap(int[] ints, int i, int min) {
    int temp = ints[i];
    ints[i] = ints[min];
    ints[min] = temp;
  }
}
