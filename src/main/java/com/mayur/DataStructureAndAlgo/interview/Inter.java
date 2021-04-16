package com.mayur.DataStructureAndAlgo.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by MAYUR on 2/19/21.
 */
public class Inter {

  /**
   * create student class -> immutable
   *
   * fields : name : string
   *          age : int
   *          marks : ArrayList<Integer>
   */
  public static void main(String[] args) {
    List<Integer> marks = new ArrayList<>();
    marks.add(99);
    marks.add(87);
    marks.add(80);
    marks.add(81);
    marks.add(82);

    Student student = new Student("ABC",15, marks);
    Student student1 = new Student("DEF",25, marks);
    Student student2 = new Student("GHI",29, marks);
    Student student4 = new Student("DEF",30, marks);
    Student student5 = new Student("ABC",20, marks);
    Student student6 = new Student("GHI",28, marks);

    List<Student> studentList = new ArrayList<>();
    studentList.add(student);
    studentList.add(student1);
    studentList.add(student2);
    studentList.add(student4);
    studentList.add(student5);
    studentList.add(student6);

    System.out.println("natural");
    studentList.forEach(System.out::println);
    studentList.sort(Comparator.comparing(Student::getName).reversed().thenComparing(Student::getAge));
    System.out.println("sorted");

    studentList.forEach(System.out::println);

//
//    System.out.println(student.toString());
//    student.getMarks().add(79);
//    System.out.println(student.toString());

  }
}

final class Student {
  private final String name;
  private final int age;
  private final List<Integer> marks;

  public Student(String name, int age, List<Integer> marks) {
    this.name = name;
    this.age = age;
    List<Integer> marksMain = new ArrayList<>();
    for (Integer val : marks) {
      marksMain.add(val);
    }
    this.marks = marksMain;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public List<Integer> getMarks() {
    List<Integer> copy = new ArrayList<>();
    for (Integer val : this.marks) {
      copy.add(val);
    }
    return copy;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
        .add("name='" + name + "'").add("age=" + age).add("marks=" + marks).toString();
  }
}
