package com.mayur.DataStructureAndAlgo.DataStructure.Graph.Questions;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by MAYUR on 12/26/20.
 */
public class DetectCycle {

  public static void main(String[] args) {
    GrApH g = new GrApH(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 3);
    //    g.addEdge(2, 0);
    //    g.addEdge(2, 3);
    //    g.addEdge(3, 3);


    if (g.isCyclic()) {
      System.out.println("its cyclic !!!!");
    } else
      System.out.println("not cyclic !!!");
  }
}


class GrApH {
  private int V;
  private LinkedList[] adj;

  public GrApH(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      adj[i] = new LinkedList();
    }
  }

  public void addEdge(int u, int v) {
    adj[u].add(v);
  }

  public boolean isCyclic() {

    boolean[] visited = new boolean[V];
    boolean[] reStack = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (isCyclicUtil(i, visited, reStack))
        return true;
    }
    return false;
  }

  private boolean isCyclicUtil(int i, boolean[] visited, boolean[] reStack) {

    if (reStack[i])
      return true;

    if (visited[i])
      return false;

    visited[i] = true;
    reStack[i] = true;

    Iterator<Integer> list = adj[i].listIterator();
    while (list.hasNext()) {
      int val = list.next();
      if (isCyclicUtil(val, visited, reStack))
        return true;
    }
    reStack[i] = false;
    return false;
  }
}
