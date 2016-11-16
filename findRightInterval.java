/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer,Integer> treemap = new TreeMap<>();
        int[] res = new int[intervals.length];
        for (int i=0;i<intervals.length;i++) treemap.put(intervals[i].start,i);
        for (int i=0;i<intervals.length;i++){
            Integer k = treemap.ceilingKey(intervals[i].end);
            res[i] = k==null?-1:treemap.get(k);
        }
        return res;
    }
}


/**
 * 	ceilingKey(K key) :Returns the least key greater than or equal to the given key, or null if there is no such key.
 * floorKey(K key): Returns the greatest key less than or equal to the given key, or null if there is no such key.
 * 
 * 
 *
 * **/
