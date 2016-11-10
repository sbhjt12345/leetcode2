/**
 * 此题的基本思路：使用拓扑排序。
 * 如何想到使用拓扑？ 因为里面的subsequence必须还是按照顺序排列的，有先后；其次，他需要考虑多个sequence共存时，
 * 依然保持前后顺序一致。
 * 总结：两大要素考虑使用拓扑：答案需要你保持input的原始前后顺序；input有多个element
 * 
 * execution基本手法：
 * 建立一个map记录V->{E1,E2,E3}；
 * 建立另一个map记录indegree
 * 使用queue一步步剥离出topological sorting result
 * 
 * 
 * 
 * **/




public class Solution {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        Map<Integer,Integer> indegree = new HashMap<>();
        
        for (int[] seq : seqs){
            if (seq.length==1) {
                if (!map.containsKey(seq[0])){
                    map.put(seq[0],new HashSet<>());
                    indegree.put(seq[0],0);
                }
            }
            else {
                for (int i=0;i<seq.length-1;i++){
                    if (!map.containsKey(seq[i])){
                        map.put(seq[i],new HashSet<>());
                        indegree.put(seq[i],0);
                    }
                    if (!map.containsKey(seq[i+1])){
                        map.put(seq[i+1],new HashSet<>());
                        indegree.put(seq[i+1],0);
                    }
                    if (map.get(seq[i]).add(seq[i+1])){
                        indegree.put(seq[i+1],indegree.get(seq[i+1])+1);
                    }
                }
            }
        }
        
        //如何执行？首先找出所有indegree为0的元素，如果存在复数个，那么return false;
        //随后，找出被首元素带出来的元素，indegree减去1，如果他等于零，就说明下一个是他，
        //如果存在复数个，那个就false。
        //check if it is equal to org
        Queue<Integer> queue = new LinkedList<>();
        for (int x : indegree.keySet()){
            if (indegree.get(x)==0) queue.offer(x);
        }
        int index = 0;
        while (!queue.isEmpty()){
            if (queue.size()>1) return false;
            int curr = queue.poll();
            if (index>=org.length ||curr != org[index++]) return false;
            for (int tmp : map.get(curr)){
                indegree.put(tmp,indegree.get(tmp)-1);
                if (indegree.get(tmp)==0) queue.offer(tmp);
            }
        }
        return index == org.length && index==map.size();
        
        
        
    }
}