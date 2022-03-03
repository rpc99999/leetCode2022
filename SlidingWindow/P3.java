public class P3{

  /*
    3. Longest Substring Without Repeating Characters
    Given a string s, find the length of the longest substring without repeating characters.
    Example 1:

    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.
    Example 2:

    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.
    Example 3:

    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
  */
  public static int lengthOfLongestSubstring(String s) {

        if(s.length()<1){
          return 0;
        }
        int leftPtr = 0;
        int rightPtr = 1;
        int result = 0;
        while(rightPtr<s.length()){
            String tmp = s.substring(leftPtr, rightPtr);
            String letter = s.substring(rightPtr, rightPtr+1);
            if(tmp.contains(letter)){
              result = Math.max(result, rightPtr-leftPtr);
              leftPtr = tmp.indexOf(letter) + leftPtr;
              leftPtr++;
            }else{
              rightPtr++;
            }
        }

        return Math.max(result, rightPtr-leftPtr);
  }

  public static void main(String[] args){
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
  }
}