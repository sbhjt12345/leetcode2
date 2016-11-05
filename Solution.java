import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

//
//import java.util.*;
//import java.util.Map.Entry;
//
//import javax.swing.tree.TreeNode;
//
////public class Solution {
////	public List<List<Integer>> threeSum(int[] nums) {
////		List<List<Integer>> res = new ArrayList<>();
////		HashSet<List<Integer>> mama = new HashSet<>();
////		Arrays.sort(nums);
////		for (int i=0;i<nums.length-2;i++){
////			int start = i+1;
////			int end = nums.length-1;
////			while (start<end){
////				int result = nums[i]+nums[start]+nums[end];
////				if (result<0) start++;
////				else if (result>0) end--;
////				else {
////					List<Integer> litres = new ArrayList<Integer>();
////					litres.add(nums[i]);
////					litres.add(nums[start]);
////					litres.add(nums[end]);
////					if (mama.add(litres)) res.add(litres);
////					while (nums[start+1]==nums[start]&&start<end) start++;
////					while (nums[end-1]==nums[end]&&start<end) end--;
////					start++;end--;
////				}
////			}
////		}
////		return res;
////	}
////	public static void main(String[] args){
////		Solution A = new Solution();
////		int[] nums = {-1,0,1,2,-1,-4};
////		System.out.println(A.threeSum(nums));
////
////	}
////}
///** idea: first find out left most 1 bit, then split into two groups, one with one result*/
////public class Solution {
////    public int[] singleNumber(int[] nums) {
////        int diff = 0;
////        for (int num:nums){
////            diff ^= num;
////        }
////        diff = Integer.highestOneBit(diff);
////        
////        int[] res = {0,0};
////        for ( int num:nums){
////            if ((num&diff)==0){
////                res[0] ^= num;
////            }
////            else res[1] ^= num;
////        }
////        return res;
////    }
////}
//
//
////public class Solution{
////    static String[] getSuspiciousList(String[] transactions) {
////        int n = transactions.length;
//// //       List<String> res = new ArrayList<>();
////        String[] ress = new String[n];
////        Map<String,List<String>> notdead = new HashMap<>();
////        Map<String,Integer> isdead = new HashMap<>();
////        for (int i=0;i<n;i++){
////            String[] part = transactions[i].split("|");
////            if (Integer.parseInt(part[1])>=3000){
////                if (!isdead.containsKey(part[0])){
////                    isdead.put(part[0],i);
////                }
////            }
////            else if (Integer.parseInt(part[1])<3000){
////                if (!isdead.containsKey(part[0])){
////                    if (!notdead.containsKey(part[0])){
////                       List<String> lres = new ArrayList<>();
////                       lres.add(i+"|"+part[2]+"|"+part[3]);
////                       notdead.put(part[0],lres);
////                    }
////                    else{
////                        String mama = notdead.get(part[0]).get(notdead.get(part[0]).size()-1);
////                        String[] mama2 = mama.split("|");
////                        if (mama2[1].equals(part[2])) {
////                            notdead.get(part[0]).add(i+"|"+part[2]+"|"+part[3]);
////                        }
////                        else {
////                            int a = Character.getNumericValue(mama2[2].charAt(0));
////                            int b = Character.getNumericValue(part[3].charAt(0));
////                            if (b-a>1) {
////                                notdead.get(part[0]).add(i+"|"+part[2]+"|"+part[3]);
////                            }
////                            else {
////                                int c = Integer.parseInt(mama2[2].substring(1));
////                                int d = Integer.parseInt(part[3].substring(1));
////                                if (d-c>=0) {
////                                    notdead.get(part[0]).add(i+"|"+part[2]+"|"+part[3]);
////                                }
////                                else{         isdead.put(part[0],Character.getNumericValue(notdead.get(part[0]).get(0).charAt(0)));
////                                    }
////                            }
////                        }
////                    }
////                }
////                else{
////                    if (notdead.containsKey(part[0])){
////                        notdead.remove(part[0]);
////                    }
////                }
////            }
////        }
////        for (String keytmp : isdead.keySet()){
////           ress[isdead.get(keytmp)] = keytmp; 
////        }
////        List<String> fin = new ArrayList<>();
////        for (String str:ress){
////            if (str != null){
////                fin.add(str);
////            }
////        }
////        return (String[]) fin.toArray();
////        
////
////    }
////    }
////}
//
////public class Solution {
////    public int lengthOfLIS(int[] nums) {
////        if (nums==null || nums.length==0) return 0;
////        int[] res = new int[nums.length];
//// //       res[0] = 1;
////        int max = 1;
////        for (int i=0;i<nums.length;i++){
////            res[i] = 1;
////            for (int j=0;j<i;j++){
////                if (nums[j]<nums[i]){
////                    res[i] = Math.max(res[i],res[j]+1);
////                }
////            }
////            max = Math.max(max,res[i]);
////        }
////        return max;
////    }
////}
//
////public class Solution {
////    public int lengthOfLIS(int[] nums) {            
////        int[] dp = new int[nums.length];
////        int len = 0;
////
////        for(int x : nums) {
////            int i = Arrays.binarySearch(dp, 0, len, x);
////            if(i < 0) i = -(i + 1);
////            dp[i] = x;
////            if(i == len) len++;
////        }
////
////        return len;
////    }
////}
////
////public class Solution {
////public int minCost(int[][] costs) {
////    if(costs==null||costs.length==0){
////        return 0;
////    }
////    for(int i=1; i<costs.length; i++){
////        costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
////        costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
////        costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
////    }
////    int n = costs.length-1;
////    return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
////}
//
//
////    //Use for disapearing an island
////    public void disappear(int i, int j, char[][] grid){
////        //array edge detect
////        if(i < 0 || i >= grid.length){
////            return;
////        }
////        if(j < 0 || j >= grid[i].length){
////            return;
////        }
////        //island edge detect
////        if(grid[i][j] == '0'){
////            return;
////        }
////
////        //disapear this cell
////        grid[i][j] = '0';
////        //disapear other cell in the same island
////        disappear(i + 1, j, grid);
////        disappear(i - 1, j, grid);
////        disappear(i, j + 1, grid);
////        disappear(i, j - 1, grid);
////    }
////}
//
////public class Solution {
////	public List<Integer> numIslands2(int m, int n, int[][] positions) {
////		int[][] haha = new int[m][n]; 
////		List<Integer> res = new ArrayList<>();
////		if (positions==null || m==0) return res;
////		for (int i=0;i<m;i++){
////			int count = 0;
////			helper(haha,positions[i][0],positions[i][1]);
////			helper2(haha,positions[i][0],positions[i][1]);
////
////		}
////	}
////
////	public void helper(int[][] haha, int i, int j){
////		int m = positions.length;
////		int n = positions[0].length;
////		if (!i<0 || !i>=m || !j<0 || !j>=n){
////			haha[i][j] = 1;
////		}
////	}
////
////	public void helper2(int[][] haha, int i, int j){
////		int m = positions.length;
////		int n = positions[0].length;
////		if (haha[i][j] != 0){
////			if (!i<0 || !i>=m || !j<0 || !j>=n){
////				helper2(haha,i+1,j);
////				helper2(haha,i-1,j);
////				helper2(haha,i,j+1);
////				helper2(haha,i,j-1);
////			}
////
////		}
////	}
////
////
////}
//
//
////public class Solution {
////	List<List<Integer>> res;
////    public List<List<Integer>> combine(int n, int k) {
////        res = new ArrayList<>();
////        for (int i=1;i<=n;i++){
////        	List<Integer> lres = new ArrayList<>();
//// //       	lres.add(i);
////        	bt(res,lres,i,n,k);
////        	}
////        return res;
////        }
////    
////    private void bt(List<List<Integer>> res, List<Integer> lres, int i,int n,int k){
////
////    	lres.add(i);
////    	if (lres.size()==k) {
////    		res.add(lres);
////    		return;
////    	}
////    	for (int j=i+1;j<=n;j++){
////    		bt(res,lres,j,n,k);
////    		lres.remove(lres.size()-1);
////    	}
////    }
////}
//
////public class Solution {
////	public List<List<Integer>> combinationSum(int[] candidates, int target) {
////		Arrays.sort(candidates);
////		List<List<Integer>> res = new ArrayList<>();
////		List<Integer> lres = new ArrayList<>();
////		bt(res, lres, candidates, target, 0);
////		return res;
////	}
////
////	private void bt(List<List<Integer>> res, List<Integer> lres, int[] candidates, int target, int start) {
////		if (target == 0) {
////			res.add(lres);
////			return;
////		}
////		if (target < 0)
////			return;
////		for (int i = start; i < candidates.length; i++) {
////			lres.add(candidates[i]);
////			bt(res, lres, candidates, target - candidates[i], start);
////			lres.remove(lres.size() - 1);
////		}
////	}
////}
//
////public class Solution {
////    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
////        Arrays.sort(candidates);
////        List<List<Integer>> res = new ArrayList<>();
////        List<Integer> lres = new ArrayList<>();
////        bt(res,lres,candidates,target,0);
////        return res;
////    }
////    
////    public void bt(List<List<Integer>> res, List<Integer> lres,int[] candidates, int target, int start){
////        if (target==0){
////            res.add(new ArrayList<Integer>(lres));
////            return;
////        }
////        if (target<0||start==candidates.length) return;
////        for (int i=0;i<candidates.length;i++){
////            lres.add(candidates[i]);
////            bt(res,lres,candidates,target-candidates[i],i+1);
////            lres.remove(lres.size()-1);
////        }
////    }
////}
//
////public class Solution {
////	public List<String> generateAbbreviations(String word) {
////		List<String> res = new ArrayList<>();
////		if (word==null || word.length()==0) return res;
////		StringBuffer tmp = new StringBuffer(word);
////		bt(res,word,0,1,tmp);
////		return res;
////	}
////
////	private void bt(List<String> res, String word, int indexstart,int len,StringBuffer tmp){
////		for (int i=indexstart;i<word.length();i++){
////			for (int j = len;j<word.length();j++){
////				if ((!(i-1>=0 && Character.isDigit(tmp.charAt(i-1)))
////						||
////						!(i+1<tmp.length() && Character.isDigit(tmp.charAt(i+1))))
////						&& (i+j<=tmp.length())){
////					tmp.replace(i, i+j, Integer.toString(j));
////					System.out.println(tmp);
////					res.add(tmp.toString());
////					System.out.println(res);
////					bt(res,word,i+1,j,tmp);
////					tmp.replace(i, i+j,word.substring(i,i+j));
////				}
////
////
////			}
////		}
////	}
////	
////	public static void main(String[] args){
////		Solution A = new Solution();
////		System.out.println(A.generateAbbreviations("word"));
////	}
////
////}
//
////public class Solution {
////    public List<String> generatePossibleNextMoves(String s) {
////
////        List<String> res = new LinkedList<>();
////        if (s==null || s.length()==0 ||s.length()==1) return res;
////        for (int i=0;i<s.length()-1;i++){
////            if (s.charAt(i)==s.charAt(i+1) && s.charAt(i)=='+'){
////                String tmp = (i>0?"":s.substring(0,i))+"--"+ (i+2<s.length()?s.substring(i+2):"");
////                res.add(tmp);
////            }
////        }
////        return res;
////    }
////}
//
////public class Solution {
////    public boolean canWin(String s) {
////        if (s==null || s.length()<=1) return false;
////        for (int i=0;i<s.length();i++){
////            if (s.startsWith("++",i)){
////                String tmp = s.substring(0,i) + "--" + s.substring(i+2);
////                if (canWin(tmp)==false) return true;; 
////            }
////        }
////        return false;
////
////    }
////}
//
//
////public class Solution {
////    public List<List<Integer>> getFactors(int n) {
////        List<List<Integer>> res = new ArrayList<>();
//// //       if (n==1) return res;
////        List<Integer> lres = new ArrayList<>();
////        bt(res,lres,n,2);
////        return res;
////    }
////    
////    private void bt(List<List<Integer>> res, List<Integer> lres, int n, int start){
////        if (n==1 && !(res.size()<=1)) {
////            res.add(new ArrayList<Integer>(lres));
////        }
////        for (int i=start;i<=n;i++){
////            if (n%start==0 && (lres.isEmpty() || start>=lres.get(lres.size()-1))){
////                lres.add(start);
////                bt(res,lres,n/start,start);
////                lres.remove(lres.size()-1);
////            }
////        }
////    }
////}
//
////public class Solution {
////	public List<List<String>> solveNQueens(int n) {
////		List<List<String>> res= new ArrayList<>();
////		String dot = "";
////		String dot2 = "";
////		if (n<=2) return res;
////		for (int i=0;i<n;i++){
////			dot+=".";
////			dot2+= ".";
////		}
////		List<String> lres = new ArrayList<>();
////		bt(res,lres,0,n,dot,dot2);
////		return res;
////	}
////
////	private void bt(List<List<String>> res, List<String> lres, int start, int n, String dot, String dot2){
////		if (lres.size()==n){
////			res.add(lres);
////			return;
////		}
////
////		for (int i = start;i<n;i++){
////			String tmp = dot.substring(0,i)+'Q'+dot.substring(i+1);
////			if ((i-1>=0 && dot2.charAt(i-1)== 'Q') || (i+1<dot2.length() && dot2.charAt(i+1)=='Q')) return;
////			else{
////				lres.add(tmp);
////				System.out.println(lres);
////				bt(res,lres,i+2,n,dot,tmp);
////			}
////		}
////	}
////
////	public static void main(String[] args){
////		Solution A = new Solution();
////		System.out.println(A.solveNQueens(4));
////	}
////}
//
////public class Solution {
////	public List<List<String>> solveNQueens(int n) {
////		List<List<String>> res = new ArrayList<>();
////		if (n<=2) return res;
////		char[][] board =new char[n][n];
////		for (int i=0;i<n;i++){
////			for (int j=0;j<n;j++){
////				board[i][j] = '.';
////			}
////		}
////		bt(res,0,n, board);
////		return res;
////	}
////	
////	private void bt(List<List<String>> res, int col,int n,char[][] board){
////		if (col == n){
////			res.add(construct(board));
////			return;
////		}
////		
////		for (int i=0;i<n;i++){
////			if (valid(board,i,col)){
////				board[i][col] = 'Q';
////				bt(res,col+1,n,board);
////				board[i][col] = '.';
////			}
////		}
////	}
////	
////	private boolean valid(char[][] board, int x, int y){
////		for (int i=0;i<board.length;i++){
////			for (int j=0;j<y;j++){
////				if (board[i][j] == 'Q' && (x==i||x+j==y+i||i+j==x+y)) return false;
////			}
////		}
////		return true;
////	}
//
////public class Solution {
////	private  HashSet<Integer> coll = new HashSet<>();
////	private HashSet<Integer> diag1 = new HashSet<>();
////	private HashSet<Integer> diag2 = new HashSet<>();
////	public int totalNQueens(int n) {
////
////		return bt(n,0,0);
////	}
////
////	private int bt(int n,int count,int row){
////		for (int col = 0;col<n;col++){
////			if (coll.contains(col)) continue;
////			int diag11 = row-col;
////			if (diag1.contains(diag11)) continue;
////			int diag22 = row+col;
////			if (diag2.contains(diag22)) continue;
////			if (row==n-1) count++;
////			else{
////				coll.add(col);
////				diag1.add(diag11);
////				diag2.add(diag22);
////				bt(n,count,row+1);
////				coll.remove(col);
////				diag1.remove(diag11);
////				diag2.remove(diag22);
////			}
////		}
////		return count;
////	}
////}
//
//
////public class Solution {
////	public List<List<String>> partition(String s) {
////		List<List<String>> res = new ArrayList<>();
////		if (s==null || s.length()==0) return res;
////		List<String> lres = new ArrayList<>();
////		bt(res,lres,0,s);
////		return res;
////	}
////
////	private void bt(List<List<String>> res, List<String> lres, int start, String s){
////		if (start==s.length()+1){
////			res.add(new ArrayList<String>(lres));
////			return;
////		}
////		int temp = 0;
////		for (int i=start;i<s.length();i++){
////			String tmp = "";
////			for (int j=i+1;j<s.length();j++){
////				if (isPal(s.substring(i,j))){
////					temp = j;
////					break;
////				}
////			}
////			if (temp !=0){
////				tmp = s.substring(i,temp);
////				lres.add(tmp);
////				bt(res,lres,start+temp,s);
////				lres.remove(lres.size()-1);
////			}
////		}
////	}
////
////	private boolean isPal(String s){
////         if (s.length()==1) return true;
////         int low = 0;
////         int high = s.length()-1;
////         while (low<high){
////             if (s.charAt(low) != s.charAt(high)) return false;
////             low++;
////             high--;
////         }
////         return true;
////	}
////}
//
////public class Solution {
////    public List<String> generatePalindromes(String s) {
////    	int odd = 0;
////    	String mid="";
////        HashMap<Character,Integer> haha = new HashMap<>();
////        List<Character> ch = new ArrayList<>();
////        List<String> res = new ArrayList<>();
////        for (Character t : s.toCharArray()){
////        	if (!haha.containsKey(t)) haha.put(t, 1);
////        	else haha.put(t, haha.get(t)+1);
////        	odd += haha.get(t)%2==0?-1:1;
////        }
////        
////        if (odd>1) return res;
////        else{
////        	for (Map.Entry<Character, Integer> entry : haha.entrySet()){
////        		Character c = entry.getKey();
////        		int v = entry.getValue();
////        		if (v%2!=0) mid+=c;
////        		else{
////        			for (int i=0;i<v/2;i++){
////        				ch.add(c);
////        			}
////        		}
////        	}
////        	
////        	bt(res,ch,mid, new boolean[ch.size()], new StringBuilder());
////        	return res;
////        }
////    }
////        
////     private void bt(List<String> res, List<Character> ch, String mid, boolean[] bs, StringBuilder sb){
////    	 if (sb.length()==ch.size()){
////    		 res.add(sb.toString()+mid+sb.reverse().toString());
////    		 
////    		 return;
////    	 }
////    	 
////    	 for (int i=0;i<ch.size();i++){
////    		 if (i>0 && ch.get(i)==ch.get(i-1) && !bs[i-1]) continue;
////    		 if (!bs[i]){
////    			 sb.append(ch.get(i));
////    			 bs[i] = true;
////    			 bt(res,ch,mid,bs,sb);
////    			 sb.deleteCharAt(i);
////    			 bs[i] = false;
////    		 }
////    	 }
////     }      
////}
////
////
////public class Solution {
////public List<String> generatePalindromes(String s) {
////    int[] map = new int[256];
////    for(int i=0;i<s.length();i++){
////        map[s.charAt(i)]++;
////    }
////    int j=0,count=0;
////    for(int i=0;i<256;i++){
////        if(count== 0 && map[i] %2 == 1){
////            j= i;
////            count++;
////        }else if(map[i] % 2==1){
////            return new ArrayList<String>();
////        }
////    }
////    String cur = "";
////    if(j != 0){
////        cur = ""+ (char)j;
////        map[j]--;
////    }
////    List<String> res = new ArrayList<String>();
////    DFS(res,cur,map,s.length());
////    return res;
////}
////public void DFS(List<String> res,String cur,int[] map,int len){
////    if(cur.length()== len){
////        res.add(new String(cur));
////        return;
////    }
////        for(int i=0;i<map.length;i++){
////            if(map[i] <= 0) continue;
////            map[i] = map[i] - 2;
////            cur = (char)i + cur + (char)i;
////            DFS(res,cur,map,len);
////            cur = cur.substring(1,cur.length()-1);
////            map[i] = map[i]+2;
////    }
////}
//
//
////public class Solution {
////    public int longestConsecutive(TreeNode root) {
////        if (root==null) return 0;
////        int max = 1;     
////        int max2 = 1;
////        TreeNode cur = root;
////        while (cur.right!=null){
////            if (cur.right.val-1 == cur.val){
////            max++;
////            cur = cur.right;
////            }
////            else break;
////        }
////        return Math.max(max,Math.max(longestConsecutive(root.left),longestConsecutive(root.right)));
////    }
////}
//
////public class Solution {
////	public int countComponents(int n, int[][] edges) {
////		Map<Integer,Integer> haha = new HashMap<>();
////		for (int i=0;i<edges.length;i++){
////			for (int j=0;j<edges[0].length;j++){
////				if (!haha.containsKey(edges[i][j])){
////					haha.put(edges[i][j],1);
////				}
////				else{
////					haha.put(edges[i][j],haha.get(edges[i][j])+1);
////				}
////
////			}
////		}
////		int count = 0;
////		for (Map.Entry<Integer,Integer> ent : haha.entrySet()){
////			if (ent.getValue() >1){
////				count++;
////			}
////		}
////		return edges.length-count;
////	}
////}
////}
//
//
////public class Solution {
////    public boolean validTree(int n, int[][] edges) {
////        int[] nums = new int[n];
////        for (int i=0;i<n;i++){
////            nums[i] = i;
////        }
////        for (int[] pair : edges){
////            int rootx = root(nums,pair[0]);
////            int rooty = root(nums,pair[1]);
////            if (rootx==rooty) return false;
////            nums[rooty] = rootx;
////        }
////        return edges.length == n-1;
////    }
////    
////    private int root(int[] nums, int i){
////        while (i != nums[i]) i=nums[i];
////        return i;
////    }
////}
//
////public class Solution {
////	public int numIslands(char[][] grid) {
////		int m = grid.length;
////		int n = grid[0].length;
////		int res = m*n;
////		int[] id = new int[m*n];
////		for (int i=0;i<m*n;i++){
////			id[i] = i;
////		}
////		for (int i=0;i<m;i++){
////			for (int j=0;j<n;j++){
////				int index = i*n+j;
////				if (index<=4 && index!=0){
////					help(grid,id,i,j,index,res);
////				}
////				else if (index%5==0){
////					help2(grid,id,i,j,index,res);
////				}
////				else{
////                    
////				}
////
////			}
////		}
////
////
////
////	}
////
////	private void help(char[][] grid, int[] id, int i, int j, int index,int res){
////		if(grid[i][j]=='1' && grid[i][j-1]=='1'){
////			int rootx = root(id,index);
////			int rooty = root(id,index-1);
////			if (rootx != rooty){
////				id[rooty] = rootx;
////				res--;
////			}
////		}
////	}
////	private void help2(char[][] grid,int[] id,int i,int j, int index,int res){
////		if (grid[i][j]=='1' && grid[i-1][j]=='1'){
////			int rootx = root(id,index);
////			int rooty = root(id,index-5);
////			if (rootx != rooty){
////				id[rooty] = rootx;
////				res--;
////			}
////		}
////	}
////
////	private int root(int[] id , int i){
////		while (i!= id[i]) i= id[i];
////		return i;
////	}
////}
//
////public class Solution {
////    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
////    public List<Integer> numIslands2(int m, int n, int[][] positions) {
////        List<Integer> res = new ArrayList<>();
////        if (positions==null || m==0) return res;
////        int count = 0;
////        int[] id = new int[m*n];
////        for (int i=0;i<m*n;i++){
////            id[i] = -1;
////        }
////        for (int[] pair : positions){
////            int index = n*pair[0] + pair[1];
////            id[index] = index;
////            count++;
////            
////            for (int[] dir : dirs){
////                int a = pair[0] + dir[0];
////                int b = pair[1] + dir[1];
////                int c = a*n + b;
////                if (a<0 || a>=m || b<0 || b>=n || id[c]==-1) continue;
////                id[index] = root(id,c);
////                count--;
////            }
////            res.add(count);           
////        }
////        return res;
////    }
////    
////    private int root(int[] id ,int i){
////        while (i != id[i]) i=id[i];
////        return i;
////    }
////}
//
////public class Solution {
////    public List<List<Integer>> pathSum(TreeNode root, int sum) {
////        List<List<Integer>> res = new ArrayList<>();
////        List<Integer> lres = new ArrayList<>();
////        helper(res,lres,root,sum);
////        return res;
////    }
////    
////    public void helper(List<List<Integer>> res, List<Integer> lres, TreeNode root , int sum){
////        if (root==null){
////            return;
////        }
////        lres.add(root.val);
////        if (root.left==null && root.right==null && root.val==sum){
////            res.add(new ArrayList<>(lres));
////        }else{
////            helper(res,lres,root.left,sum-root.val);
////            helper(res,lres,root.right,sum-root.val);
////        }
////        lres.remove(lres.size()-1);
////    }
////}
//
////public class Solution {
////    List<Integer> res;
////	public List<Integer> spiralOrder(int[][] matrix) {
//////		List<Integer> res= new ArrayList<>();
////		if (matrix==null || matrix.length==0) return res;
////		int m = matrix.length;
////		int n = matrix[0].length;
////		help(matrix,m-1,n-1,res);
////        return res;
////
////	}
////
////	public void help(int[][] matrix, int m, int n, List<Integer> res){
////	    if (m==0 || n==0) return;
////		for (int j=0;j<n;j++){
////			res.add(matrix[0][j]);
////		}
////		for (int i=1;i<m;i++){
////			res.add(matrix[i][n-1]);
////		}
////		for (int j = n-2;j>=0;j--){
////			res.add(matrix[m-1][j]);
////		}
////		for (int i=m-2;i>0;i--){
////			res.add(matrix[i][0]);
////		}
////		help(matrix,m-1,n-1,res);
////	}
////}
//
////public class Solution {
////    List<Integer> res;
////	public List<Integer> spiralOrder(int[][] matrix) {
////		List<Integer> res= new ArrayList<>();
////		if (matrix==null || matrix.length==0) return res;
////		int m = matrix.length;
////		int n = matrix[0].length;
////		help(matrix,0,m,n,res);
////        return res;
////
////	}
////
////	public void help(int[][] matrix, int a,int m, int n, List<Integer> res){
////	    if (m==0 || n==0 || a==m || a==n) return;
////	    if (m-a==1){
////	        for (int j=a;j<n;j++) res.add(matrix[a][j]);
////	        return;
////	    }
////	    if (n-a==1){
////	        for (int i=a;i<m;i++) res.add(matrix[i][a]);
////	        return;
////	    }
////		for (int j=a;j<n;j++){
////			res.add(matrix[a][j]);
////		}
////		for (int i=a+1;i<m;i++){
////			res.add(matrix[i][n-1]);
////		}
////		for (int j = n-2;j>=a;j--){
////			res.add(matrix[m-1][j]);
////		}
////		for (int i=m-2;i>a;i--){
////			res.add(matrix[i][a]);
////		}
////		help(matrix,a+1,m-1,n-1,res);
////	}
////}
////
////public class Solution {
////    public int[][] generateMatrix(int n) {
////        int[][] res = new int[n][n];
////        if (n==0) return res;
////        help(res,n,n,0,1,n*n);
////        return res;
////    }
////    
////    public void help(int[][] res, int m, int n, int a,int count,int cc){
////        if (m-a==1){
////            for (int i=a;i<m;i++) res[a][a] = count;
////            return;
////        }
////        if (count==cc+1) return;
////        for (int j=a;j<n;j++){
////            res[a][j] = count;
////            count++;
////        }
////        for (int i=a+1;i<m;i++){
////            res[i][n-1] = count;
////            count++;
////        }
////        for (int j = n-2;j>=a;j--){
////            res[m-1][j] = count;
////            count++;
////        }
////        for (int i = m-2;i>a;i--){
////            res[i][a] = count;
////            count++;
////        }
////        help(res,m-1,n-1,a+1,count,cc);
////    }
////}
//
////public class Solution {
////    public int longestIncreasingPath(int[][] matrix) {
////        if (matrix==null || matrix.length==0) return 0;
////        int m = matrix.length;
////        int n = matrix[0].length;
////        int res = 1;
////        for (int i=0;i<m;i++){
////            for (int j=0;j<n;j++){
////                help(matrix,i,j,m,n,res,1);
////            }
////        }
////        return res;
////    }
////    
////    private void help(int[][] matrix, int i, int j,int m, int n, int res,int count){
////        int a = count;
////        if (i-1>=0 && matrix[i-1][j]>matrix[i][j]) {
////            count++;
////            res = Math.max(res,count);
////            help(matrix,i-1,j,m,n,res,count);
////            count = a;
////        }
////        if (i+1<m && matrix[i+1][j]>matrix[i][j]){
////            count++;
////            res = Math.max(res,count);
////            help(matrix,i+1,j,m,n,res,count);
////            count = a;
////        }
////        if (j-1>=0 && matrix[i][j-1]>matrix[i][j]){
////            count++;
////            res = Math.max(res,count);
////            help(matrix,i,j-1,m,n,res,count);
////            count = a;
////        }
////        if (j+1<n && matrix[i][j+1]>matrix[i][j]){
////            count++;
////            res = Math.max(res,count);
////            help(matrix,i,j+1,m,n,res,count);
////            count = a;
////        }       
////        
////    }
////}
////
////public class Solution {
////    public int nthSuperUglyNumber(int n, int[] primes) {
////        if (n==1) return 1;
////        int count=1;
////        int num = primes[0]==2?2:3;
////        if (primes[0] != 2){
////            while (count !=n){
////            boolean isu = isugly(num,primes);
////            
////            }
////        }
////        while (count != n){
////            boolean isu = isugly(num,primes);
////            if (isu) count++;
////            if (count==n) return num;
////            num++;
////        }
////        return num;
////    }
////    private boolean isugly(int num, int[] primes){
////        if (num==1) return true;
////        boolean flag = false;
////        for (int i=0;i<primes.length;i++){
////            if (num%primes[i]==0){
////                flag = isugly(num/primes[i],primes);
////            }
////        }
////        return flag;
////    }
////}
////    
////    public static void main(String[] args){
////    	Solution A = new Solution();
////    	int[][] a = {{3,4,5},{3,2,6},{2,2,1}};
////    	System.out.println(A.longestIncreasingPath(a));
////    }
////}
//
////public class Solution {
////    public int nthSuperUglyNumber(int n, int[] primes) {
////        if (n==1) return 1;
////        int count=1;
////        int num = primes[0]==2?2:3;
////        if (primes[0] != 2){
////            while (count !=n){
////            boolean isu = isugly(num,primes);
////            
////            }
////        }
////        while (count != n){
////            boolean isu = isugly(num,primes);
////            if (isu) count++;
////            if (count==n) return num;
////            num++;
////        }
////        return num;
////    }
////    private boolean isugly(int num, int[] primes){
////        if (num==1) return true;
////        boolean flag = false;
////        for (int i=0;i<primes.length;i++){
////            if (num%primes[i]==0){
////                flag = isugly(num/primes[i],primes);
////            }
////        }
////        return flag;
////    }
////}
//
////public class Solution {
//////  public int[][] dirs = {{0,-1},{0,1},{1,0},{-1,0}};
////  public int shortestDistance(int[][] grid) {
////      if (grid==null || grid.length==0) return -1;
////      int m = grid.length;
////      int n = grid[0].length;
////      Map<Integer,Integer> qq = new HashMap<>();
////      int res = Integer.MAX_VALUE;
////      int[][] mama = new int[m][n];
////      for (int i=0;i<m;i++){
////          for (int j=0;j<n;j++){
////              mama[i][j] = -1;
////          }
////      }
////      int[][] copy = mama;
////      for (int i=0;i<m;i++){
////          for (int j=0;j<n;j++){
////              if (grid[i][j]==1){
////                  qq.put(i,j);
////              }
////          }
////      }
////      
////      for (int i=0;i<m;i++){
////          for (int j=0;j<n;j++){
////              help(grid,i,j,m,n,mama,0);
////              if (mama[i][j]==-1) continue;
////              int b = calculate(qq,mama);
////              if (b != -1) res= Math.min(res,b);
////              mama = copy;
////          }
////      }
////      return res==Integer.MAX_VALUE?-1:res;
////  }
////  
////  public void help(int[][] grid, int i, int j, int m, int n, int[][] mama,int la){
////      if (i<0 || j<0 || i==m || j==n || grid[i][j]==2 || (grid[i][j]==1 && la==0)) return;
////      if (grid[i][j]==1 && mama[i][j]>0) {
////          mama[i][j] = Math.min(mama[i][j],la);
////      }
////      if (grid[i][j]==1 && mama[i][j]==-1) {
////          mama[i][j]=la;
////          return;
////      }
////      if (mama[i][j] != -1){
////          return;
////      }
////      mama[i][j] = la;
////      help(grid,i+1,j,m,n,mama,la+1);
////      help(grid,i-1,j,m,n,mama,la+1);
////      help(grid,i,j-1,m,n,mama,la+1);
////      help(grid,i,j+1,m,n,mama,la+1);
////  }
////  
////  public int calculate(Map<Integer,Integer> qq, int[][] mama){
////      int res = 0;
////      for (Map.Entry<Integer,Integer> entry : qq.entrySet()){
////          int a = mama[entry.getKey()][entry.getValue()];
////          if (a==-1) return -1;
////          res+= a;
////      }
////      return res;
////  }
////}
//
////public class Solution {
////public int shortestDistance(int[][] grid) {
////    int row = grid.length;
////    if (row == 0) {
////        return -1;
////    }
////    int col = grid[0].length;
////    int[][] record1 = new int[row][col]; // visited num
////    int[][] record2 = new int[row][col]; // distance
////    int num1 = 0;
////    for (int r = 0; r < row; r++) {
////        for (int c = 0; c < col; c++) {
////            if (grid[r][c] == 1) {
////                num1 ++;
////                boolean[][] visited = new boolean[row][col];
////                Queue<int[]> queue = new LinkedList<int[]>();
////                queue.offer(new int[]{r, c});
////                int dist = 0;
////                while (!queue.isEmpty()) {
////                    int size = queue.size();
////                    for (int i = 0; i < size; i++) {
////                        int[] node = queue.poll();
////                        int x = node[0];
////                        int y = node[1];
////                        record2[x][y] += dist;
////                        record1[x][y] ++;
////                        if (x > 0 && grid[x - 1][y] == 0 && !visited[x - 1][y]) {
////                            queue.offer(new int[]{x - 1, y});
////                            visited[x - 1][y] = true;
////                        }
////                        if (x + 1 < row && grid[x + 1][y] == 0 && !visited[x + 1][y]) {
////                            queue.offer(new int[]{x + 1, y});
////                            visited[x + 1][y] = true;
////                        }
////                        if (y > 0 && grid[x][y - 1] == 0 && !visited[x][y - 1]) {
////                            queue.offer(new int[]{x, y - 1});
////                            visited[x][y - 1] = true;
////                        }
////                        if (y + 1 < col && grid[x][y + 1] == 0 && !visited[x][y + 1]) {
////                            queue.offer(new int[]{x, y + 1});
////                            visited[x][y + 1] = true;
////                        }
////                    }
////                    dist ++;
////                }
////            }
////        }
////    }
////    int result = Integer.MAX_VALUE;
////    for (int r = 0; r < row; r++) {
////        for (int c = 0; c < col; c++) {
////            if (grid[r][c] == 0 && record1[r][c] == num1 && record2[r][c] < result) {
////                result = record2[r][c];
////            }
////        }
////    }
////    return result == Integer.MAX_VALUE ? -1 : result;
////}
//
//
//
////public class Solution {
////    public List<String> generateAbbreviations(String word) {
////        List<String> res = new ArrayList<>();
////        bt(res,word,0);
////        return res;
////    }
////    public void bt(List<String> res, String word, int start){
////        for (int i=start;i<word.length();i++){
////            String temp="";
////            if (i-1>=0 && Character.isDigit(word.charAt(i-1)){
////            	temp = word.substring(0,i-1)+(word.charAt(i-1)+'1')+word.substring(i+1);
////            	res.add(temp);
////            	bt(res,temp,start+1);
////            }
////        }
////    }
////}
//
//
//
//
////public class Solution {
////	 public class TreeNode {
////	     int val;
////	     TreeNode left;
////	     TreeNode right;
////	     TreeNode(int x) { val = x; }
////	 }
////	 
////	    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
////	        List<List<Integer>> res = new ArrayList<>();
////	        if (root==null) return res;
////	        List<Integer> lres = new ArrayList<>();
////	        Map<TreeNode,Integer> q = new HashMap<>(); 
////	        int level = 1;
////	        q.put(root,level);
////	        
////	        while (!q.isEmpty()){
////	            Map<TreeNode,Integer> copy = q;
////	            for (Map.Entry<TreeNode,Integer> entry:copy.entrySet()){
////	                
////	                TreeNode temp = entry.getKey();
////	                if (entry.getValue()==level && level%2!=0){
////	                    lres.add(temp.val);
////	                }
////	                else if (entry.getValue()==level && level%2==0){
////	                    lres.add(0,temp.val);
////	                }
////	                q.remove(temp);
////	                if (temp.left!=null) q.put(temp.left,level+1);
////	                if (temp.right!=null) q.put(temp.right,level+1);
////	            }
////	            res.add(lres);
////	            lres = new ArrayList<Integer>();
////	            level++;
////	            }
////	        return res;
////	    }
////	}
////}
//
//
////public class Solution{
////	public int max = 0;
////	public int solution(String s, Set<String> list){
////		int len = s.length();
////		if (list.contains(s)) return len;
////
////		for (int i=0;i<len;i++){
////			String temp = s.substring(0,i)+s.substring(i+1);
////			if (list.contains(temp)){
////				max = Math.max(max,temp.length());      
////			}
////			int sth = solution(temp,list);
////			max = Math.max(sth,max);
////		}
////		return max;
////	}
////	
////	public static void main(String[] args){
////		Solution A = new Solution();
////		Set<String> ss = new HashSet<>();
////		ss.add("kmo");
////		ss.add("tko");
////		ss.add("ko");
////		System.out.println(A.solution("kyo", ss));
////	}
////}
////
/////**
//// * Definition for an interval.
//// * public class Interval {
//// *     int start;
//// *     int end;
//// *     Interval() { start = 0; end = 0; }
//// *     Interval(int s, int e) { start = s; end = e; }
//// * }
//// */
////public class Solution {
////    public List<Interval> merge(List<Interval> intervals) {
////        if (intervals.size() <=1) return intervals;
////        
////        Collections.sort(intervals, new Comparator<Interval>(){
////            @Override
////            public int compare(Interval i1, interval i2){
////                return i1.start-i2.start;
////            }
////        });
////        
////        List<Interval> res = new ArrayList<>();
////        int start = intervals.get(0).start;
////        int end = intervals.get(0).end;
////        for (Interval tmp : intervals){
////            if (tmp.start<=end){
////                end = Math.max(end,tmp.end);
////            }
////            else{
////                res.add(new Interval(start,end));
////                start = tmp.start;
////                end = tmp.end;
////            }
////        }
////        res.add(new Interval(start,end));
////        return res;
////        
////    }
////}
//
////public class Solution {
////    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
////        if (intervals.size()<1){
////            List<Interval> res = new LinkedList<>();
////            res.add(newInterval);
////            return res;
////        }
////
////        List<Interval> res = new LinkedList<>();
////        int start = newInterval.start;
////        int end = newInterval.end;
////        boolean flag = false;
////        
////        for (Interval tmp : intervals){
////            if (flag==true) res.add(tmp);
////            else{
////            if (tmp.start<=start&&tmp.end>=end){
////                res.add(tmp);
////                flag = true;
////            }
////            if (tmp.end<start){
////                res.add(tmp);
////            }
////            if (tmp.start>end){
////                
////                res.add(new Interval(start,end));
////                res.add(tmp);
////                flag = true;
////            }
////            if (tmp.end>=start){
////                start = Math.min(start,tmp.start);
////                end = Math.max(tmp.end,end);
////            }
////            }
////        }
////        if (!flag) res.add(new Interval(start,end));
////        return res;
////    }
////}
//
////public class Solution{
////	public String reverseHTML(String s){
////		if (s.length()<=1 || s==null) return s; 
////		char[] haha = s.toCharArray();
////		StringBuffer sb = new StringBuffer();
////		for (int i=haha.length-1;i>=0;i--){
////			if (haha[i] != ';') sb.append(haha[i]);
////			else{
////				int len = i;
////				while (haha[i]!='&' && i>=0) i--;
////				if (i>=0) sb.append(s.substring(i,len+1));
////				else sb.append(reverseHTML(s.substring(0,len+1)));
////			}
////		}
////		return sb.toString();
////	}
////
////	public static void main(String[] args) {
////		Solution sol = new Solution();
////
////		String s = "1234&euro;567";
////		//String s = "&euro4321";
////		String result = sol.reverseHTML(s);
////
////		System.out.println(result);
////	}
////}
//
////public class Solution {
////    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        long Q = scanner.nextInt();
////        int M = scanner.nextInt();
////
////        long N = 0;
////        Pair[] pairs = new Pair[M];
////
////        for (int i = 0; i < M; i++) {
////            int v = scanner.nextInt();
////            long c = (long) scanner.nextInt();
////            
////            N += c;
////
////            Pair pair = new Pair(v, c);
////
////            pairs[i] = pair;
////        }
////
////        // sort the array according to the vi
////        Arrays.sort(pairs, new MyPairComparator());
////
////        // Calculate the accmulated count
////        for (int i = 1; i < M; i++) {
////            pairs[i].count += pairs[i - 1].count;
////        } 
////
////        // Find all the quantiles
////        List<Integer> result = findQuantiles(N, Q, pairs);
////        for (Integer num : result) {
////            System.out.println(num);
////        }
////
////        scanner.close();
////    }
////
////    public static List<Integer> findQuantiles(long N, long Q, Pair[] pairs) {
////        List<Integer> result = new ArrayList<>();
////
////        if (N <= 0 || Q <= 1 || pairs == null || pairs.length == 0) {
////            return result;
////        }
////
////        // Find the i-th quantile
////        for (long i = 1; i < Q; i++) {
////            long index = (long) Math.ceil((double) N * i / Q);
////
////            int quantile = binarySearch(pairs, index);
////            result.add(quantile);
////        }
////
////        return result;
////    }
////
////    // If it can find the target, return the value with the index of the target
////    // Otherwise, return the next value with the index greter than the target
////    private static int binarySearch(Pair[] pairs, long target) {
////        int lo = 0; 
////        int hi = pairs.length - 1;
////
////        while (lo + 1 < hi) {
////            int mid = lo + (hi - lo) / 2;
////            if (pairs[mid].count == target) { 
////                return pairs[mid].value;
////            } else if (pairs[mid].count > target) {
////                hi = mid;
////            } else {
////                lo = mid;
////            }
////        }
////
////        if (pairs[lo].count >= target) {
////            return pairs[lo].value;
////        } else {
////            return pairs[hi].value;
////        }
////    }
////
////    static class Pair {
////        int value;
////        long count;
////
////        public Pair(int value, long count) {
////            this.value = value;
////            this.count = count;
////        }
////    }
////
////    static class MyPairComparator implements Comparator<Pair>{ 
////        @Override
////        public int compare(Pair a, Pair b) {
////            return a.value - b.value;
////        }
////    } 
////}
//
//
////public class Solution{
////	static class Pair{
////		int row;
////		int col;
////		public Pair(int row, int col){
////			this.row = row;
////			this.col = col;
////		}
////	}
////	static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
////	public static List<String> dfs(char[][] board, int H, int W){
////		List<String> res = new ArrayList<>();
////		Set<Character> ha = new HashSet<>();
////		for(int i=0;i<H;i++){
////			for (int j=0;j<W;j++){
////				helper(res,board,H,W,i,j,ha);
////			}
////		}
////		return res;
////	}
////	
////	public static void helper(List<String> res, char[][] board, int H, int W, int i, int j,Set<Character> ha){
////		if (i<0||j<0||i>=H||j>=W||board[i][j]=='0') return;
////		if (ha.contains(board[i][j])){
////			board[i][j]='0';
////			return;
////		}
////		int mi = i+1;
////		int ma = j+1;
////		res.add(board[i][j]+""+mi+ma);
////		ha.add(board[i][j]);
////		board[i][j] = '0';
////		for (int[] dir : dirs){
////			int x = i +dir[0];
////			int y = j + dir[1];
////			helper(res,board,H,W,x,y,ha);
////		}
////	}
////	
////	public static void main(String args[]){
////       Scanner sc = new Scanner(System.in);
////       int H = sc.nextInt();
////       int W = sc.nextInt();
////       char[][] board = new char[H][W];
////       for (int i=0;i<H;i++){
////    	   for (int j=0;j<W;j++){
////    		   board[i][j] = sc.next().charAt(0);
////    	   }
////       }
////       List<String> res = dfs(board,H,W);
////       for (String s : res){
////    	   System.out.println(s.charAt(0)+" "+s.charAt(1)+" "+s.charAt(2));
////       }
////       
////	}
////}
//
////public class Solution{
////	public int max(int[][] board, int X, int K){
////		if (board==null || board.length==0) return 0;
////		int H = board.length;
////		int W = board[0].length;
////		
////	}
////}
//
////public class Solution{
////	public String taka(String s){
////		int[] let = new int[26];
////		char[] ma = s.toCharArray();
////		Arrays.sort(ma);
////		StringBuffer sb = new StringBuffer();
////		for (int i=1;i<ma.length-1;i++){
////			if (ma[i]==ma[i-1] && (ma[i]!=ma[i+1])){
////				swap(i,i+1,ma);
////			}
////		}
////		for (int j=ma.length-2;j>0;j--){
////			if (ma[j]==ma[j+1] && (ma[j] != ma[j-1])){
////				swap(j,j-1,ma);
////			}
////		}
////		
////		for (int i=0;i<ma.length-1;i++){
////			if (ma[i]==ma[i+1]) return "bang!wrong";
////			sb.append(ma[i]);
////		}
////		sb.append(ma[ma.length-1]);
////		return sb.toString();
////		
////	}
////	
////	public void swap(int i,int j,char[] ma){
////		char tmp = ma[i];
////		ma[i] = ma[j];
////		ma[j] = tmp;
////		
////	}
////	
////	public static void main(String[] args){
////		Solution sol = new Solution();
//////		Scanner sc = new Scanner(System.in);
////		String s = "abbbcdd";
////		String ss = sol.taka(s);
////		if (ss.equals("bang!wrong")) System.out.println(-1);
////		else System.out.println(ss);
//////		sc.close();
////	}
////}
//
////import java.util.*;
////
////public class Main{
////
////	static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
////	public static List<String> dfs(char[][] board, int H, int W){
////		List<String> res = new ArrayList<>();
////		Set<Character> ha = new HashSet<>();
////		for(int j=0;j<W;j++){
////			for (int i=0;i<H;i++){
////				helper(res,board,H,W,i,j,ha);
////			}
////		}
////		return res;
////	}
////
////	public static void helper(List<String> res, char[][] board, int H, int W, int i, int j,Set<Character> ha){
////		if (i<0||j<0||i>=H||j>=W||board[i][j]=='0') return;
////		if (ha.contains(board[i][j])){
////			board[i][j]='0';
////			return;
////		}
////		int mi = i+1;
////		int ma = j+1;
////		res.add(board[i][j]+""+mi+ma);
////		ha.add(board[i][j]);
////		board[i][j] = '0';
////		for (int[] dir : dirs){
////			int x = i +dir[0];
////			int y = j + dir[1];
////			helper(res,board,H,W,x,y,ha);
////		}
////	}
////
////	public static void main(String args[]){
////		Scanner sc = new Scanner(System.in);
////		int H = sc.nextInt();
////		int W = sc.nextInt();
////		char[][] board = new char[H][W];
////		for (int i=0;i<H;i++){
////			for (int j=0;j<W;j++){
////				board[i][j] = sc.next().charAt(0);
////			}
////		}
////		List<String> res = Main.dfs(board, H, W);
////		for (String s : res){
////			System.out.println(s.charAt(0)+" "+s.charAt(1)+" "+s.charAt(2));
////		}
////		sc.close();
////	}
//
////public class Solution {
////	public String largestNumber(int[] nums) {
////		if (nums==null || nums.length==0) return "";
////
////		String[] haha = new String[nums.length];
////		for (int i=0;i<haha.length;i++){
////			haha[i] = nums[i]+"";
////		}
////
////		Comparator<String> comp = new Comparator<String>(){
////			@Override
////			public int compare(String s1, String s2){
////				String a1 = s1+s2;
////				String a2 = s2+s1;
////				return a2.compareTo(a1);
////			}
////		};
////
////		Arrays.sort(haha,comp);
////		if (haha[0].charAt(0)=='0') return 0+"";
////		StringBuffer sb = new StringBuffer();
////		for (String s: haha){
////			sb.append(s);
////		}
////
////		return sb.toString();
////
////
////
////	}
////}
//
//
//
//
////public class Solution {
////    public List<List<Integer>> verticalOrder(TreeNode root) {
////        int min = Integer.MAX_VALUE;
////        int max = Integer.MIN_VALUE;
////        Map<TreeNode, Integer> map = new HashMap<>();
////        List<List<Integer>> res = new ArrayList<>();
////        helper(map,0,root,min,max);
////        if (min!= Integer.MAX_VALUE){
////            for (int i=min;i<=0;i++){
////                List<Integer> lres = new ArrayList<>();
////                for (Map.entry<TreeNode,Integer> ele : map.entrySet()){
////                    if (ele.getValue()==i) lres.add(ele.getKey());
////                }
////                res.add(lres);
////            }
////        }
////        if (max != Integer.MIN_VALUE){
////            for (int i=1;i<=max;i++){
////            List<Integer> lres = new ArrayList<>();
////            for (Entry<TreeNode,Integer> ele : map.entrySet()){
////                if (ele.getValue()==i) lres.add(ele.getKey());
////            }
////            res.add(lres);
////        }
////        }
////        return res;
////    }
////    
////    public void helper(Map<TreeNode,Integer> map, int start, TreeNode root,int min, int max){
////        if (root==null) return;
////        if (start<min) min =start;
////        if (start>max) max = start;
////        map.put(root,0);
////        helper(map,start-1,root.left,min,max);
////        helper(map,start+1,root.right,min,max);
////    }
////}
////
////}
//
//public class Solution {
//    public int minCostII(int[][] costs) {
//        if (costs==null || costs.length==0) return 0;
//        int len = costs.length, k = costs[0].length;
//        int min1 = 0, min2 = 0, min1id = -1;
//        for (int i=0;i<len;i++){
//        	int m1 = Integer.MAX_VALUE,m2=m1,min1idtmp = -1;
//        	for (int j=0;j<k;j++){
//        		int cost = costs[i][j] + min1id==j?min2:min1;
//        		
//        		if (costs[i][j]<m1) {
//        			m2 = m1; m1 = cost; min1idtmp = j;
//        		}
//        		else if (costs[i][j]<m2) m2 = j;
//        	}
//        	m1 = min1;m2=min2;min1id = min1idtmp;
//        }
//        return min1;
//    }
//    
//    public static void main(String[] args){
//    	Solution A = new Solution();
//    	int[][] costs = {{0,1},{1,1},{3,2},{4,1}};
//    	System.out.println(A.minCostII(costs));
//    }
//}
//
//public class Solution {
//    public int shortestDistance(int[][] grid) {
//        if (grid == null || grid[0].length == 0) return 0;
//        final int[] shift = new int[] {0, 1, 0, -1, 0};
//
//        int row  = grid.length, col = grid[0].length;
//        int[][] distance = new int[row][col];
//        int[][] reach = new int[row][col];
//        int buildingNum = 0;
//
//        for (int i = 0; i < row; i++) {
//            for (int j =0; j < col; j++) {
//                if (grid[i][j] == 1) {
//                    buildingNum++;
//                    Queue<int[]> myQueue = new LinkedList<int[]>();
//                    myQueue.offer(new int[] {i,j});
//
//                    boolean[][] isVisited = new boolean[row][col];
//                    int level = 1;
//
//                    while (!myQueue.isEmpty()) {
//                        int qSize = myQueue.size();
//                        for (int q = 0; q < qSize; q++) {
//                            int[] curr = myQueue.poll();
//
//                            for (int k = 0; k < 4; k++) {
//                                int nextRow = curr[0] + shift[k];
//                                int nextCol = curr[1] + shift[k + 1];
//
//                                if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col
//                                    && grid[nextRow][nextCol] == 0 && !isVisited[nextRow][nextCol]) {
//                                        //The shortest distance from [nextRow][nextCol] to thic building
//                                        // is 'level'.
//                                        distance[nextRow][nextCol] += level;
//                                        reach[nextRow][nextCol]++;
//
//                                        isVisited[nextRow][nextCol] = true;
//                                        myQueue.offer(new int[] {nextRow, nextCol});
//                                    }
//                            }
//                        }
//                        level++;
//                    }
//                }
//            }
//        }
//
//        int shortest = Integer.MAX_VALUE;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
//                    shortest = Math.min(shortest, distance[i][j]);
//                }
//            }
//        }
//
//        return shortest == Integer.MAX_VALUE ? -1 : shortest;
//
//
//    }
//}
//public class Solution {
//	int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
//	public int shortestDistance(int[][] grid) {
//		if (grid==null || grid.length==0) return -1;
//		int m = grid.length;
//		int n = grid[0].length;
//		int[][] dis = new int[m][n];
//		int[][] reach = new int[m][n];
//		int numbuilding = 0;
//
//		for (int i=0;i<m;i++){
//			for (int j=0;j<n;j++){
//				if (grid[i][j]==1){
//					numbuilding++;
//					Queue<int[]> ma = new LinkedList<int[]>();
//					boolean[][] visit = new boolean[m][n];
//					ma.offer(new int[]{i,j});
//					int level = 1;
//					while (!ma.isEmpty()){
//						int qsize = ma.size();
//						for (int p=0;p<qsize;i++){
//							int[] tmp = ma.poll();
//							for (int[] dir : dirs){
//								int x = tmp[0] + dir[0];
//								int y = tmp[1] + dir[1];
//								if (x>=0 && x<m && y>=0 && y<n && !visit[x][y] && grid[x][y]==0){
//									ma.offer(new int[]{x,y});
//									visit[x][y] = true;
//									dis[x][y] += level;
//									reach[x][y]++;
//								}
//							}
//						}
//						level++;
//					}
//				}
//			}
//		}
//
//		int num = Integer.MAX_VALUE;
//		for (int i=0;i<m;i++){
//			for (int j=0;j<n;j++){
//				if (grid[i][j]==0 && reach[i][j]==numbuilding) num = Math.min(num,dis[i][j]);
//			}
//		}
//		return num==Integer.MAX_VALUE?-1:num;
//	}

