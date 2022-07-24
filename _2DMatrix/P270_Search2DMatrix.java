package _2DMatrix;

public class P270_Search2DMatrix {
  public static boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    int i = m-1;
    int j = 0;
    // we must begin from bottom-left 
    // if target > matrix[i][j+1], we move upper row (matrix[i][j])
    while(i>=0 && j<n){
      if(matrix[i][j]==target) return true;
      if(j==0){
          if (i>0 && target<matrix[i][j]){
            i--;
          }else{
            j++;
          }
      }else{
        if (j+1<n && matrix[i][j+1]>target){
          i--;
        }else{
          if(matrix[i][j]>target){
            i--;
          }else{
            j++;
          }
        }
      }
    }
    return false;
}
public static void main(String[] args){
    int[][] arr = new int[][]{{1,4},{2,5}};
    int target = 4;
    searchMatrix(arr, target);
}
}
