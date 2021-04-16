package com.mayur.DataStructureAndAlgo.Random;

import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by MAYUR on 2/15/21.
 */
public class Testing {

//  public static void main(String[] args) {
//
//    String binString = "1010111000";
//    List<String> goodStrings = new ArrayList<>();
//    for (int i = 0; i < binString.length(); i++) {
//      for (int j = 0; j < binString.length(); j++) {
//        if (i<j+1) {
//          String subString = binString.substring(i,j+1);
//          //System.out.println(subString);
//          if (isGoodString(subString))
//            goodStrings.add(subString);
//        }
//      }
//
//    }
//    System.out.println("####");
//    Collections.sort(goodStrings, (o1, o2) -> {
//      String a = o1 + o2;
//      String b = o2 + o1;
//      return a.compareTo(b) > 0 ? -1 : 1;
//    });
//    System.out.println(goodStrings.stream().reduce((a, b) -> a + b).get());
//  }
//
//  private static boolean isGoodString(String subString) {
//    if (!equalCounts(subString))
//      return false;
//
//      for (int j = 1; j <= subString.length(); j++) {
//        if (unequalCount(subString.substring(0,j)))
//          return false;
//      }
//
//    return true;
//  }
//
//  private static boolean unequalCount(String subString) {
//    char[] chars = subString.toCharArray();
//    int zeros = 0;
//    int ones = 0;
//    for (int i = 0; i < chars.length; i++) {
//      if (chars[i]=='0') {
//        zeros++;
//      } else if (chars[i]=='1')
//        ones++;
//    }
//    return zeros>ones;
//  }
//
//  private static boolean equalCounts(String subString) {
//    char[] chars = subString.toCharArray();
//    int zeros = 0;
//    int ones = 0;
//    for (int i = 0; i < chars.length; i++) {
//      if (chars[i]=='0') {
//        zeros++;
//      } else if (chars[i]=='1')
//        ones++;
//    }
//    return zeros==ones;
//  }


  public static void main(String[] args) {
    String str = "1010111000";
    sum(10);
    System.out.println(makeLargestSpecial(str));


  }

  static void sum(long i) {
    System.out.println("long");
  }

  static void sum(float i) {
    System.out.println("float");
  }
  public static String makeLargestSpecial(String S) {
    int count = 0, i = 0;
    List<String> res = new ArrayList<String>();
    for (int j = 0; j < S.length(); ++j) {
      if (S.charAt(j) == '1') count++;
      else count--;
      if (count == 0) {
        res.add('1' + makeLargestSpecial(S.substring(i + 1, j)) + '0');
        i = j + 1;
      }
    }
    Collections.sort(res, Collections.reverseOrder());
    return String.join("", res);
  }
}
