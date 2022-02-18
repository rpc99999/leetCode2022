import java.math.BigInteger;

public class P278 {
  /* Day 1 Binary Search
   * You are a product manager and currently leading a team to develop a new
   * product. Unfortunately, the latest version of your product fails the quality
   * check. Since each version is developed based on the previous version, all the
   * versions after a bad version are also bad.
   * 
   * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
   * bad one, which causes all the following ones to be bad.
   * 
   * You are given an API bool isBadVersion(version) which returns whether version
   * is bad. Implement a function to find the first bad version. You should
   * minimize the number of calls to the API.
   */

   /* The isBadVersion API is defined in the parent class VersionControl.*/
  boolean isBadVersion(int version){
    if(version == 2)
    return true;

    return false;
  }

  public int firstBadVersion(int n) {
      if(n==1){
        return 1;   // if only 1 item, assume the first one is bad version
      }else{
        return this.firstBadVersion(0, n-1);
      }
  }

  public int firstBadVersion(int left, int right){
      if(left>=right){
        return right;
      }

      int tmp = left/2 + right/2;
      if(isBadVersion(tmp+1)){
          if(tmp > 0 && !isBadVersion(tmp)){
            return tmp+1;
          }else{
            if(tmp<=0){
              return 1;
            }else{
              return this.firstBadVersion(left, tmp-1);
            }
          }
      }else{
          return this.firstBadVersion(tmp+1, right);
      }
  }

  public static void main(String[] args){
    P278 f = new P278();
    f.firstBadVersion(2);
  }
}
