public class P42_Trapping_Rain_Water {
  public static int trap1(int[] height) {
    //Brute force
    //For each i in height[i]
    //Find left max and right max in each i
    //Then find minimum (left_max, right_max) 
        int result = 0;
        for(int i = 0 ; i < height.length; i++){
          if(i==0||i==height.length-1){
            continue;
          }
          int l_ptr = i-1;
          int r_ptr = i+1;
          int l_max = height[i];
          int r_max = height[i];
          while(l_ptr>=0){
            l_max = Math.max(height[l_ptr], l_max);
            l_ptr--;
          }
          while(r_ptr<height.length){
            r_max = Math.max(height[r_ptr], r_max);
            r_ptr++;
          }
          result += (Math.min(l_max, r_max) - height[i]);
        }
        return result;    
  }

  public static int trap2(int[] height){
    // Using above
    // Use array to store the left_max and right_max for each element to fasten the time
    // Then find minimum (left_max, right_max) for each element
    int[] left_max = new int[height.length];
    int[] right_max = new int[height.length];
    left_max[0] = height[0];
    right_max[height.length-1] = height[height.length-1];
    for(int i = 1 ; i < height.length; i++){
      left_max[i] = Math.max(left_max[i-1], height[i]);
    }

    for(int i = height.length-2 ; i >=0; i--){
      right_max[i] = Math.max(right_max[i+1], height[i]);
    }

    int result = 0;
    for(int i = 0 ; i < height.length; i++){
      result += (Math.min(left_max[i], right_max[i])-height[i]);
    }
    return result;
  }

  public static int trap3(int[] height){
    // Same as trap2 
    // but Space would be : O(1)
    // if height[l_ptr] < height[r_ptr], then the water at l_ptr must be : left_max[l_ptr] - height[l_ptr]
    // vice,  height[l_ptr] > height[r_ptr], then the water at r_ptr must be : right_max[r_ptr] - height[r_ptr]
    

    int l_ptr = 0;
    int r_ptr = height.length-1;
    int l_max = -1; int r_max = -1;
    int result = 0;
    while(l_ptr<r_ptr){
      if(height[l_ptr]<height[r_ptr]){
        l_max = Math.max(l_max, height[l_ptr]);
        result += (l_max - height[l_ptr]);
        l_ptr++;
      }else{
        r_max = Math.max(r_max, height[r_ptr]);
        result += (r_max - height[r_ptr]);
        r_ptr--;
      }
    }
    return result;
  }
  public static void main(String[] args){
    System.out.println(trap3(new int[]{4,2,0,3,2,5}));
  }
}
