/** this is a google interview question.
 * 自己之前的思路：建立一个sum的array，和一个map<Integer,List<Integer>> 然后逐步添加，当sum值曾经出现过时候，
 * 加入到相应的list里面，不然的话就新建一个entryset。在循环结束后，再去寻找+-k的index，比大小。这个方法实在太麻烦了，
 * 其实可以在loop里就比大小，具体见答案，一目了然。
 * 
 * 经验教训：mdzz，太麻烦的写法，绕好几个弯考虑超多corner的，绝对是有问题，但思路没问题，需要找到巧妙捷径，这是最需要训练的。
 * 
 * @author Jiantao
 *
 */


public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sums = 0, max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            sums += nums[i];
            if (sums==k) max = i+1;
            else if (map.containsKey(sums-k)) max = Math.max(max,i-map.get(sums-k));
            if (!map.containsKey(sums)) map.put(sums,i); 
        }
        return max;
    }
}