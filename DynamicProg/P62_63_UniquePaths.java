import java.util.Date;

public class P62_63_UniquePaths {
  public static int uniquePaths(int m, int n) {
      if(m==1 && n==1){
        return 1;
      }

      int[][] dp = new int[m+1][n+1];
      for(int i = 1; i<=m; i++){
        for(int j = 1; j <= n ; j++){
          if(i==1 && j==1){
            dp[i][j] = 1;
          }

          if(i>1){
            dp[i][j] += dp[i-1][j];
          }
          if(j>1){
            dp[i][j] += dp[i][j-1];
          }
        }
      }

      return dp[m][n];
  }

  public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
      int m = obstacleGrid.length;
      int n = obstacleGrid[0].length;

      if(obstacleGrid[m-1][n-1]==1){
        return 0;
      }

      if(m==1 && n==1){
        return 1;
      }

      int[][] dp = new int[m+1][n+1];
      for(int i = 1 ; i <= m ; i++){
        for(int j = 1; j <= n ; j++){
          if(i==1 && j==1){
            dp[i][j] = 1;
          }

          if(i>1){
            if(obstacleGrid[i-2][j-1]!=1){
              dp[i][j] += dp[i-1][j];
            }
          }
          if(j>1){
            if(obstacleGrid[i-1][j-2]!=1){
              dp[i][j] += dp[i][j-1];
            }
          }
        }
      }

      return dp[m][n];
  }

  public static int uniquePathsIII(int[][] grid) {
      int start_xpos=0, end_xpos=0;
      int start_ypos=0, end_ypos=0;
      for(int i = 0 ; i < grid.length ; i++){
        for(int j = 0 ; j < grid.length; j++){
          if(grid[i][j]==1){
            start_xpos = i;
            start_ypos = j;
          }
          if(grid[i][j]==2){
            end_xpos = i;
            end_ypos = j;
          }
        }
      }

      if(start_xpos>end_xpos || start_ypos > end_ypos){
        return 0;
      }else if(start_xpos==end_xpos && start_ypos == end_ypos){
        return 1;
      }

      int m = (end_xpos-start_xpos)+1;
      int n = (end_ypos-start_ypos)+1;

      int[][] dp = new int[m][n];
      dp[m-1][n-1] = 1;
      for(int i = 0 ; i <= m-1; i++){
        for(int j = 0 ; j <= n-1; j++){
          if(i>0){
            if(grid[end_xpos-i+1][end_ypos-j]!=-1){
              dp[m-1-i][n-1-j] += dp[m-1-i+1][n-1-j];
            }
          }

          if(j>0){
            if(grid[end_xpos-i][end_ypos-j+1]!=-1){
              dp[m-1-i][n-1-j] += dp[m-1-i][n-1-j+1];
            }
          }
        }
      }

      return dp[0][0];
  }

  public static void main(String[] args) throws InterruptedException{
    Date date1 = new Date();
    Thread.sleep(1000);
    Date date2 = new Date();
    System.out.println(date2.getTime() - date1.getTime());
  }
}
