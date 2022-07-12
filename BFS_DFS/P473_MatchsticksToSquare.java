import java.util.Arrays;

public class P473_MatchsticksToSquare {
  // For description of problem , plz refer to https://leetcode.com/problems/matchsticks-to-square/
  public boolean makesquare(int[] matchsticks) {
    Arrays.sort(matchsticks);   
    int sum = 0;
    for(int i = 0 ; i < matchsticks.length/2; i++){ // reverse the array to descending order
      int t = matchsticks[i];
      matchsticks[i] = matchsticks[matchsticks.length-1-i];
      matchsticks[matchsticks.length-1-i] = t;
      sum += t;
      sum += matchsticks[i]; 
    }
    sum += (matchsticks.length%2==1) ? matchsticks[matchsticks.length/2] : 0;
      if(sum%4!=0) return false;  // if the sum can not be divided by 4, of coz is false
    int length = sum/4;
    
    
    boolean[] v = new boolean[matchsticks.length];    // to record whether the element has been occupied
    
    return rec(matchsticks, v, 0, 0, 0, length);
  }
  
  public boolean rec(int[] matchsticks, boolean[] v, int start, int cur, int nthBucket, int length){
    if(nthBucket==4) return true;
    if(length==cur) return rec(matchsticks, v, 0,0, nthBucket+1, length); // if current buckets is done, we process the next buckets
    
    for(int i = start; i < matchsticks.length; i++){
      if(!v[i] && matchsticks[i] + cur <= length){    // doing dfs
        v[i] = true;
        boolean res = rec(matchsticks, v, start+1, cur+matchsticks[i], nthBucket, length); // doing dfs
        if(res) return true;
        
        v[i] = false;
        // fastern the DFS
        // if cur == 0, and matchsticks[i] is sorted descendingly
        // this mean matchsticks[i+1] cannot match as well, as matchsticks[i+1] < matchsticks[i]
        if(cur==0) return false;
        if(cur+matchsticks[i]==length) {
          return false;
        }
        // fastern the DFS
        // if matchstick[i] = x is not match in DFS, of coz DFS for i+1 is not match as matchstick[i+1] == x
        while(i + 1 < matchsticks.length && matchsticks[i+1]==matchsticks[i]){  
          i++;
        }
      }
    }
    
    return false;
  }

  public static void main(String[] args){
    int[] arr = new int[]{2,2,2,2,2,6};
    P473_MatchsticksToSquare t = new P473_MatchsticksToSquare();
    System.out.println(t.makesquare(arr));
  }
}
