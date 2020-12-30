package com.mayur.DataStructureAndAlgo.DataStructure.Graph.Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Created by MAYUR on 12/26/20.
 */
public class WeightedGraph {

  public static void main(String[] args) {

    Vertex zero = new Vertex("ZERO",0);
    Vertex one = new Vertex("ONE",1);
    Vertex two = new Vertex("TWO",2);
    Vertex three = new Vertex("THREE",3);
    Vertex four = new Vertex("FOUR",4);
    Vertex five = new Vertex("FIVE",5);

    Edge e1 = new Edge(one, three, 10);
    Edge e2 = new Edge(three, two, 20);
    Edge e3 = new Edge(two, five, 30);
    Edge e4 = new Edge(five, zero, 40);
    Edge e5 = new Edge(zero, four, 50);
    Edge e6 = new Edge(four, one, 60);

    GrrApH graph = new GrrApH();
    graph.addEdge(e1);
    graph.addEdge(e2);
    graph.addEdge(e3);
    graph.addEdge(e4);
    graph.addEdge(e5);
    graph.addEdge(e6);

    graph.BFT(one);
  }
}


class GrrApH {

  List<Edge> edgeList;

  public GrrApH() {
    this.edgeList = new ArrayList<>();
  }

  public void addEdge(Edge edge) {
    edgeList.add(edge);
    edge.getFrom().addConnection(edge.getTo());
    edge.getTo().addConnection(edge.getFrom());
  }

  public void BFT(Vertex start) {
    List<Edge> fromList = edgeList.stream().filter(edge -> {
      if (edge.getFrom().equals(start))
        return true;
      return false;
    }).collect(Collectors.toList());
    Edge startEdge = fromList.get(0);
    Queue<Vertex> queue = new LinkedList<>();
    Map<Vertex, Boolean> visited = new HashMap<>();
    queue.add(startEdge.getFrom());

    while (!queue.isEmpty()) {
      Vertex vertex = queue.poll();
      if (visited.get(vertex) == null || !visited.get(vertex)) {
        System.out.println(vertex + " ");
      }
      visited.put(vertex, true);
      List<Vertex> neighbours = vertex.getConnections();
      for (Vertex vtex : neighbours) {
        if (visited.get(vtex) == null || !visited.get(vtex)) {
          queue.add(vtex);
        }
      }
    }
  }
}


class Edge {
  private Vertex from;
  private Vertex to;
  private int weight;

  public Edge(Vertex from, Vertex to, int weight) {
    this.from = from;
    this.to = to;
    this.weight = weight;
  }

  public Vertex getFrom() {
    return from;
  }

  public void setFrom(Vertex from) {
    this.from = from;
  }

  public Vertex getTo() {
    return to;
  }

  public void setTo(Vertex to) {
    this.to = to;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Edge edge = (Edge) o;
    return weight == edge.weight && Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to, weight);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Edge.class.getSimpleName() + "[", "]").add("from=" + from)
        .add("to=" + to).add("weight=" + weight).toString();
  }
}


class Vertex {
  private String name;
  private int data;
  private List<Vertex> connections;

  public Vertex(String name, int data) {
    this.name = name;
    this.data = data;
    connections = new LinkedList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public List<Vertex> getConnections() {
    return connections;
  }

  public void addConnection(Vertex vertex) {
    connections.add(vertex);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Vertex.class.getSimpleName() + "[", "]")
        .add("name='" + name + "'").add("data=" + data).toString();
  }
}
