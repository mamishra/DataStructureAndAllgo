package com.mayur.DataStructureAndAlgo.Strings.Questions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by MAYUR on 12/18/20.
 */
public class MaximumOccurrenceCharacter {
  /**
   * Find maximum occurrence character in the given string
   */

  public static void main(String[] args) {
    String string = "aaabbbbcccccc";
    System.out.println(getMaximumOccurrenceCharacter(string));
  }

  private static char getMaximumOccurrenceCharacter(String string) {
    Map<Character,Integer> charFrequency = new HashMap<>();
    char[] chars = string.toCharArray();
    for (char aChar : chars) {
      if (charFrequency.containsKey(aChar)) {
        int val = charFrequency.get(aChar);
        charFrequency.put(aChar, val + 1);
      } else {
        charFrequency.put(aChar, 1);
      }
    }
    final AtomicInteger max = new AtomicInteger();
    charFrequency.entrySet().forEach(characterIntegerEntry -> {
      if (max.get() <characterIntegerEntry.getValue())
        max.set(characterIntegerEntry.getValue());
    });
    AtomicReference<Character> characterr = new AtomicReference<>();
    charFrequency.forEach((character,integer)->{
      if (integer==max.get())
        characterr.set(character);
    });
    return characterr.get();
  }
}
