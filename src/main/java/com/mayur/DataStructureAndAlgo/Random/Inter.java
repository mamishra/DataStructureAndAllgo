package com.mayur.DataStructureAndAlgo.Random;

/**
 * Created by MAYUR on 2/14/21.
 */
public interface Inter {

  //abstract method
  void doWork();

  //default method
  default void doNothing() {
    System.out.println("nothing");
  }

  //static method -> called from interface itself
  static void chilling() {
    System.out.println("chilling");
  }
}
