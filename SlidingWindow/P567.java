import java.util.HashMap;
import java.util.Map;

public class P567 {
  /**
   * 567. Permutation in String
   * Given two strings s1 and s2, return true if s2 contains a permutation of s1,
   * or false otherwise.
   * 
   * In other words, return true if one of s1's permutations is the substring of
   * s2.
   * Example 1:
   * 
   * Input: s1 = "ab", s2 = "eidbaooo"
   * Output: true
   * Explanation: s2 contains one permutation of s1 ("ba").
   * Example 2:
   * 
   * Input: s1 = "ab", s2 = "eidboaoo"
   * Output: false
   */

  public static boolean checkInclusion(String s1, String s2) {
    int leftPtr = 0;
    while (leftPtr <= s2.length() - s1.length()) {
      for (int i = 0; i < s1.length(); i++) {
        int index = leftPtr + i;
        String tmp = s2.substring(index, index + 1);
        if (!s1.contains(tmp)) {
          leftPtr = index + 1;
          break;
        } else if (i == s1.length() - 1) {
          boolean result = isPermutation(s1, s2.substring(leftPtr, leftPtr + s1.length()));
          if (result) {
            return true;
          } else {
            leftPtr++;
          }
        }
      }
    }
    return false;
  }

  public static boolean checkInclusion_Goodway(String s1, String s2) {
    if (s2.length() < s1.length()) {
      return false;
    }
    /*
     * How do we know string p is a permutation of string s? Easy, each character in
     * p is in s too. So we can abstract all permutation strings of s to a map
     * (Character -> Count). i.e. abba -> {a:2, b:2}. Since there are only 26 lower
     * case letters in this problem, we can just use an array to represent the map.
     */
    int leftPtr = 0;
    int[] charsCount_S1 = new int[26];
    int[] charsCount_S2 = new int[26];
    int char_a = ((char) 'a');
    for (char c : s1.toCharArray()) {
      charsCount_S1[(int) c - char_a]++;
    }
    String tmp = s2.substring(0, s1.length());
    for (char c : tmp.toCharArray()) {
      charsCount_S2[(int) c - char_a]++;
    }

    /*
     * How do we know string s2 contains a permutation of s1? We just need to create
     * a sliding window with length of s1, move from beginning to the end of s2.
     * When a character moves in from right of the window, we subtract 1 to that
     * character count from the map. When a character moves out from left of the
     * window, we add 1 to that character count. So once we see all zeros in the
     * map, meaning equal numbers of every characters between s1 and the substring
     * in the sliding window, we know the answer is true.
     */
    while (leftPtr <= s2.length() - s1.length()) {
      boolean hasPerm = true;
      for (int i = 0; i < 26; i++) {
        hasPerm = (hasPerm && (charsCount_S1[i] == charsCount_S2[i]));
      }
      if (hasPerm) {
        return true;
      } else if (leftPtr == s2.length() - s1.length()) {
        return false;
      } else {
        char[] s2CharArray = s2.toCharArray();
        int char_leftPtr = s2CharArray[leftPtr];
        int char_rightPtr = s2CharArray[leftPtr + s1.length()];
        charsCount_S2[char_leftPtr - char_a]--;
        charsCount_S2[char_rightPtr - char_a]++;
        leftPtr++;
      }
    }
    return false;

  }

  public static boolean isPermutation(String word, String word2) {
    /*
     * Not a really good way to check permutation by hashmap
     * cause timeout
     */
    Map<String, Integer> hashMap = new HashMap<String, Integer>();
    for (int i = 0; i < word.length(); i++) {
      Integer count = hashMap.get(word.substring(i, i + 1));
      if (count == null) {
        count = 0;
      }
      hashMap.put(word.substring(i, i + 1), count + 1);
    }
    for (int i = 0; i < word2.length(); i++) {
      Integer count = hashMap.get(word2.substring(i, i + 1));
      if (count != null) {
        count = count - 1;
        if (count == 0) {
          hashMap.remove(word2.substring(i, i + 1));
        } else {
          hashMap.put(word2.substring(i, i + 1), count);
        }
      }
    }
    return hashMap.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(checkInclusion_Goodway("ab", "eidbaooo"));
  }
}
