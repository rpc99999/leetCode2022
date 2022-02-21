public class P577_ReverseWordInStringIII {

  public String reverseWords(String s) {
    String[] words = s.split(" ");
    StringBuffer result = new StringBuffer();
    for(int i = 0 ; i < words.length; i++){
      String word = words[i];
      char[] wordChar = word.toCharArray();
      this.reverseString(wordChar);
      result.append(new String(wordChar));

      if(i!=words.length-1)
      result.append(" ");
    }
    return result.toString();
  }

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

  public static void main(String[] args){
    System.out.println("asdfasf");
  }
}
