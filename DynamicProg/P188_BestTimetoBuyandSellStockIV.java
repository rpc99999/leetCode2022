public class P188_BestTimetoBuyandSellStockIV {
  public int maxProfit(int k, int[] prices) {
    
    int n = prices.length;
    if(k>=n/2){
      int res = 0;
      for(int i = 1; i < n; i++){
        res += Math.max(0, prices[i]-prices[i-1]);
      }
      return res;
    }
  
    int[][] dp = new int[k+1][prices.length];
    //dp[i][j] = Math.max(dp[i-1][j], prices[j]-prices[jj] + dp[i-1][jj]), 0<=jj<j
    //dp[i][j] = Math.max(dp[i-1][j], prices[j] + Math.max(dp[i-1][jj]-prices[jj]))
    for(int i = 1; i <= k ; i++){
      int tmp = dp[i-1][0] - prices[0];
      for(int j = 1; j < n; j++){
        dp[i][j] = Math.max(dp[i][j-1], prices[j] + tmp);
        tmp = Math.max(tmp, dp[i-1][j] - prices[j]);
      }
    }
    return dp[k][prices.length-1];
  }
}
