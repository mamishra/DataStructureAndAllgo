package com.mayur.DataStructureAndAlgo.BitMasking.Questions;

/**
 * Created by MAYUR on 12/27/20.
 */
public class CountSetBits {

  /**
   * We are asked to count the number of set bits in a given number.
   *
   * 5 = 00000101 => no of set bits = 2
   */

  public static void main(String[] args) {
    System.out.println(getNoOfSetBits(5));
  }

  private static int getNoOfSetBits(int num) {
    int count = 0;
    while (num > 0) {
      count += (num & 1);
      num = (num >> 1);
    }
    return count;
  }
}
