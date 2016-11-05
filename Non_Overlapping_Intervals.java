
/**
 * 思路：对interval进行排序即可：当前面的interval尾巴小于等于后面interval的头时，就表示没有重复
 * 
 * 极容易出bug的地方：
 * （1）Comparator的写法
 * 
 * （2）没有注意到考虑前面元素的尾巴甚至大于后面元素尾巴的情况：这种情况下，应该选择后面的元素，才能尽可能使得
 *     更后面的元素不重复；；如果没有出现上述情况，千万不要忘记j++这一部，不然就TLE
 * 
 * 
 * 
 * 
 * 
 * 
 */


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
    
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length==1) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval A, Interval B){
                if(A.start!=B.start) return A.start-B.start;
                else return A.end-B.end;
            }
        });
        int res = 0;
        int i=0, j=1;
        while (i<intervals.length && j<intervals.length && i<j){
            if (intervals[i].end<=intervals[j].start){
                i=j;
                j++;
            }
            else {
                res++;
                if (intervals[i].end>=intervals[j].end){
                    i=j;
                    j++;
                }
                else j++;
            }
        }
        return res;
    }
}