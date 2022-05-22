package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P316_RemoveDuplicateLetters{
  public static String removeDuplicateLetters(String s) {
      
    Stack<Integer> stackChar = new Stack<Integer>();
    Map<Integer, Boolean> isAdded = new HashMap<Integer, Boolean>();
    int[] lastIndexArr = new int[26];

    for(int i = 0 ; i < s.toCharArray().length; i++){
      int letterAsInt = convertCharToInt(s.toCharArray()[i]);
      lastIndexArr[letterAsInt] = i;
    }

    for(int i = 0 ; i < s.toCharArray().length; i++){
      int letterAsInt = convertCharToInt(s.toCharArray()[i]);
      if(!stackChar.empty()){
        if(isAdded.get(letterAsInt)==null){
            // if null, we need to added it into stack
            while(!stackChar.isEmpty()){
              Integer peekLetter = stackChar.peek();
              if(peekLetter>letterAsInt){
                  // check the peekLetter is the last same letter
                  if(lastIndexArr[peekLetter]<=i){
                      // if yes, we do not remove the peek
                      break;
                  }else{
                    // if no, we remove the peek, and marked peekLetter as 'not added'
                    stackChar.pop();
                    isAdded.remove(peekLetter);
                  }
              }else{
                break;
              }
            }
            stackChar.add(letterAsInt);
            isAdded.put(letterAsInt, true);
        }else{
            // if already in stack, we skip it
        }
      }else{
        stackChar.push(letterAsInt);
        isAdded.put(letterAsInt, true);
      }
    }
    
      // pop the stack, return the reverse string as result;
      String result = "";
      while(!stackChar.isEmpty()){
        result = (convertIntToString(stackChar.pop()) + result);
      }
      return result;
  }

  public static int convertCharToInt(char tmp){
    return tmp - 'a' ;
  }

  public static String convertIntToString(int letterAsInt){
    return Character.toString((char)letterAsInt + 'a');
  }


  public static void main(String[] args){
    System.out.println(removeDuplicateLetters("bcab"));
  }
}