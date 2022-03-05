public class P695 {
  /*
   * 695. Max Area of Island
   * You are given an m x n binary matrix grid. An island is a group of 1's
   * (representing land) connected 4-directionally (horizontal or vertical.) You
   * may assume all four edges of the grid are surrounded by water.
   * 
   * The area of an island is the number of cells with a value 1 in the island.
   * 
   * Return the maximum area of an island in grid. If there is no island, return
   * 0.
   */

  public static int maxAreaOfIsland(int[][] grid) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++){
          for(int j = 0; j < grid[i].length; j++){
            if(!visited[i][j] && grid[i][j]!=0){
                maxArea = Math.max(maxArea, findArea(grid, visited, i, j));
            }
          }
        }
        return maxArea;
  }

  public static int findArea(int[][] grid, boolean[][] visited, int i, int j){
    if(!visited[i][j] && grid[i][j]!=0){
      visited[i][j]=true;
      int area = 1;
      if(i>0 && grid[i-1][j]!=0){
        area += findArea(grid, visited, i-1, j);
      }
      if(j>0 && grid[i][j-1]!=0){
        area += findArea(grid, visited, i, j-1);
      }
      if(i+1<grid.length && grid[i+1][j]!=0){
        area += findArea(grid, visited, i+1, j);
      }
      if(j+1<grid[i].length && grid[i][j+1]!=0){
        area += findArea(grid, visited, i, j+1);
      }
      return area;
    }
    return 0;
  }

  public static void main(String[] args){
    int[][] grid = new int[][]{{1,0,1},{1,0,1}};
    System.out.println(maxAreaOfIsland(grid));
  }
}
