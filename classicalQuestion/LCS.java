package classicalQuestion;

public class LCS {
  // longest common subsequence
  // Brute force : O(2^(n+m))
  // Optimal using DP : O(mn)

  
  public int findLCSWithoutDP(char[] arr_m, char[] arr_n, int m_ptr, int n_ptr){
    // due to sub-problem is repeating
    // O(2^(n+m))
    if(m_ptr<0 || n_ptr<0){
      return 0;
    }

    int res = 0;
    if(arr_m[m_ptr]==arr_n[n_ptr]){
      res = 1 + this.findLCSWithoutDP(arr_m, arr_n, m_ptr-1, n_ptr-1);
    }else{
      res = Math.max(this.findLCSWithoutDP(arr_m, arr_n, m_ptr-1, n_ptr), this.findLCSWithoutDP(arr_m, arr_n, m_ptr, n_ptr-1));
    }
    return res;
  }

  public int findLCSByDP(String m, String n){
    Integer[][] dp = new Integer[m.length()][n.length()];
    return this.recur(m.toCharArray(), n.toCharArray(), m.length()-1, n.length()-1, dp);
  }

  public int recur(char[] arr_m, char[] arr_n, int m_ptr, int n_ptr, Integer[][] dp){
    // O(mn)
    if(m_ptr<0 || n_ptr<0){
      return 0;
    }else if(dp[m_ptr][n_ptr]!=null){
      return dp[m_ptr][n_ptr];
    }

    int res = 0;
    if(arr_m[m_ptr]==arr_n[n_ptr]){
      res = 1 + this.recur(arr_m, arr_n, m_ptr-1, n_ptr-1, dp);
    }else{
      res = Math.max(this.recur(arr_m, arr_n, m_ptr-1, n_ptr, dp), this.recur(arr_m, arr_n, m_ptr, n_ptr-1, dp));
    }
    dp[m_ptr][n_ptr] = res;
    return res;
  }

  public static void main(String[] args){
    LCS s = new LCS();
    String m = "npvwwtwtvml";
    String n = "mtutktznesa";
    //with DP
    long startTime = System.nanoTime();
    System.out.println(s.findLCSByDP(m, n));
    System.out.println(System.nanoTime() - startTime);
    startTime = System.nanoTime();
    System.out.println(s.findLCSWithoutDP(m.toCharArray(), n.toCharArray(), m.length()-1, n.length()-1));
    System.out.println(System.nanoTime() - startTime);
  }
}
