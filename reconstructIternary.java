public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String,List<String>> map = new HashMap<>();
        for (String[] tic : tickets){
            if (!map.containsKey(tic[0])){
                map.put(tic[0],new ArrayList<>());
                map.get(tic[0]).add(tic[1]);
            }
            else map.get(tic[0]).add(tic[1]);
        }
        for (String x : map.keySet()) Collections.sort(map.get(x));
        List<String> res = new ArrayList<>(); 
        helper(map,res,tickets.length+1,"JFK");
        return res;
    }
    
    public boolean helper(Map<String,List<String>> map, List<String> res, int n, String curr){
        res.add(curr);
        if (res.size()==n) return true;
        if (!map.containsKey(curr) || map.get(curr).size()==0) return false;
        for (int i=0;i<map.get(curr).size();i++){
            String next = map.get(curr).remove(i);
            if (helper(map,res,n,next)) return true;
            res.remove(res.size()-1);
            map.get(curr).add(i,next);
        }
        return false;
    }
}