//public class Solution {
//    public String minWindow(String s, String t) {
//        if(s==null||s.isEmpty()||t==null||t.isEmpty()) return "";
//        int[] map = new int[256];
//        for (int i=0;i<t.length();i++){
//            map[t.charAt(i)]++;
//        }
//        int counter = t.length(),start=0,end=0,minlen=Integer.MAX_VALUE,minstart=0;
//        while (end<s.length()){
//            if (map[s.charAt(end)]>0){
//                counter--;
//            }
//            map[s.charAt(end)]--;
//            end++;
//            while (counter==0){
//                if (end-start<minlen){
//                    minlen = end-start;
//                    minstart = start;
//                }
//                map[s.charAt(start)]++;
//                if (map[s.charAt(start)]>0) counter++;
//                start++;
//            }
//        }
//        
//        if (minlen==Integer.MAX_VALUE) return "";
//        else return s.substring(minstart,minstart+minlen);
//    }
//    
//    public static void main(String[] args){
//    	Solution haha = new Solution();
//    	String s = "ADOBECODEBANC";
//    	String t = "ABC";
//    	System.out.println(haha.minWindow(s, t));
//}
//
//
//}

//public class Solution {
//    public int lengthOfLongestSubstringTwoDistinct(String s) {
//        if (s.isEmpty() || s.length()<2) return 0;
//        int counter=0,begin=0,end=0,maxlen=Integer.MIN_VALUE;
//        int[] map = new int[256];
//        while (end<s.length()){
//            if (map[s.charAt(end++)]++==0) counter++;
//            while (counter>2) if(map[s.charAt(begin++)]--==1) counter--;
//            maxlen = Math.max(maxlen,end-begin);
//        }
//        return maxlen;
//    }
//}

