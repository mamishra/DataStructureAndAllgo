package com.mayur.DataStructureAndAlgo.Algorithm.DynamicProgramming.Questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MAYUR on 12/30/20.
 */
public class Q1Fibonacci {
  /**
   * provided with 'n' return the nth Fibonacci number in the sequence
   */

  public static void main(String[] args) {
    long num = 50;
    System.out.println(fibDP(num));
    System.out.println(fibRecursion(num));
    System.out.println(fibTabulation(num));
  }


  /**
   *
   *  Function call stack
   *                              fib(5)
   *                          |             |
   *                          |             |
   *                        fib(4)         fib(3)
   *                      |       |       |      |
   *                      |       |       |      |
   *                    fib(3)  fib(2)  fib(2)  fib(1)
   *                   |     |
   *                   |     |
   *                 fib(2) fib(1)
   *
   *              Base conditions return 1
   *
   *              Time complexity : O(2^n)  since height is n, and no of nodes at a level is 2
   *              Auxilary Space  : O(n)  since at any point of time function stack will have at max n values
   */
  private static long fibRecursion(long num) {
    if (num <= 2) return 1; // base condition
    return fibRecursion(num-1) + fibRecursion(num-2); // recursive call
  }


  /**
   *
   *  Function call stack
   *                              fib(5)
   *                          |             |
   *                          |             |
   *                        fib(4)         fib(3)---value from memo
   *                      |       |
   *                      |       |
   *                    fib(3)  fib(2)
   *                   |     |
   *                   |     |
   *                 fib(2) fib(1)
   *
   *              Base conditions return 1
   *
   *              Time complexity : O(2n) = O(n^2)  2 nodes for each n counts
   *              Auxilary Space  : O(n)  since at any point of time function stack will have at max n values
   */
  private static Long fibDP(long num) {
    Map<Long, Long> memo = new HashMap<>();
    return fibDPUtil(num,memo);
  }

  private static Long fibDPUtil(long num, Map<Long, Long> memo) {
    if (memo.containsKey(num)) return memo.get(num); // check in memo
    if (num <= 2) return 1L; // base case
    memo.put(num, fibDPUtil(num-1,memo) + fibDPUtil(num-2,memo)); // recursive call and memoization
    return memo.get(num);
  }


  /**
   *
   * Time complexity : O(n)
   * Space Complexity : O(n)
   *
   */
  private static long fibTabulation(long num) {
    long[] array = new long[(int) (num+1)];
    array[1] = 1;
    for (int i = 0; i <= num; i++) {
      if (i+1<=num) {
        array[i+1] += array[i];
      }
      if (i+2<=num) {
        array[i+2] += array[i];
      }
    }
    return array[(int) num];
  }
}
