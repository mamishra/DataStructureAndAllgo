package com.mayur.DataStructureAndAlgo.BitMasking.Questions;

/**
 * Created by MAYUR on 12/27/20.
 */
public class ExtractIthBit {

  /**
   * Extract ith bit of a given number
   */

  public static void main(String[] args) {
    int a = 23;
    int i = 4;
    System.out.println("Binary of "+a+" is "+Integer.toBinaryString(a));
    System.out.println(i+"th Bit of "+a+" is "+getithBit(a,i));
  }

  private static int getithBit(int a, int i) {
    a = (a>>i);
    return a&1;
  }
}
