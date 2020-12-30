package com.mayur.DataStructureAndAlgo.DataStructure.Graph.Questions;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by MAYUR on 12/26/20.
 */
public class DetectCycleNonDirectional {

  public static void main(String[] args) {
    Graphh g = new Graphh(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    System.out.println(g.isCyclic() ? "Cyclic hai !!!" : "Cyclic nai h !!");
  }
}

//Non Directional Graph
class Graphh {
  private int V;
  private LinkedList<Integer>[] adj;

  public Graphh(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      adj[i] = new LinkedList<>();
    }
  }

  public void addEdge(int u, int v) {
    adj[u].add(v);
    adj[v].add(u);
  }

  public boolean isCyclic() {

    boolean visited[] = new boolean[V];
    for (int i = 0; i < V; i++)
      visited[i] = false;

    // Call the recursive helper
    // function to detect cycle in
    // different DFS trees
    for (int u = 0; u < V; u++)
    {

      // Don't recur for u if already visited
      if (!visited[u])
        if (isCyclicUtil(u, visited, -1))
          return true;
    }
    return false;
  }

  private boolean isCyclicUtil(int i, boolean[] visited, int parent) {
    visited[i] = true;
    Iterator<Integer> iterator = adj[i].listIterator();
    Integer j;
    while (iterator.hasNext()) {
      j = iterator.next();
      if (!visited[j]) {//not visited then recursive
        if (isCyclicUtil(j, visited, i))
          return true;
      } else if (j != parent)//if visited and from different path apart from parent
        return true;
    }
    return false;
  }
}
