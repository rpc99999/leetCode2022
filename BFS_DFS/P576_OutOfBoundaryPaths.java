public class P576_OutOfBoundaryPaths {
  //https://leetcode.com/problems/out-of-boundary-paths/
  //solved by DFS + DP + Greedy
  public int findPaths(int m, int n, int maxMove, int startRow, int startColumn){
    int[][][] dp = new int[m][n][maxMove];  // no. of way to move to cell(m,n) in maxmove
    int mod = 1000000007;
    if(maxMove==0){
      return 0;
    }
  
    dp[startRow][startColumn][0] = 1; // no. of way to move from start cell in 0 move
  
    for(int k = 1; k <= maxMove-1; k++){
      for(int i = 0 ; i < m; i++){
        for(int j = 0 ; j < n; j++){
            dp[i][j][k] = 0;
            if(i>0){
              dp[i][j][k] = (dp[i][j][k] + dp[i-1][j][k-1]) % mod;
            }
            if(j>0){
              dp[i][j][k] = (dp[i][j][k] + dp[i][j-1][k-1]) % mod;
            }
            if(i<m-1){
              dp[i][j][k] = (dp[i][j][k] + dp[i+1][j][k-1]) % mod;
            }
            if(j<n-1){
              dp[i][j][k] = (dp[i][j][k] + dp[i][j+1][k-1]) % mod;
            }
        }
      }
    }
  
    int res = 0;
    for(int k = 0; k <= maxMove-1; k++){  //1 move is left for move outbound, so start from '0' to 'maxMove-1'
      for(int i = 0 ; i < m ; i++){
        for(int j = 0 ; j < n ; j++){
          if(i==0){
            res = (res + dp[i][j][k]) % mod;
          }
          if(j==0){
            res = (res + dp[i][j][k]) % mod;
          }
          if(i==m-1){
            res = (res + dp[i][j][k]) % mod;
          }
          if(j==n-1){
            res = (res + dp[i][j][k]) % mod;
          }
        }
      }
    }
    return res;
  }
  
    public static void main(String[] args){
      P576_OutOfBoundaryPaths s = new P576_OutOfBoundaryPaths();
      System.out.println(s.findPaths(1,3,3,0,1));
    }
}
