package com.mayur.DataStructureAndAlgo.Random;

/**
 * Created by MAYUR on 2/4/21.
 */
public class Test {
  public static void main(String[] args) {

    /**
     * class interface trial
     */
    Klass klass = new Klass();
    klass.doWork();
    klass.doNothing();
    Inter.chilling();
    //class static method with same name as interface static method
    Klass.chilling();

    /**
     * parent child trial
     */
    Parent parent = new Parent();
    Child child = new Child();
    Parent cross = new Child();
    parent.pintName();
    child.pintName();
    cross.pintName();//prints child

    //static methods
    Parent.staticMethod();
    Child.staticMethod();

    MyAbstract myAbstract = new MyAbstract() {

    };
    myAbstract.doSomething();
    //myAbstract.doNothing();
  }


}

abstract class MyAbstract {
  private int num;

  public void doSomething() {
    System.out.println("doing something");
  }

  //public abstract void doNothing();

}
