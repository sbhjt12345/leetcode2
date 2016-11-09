# leetcode2
test


public class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums==null || nums.length==0) return 0;
        int[][] dp = new int[m][nums.length];dp[0][0] = nums[0];
        for (int i=1;i<nums.length;i++){
            dp[0][i] = dp[0][i-1] + nums[i];  
        }
        for (int i=1;i<m;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        
        for (int level = 1;level<m;level++){
            
            for (int i=level-1;i<nums.length-1;i++){
                for (int j= i+1;j<nums.length;j++){
                   // System.out.println("level is" + level);
                   // System.out.println("i is " + i + " , j is " + j);
                    int t = Math.max(dp[0][j]-dp[0][i], dp[level-1][i]);
                   // System.out.println("dp["+level+"]["+j+"] is "+dp[level][j]+", t is " + t);
                    if (t<=dp[level][j]) dp[level][j] = t;
                }
            }
        }
        return dp[m-1][nums.length-1];
    }
}

This is TLE, need to change it to 1-D array to avoid TLE.
