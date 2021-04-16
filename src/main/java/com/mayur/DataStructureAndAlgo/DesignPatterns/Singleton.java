package com.mayur.DataStructureAndAlgo.DesignPatterns;

/**
 * Created by MAYUR on 2/22/21.
 */
public class Singleton {

  MySingleton obj1 = MySingleton.getInstance();
  MySingleton obj2 = MySingleton.getInstance();

  MySingletonLazy obj11 = MySingletonLazy.getInstance();
  MySingletonLazy obj22 = MySingletonLazy.getInstance();

}

class MySingleton {

  //create static object inside class
  static MySingleton obj = new MySingleton(); //Eager instantiation, even if I dont need it, its loaded in memory

  //make default constructor private
  private MySingleton() {

  }

  //create static getInstance method to return instance
  public static MySingleton getInstance() {
    return obj;
  }
}

class MySingletonLazy {

  //create static object inside class
  static MySingletonLazy obj;

  //make default constructor private
  private MySingletonLazy() {

  }

  //create static getInstance method to return instance
  public static synchronized MySingletonLazy getInstance() {//making synchronized to avoid multiple threads making diff objects
    if (obj==null){
      obj = new MySingletonLazy();//Lazy instantiation
    }
    return obj;
  }
}
