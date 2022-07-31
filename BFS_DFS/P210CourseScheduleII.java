import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class P210CourseScheduleII {
  // Use : Kahn’s algorithm
  // Ref : https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/

  public int[] findOrder(int numCourses, int[][] prerequisites) {
        int visitedNode = 0;
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        // step 1 , set all node with in-degree = 0
        // step 2 , increment in-degree the destination node by 1
        for(int i = 0 ; i < prerequisites.length; i++){
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];

            indegree[dest]++;
            List<Integer> list = map.get(src);
            if(list==null){
              list = new ArrayList<Integer>();
            }
            list.add(dest);
            map.put(src, list);
        }

        // step 3, for node with in-degree = 0, add it into queue
        Deque<Integer> dq = new LinkedList<Integer>();
        for(int i = 0 ; i < numCourses; i++){
          if(indegree[i]==0){
            res[visitedNode] = i;
            visitedNode++;
            dq.add(i);
          }
        }

        while(!dq.isEmpty()){
            int node = dq.poll();
            List<Integer> list = map.get(node);
            if(list!=null){
              for(int i = 0 ; i < list.size(); i++){
                // decrease the in-degree by 1 for each dest node
                int dest = list.get(i);
                indegree[dest]--;
                if(indegree[dest]==0){
                    res[visitedNode] = dest;
                    visitedNode++;
                    dq.add(dest);
                }
              }
            }
            map.put(node, list);
        }

        if(visitedNode!=numCourses) return null;    // existed cycle

        return res;
  }
}
