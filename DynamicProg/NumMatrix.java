public class NumMatrix {

  int[][] dp ;

  // Good but take space O(m*n)
  // public NumMatrix(int[][] matrix) {
  //       dp = new int[matrix.length][matrix[0].length];
  //       for(int i = 0; i < matrix.length; i++){
  //         for(int j = 0; j < matrix[i].length; j++){
  //           if(i==0 && j==0){
  //             dp[i][j] = matrix[i][j];
  //           }else{
  //             if(j==0){
  //               dp[i][j] = dp[i-1][j] + matrix[i][j];
  //             }
  //             else if(i==0){
  //               dp[i][j] = dp[i][j-1] + matrix[i][j];
  //             }else{
  //               dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i][j];
  //             }
  //           }
  //         }
  //       }
  // }

  // reduce space from O(m*n) to O(1)
  public NumMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
          for(int j = 0; j < matrix[i].length; j++){
            if(i==0 && j==0){
              continue;
            }else{
              if(j==0){
                matrix[i][j] = matrix[i-1][j] + matrix[i][j];
              }
              else if(i==0){
                matrix[i][j] = matrix[i][j-1] + matrix[i][j];
              }else{
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1] - matrix[i-1][j-1] + matrix[i][j];
              }
            }
          }
        }
        dp = matrix;
  }
  
  public int sumRegion(int row1, int col1, int row2, int col2) {
      int result = dp[row2][col2];
      if(row1==0 && col1==0){
        return result;
      }
      
      if(row1==0){
        result = result - dp[row2][col1-1];
      }else if(col1==0){
        result = result - dp[row1-1][col2];
      }else{
        result = result - dp[row1-1][col2] - dp[row2][col1-1] + dp[row1-1][col1-1];
      }
      return result;
  }

  public static void main(String[] args){
    int[][] matrix = new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
    NumMatrix f = new NumMatrix(matrix);
    f.sumRegion(2,1,4,3);
  }
}
