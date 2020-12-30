package com.mayur.DataStructureAndAlgo.BitMasking.Questions;

/**
 * Created by MAYUR on 12/27/20.
 */
public class MaximumXOR {

  /**
   * Given 2 numbers, find the maximum XOR value possible pairing any two numbers between them.
   */

  public static void main(String[] args) {
    int a = 10;
    int b = 15;
    int max = a^(a+1);
    for (int i = a; i <=b; i++) {
      for (int j = i+1; j <= b ; j++) {
        if (max<(i^(j)))
          max = (i^(j));
      }
    }
    System.out.println(max);
  }
}