//public class Solution {
//    public String shortestPalindrome(String s) {
//        // the algorithm is to use the kmp algorithm to find out the longest palindrome inside, and add the reverse of the rest substring
//        String rev = new StringBuilder(s).reverse().toString();
//        String sss = s+"#"+rev;
//        int[] kmp = new int[sss.length()];
//        for (int i=1;i<kmp.length;i++){
//        	int j=kmp[i-1];
//        	while (j>0 && sss.charAt(i)!=sss.charAt(j)) j=kmp[j-1];
//        	kmp[i]=j+(sss.charAt(i)==sss.charAt(j)?1:0);
//        }
//        return new StringBuilder(s.substring(kmp[kmp.length-1])).reverse().toString()+s;
//        
//    }
//}

//public class Solution {
//    public String shortestPalindrome(String s) {
//        if(s.length()<=1) return s;
//        String new_s = s+"#"+new StringBuilder(s).reverse().toString();
//        int[] position = new int[new_s.length()];
//
//        for(int i=1;i<position.length;i++)
//        {
//            int pre_pos = position[i-1];
//            if (i==7) System.out.println("the prepos is "+pre_pos);
//            while(pre_pos>0 && new_s.charAt(pre_pos)!=new_s.charAt(i)){
//                pre_pos = position[pre_pos-1];
//               if (i==7) System.out.println("we are in the loop and the prepos is "+pre_pos);
//            }
//            position[i] = pre_pos+((new_s.charAt(pre_pos)==new_s.charAt(i))?1:0);
//            
//        }
//        System.out.println(position[7]);
//        return new StringBuilder(s.substring(position[position.length-1])).reverse().toString()+s;
//    }
//    
//    public static void main(String[] args){
//    	Solution haha = new Solution();
//    	String s = "aaabaaaab";
//    	System.out.println("the final result is "+haha.shortestPalindrome(s));
//    }
//}

