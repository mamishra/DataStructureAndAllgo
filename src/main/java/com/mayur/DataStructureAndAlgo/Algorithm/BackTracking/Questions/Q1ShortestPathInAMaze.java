package com.mayur.DataStructureAndAlgo.Algorithm.BackTracking.Questions;

/**
 * Created by MAYUR on 1/3/21.
 */
public class Q1ShortestPathInAMaze {

  /**
   * Given a maze find the shortest possible path in a maze from the given position to a final
   * position.
   */

  public static void main(String[] args) {
    int[][] maze =
        {
          {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
          {0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
          {0, 0, 1, 0, 1, 1, 1, 0, 0, 1},
          {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
          {0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
          {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
          {0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
          {0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
          {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
          {0, 0, 1, 0, 0, 1, 1, 0, 0, 1}
    };
    int fromX = 0;
    int fromY = 0;
    int toX = 9;
    int toY = 9;
    int result = getShortestPath(maze, fromX, fromY, toX, toY);
    System.out.println(result >= 10000 ? "no path present" : result);
  }

  private static int getShortestPath(int[][] maze,int fromX,int fromY,int toX, int toY) {

    int row = maze.length;
    int column = maze[0].length;
    boolean[][] visited = new boolean[row][column];
    return getShortestPathUtil(maze,fromX,fromY,toX,toY,row,column,visited);
  }

  private static int getShortestPathUtil(int[][] maze, int fromX, int fromY, int toX, int toY,
      int row, int column,boolean[][] visited) {

    // base conditions
    if (fromX < 0 || fromX >= row || fromY < 0 || fromY >= column || toX >= row || toX < 0
        || toY >= column || toY < 0 || maze[toX][toY] == 0 || visited[fromX][fromY])
      return 10000;
    if (fromX == toX && fromY == toY) {
      return 0;
    }

    if (maze[fromX][fromY] == 1) {

      visited[fromX][fromY] = true;

      int top = getShortestPathUtil(maze, fromX - 1, fromY, toX, toY, row, column, visited);
      int bottom = getShortestPathUtil(maze, fromX + 1, fromY, toX, toY, row, column, visited);
      int left = getShortestPathUtil(maze, fromX, fromY - 1, toX, toY, row, column, visited);
      int right = getShortestPathUtil(maze, fromX, fromY + 1, toX, toY, row, column, visited);

      //this step is making backtracking work
      visited[fromX][fromY] = false;

      return 1 + Math.min(Math.min(top, bottom), Math.min(left, right));
    }
    return 10000;
  }
}
