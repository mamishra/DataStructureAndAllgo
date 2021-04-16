package com.mayur.DataStructureAndAlgo.interview;

/**
 * Created by MAYUR on 3/3/21.
 */


/**
 * [1:19 PM] Partha Sarthi
 *
 * 10. Best Time to Buy and Sell Stock with Cooldown
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * • You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * • After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 * Input: [1,2,3,0,2]
 *
 * 1 : [1,2,-1,1]
 * 2 : [1,-2,0]
 * 3 : [-3,-1]
 * 0 : [-2]
 * 2 : []
 *
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */


import org.springframework.scheduling.support.SimpleTriggerContext;

import java.time.LocalTime;
import java.util.Stack;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * Note: The input string may contain letters other than the parentheses ( and ).
 * Example 1:
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 * Input: ")("
 * Output: [""]
 */

public class Interview1234 {


  public static void main(String[] args) {
    String input = "((((()))(((((())";
    String result = getValid(input);
    System.out.println(result);
    LocalTime localTime = LocalTime.now();
    System.out.println(localTime);
    LocalTime localTime1 = LocalTime.parse("17:16:22.660");
    System.out.println(localTime1);
  }

  private static String getValid(String input) {
    Stack<String> strings = new Stack<>();
    String result = "";
    for (int i = 0; i < input.length(); i++) {
      String element = input.substring(i,i+1);
      if (element.equals("(")) {
        strings.push("(");
      } else if(element.equals(")") && !strings.isEmpty()) {
        if (strings.peek().equals("(")) {
          result+="()";
          strings.pop();
        }
        else {
          while (strings.peek().equals("(")) {
            result+=strings.pop();
          }
          result+=strings.pop();
        }
      } else if (!element.equals(")"))
        strings.push(element);
    }
    return result;
  }


}
