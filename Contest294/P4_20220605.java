package Contest294;

import java.util.LinkedList;

public class P4_20220605 {
  LinkedList<String> wordList = new LinkedList<String>();
  int pos = 0;
  public TextEditor() {
        this.wordList = new LinkedList<String>();
        this.pos = 0;
  }
  
  public void addText(String text) {
      for(int i = 0 ; i < text.length(); i++){
        String t = text.substring(i, i+1);
        wordList.add(pos, t);
        pos++;
      }
  }
  
  public int deleteText(int k) {
      int res = 0;
      while(k>0){
        if(pos==0){
          return res;
        }else{
          wordList.remove(pos-1);
          pos--;
          res++;
        }
        k--;
      }
      return res;
  }
  
  public String cursorLeft(int k) {
      String res = "";
      if(pos-k<0){
        pos=0;
        res = this.printText(Math.max(pos-10,0), pos);
      }else{
        pos = pos-k;
        if(pos<10){
          res = this.printText(0, pos);
        }else{
          res = this.printText(pos-10, pos);
        }
      }
      return res;
  }
  
  public String cursorRight(int k) {
    String res = "";
      if(pos+k>wordList.size()){
        pos=wordList.size();
        res = this.printText(Math.max(pos-10,0), pos);
      }else{
        pos = pos+k;
        if(pos<10){
          res = this.printText(0, pos);
        }else{
          res = this.printText(pos-10, pos);
        }
      }
      return res;
  }

  public String printText(int from, int to){
    StringBuffer strb = new StringBuffer();
    for(int i = from; i < to; i++){
      strb.append(wordList.get(i));
    }
    return strb.toString();
  }
  
}
