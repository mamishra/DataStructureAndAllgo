package com.mayur.DataStructureAndAlgo.DataStructure.Graph.Questions;


import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by MAYUR on 12/25/20.
 */
public class DFT {

  public static void main(String[] args) {
    GrapH g = new GrapH(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    System.out.println("Following is Depth First Traversal "+
        "(starting from vertex 2)");

    g.depthFirstTraversal(2);
  }

}

class GrapH {

  private int V;
  private LinkedList[] adj;

  public GrapH(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      adj[i] = new LinkedList();
    }
  }

  public void addEdge(int u, int v) {
    adj[u].add(v);
  }

  public void depthFirstTraversal(int start) {
    if (start>=V)
      return;
    boolean[] visited = new boolean[V];
    DftUtil(start,visited);
  }

  private void DftUtil(int start, boolean[] visited) {
    visited[start] = true;
    System.out.print(start + " ");

    // Recur for all the vertices adjacent to this
    // vertex
    Iterator<Integer> i = adj[start].listIterator();
    while (i.hasNext()) {
      int n = i.next();
      if (!visited[n])
        DftUtil(n, visited);
    }
  }
}