//public class Solution{
//	public boolean isUniqueChars(String str){
//		int checker = 0;
//		for (int i=0;i<str.length();i++){
//			int val = str.charAt(i)-'a';
//			if ((checker & (1 << val)) >0){
//				return false;
//			}
//			checker |= (1<<val);
//		}
//		return true;
//	}

//public class Solution {
//    public int[] countBits(int num) {
//        int[] res = new int[num+1];
//        res[0] = 0;
//        int pow = 1;
//        for (int i=1,t=0;i<=num;i++,t++){
//            if (i==pow){
//                pow <<= 1;
//                t = 0;
//            }
//            res[i] = res[t] + 1;
//        }
//        return res;
//        
//    }
//}
//
////
//public class Solution {
//    public int[] polygon(int[][] input){
//        int[] res = new int[3];
//        if (input==null || input.length==0) return res;
//        int sq = 0;
//        int rec = 0;
//        int pol = 0;
//        int m = input.length;
//        int n = input[0].length;
//        for (int i=0;i<m;i++){
//            if (isSquare(input[i])) sq++;
//            else if (isRec(input[i])) rec++;
//            else pol++;
//        }
//        res[0] = sq;res[1]=rec;res[2]=pol;
//        return res;
//    }
//    
//    public boolean isSquare(int[] a){
//        //assert a.length!=0
//        int c = a[0];
//        for (int i=0;i<a.length;i++){
//            if (a[i] != c) return false;
//        }
//        return true;
//    }
//    
//    public boolean isRec(int[] b){
//        //assert b.length==4
//        if (b[0]==b[2] && b[1]==b[3]) return true;
//        return false;
//    }
//    
//    public static void main(String args[] ) throws Exception {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
//        Scanner sc = new Scanner(System.in);
//        int rows = sc.nextInt(); // Number of rows
//        int[][] arr = new int[rows][4];
//        for(int i = 0; i < rows; i++){
//            for (int j=0;j<4;j++){
//                int a = sc.nextInt();
//                arr[i][j] = a;
//            }
//        }
//        Solution A = new Solution();
//        
//        System.out.println(Arrays.toString(A.polygon(arr)));
//    }
//}

