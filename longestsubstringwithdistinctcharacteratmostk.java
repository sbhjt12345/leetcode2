// sliding window


public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[256];
        int counter = 0,begin=0,end=0,maxlen=0;
        while (end<s.length()){
            if (map[s.charAt(end++)]++==0) counter++;
            while (counter>k) if(--map[s.charAt(begin++)]==0) counter--;
            maxlen=Math.max(maxlen,end-begin);
        }
        return maxlen;
    }
}
