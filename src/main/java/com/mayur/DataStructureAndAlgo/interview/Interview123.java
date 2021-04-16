package com.mayur.DataStructureAndAlgo.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by MAYUR on 3/1/21.
 */
public class Interview123 {

  public static void main(String[] args) {
    int[] arr = {4,4,4,4,2,1,1,3,3};
    printSorted(arr);
  }

  private static void printSorted(int[] arr) {

    Arrays.sort(arr);
    List<DataPair> dataPairs = new ArrayList<>();
    dataPairs.add(new DataPair(arr[0],1));
    int k = 0;
    for (int i = 0; i +1 < arr.length; i++) {
      if (arr[i]==arr[i+1]) {

        int fre = dataPairs.get(k).getFrequency();
        dataPairs.get(k).setFrequency(fre+1);
      } else {
        DataPair dataPair = new DataPair(arr[i+1],1);
        dataPairs.add(dataPair);
        k++;
      }
    }
    //nlog(n)
    dataPairs.sort(Comparator.comparing(DataPair::getFrequency).thenComparing(DataPair::getNum));



    // j keys k = j*k = n
    for (int i = dataPairs.size() - 1; i >= 0; i--) {
      for (int j = 0; j < dataPairs.get(i).getFrequency(); j++) {
        System.out.println(dataPairs.get(i).getNum());
      }
    }
  }
}

class DataPair {
  private int num;
  private int frequency;

  public DataPair(int num, int frequency) {
    this.num = num;
    this.frequency = frequency;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public int getFrequency() {
    return frequency;
  }

  public void setFrequency(int frequency) {
    this.frequency = frequency;
  }
}

