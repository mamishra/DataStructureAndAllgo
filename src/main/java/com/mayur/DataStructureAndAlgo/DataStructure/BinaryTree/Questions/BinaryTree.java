package com.mayur.DataStructureAndAlgo.DataStructure.BinaryTree.Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * Created by MAYUR on 12/13/20.
 */
public class BinaryTree {

  Node node;

  public BinaryTree(int data) {
    node = new Node(data);
  }

  //BFS
  public void printLevelOrder(Node root) {
    Queue queue = new LinkedList();
    if (root == null)
      return;
    if (root.left == null && root.right == null) {
      System.out.println(root.data);
      return;
    }
    Node temp;
    queue.add(root);
    while (!queue.isEmpty()) {
      temp = (Node) queue.peek();
      System.out.print(temp.data + " ");
      queue.remove();
      if (temp.left != null) {
        queue.add(temp.left);
      }
      if (temp.right != null) {
        queue.add(temp.right);
      }
    }
  }

  //DFS InOrder
  public void printInOrder(Node root) {
    if (root != null) {
      printInOrder(root.left);
      System.out.print(root.data + " ");
      printInOrder(root.right);
    }
  }

  //DFS PreOrder
  public void printPreOrder(Node root) {
    if (root != null) {
      System.out.print(root.data + " ");
      printPreOrder(root.left);
      printPreOrder(root.right);
    }
  }

  //DFS PostOrder
  public void printPostOrder(Node root) {
    if (root != null) {
      printPostOrder(root.left);
      printPostOrder(root.right);
      System.out.print(root.data + " ");
    }
  }

  //inserts a  node to the
  // 1st empty position in
  // level order traversal
  public void insertLevelOrder(Node temp, int data) {
    if (temp == null) {
      temp = new Node(data);
      return;
    }
    Queue queue = new LinkedList();
    queue.add(temp);
    while (!queue.isEmpty()) {
      temp = (Node) queue.peek();
      if (temp.left == null) {
        temp.left = new Node(data);
        break;
      } else
        queue.add(temp.left);
      if (temp.right == null) {
        temp.right = new Node(data);
        break;
      } else
        queue.add(temp.right);

      queue.remove();
    }
  }

  // deletes the element from the tree with given key
  // balances the tree by replacing with last node
  public void delete(Node root, int key) {
    if (root == null)
      return;
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    Node temp = null;
    while (!queue.isEmpty()) {
      temp = queue.remove();
      if (temp.left != null) {
        queue.add(temp.left);
      }
      if (temp.right != null) {
        queue.add(temp.right);
      }
    }
    assert temp != null;
    int endValue = temp.data;
    Node flag;
    queue.add(root);
    while (!queue.isEmpty()) {
      flag = queue.remove();
      if (flag.left != null && flag.left.data != temp.data) {
        queue.add(flag.left);
      } else {
        if (flag.left.data == temp.data) {
          flag.left = null;
          break;
        }
      }
      if (flag.right != null && flag.right.data != temp.data) {
        queue.add(flag.right);
      } else {
        if (flag.right.data == temp.data) {
          flag.right = null;
          break;
        }
      }
    }
    Node var;
    queue.add(root);
    while (!queue.isEmpty()) {
      var = queue.remove();
      if (var.left != null) {
        if (var.left.data != key) {
          queue.add(var.left);
        } else {
          var.left.data = endValue;
        }
      }
      if (var.right != null) {
        if (var.right.data != key) {
          queue.add(var.right);
        } else {
          var.right.data = endValue;
        }
      }
    }
  }

  public int getHeight(Node root) {
    if (root == null)
      return -1;
    else if (root.left == null && root.right == null)
      return 0;
    else {
      return Math.max(getHeight(root.left) + 1, getHeight(root.right) + 1);
    }
  }

  public int getMax(Node root) {
    int max = Integer.MIN_VALUE;
    if (root != null) {
      max = Math.max(Math.max(getMax(root.left), getMax(root.right)), root.data);
    }
    return max;
  }

  public int getMin(Node root) {
    int min = Integer.MAX_VALUE;
    if (root != null) {
      min = Math.min(Math.min(getMin(root.left), getMin(root.right)), root.data);
    }
    return min;
  }

  Vector<Node> getTrees(int[] arr, int start, int end) {

    // List to store all possible trees
    Vector<Node> trees= new Vector<Node>();

        /* if start > end then subtree will be empty so
         returning NULL in the list */
    if (start > end) {
      trees.add(null);
      return trees;
    }

        /* Iterating through all values from start to end
         for constructing left and right subtree
         recursively */
    for (int i = start; i <= end; i++) {
      /* Constructing left subtree */
      Vector<Node> ltrees = getTrees(arr, start, i - 1);

      /* Constructing right subtree */
      Vector<Node> rtrees = getTrees(arr, i + 1, end);

            /* Now looping through all left and right subtrees
             and connecting them to ith root below */
      for (int j = 0; j < ltrees.size(); j++) {
        for (int k = 0; k < rtrees.size(); k++) {

          // Making arr[i] as root
          Node node = new Node(arr[i]);

          // Connecting left subtree
          node.left = ltrees.get(j);

          // Connecting right subtree
          node.right = rtrees.get(k);

          // Adding this tree to list
          trees.add(node);
        }
      }
    }
    return trees;
  }
}

class Node {

  int data;
  Node left;
  Node right;

  public Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

class Driver{

  public static void main(String[] args) {
    BinaryTree root = new BinaryTree(1);
    root.node.left = new Node(2);
    root.node.right = new Node(3);
    root.node.left.left = new Node(4);
    root.node.left.right = new Node(5);
    root.node.right.left = new Node(6);
    root.node.right.right = new Node(7);

    /**
     *
     *          1
     *
     *      2      3
     *
     *    4   5  6   7
     *
     */
    System.out.println("Level Order : ");
    root.printLevelOrder(root.node);
    System.out.println("\nIn Order : ");
    root.printInOrder(root.node);
    System.out.println("\nPre Order : ");
    root.printPreOrder(root.node);
    System.out.println("\nPost Order : ");
    root.printPostOrder(root.node);
    root.insertLevelOrder(root.node,8);
    System.out.println("\nLevel Order : ");
    root.printLevelOrder(root.node);
    System.out.print("\nHeight : "+root.getHeight(root.node));
    root.delete(root.node,4);
    System.out.println("\nLevel Order : ");
    root.printLevelOrder(root.node);
    System.out.println("\nHeight : "+root.getHeight(root.node));
    System.out.println(root.getMax(root.node));
    System.out.println(root.getMin(root.node));

    Vector<Node> trees = root.getTrees(new int[] {2,1,3},0,2);
    for (int i = 0; i < trees.size(); i++) {
      root.printPreOrder(trees.get(i));
      System.out.println("");
    }
  }
}
