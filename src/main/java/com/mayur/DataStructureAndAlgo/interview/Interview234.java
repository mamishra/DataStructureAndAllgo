package com.mayur.DataStructureAndAlgo.interview;

/**
 * Created by MAYUR on 3/1/21.
 */
public class Interview234 {

  public static void main(String[] args) {
    int[] arr = {-1,-2,-3,-4};
    System.out.println(getMaxSubArraySum(arr));
  }

  private static int getMaxSubArraySum(int[] arr) {
    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i <= arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        int sum = Integer.MIN_VALUE;
        if (i<=j) {
          sum = getArraySum(arr,i,j);
        }
        if (maxSum<sum)
          maxSum=sum;
      }
    }
    return maxSum;
  }

  private static int getArraySum(int[] arr, int i, int j) {
    int sum = 0;
    for (int k = i; k <= j; k++) {
      sum+=arr[k];
    }
    return sum;
  }
}
