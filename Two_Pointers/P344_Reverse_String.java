public class P344_Reverse_String {

  /*
   * Write a function that reverses a string. The input string is given as an
   * array of characters s.
   * 
   * You must do this by modifying the input array in-place with O(1) extra
   * memory.
   */

  public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while(left<right){
          char tmp = s[left];
          s[left] = s[right];
          s[right] = tmp;
          left++;
          right--;
        }
  }

  public static void main(String[] args) {
    P344_Reverse_String f = new P344_Reverse_String();
    char[] result = "reverse".toCharArray();
    f.reverseString(
      result
    );
    System.out.println();

  }
}