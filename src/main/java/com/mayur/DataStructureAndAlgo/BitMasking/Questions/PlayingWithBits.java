package com.mayur.DataStructureAndAlgo.BitMasking.Questions;

/**
 * Created by MAYUR on 12/27/20.
 */
public class PlayingWithBits {

  /**
   * Count number of bits between two number A and B (both inclusive)
   *
   * A = 10 , B = 15
   *
   * 10 = 1010  - 2
   * 11 = 1011  - 3
   * 12 = 1100  - 2
   * 13 = 1101  - 3
   * 14 = 1110  - 3
   * 15 = 1111  - 4
   *
   * total     - 17
   */

  public static void main(String[] args) {
    int a = 10;
    int b = 15;
    System.out.println("Number of bits between " + a + " and " + b + " is : " + getTotalBits(a, b));
  }

  private static int getTotalBits(int a, int b) {
    int count = 0;
    for (int i = a; i <= b; i++) {
      count += getSetBits(i);
    }
    return count;
  }

  private static int getSetBits(int num) {
    int count = 0;
    while (num > 0) {
      count += num & 1;
      num = (num >> 1);
    }
    return count;
  }
}
