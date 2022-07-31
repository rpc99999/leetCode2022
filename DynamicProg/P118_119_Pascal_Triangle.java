import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P118_119_Pascal_Triangle {
  public static List<List<Integer>> generate(int numRows) {
    if(numRows == 1){
      List<Integer> result = new ArrayList();
      result.add(1);
      List<List<Integer>> resultList = new ArrayList<List<Integer>>();
      resultList.add(result);
      return resultList;
    }else{
      List<Integer> firstRow = new ArrayList();
      List<Integer> secondRow = new ArrayList();
      firstRow.add(1);
      secondRow.add(1);
      secondRow.add(1);
      List<List<Integer>> resultList = new ArrayList<List<Integer>>();
      resultList.add(firstRow);
      resultList.add(secondRow);

      if(numRows==2){
        return resultList;      
      }else{
        int current = 2;
        while(current<numRows){
          List<Integer> row = new ArrayList<Integer>();
          List<Integer> prevRow = resultList.get(current-1);
          row.add(1);
          for(int i = 1 ; i  < prevRow.size(); i++){
            row.add(prevRow.get(i) + prevRow.get(i-1));
          }
          row.add(1);
          resultList.add(row);
          current++;
        }
        return resultList;
      }

    }
  }

  public static void main(String[] args){
    generate(3);
  }
}
