package com.mayur.DataStructureAndAlgo.DataStructure.Graph.Theory;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by MAYUR on 12/25/20.
 */
public class CustomGraph {

  public static void main(String[] args) {
    Graph g = new Graph();

    Node zero = new Node(0,"ZERO",0);
    Node one = new Node(1,"ONE",100);
    Node two = new Node(2,"TWO",200);
    Node three = new Node(3,"THREE",300);

    g.addEdge(zero, one);
    g.addEdge(zero, two);
    g.addEdge(one, two);
    g.addEdge(two, zero);
    g.addEdge(two, three);
    g.addEdge(three, three);

    System.out.println("Following is Breadth First Traversal "+
        "(starting from vertex 2)\n");

    g.breadthFirstTraversal(two);

    System.out.println("\nFollowing is Depth First Traversal "+
        "(starting from vertex 2)\n");

    g.depthFirstTraversal(two);
  }
}


class Graph {

  public Graph() {
    this.adj = new HashMap<>();
  }

  private Map<Node, LinkedList<Node>> adj;

  //adds vertex to graph but dont adds any edge
  public void addVertex(Node node) {
    LinkedList linkedList;
    if (adj.containsKey(node))
      linkedList = adj.get(node);
    else
      linkedList = new LinkedList();
    adj.put(node, linkedList);
  }

  //adds edge, if vertex is missing creates it and adds edge
  public void addEdge(Node from, Node to) {
    LinkedList linkedList;
    if (adj.containsKey(from)) {
      linkedList = adj.get(from);
      if (adj.containsKey(to)) {
        linkedList.add(to);
        adj.put(from, linkedList);
      } else {
        addVertex(to);
        addEdge(from, to);
      }
    } else {
      addVertex(from);
      addEdge(from, to);
    }
  }

  public void breadthFirstTraversal(Node start) {
    Map<Node, Boolean> visited = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();
    visited.put(start, true);
    queue.add(start);

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      System.out.println(node);

      Iterator<Node> iterator = adj.get(node).listIterator();
      while (iterator.hasNext()) {
        Node iter = iterator.next();
        if (visited.get(iter) == null || !visited.get(iter)) {
          visited.put(iter, true);
          queue.add(iter);
        }
      }
    }
  }

  public void depthFirstTraversal(Node start) {
    Map<Node, Boolean> visited = new HashMap<>();
    visited.put(start, true);
    DftUtil(start, visited);
  }

  private void DftUtil(Node start, Map<Node, Boolean> visited) {
    System.out.println(start);
    Iterator<Node> iterator = adj.get(start).listIterator();
    while (iterator.hasNext()) {
      Node iter = iterator.next();
      if (visited.get(iter) == null || !visited.get(iter) ) {
        visited.put(iter, true);
        DftUtil(iter, visited);
      }
    }

  }
}


class Node {
  private int id;
  private String description;
  private int cost;

  public Node(int id, String description, int cost) {
    this.id = id;
    this.description = description;
    this.cost = cost;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Node{");
    sb.append("id=").append(id);
    sb.append(", description='").append(description).append('\'');
    sb.append(", cost=").append(cost);
    sb.append('}');
    return sb.toString();
  }
}