//public class Solution {
//	public int[] sorting(Set<String> a, int reviews, Map<Integer, List<String>> map) {
//		if (map.size() == 0)
//			return null;
//		Map<Integer, Integer> res = new HashMap<>();
//		for (Entry<Integer, List<String>> entry : map.entrySet()) {
//			Integer key = entry.getKey();
//			if (!res.containsKey(key))
//				res.put(key, 0);
//			
//			for (int j=0;j<map.get(key).size();j++){
//				String[] value = entry.getValue().get(j).replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
//				if (value != null) {
//					for (String ss : value) {
//						if (a.contains(ss))
//							res.put(key, res.get(key) + 1);
//					}
//				}
//			}
//		}
//
//		ArrayList<Map.Entry<?, Integer>> l = new ArrayList(map.entrySet());
//		Collections.sort(l, new Comparator<Map.Entry<?, Integer>>() {
//			public int compare(Map.Entry<?, Integer> o1, Map.Entry<?, Integer> o2) {
//				return o1.getValue().compareTo(o2.getValue());
//			}
//		});
//		
//		int[] rrr = new int[l.size()];
//		for (int i=0;i<l.size();i++){
//			rrr[i] = (int) l.get(i).getKey();
//		}
//		
//        return rrr;
//	}
//
//	public static void main(String args[]) throws Exception {
//		/*
//		 * Enter your code here. Read input from STDIN. Print output to STDOUT
//		 */
//		Scanner sc = new Scanner(System.in);
//		int size = sc.nextInt();
//		Set<String> hs = new HashSet<String>();
//		for (int i=0;i<size;i++){
//			String input = sc.nextLine();
//			hs.add(input);
//		}
//		
//		int b = sc.nextInt();
//		int size2 = sc.nextInt();
//		Map<Integer,List<String>> map = new HashMap<>();
//		for (int i=0;i<size2;i++){
//			int key = sc.nextInt();
//			String value = sc.nextLine();
//			if (map.containsKey(key)) map.put(key, map.get(key).add(value));
//			else{
//				List<String> xx = new ArrayList<>();
//				xx.add(value);
//				map.put(key, xx);
//			}
//		}
//		Solution A = new Solution();
//		System.out.println(A.sorting(hs, b, map));
//		
//		
//		
//	}
//}

