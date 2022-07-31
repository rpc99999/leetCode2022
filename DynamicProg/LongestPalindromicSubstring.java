public class LongestPalindromicSubstring {
/*
 * 
 * 
 * Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 */
  public static String longestPalindrome_Slow(String s) {//O(N2)
    if(s.length()==1){
      return s;
    }
    char[] c1 = s.toCharArray();
    char[] c2 = new char[s.length()];
    for(int i = 0 ; i < c1.length; i++){
      c2[c1.length-1-i] = c1[i];
    }

    int[][] dp = new int [c1.length+1][c2.length+1];
    int max = 0;
    int tmp1 = 0;
    for(int i = 0 ; i <= c1.length; i++){
      for(int j = 0 ; j <= c2.length; j++){
        if(i==0||j==0){
          dp[i][j] = 0;
          continue;
        }

        if(c1[i-1]==c2[j-1]){
          dp[i][j] = dp[i-1][j-1] + 1;
          if(max<dp[i][j] && i + j - dp[i][j] == c1.length){
            max = dp[i][j];
            tmp1 = i;
          }
        }else{
          dp[i][j] = 0;
        }
      }
    }

    return s.substring(tmp1-max, tmp1);
    
  }

  private int begin, maxLen;
  public String longestPalindrome_Fast(String s) {
      char[] str = s.toCharArray();
      int n = str.length;
      expandCenter(str, n >> 1, 0);
      return new String(str, begin, maxLen);
  }

  private void expandCenter(char[] str, int idx, int direction) { //  O(N), O(1) space
      int n = str.length, i = idx - 1, j = idx + 1;
      while (i >= 0 && str[i] == str[idx]) i--; // e.g (abcccef) => (ab'ccc'ef) => (ab'c'ef)
      while (j < n && str[j] == str[idx]) j++;
      int x = i, y = j;
      while (x >= 0 && y < n && str[x] == str[y]) {
          x--;
          y++;
      }
      if (y - x - 1 > maxLen) {
          begin = x + 1;
          maxLen = y - x - 1;
      }
      if (i + 1 << 1 > maxLen && direction <= 0) {
          expandCenter(str, i, -1);
      }
      if (n - j << 1 > maxLen && direction >= 0) {
          expandCenter(str, j, 1);
      }
  }
}
