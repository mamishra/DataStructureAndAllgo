package com.mayur.DataStructureAndAlgo.DataStructure.Graph.Questions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by MAYUR on 12/25/20.
 */
public class BFT {

  /**
   * Breadth First Traversal (or Search) for a graph is similar to Breadth First Traversal of a tree .
   * The only catch here is, unlike trees, graphs may contain cycles, so we may come to the same node again.
   * To avoid processing a node more than once, we use a boolean visited array.
   *
   */

  public static void main(String[] args) {
    Graph g = new Graph(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    System.out.println("Following is Breadth First Traversal "+
        "(starting from vertex 2)");

    g.breadthFirstTraversal(2);
  }

}

class Graph {
  private int V;
  private LinkedList[] adj;

  public Graph(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      adj[i] = new LinkedList<>();
    }
  }

  public void addEdge(int u, int v) {
    adj[u].add(v);
  }

  public void breadthFirstTraversal(int start) {

    if (start >= V)
      return;
    boolean[] visited = new boolean[V];
    Queue<Integer> queue = new LinkedList<>();
    visited[start] = true;
    queue.add(start);

    while (!queue.isEmpty()) {
      // Dequeue a vertex from queue and print it
      int s = queue.poll();
      System.out.print(s + " ");

      // Get all adjacent vertices of the dequeued vertex s
      // If a adjacent has not been visited, then mark it
      // visited and enqueue it
      Iterator<Integer> i = adj[s].listIterator();
      while (i.hasNext()) {
        int n = i.next();
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }
  }
}
