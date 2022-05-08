package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P406_QueueReconstructionbyHeight {
  /*
   * You are given an array of people, people, which are the attributes of some
   * people in a queue (not necessarily in order). Each people[i] = [hi, ki]
   * represents the ith person of height hi with exactly ki other people in front
   * who have a height greater than or equal to hi.
   * 
   * Reconstruct and return the queue that is represented by the input array
   * people. The returned queue should be formatted as an array queue, where
   * queue[j] = [hj, kj] is the attributes of the jth person in the queue
   * (queue[0] is the person at the front of the queue).
   * 
   * 
   * Example 1:
   * 
   * Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
   * Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
   * Explanation:
   * Person 0 has height 5 with no other people taller or the same height in
   * front.
   * Person 1 has height 7 with no other people taller or the same height in
   * front.
   * Person 2 has height 5 with two persons taller or the same height in front,
   * which is person 0 and 1.
   * Person 3 has height 6 with one person taller or the same height in front,
   * which is person 1.
   * Person 4 has height 4 with four people taller or the same height in front,
   * which are people 0, 1, 2, and 3.
   * Person 5 has height 7 with one person taller or the same height in front,
   * which is person 1.
   * Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.
   * 
   * 
   * Example 2:
   * 
   * Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
   * Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
   * 
   * 
   * Constraints:
   * 
   * 1 <= people.length <= 2000
   * 0 <= hi <= 1000000
   * 0 <= ki < people.length
   * It is guaranteed that the queue can be reconstructed.
   */

  public int[][] reconstructQueue1(int[][] people) {      // correct but timeout error (O(n^2) * 10^6)
      int[][] result = new int[people.length][2];
      int[] maxKiAvail = new int[100000];
      Map<Integer, String> hasBeenIncludeMap = new HashMap<Integer, String>();
      if(people.length==1){
        return people;
      }
      for(int i = 0 ; i < result.length; i++){
        int[] newNode = new int[2];
        newNode[0] = 100001;
        newNode[1] = people.length;
        int newNodeIndex = -1;
        for(int j = 0 ; j < people.length; j++){
          int hi = people[j][0];
          int ki = people[j][1];
          if(hasBeenIncludeMap.get(j) == null && maxKiAvail[hi]>=ki){
            if(newNode[0]> hi || (newNode[0]==hi && newNode[1]>ki)){
              newNode[0] = hi;
              newNode[1] = ki;
              newNodeIndex = j;
            }
          }
        }
        hasBeenIncludeMap.put(newNodeIndex, "true");
        for(int k = newNode[0]; k>=0; k--){
          maxKiAvail[k]++;
        }
        result[i] = newNode;
      }

      return result;
  }

  public int[][] reconstructQueue(int[][] people) { 
    // actually we can use 'Array.sort(...., new comperator)', then we don't need to create a class for it
    class PeopleObj implements Comparable{
        int h;
        int k;

        @Override
        public int compareTo(Object tmp) {
          if(this.h > ((PeopleObj) tmp).h || (this.h == ((PeopleObj) tmp).h && this.k < ((PeopleObj) tmp).k)){
            return 1;
          }else if(this.h == ((PeopleObj) tmp).h && this.k == ((PeopleObj) tmp).k){
            return 0;
          }else {
            return -1;
          }
        }
    }
    int[][] result = new int[people.length][2];
    if(people.length==1){
      return people;
    }
    // step 1 , sort by hi firstly,  O(nlogn)
    List<PeopleObj> tmpList = new ArrayList<PeopleObj> ();
    List<Integer> assignedNthPos = new ArrayList<Integer>();
    for(int i = 0 ; i < people.length ; i++){
      PeopleObj obj = new PeopleObj();
      obj.h = people[i][0];
      obj.k = people[i][1];
      tmpList.add(obj);
      assignedNthPos.add(i);
    }
    Collections.sort(tmpList);

    //step 2, start with smallest no of h, put the rank according to k
    for(int i = 0 ; i < tmpList.size() ; i++){  // o(n)
      PeopleObj obj = tmpList.get(i);
      int pos = assignedNthPos.get(obj.k);
      result[pos][0] = obj.h;
      result[pos][1] = obj.k;
      assignedNthPos.remove(obj.k);
    }

    return result;

  }
}
