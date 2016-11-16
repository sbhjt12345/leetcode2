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









// navie solution for scramble string( and is very likely  to be wrong)

public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1=="") return s2=="";
       // gre -> g re or gr e -> gr -> g or r
       Map<String,Set<String>> map = new HashMap<>();
       helper(s1,map);
       return map.get(s1).contains(s2);
    }
    
    public void helper(String s1,Map<String,Set<String>> map){
        if (map.containsKey(s1)) return;
        if (s1.length()==1){
            map.put(s1,new HashSet<String>());
            map.get(s1).add(s1);
            return;
        }
        int len = s1.length();
        map.put(s1,new HashSet<String>());
        for (int i=1;i<len;i++){
            String sub1 = s1.substring(0,i);
            String sub2 = s1.substring(i,len);
            helper(sub1,map);
            helper(sub2,map);
            for (String tmp1 : map.get(sub1)){
                for (String tmp2 : map.get(sub2)){
                    map.get(s1).add(tmp1+tmp2);
                    map.get(s1).add(tmp2+tmp1);
                }
            }
        }
    }
}
