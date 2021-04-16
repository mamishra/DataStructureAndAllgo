package com.mayur.DataStructureAndAlgo.Random;

/**
 * Created by MAYUR on 2/15/21.
 */
public class Exam {

  public static void main(String[] args) {
    String a = "aaeiouxa";
    System.out.println(vowelsubstring(a));
  }

  public static int vowelsubstring(String s) {
    // Write your code here
    int result = 0;
    return vovelSubstringUtil(s, result);
  }

  private static int vovelSubstringUtil(String s, int result) {
    if(s.length()<5) {
      return result;
    }
    if(!s.contains("a") || !s.contains("e") || !s.contains("i") || !s.contains("o") |!s.contains("u")) {
      return result;
    }

    for(int i =0; i < s.length(); i++) {
      for(int  j = i+1; j < s.length(); j++) {
        System.out.println(s.substring(i, j));
        result += vovelSubstringUtil(s.substring(i, j), result+1);
      }
    }
    return result;
  }
}
