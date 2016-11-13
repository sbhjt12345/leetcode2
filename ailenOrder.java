import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ailenOrder {
	public String alienOrder(String[] words) {
		if (words==null || words.length==0) return "";
		//words are sorted, not word
		Map<Character,Set<Character>> map = new HashMap<>();
		Map<Character,Integer> indegree = new HashMap<>();
		boolean haha = false;
		int len2 = words[0].length();
		for (String word : words){
		    if (word.length() < len2) haha = true;      // if there is nothing in map which means every indegree is 0 then check whether it should be valid or not
		    for (char tmp : word.toCharArray()){
		        indegree.put(tmp,0);
		    }
		}
		for (int i=0;i<words.length-1;i++){
				int len = Math.min(words[i].length(),words[i+1].length());
				for (int j=0;j<len;j++){
					if (words[i].charAt(j) != words[i+1].charAt(j)){
					    if (!map.containsKey(words[i].charAt(j))) {
							map.put(words[i].charAt(j),new HashSet<>());
						}
					    if (map.get(words[i].charAt(j)).add(words[i+1].charAt(j))){
    					   indegree.put(words[i+1].charAt(j),indegree.get(words[i+1].charAt(j))+1);
				       }
				       break;   // pay attention!
					}
				}
		}
		
		if (haha && map.size()==0) return "";        // Nick Young face
		StringBuilder sb = new StringBuilder();
		Queue<Character> queue = new LinkedList<>();
		for (char x : indegree.keySet()){
		    if (indegree.get(x) == 0) {
		        queue.offer(x);
		    }
		}
		while (!queue.isEmpty()){
		    char tmp = queue.poll();
		    sb.append(tmp+"");
		    if (map.containsKey(tmp)){
		        for (char c : map.get(tmp)){
		        indegree.put(c,indegree.get(c)-1);
		        if (indegree.get(c)==0) queue.offer(c);
		    }
		    }
		}
       if (sb.length() != indegree.size()) return "";
       return sb.toString();
	}
	
	public static void main(String[] args){
		ailenOrder A = new ailenOrder();
		String[] words = {"wrt","wrf","er","ett","rftt"};
		A.alienOrder(words);
	}
}