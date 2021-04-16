package com.mayur.DataStructureAndAlgo.Random;

import java.util.Objects;

/**
 * Created by MAYUR on 2/21/21.
 */
public class NewTest {
  public static void main(String[] args) {
    Person p1 = new Person(22,"Mohit");
    Person p2 = new Person(22,null);

    System.out.println(p1==p2);
    System.out.println(p1.equals(p2));
    System.out.println("p1 : "+p1.hashCode()+"\np2 : "+p2.hashCode());
  }

}

class Person {
  private int age;
  private String name;

  public Person(int age, String name) {
    this.age = age;
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Person person = (Person) o;
    return age == person.age && Objects.equals(name, person.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(age, name);
  }
}