//public class Solution {
//    
//    public List<Integer> token(int[] haha){
//        List<Integer> res= new ArrayList<>();
//        
//        if (haha==null || haha.length==0) return res;
//        res.add(haha[0]);
//        for (int i=1;i<haha.length;i++){
//            int t = haha[i]-haha[i-1];
//            if (Math.abs(t)>127){
//                res.add(-128);
//                res.add(t);
//            }
//        }
//        
//        return res;
//        
//        
//        
//        
//    }
//    public static void main(String args[] ) throws Exception {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
//        
//        Scanner sc = new Scanner(System.in);
//		int size = sc.nextInt();
//        int[] input = new input[size];
//        for (int i=0;i<size;i++){
//            int ele = sc.nextInt();
//            input[i] = ele;
//        }
//        Solution A = new Solution();
//        A.token(input);
//    }
//}

//public class Solution {
//    public int twoSum(int target,int size,int[] arr){
//        if (size==0) return 0;
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i=0;i<size;i++){
//            if (map.containsKey(target-arr[i])) return 1;
//            map.put(arr[i],i+1);
//        }
//        return 0;
//    }
//    
//public static void main(String args[] ) throws Exception {
//    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
//    Scanner sc = new Scanner(System.in);
//    int target = sc.nextInt();
//    int size = sc.nextInt();
//    int[] arr = new int[size];
//    for (int i=0;i<size;i++){
//        int ele = sc.nextInt();
//        arr[i] = ele;
//    }
//    
//    Solution A = new Solution();
//    System.out.println(A.twoSum(target,size,arr));
//}
//}
//
//public class Solution {
//    // you need treat n as an unsigned value
//    public int reverseBits(int n) {
//        if (n==0) return n;
//        int tmp = n;
//        int checker = 1;
//        int res = 0;
//        int count = 0;
//        
//        while (n !=0){
//            count++;
//            n>>=1;
//            System.out.println(n);
//            System.out.println(count);
//        }
//        System.out.println("final: " + count);
//        int rest = 32-count;
//        
//        for (int i=count;i>=1;i--){
//            if ((checker&tmp) >0){
//            	System.out.println("true");
//                res += 1<<(i-1);
//                System.out.println("now is " + res);
//            }
//            checker<<=1;
//        }
//        return res<<rest;
//    }
//    
//    public static void main(String[] args){
//    	int a = 1;
//    	Solution A = new Solution();
//    	System.out.println(A.reverseBits(a));
//    }
//}

//public class Solution {
//    public int maxSubArray(int[] nums) {
//        if (nums==null || nums.length==0) return 0;
//        if (nums.length==1) return nums[0];
//        int lo = 0,hi = nums.length-1;
//        return helper(nums,lo,hi);
//    }
//    
//    public int helper(int[] nums, int lo, int hi){
//    	if (lo==hi) return nums[lo];
//    	int mid = hi + (hi-lo)/2;
//    	int left = helper(nums,lo,mid);
//    	int right = helper(nums,mid+1,hi);
//    	int leftmax = Integer.MIN_VALUE;
//    	int leftsum = 0;
//    	for (int i=mid;i>=lo;i--){
//    		leftsum += nums[mid];
//    		if (leftsum>leftmax) leftmax = leftsum;
//    	}
//    	int rightmax = Integer.MIN_VALUE;
//    	int rightsum = 0;
//    	for (int i=mid+1;i<=hi;i++){
//    		rightsum += nums[i];
//    		rightmax = Math.max(rightmax, rightsum);
//    	}
//    	return Math.max(Math.max(left, right),leftmax+rightmax);
//    }
//}
//
//public class Solution {
//    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//        List<Integer> res = new ArrayList<>();
//        helper(nums1,nums2,res,k);
//    }
//    
//    public void helper(int[] nums1, int[] nums2, List<Integer> res,int k){
//    	if (res.size() == k) return;
//    	
//    	
//    }
    
//    public int[] con(int[] nums1, int[] nums2){
//        int[] con = new int[nums1.length+nums2.length];
//        for (int i=0;i<nums1.length;i++){
//            con[i] = nums1[i];
//        }
//        for (int j=0;j<nums2.length;j++){
//            con[nums1.length+j] = nums2[j];
//        }
//        return con;
//    }
//}






//public class Solution {
//    public List<Integer> countSmaller(int[] nums) {
//        List<Integer> res =  new ArrayList<>();
//        if (nums==null || nums.length==0) return res;
//        int[] rage = new int[nums.length];
//        int[] copy = new int[nums.length];
//        for (int i=0;i<nums.length;i++){
//            copy[i] = nums[i];
//        }
//        ch(nums,copy,rage,0,nums.length-1);
//        for (int i=0;i<nums.length;i++){
//            res.add(rage[i]);
//        }
//        return res;
//    }
//    
//    public void ch(int[] nums, int[] copy,int[] rage,int lo, int hi){
//        if (hi==lo) return;
//        int mid = lo + (hi-lo)/2;
//        ch(nums,copy,rage,mid+1,hi);
//        ch(nums,copy,rage,lo,mid);
//        int[] merge = new int[hi-lo+1];
//        int i=lo,p=0,q=mid+1;
//        while (i<=mid){
//            int count = 0, j=mid+1;
//            while (j<=hi && nums[j]<copy[i]) {count++;j++;}
//            rage[i] += count;
//            while (q<=hi && nums[q] < nums[i]){
//                merge[p++] = nums[q++];
//            }
//            merge[p++] = nums[i++];
//        }
//        while (q<=hi) merge[p++] = nums[q++];
//        System.arraycopy(merge,0,nums,lo,merge.length);
//    }
//    
//    public static void main(String[] args){
//    	Solution A = new Solution();
//    	int[] nums = {7,9,0,-3,-1,4,2,1};
//    	System.out.println(A.countSmaller(nums));
//    }
//}


//public class Solution {
//    public List<Integer> findSubstring(String s, String[] words) {
//        List<Integer> res = new ArrayList<>();
//        if (s.length()==0 || words==null || words.length==0) return res;
//        int k = words.length, len = words[0].length();
//        int whole = k*len;
//        Map<String,Integer> map =  new HashMap<>();
//        for (String word : words){
//            if (map.containsKey(word)) map.put(word,map.get(word)+1);
//            else map.put(word,1);
//        }
//        Map<String,Integer> curmap = new HashMap<>();
//        for (int i=0;i<len;i++){
//            int count = 0;
//            for (int l=i, r=i;r+len<s.length();r=r+len){
//            	String temp = s.substring(r,r+len);
//            	if (map.containsKey(temp)){
//            		if (curmap.containsKey(temp)) curmap.put(temp, curmap.get(temp)+1);
//            		else curmap.put(temp, 1);
//            		
//            		if (curmap.get(temp) <= map.get(temp)) count++;
//            		while (curmap.get(temp)>map.get(temp)){
//            			String temp2 = s.substring(l,l+len);
//            			curmap.put(temp2, curmap.get(temp2)-1);
//            			l = l + len;
//            			if (curmap.get(temp2) < map.get(temp2)) count--;
//            		}
//            		
//            		if (count==k){
//            			res.add(l);
//            			String temp2 = s.substring(l,l+len);
//            			curmap.put(temp2, curmap.get(temp2)-1);
//            			l = l+len;
//            			count--;
//            			
//            		}
//            	}
//            	else {
//            		l += len;
//            		curmap.clear();
//            		count = 0;
//            	}
//            }
//            curmap.clear();
//        }
//       return res; 
//    }
//}

//public class Solution {
//    public int strStr(String haystack, String needle) {
//        if (needle.length()==0) return 0;
//        if (haystack.length()==0) return -1;
//        int[] pattern = table(needle);
//        int i=0,j=0;
//        while (i<haystack.length() && j<needle.length()){
//            if (haystack.charAt(i)==needle.charAt(j)){
//                i++;
//                j++;
//                if (j==needle.length()) return i-j;
//            }
//            else {
//                if (j!=0) j=pattern[j-1];
//                else i++;
//            }
//        }
//        return -1;
//    }
//    
//    public int[] table(String needle){
//        int[] res = new int[needle.length()];
//        int index = 0;
//        res[0] = 0;
//        for (int i=1;i<needle.length();){
//            if (needle.charAt(i) == needle.charAt(index)){
//                res[i] = index+1;
//                index++;
//                i++;
//            }
//            
//            else{
//                if (index!=0) index=res[index-1];
//                else {
//                    res[i] = 0;
//                    i++;
//                }
//            }
//        }
//        return res;
//    }
//    
//    public static void main(String[] args){
//    	
//    }
//}

//public class Solution {
//    public boolean isMatch(String s, String p) {
//        if (p.length()==0) return s.length()==0;
//        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
//        // dp[i][j] = dp[i-1][j-1]&&(s[i-1]==p[j-1] || p[j-1] == * or ?
//        // dp[i][j] = dp[i-1][j] && (j==* )
//        // dp[i][j] = dp[i][j-1] && (j-2 = * && j-1=?)
//        dp[0][0] = true;
//        for (int j=0;j<p.length();j++){
//            if (p.charAt(j)=='*') dp[0][j+1] = true;
//            else break;
//        }
//        
//        for (int i=0;i<s.length();i++){
//            for (int j=0;j<p.length();j++){
//                if (p.charAt(j)=='*'){
//                    dp[i][j] = i>0 && j>0 && dp[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)==?);
//                }
//                else{
//                    dp[i][j] = (i>0 && dp[i-1][j]) || (j>0 && dp[i][j-1]);
//                }
//                
//                
//            }
//        }
//        return dp[s.length()][p.length()];
//    }
//}

//public class Solution {
//    public int numDistinct(String s, String t) {
//        int lens = s.length();
//        int lent = t.length();
//        int[][] dp = new int[lens+1][lent+1];
//        
//        dp[0][0] = 1;
//        for (int i=1;i<=lens;i++) dp[i][0] = 1;
//        
//        for (int i=1;i<=lens;i++){
//            for (int j=1;j<=lent;j++){
//            	System.out.println("-------------------------------");
//            	System.out.println("i is " + i +" and j is "+ j );
//            	System.out.println("s at i-1 is " + s.charAt(i-1));
//            	System.out.println("t at j-1 is " + t.charAt(j-1));
//            	
//                if (i<j) dp[i][j] = 0;
//                else if (i==j){
//                    if (s.charAt(i-1) == t.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
//                    else dp[i][j] = 0;
//                    
//                }
//                else {
//                    if (s.charAt(i-1)==t.charAt(j-1)) {
//                        dp[i][j] = Math.max(dp[i-1][j]+1,dp[i][j-1]);
//                    }
//                    else dp[i][j] = dp[i-1][j];
//                    
//                }
//                System.out.println("dp["+i+"]["+j+"] is " + dp[i][j]);
//            }
//        }
//        
//        return dp[lens][lent];
//    }
//    
//    public static void main(String[] args){
//    	Solution A = new Solution();
//    	A.numDistinct("rabbbit", "rabbit");
//    }
//}

//public class Solution {
//    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//        int m = nums1.length, n = nums2.length;
//        int[] ans = new int[k];
//        for (int i=Math.max(k-m,0);i<Math.min(n,k);i++){
//            int[] p1 = maxArray(nums1,i);
//            int[] p2 = maxArray(nums2,k-i);
//            int pos1 = 0,pos2=0,tpos=0;
//            int[] res = new int[k];
//            while (pos1<m || pos2<n){
//                res[tpos++] = greater(pos1,nums1,pos2,nums2)?nums1[pos1++]:nums2[pos2++];
//            }
//            if (greater(0,res,0,ans)) ans = res;
//        }
//        return ans;
//    }
//    
//    public boolean greater(int pos1,int[] nums1, int pos2, int[] nums2){
//        while (pos1<nums1.length && pos2<nums2.length && nums1[pos1] == nums2[pos2]){
//            pos1++;pos2++;
//        }
//        return pos2==nums2.length || (pos1<nums1.length && nums1[pos1]>nums2[pos2]);
//    }
//    
//    public int[] maxArray(int[] nums, int k){
//        int[] res = new int[k];
//        int len = 0;
//        
//        for (int i=0;i<nums.length;i++){
//            while (len>0 && nums.length-i>k-len && nums[i]>nums[len-1]) len--;
//            if (len<k) res[len++] = nums[i];
//        }
//        return res;
//    }
//}


public class Solution{
	public int maxRec(int[] his){
		Stack<Integer> stack = new Stack<>();
		int maxarea = Integer.MIN_VALUE;
		for (int i=0;i<=his.length;i++){
			int curhei = i!=his.length?his[i]:0;
			//int prehei = stack.peek();
			if (stack.isEmpty() || his[stack.peek()]<=curhei) stack.push(i);
			else{
				int tp = stack.pop();
				maxarea = Math.max(maxarea, his[tp]*(stack.isEmpty()?i:i-stack.peek()-1));
				i--;
			}
		}
		return maxarea;	
	}
}