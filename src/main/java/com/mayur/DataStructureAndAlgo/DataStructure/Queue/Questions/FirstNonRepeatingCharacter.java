package com.mayur.DataStructureAndAlgo.DataStructure.Queue.Questions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by MAYUR on 11/9/20.
 */
public class FirstNonRepeatingCharacter {

  public static void main(String[] args) {
    String string = "abcabc";
    System.out.println(getFirstNonRepeatingCharacter(string));
  }

  private static String getFirstNonRepeatingCharacter(String string) {
    char[] chars = string.toCharArray();
    Queue<Character> queue = new LinkedList<>();
    int[] charFreq = new int[26];
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < chars.length; i++) {
      queue.add(chars[i]);
      charFreq[chars[i] - 'a']++;
      while (!queue.isEmpty()) {
        if (charFreq[queue.peek()-'a'] > 1) {
          queue.remove();
        } else {
          stringBuilder.append(queue.peek());
          break;
        }
      }
      if (queue.isEmpty())
        stringBuilder.append('#');
    }
    return stringBuilder.toString();
  }

}
