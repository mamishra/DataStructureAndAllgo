package com.mayur.DataStructureAndAlgo.DataStructure.Array.Questions;

import java.util.Arrays;

/**
 * Created by MAYUR on 12/3/20.
 */
public class ArraySearch {

  /**
   * Another interesting array problem, because array doesn't provide any built-in method to check if any number exists or not.
   * This problem is essentially how to search an element in the array.
   * There are two options sequential search or binary search.
   * You should ask the interviewer about whether an array is sorted or not,
   * if the array is sorted then you can use binary search to check if given number is present in an array or not.
   * The complexity of binary search is O(logN). BTW,
   * if interviewer says that array is not sorted then you can still sort and perform binary search
   * otherwise you can use sequential search. Time complexity of sequential search in array is O(n).
   */

  public static void main(String[] args) {
    int[] array = {9,7,8,6,4,5,2,3,1};
    System.out.println(sequentialSearch(array, 10));
    System.out.println(binarySearch(array, 10));
  }

  // Binary search can be done on sorted array so sorting is done here
  //sorting time complexity is O(n.logn)
  //Binary search time complexity is O(logn)
  private static boolean binarySearch(int[] array, int num) {
    Arrays.sort(array);
    int mid = array.length / 2;
    if (array[mid] == num)
      return true;
    else if (array[mid] > num) {
      if (mid != 0) {
        return binarySearch(getSubArray(array, 0, mid), num);
      } else
        return false;
    } else {
      if (mid + 1 != array.length - 1) {
        return binarySearch(getSubArray(array, mid + 1, array.length - 1), num);
      } else
        return false;
    }
  }

  private static int[] getSubArray(int[] array, int start, int end) {
    return Arrays.copyOfRange(array,start,end);
  }

  //sequential search time complexity O(n)
  private static boolean sequentialSearch(int[] array, int number) {
    for (int num : array) {
      if (num==number)
        return true;
    }
    return false;
  }

}
