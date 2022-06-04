package backtracking;

import java.util.ArrayList;
import java.util.List;

public class N_Queen {
  public List<List<String>> solveNQueens(int n) {
        //stack to record the position of each chess
      List<List<String>> result = new ArrayList<List<String>>();
      // start backtrack recursion
      this.process(result, new ArrayList<String>(), 0, n);
      return result;
  }

  public void process(List<List<String>> result, List<String> tmpList, int row, int n){
      for(int i = 0; i < n; i++){
        if(this.isValid(tmpList, row, i)){
          String tmp = this.getRowStr(i, n);
          tmpList.add(tmp);
          if(tmpList.size() == n){
            result.add(List.copyOf(tmpList));
          }else{
            this.process(result, tmpList, row+1, n);
          }
          tmpList.remove(row);
        }
      }
  }

  public String getRowStr(int col, int n){
    String str = "";
    for(int i = 0 ; i < n ; i++){
      if(col==i){
        str += "Q";
      }else{
        str += ".";
      }
    }
    return str;
  }

  public boolean isValid(List<String> tmpList, int row, int col){
    for(int i = 0 ; i < tmpList.size() ; i++){
      String tmp = tmpList.get(i);
      int tmpRow = i;
      int tmpCol = this.getColumn(tmp);
      // as row must be diff, no need to check row

      // check vertical
      if(tmpCol == col){
        return false;
      }

      // check diagonal
      if(Math.abs(tmpCol-col) == Math.abs(tmpRow-row)){
        return false;
      }
    }
    return true;
  }

  public int getColumn(String str){
    // return column position of the Q
    return str.indexOf("Q");
  }

  public static void main(String[] args){
    N_Queen t = new N_Queen();
    List<List<String>> result = t.solveNQueens(5);
    for(int i = 0 ; i < result.size(); i++){
      List<String> possibleWay = result.get(i);
      for(int j = 0 ; j < possibleWay.size(); j++){
        System.out.println(possibleWay.get(j));
      }
      System.out.println("------------------------");
    }
  }
}
