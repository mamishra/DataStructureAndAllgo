package com.mayur.DataStructureAndAlgo.BitMasking.Questions;

/**
 * Created by MAYUR on 12/27/20.
 */
public class MinimumBitSwitching {

  /**
   * We are asked to change number 'A' to 'B' by manipulating minimum number of bits
   */

  public static void main(String[] args) {
    int a = 5; //00000101
    int b = 15; //00001111

    System.out.println(getMinBitSwitch(a,b));
  }

  private static int getMinBitSwitch(int a, int b) {
    int res = a^b;
    //counting set bits here
    int count = 0;
    while (res>0) {
      count += (res&1);
      res = res>>1;
    }
    return count;
  }
}
