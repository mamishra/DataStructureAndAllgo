package com.mayur.DataStructureAndAlgo.DataStructure.Array.Questions;

import java.util.BitSet;
import java.util.stream.Stream;

/**
 * Created by MAYUR on 12/2/20.
 */
public class FindMissingNumber {

  /**
   * This is one of the most simple array problems you will see,
   * mostly asked in a telephonic round of Interview.
   * You have given an integer array which contains numbers from 1 to 100
   * but one number is missing, you need to write a Java program to find
   * that missing number in an array.
   * You cannot use any open source library or Java API method which solves this problem.
   * One trick to solve this problem is to calculate sum of all numbers in the array
   * and compare with expected sum, the difference would be the missing number.
   *
   **/

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 8};
    System.out.println(findSingleMissingNumber(array, 8));
    int[] array2 = {1,2,4,5,7,8,10};
    findMultiMissingNumber(array2,10);
  }

  private static void findMultiMissingNumber(int[] array, int size) {
    BitSet bitSet = new BitSet(size);
    for (int val : array) {
      bitSet.set(val-1);
    }
    int lastMissing = 0;
    for (int i = 0; i < size-array.length; i++) {
      lastMissing = bitSet.nextClearBit(lastMissing)+1;
      System.out.println(lastMissing);
    }
  }

  private static int findSingleMissingNumber(int[] array, int size) {
    int expectedSum = size * (size + 1) / 2;
    int sum = 0;
    for (int val : array) {
      sum += val;
    }
    int actualSum = sum;
    return expectedSum - actualSum;
  }

}
