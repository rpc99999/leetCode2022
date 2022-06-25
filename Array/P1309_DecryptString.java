public class P1309_DecryptString {
  /*
   * You are given a string s formed by digits and '#'. We want to map s to
   * English lowercase characters as follows:
   * 
   * Characters ('a' to 'i') are represented by ('1' to '9') respectively.
   * Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
   * Return the string formed after mapping.
   * 
   * The test cases are generated so that a unique mapping will always exist.
   * 
   */
  public String freqAlphabets(String s) {
    // using array only : 1ms
    // using map + substring : 7ms
    char[] arr = s.toCharArray();
    StringBuffer sb = new StringBuffer();
    for(int i = 0 ; i < s.length(); i++){
      if(i<s.length()-2 && arr[i+2] == '#'){
        int tt = (((int)arr[i] - 48) * 10 + (int)arr[i+1] - 48 - 1);
        char t = (char) ('a' + tt);
        sb.append(t);
        i+=2;
      }else{
        char t = (char)('a' + (int)arr[i] -48 -1);
        sb.append(t);
      }
    }
    return sb.toString();
    }

  public void checkSolution()[
      System.out.println(this.freqAlphabets("10#11#12").equals("jkab"));
    ]
}
