package com.mayur.DataStructureAndAlgo.BitMasking.Questions;

/**
 * Created by MAYUR on 12/27/20.
 */
public class Swapping {

  /**
   * Swapping 2 numbers using bitwise operator
   */

  public static void main(String[] args) {
    int a = 15;
    int b = 17;

    System.out.println("a = "+a+" b = "+b);

    a = a^b;
    b = a^b;
    a = a^b;

    System.out.println("a = "+a+" b = "+b);
  }
}
