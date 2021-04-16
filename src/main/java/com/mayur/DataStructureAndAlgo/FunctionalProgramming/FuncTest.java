package com.mayur.DataStructureAndAlgo.FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by MAYUR on 2/17/21.
 */
public class FuncTest {

  public static void main(String[] args) {

    //Function takes integer and returns integer
    Function<Integer, Integer> add1 = x -> x + 1;

    //Function takes integer and returns integer
    Function<Integer, Integer> doubled = x -> x * 2;

    //Function takes 2 integer and returns integer
    BinaryOperator<Integer> multiply = (x, y) -> x * y;

    //Function takes integer and returns integer
    UnaryOperator<Integer> square = x -> x * x;

    //Function takes integer and returns Function, that further takes integer and returns integer
    Function<Integer, Function<Integer, Integer>> modulus = x -> y -> x % y;


    System.out.println(add1.apply(1));
    System.out.println(doubled.apply(1));
    System.out.println(multiply.apply(2,3));
    System.out.println(square.apply(3));
    System.out.println(modulus.apply(7).apply(3));

    //calling method that takes function and integer
    System.out.println(calculator(doubled,2));
    System.out.println(calculator(add1,2));
    System.out.println(calculator(x -> (int)Math.pow(x, 2), 2));

    List<Integer> integerList = new ArrayList<>();
    for (int i =1 ; i < 6; i++)
      integerList.add(i);
    List<Integer> newList = new ArrayList<>();
    integerList.stream().forEach(a -> newList.add(calculator(x -> x*2,a)));
    System.out.println(newList);

  }

  private static int calculator(Function<Integer, Integer> function, int num) {
    return function.apply(num);
  }



}
