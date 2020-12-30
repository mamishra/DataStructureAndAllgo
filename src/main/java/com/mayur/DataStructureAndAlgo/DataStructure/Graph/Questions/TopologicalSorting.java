package com.mayur.DataStructureAndAlgo.DataStructure.Graph.Questions;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by MAYUR on 12/26/20.
 */
public class TopologicalSorting {

  /**
   * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that
   * for every directed edge u v, vertex u comes before v in the ordering. Topological Sorting for a
   * graph is not possible if the graph is not a DAG.
   */

  public static void main(String[] args) {

    GraPh g = new GraPh(6);

    g.addEdge(5, 2);
    g.addEdge(5, 0);
    g.addEdge(4, 0);
    g.addEdge(4, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 1);

    g.topologicalSorting();
  }
}


class GraPh {
  private int V;
  private LinkedList[] adj;

  public GraPh(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      adj[i] = new LinkedList();
    }
  }

  public void addEdge(int u, int v) {
    adj[u].add(v);
  }

  public void topologicalSorting() {
    boolean[] visited = new boolean[V];

    Stack<Integer> traversal = new Stack<>();
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        topoUtil(i, visited, traversal);
      }
    }
    while (!traversal.isEmpty()) {
      System.out.print(traversal.pop() + " ");
    }
  }

  private void topoUtil(int i, boolean[] visited, Stack<Integer> traversal) {
    LinkedList<Integer> linkedList = adj[i];
    visited[i] = true;
    for (Integer val : linkedList) {
      if (!visited[val]) {
        topoUtil(val, visited, traversal);
      }
    }
    traversal.push(i);
  }
}
