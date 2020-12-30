package com.mayur.DataStructureAndAlgo.BitMasking.Questions;

/**
 * Created by MAYUR on 12/27/20.
 */
public class EvenOdd {

  /**
   * Every odd number contains a 1 at the end.
   * Every even number contains a 0 at the end.
   *
   * odd number & 1 = 1
   * even number & 1 = 0
   */

  public static void main(String[] args) {
    int a = 3;
    System.out.println(getEvenOdd(a));
  }

  private static String getEvenOdd(int i) {
    return (i & 1) == 1 ? "Odd" : "Even";
  }
}
