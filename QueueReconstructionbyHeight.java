/**
 * Idea : smaller guys have nothing to do with taller guys.
 * (1): First get the tallest guys, their position k is their relative position if there are only guys with 
 * that height.
 * (2): What about the second tallest guy? 
 * Suppose his k=m, this means there are m guys who are taller than him and stand in front of him.
 * 0 1 2 .... m-1  m
 * 1 2 3 .... m    the second tallest guy
 * 
 * this means his relative index till now should be m, which is the given k.
 * 
 * loop
 * 
 * **/



public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people==null || people.length==0) return new int[0][0];
        //int[][] res = new int[people.length][2];
        List<int[]> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if (o1[0] != o2[0]) return o2[0] - o1[0];
                else return o1[1]-o2[1];
            }
        });
        
        for (int[] p : people) pq.offer(p);
        while (!pq.isEmpty()){
            int[] tmp = pq.poll();
            if (tmp[1]>res.size()) res.add(tmp);
            else res.add(tmp[1],tmp);
        }
        return res.toArray(new int[people.length][2]);
    }
}