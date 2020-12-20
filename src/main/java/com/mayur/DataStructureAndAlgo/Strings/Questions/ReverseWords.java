package com.mayur.DataStructureAndAlgo.Strings.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by MAYUR on 12/18/20.
 */
public class ReverseWords {

  /**
   * Reverse words in a given sentence
   */

  public static void main(String[] args) {
    String string = "my name is mayur";
    System.out.println(reverseWordsSentence(string));
  }

  private static String reverseWordsSentence(String string) {
    List<String> stringList = Stream.of(string.split(" ")).collect(Collectors.toList());
    List<String> resultList = new ArrayList<>();
    for (String strng : stringList) {
      resultList.add(revrese(strng));
    }
    return resultList.stream().reduce((a, b) -> a + " " + b).get();
  }

  private static String revrese(String string) {
    StringBuilder stringBuilder = new StringBuilder();
    char[] chars = string.toCharArray();
    for (int i = chars.length - 1; i >= 0; i--) {
      stringBuilder.append(chars[i]);
    }
    return stringBuilder.toString();
    
  }
}
