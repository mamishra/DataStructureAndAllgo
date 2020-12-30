package com.mayur.DataStructureAndAlgo.BitMasking.Questions;

/**
 * Created by MAYUR on 12/27/20.
 */
public class RemoveLastSetBit {

  /**
   * Remove the last set bit from a given number
   */

  public static void main(String[] args) {
    int a = 15;
    System.out.println(Integer.toBinaryString(a));
    System.out.println(Integer.toBinaryString(removeLastBit(a)));
  }

  private static int removeLastBit(int a) {
    return a&(a-1);
  }
}
