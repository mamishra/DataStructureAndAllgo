package com.mayur.DataStructureAndAlgo.BitMasking.Questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAYUR on 12/27/20.
 */
public class TwoUniqueInSequence {

  /**
   * Given a sequence of numbers every number occurs twice except two numbers.
   * Find those two numbers.
   */

  public static void main(String[] args) {
    int[] sequence = {1,1,2,3};
    printTwoUnique(sequence);
  }

  private static void printTwoUnique(int[] sequence) {
    int allXOR = sequence[0];
    for (int i = 1; i < sequence.length; i++) {
      allXOR ^= sequence[i];
    }
    int oddXOR = getOddSequence(sequence);
    int evenXOR = oddXOR^allXOR;

    System.out.println("Two non repeating numbers are : "+oddXOR+" and "+evenXOR);
  }

  private static int getOddSequence(int[] sequence) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < sequence.length; i++) {
      if ((sequence[i]&1) == 1)
        list.add(sequence[i]);
    }
    int oddXOR = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      oddXOR ^= list.get(i);
    }
    return oddXOR;
  }
}
