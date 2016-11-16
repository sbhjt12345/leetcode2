public class Solution {
    public int wiggleMaxLength(int[] nums) {
       if (nums==null) return 0;
       if (nums.length<=1) return nums.length;
       int up =1,down=1;
       for (int i=1;i<nums.length;i++){
           if (nums[i]>nums[i-1]) up = down+1;
           else if (nums[i]<nums[i-1]) down= up+1;
       }
       return Math.max(up,down);
    }
}


public int wiggleMaxLength(int[] a) {
    if(a.length<2) return a.length;
    
    int start=1;
    while( (start<a.length) && (a[start] == a[start-1]) )
        start++;
    if(start==a.length)
         return 1;
     
    boolean increasing = a[start]>a[0];   // denoting if we are expecting increased relative to prev
    int prev = a[0], maxLen=1;
    for(int i=start; i<a.length; i++){
        if ( (increasing && (a[i] >prev)) || (!increasing && (a[i] < prev) ) ) {
                increasing = !increasing;
                maxLen++;
        }
        prev = a[i];
    }
    return maxLen;
}
