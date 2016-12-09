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

//Sudoku Solver : remember the indian: build the tree;

public class Solution {
    public void solveSudoku(char[][] board) {
        if (board==null || board.length==0) return;
        helper(board);
    }
    
    public boolean helper(char[][] board){
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]=='.'){
                    for (char c = '1';c<='9';c++){
                        if (valid(c,board,i,j)){
                            board[i][j] = c;
                            if (helper(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean valid(char c, char[][] board, int i, int j){
        for (int x =0;x<board[0].length;x++){
            if (x!=j && board[i][x]==c) return false;
        }
        for (int x=0;x<board.length;x++){
            if (x!=i && board[x][j]==c) return false;
        }
        for (int a=i/3*3;a<i/3*3+3;a++){
            for (int b=j/3*3;b<j/3*3+3;b++){
                if ((!(a==i&&b==j)) &&board[a][b]==c) return false; 
            }
        }
        return true;
    }
}


------------------------------------------------------------------------------------------
Valid Squares TLE

public class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        int n = words[0].length();
      //  char[][] board = new char[n][n];
        List<String> lres = new ArrayList<>();
        helper(res,n,words,lres);
        return res;
    }
    
    public void helper(List<List<String>> res, int n, String[] words, List<String> lres){
        if (lres.size()==n) {
        //    System.out.println("bingo");
            res.add(new ArrayList<>(lres));
            return;
        }
        for (int i=0;i<words.length;i++){
         //   System.out.println(lres);
            if (valid(words[i],lres)){
                lres.add(words[i]);
                helper(res,n,words,lres);
                lres.remove(lres.size()-1);
            }
        }
    }
    
    public boolean valid(String newWord, List<String> lres){
        if (lres.size()==0) return true;
        lres.add(newWord);
        int size = lres.size();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<size;i++){
            sb.append(lres.get(i).toCharArray()[size-1]+"");
        }
        lres.remove(lres.size()-1);
      //  System.out.println("--------------");
      //  System.out.println(sb.toString());
      //  System.out.println("newword is " + newWord);
      //  System.out.println(newWord.substring(0,size));
      //  System.out.println("--------------");
        
        if (newWord.substring(0,size).equals(sb.toString())) return true;
        return false;
    }
}

-------------------------------------------------------------------------------------------------------
public class Solution {
    class tuple{
        int num, level;
        public tuple(int num, int level){
            this.num = num;
            this.level = level;
        }
    }
    
    public int calculate(String s) {
        if (s==null || s.length()==0) return 0;
        if (s.length()==1) return Integer.valueOf(s);
        Stack<tuple> stack = new Stack<>();
        Stack<Character> operator = new Stack<>();
        int l = 0;
        int level = 0;
        for (int r= 0;r<s.length();r++){
            char c = s.charAt(r);
            if (c=='+' || c=='-'){
                if (s.charAt(r-1) != '(' && s.charAt(r-1) != ')'){
                    int num = Integer.valueOf(s.substring(l,r));
                    if (stack.isEmpty()) {
                        stack.push(new tuple(num,level));
                        operator.push(c);
                    }
                    else {
                        if (stack.peek().level==level){
                            int tmp = domath(stack.pop().num,num,c);
                            stack.push(new tuple(tmp,level));
                        }
                        else {
                            stack.push(new tuple(num,level));
                            operator.push(c);
                        }
                    }
                }
                else operator.push(c);
                l=r+1;
            }
            else if (c=='('){
                level++;
                l=r+1;
            }
            else if (c==')'){
                int num = Integer.valueOf(s.substring(l,r));
                int tmp = domath(stack.pop().num,num,operator.pop());
                level--;
                if (!stack.isEmpty() && stack.peek().level == level){
                    int tmp2 = domath(stack.pop().num,tmp,operator.pop());
                    stack.push(new tuple(tmp2,level));
                }
                else stack.push(new tuple(tmp,level));
                //System.out.println("tmp is " + tmp);
                //System.out.println(stack.size()+", and operator still has " + operator.size());
                if (r==s.length()-1){
                    int b = stack.pop().num;
                    if (operator.isEmpty()) return b;
                    else return domath(stack.pop().num,b,operator.pop());
                }
            }
            else{
                if (r==s.length()-1){
                    int num = Integer.valueOf(s.substring(l));
                    if (stack.isEmpty()) return num;                 //forget to consider when it is totally a number
                    else return domath(stack.pop().num,num,operator.pop());
                }
            }
    }
    return stack.pop().num;   // forget add ".num"
}

    public int domath(int a, int b, char ope){
        if (ope=='+') return a+b;
        else return a-b;
    }
}
-----------------------------------------------------------------------------------------------------------------------


public class Solution {
    public int calculate(String str) {
        Stack<Integer> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        int num = 0;
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)=='*' || str.charAt(i)=='-' || str.charAt(i)=='/' || str.charAt(i)=='+') {
                t.push(str.charAt(i));
            }
            else {
               while  (i<str.length() && (str.charAt(i) == ' ' || Character.isDigit(str.charAt(i)))) {
                    if (Character.isDigit(str.charAt(i))) num = num*10 + (str.charAt(i)-'0');
                    i++;
                   }
                    if (s.isEmpty() || (!t.isEmpty() && (t.peek()=='+' || t.peek()=='-'))) {
                        s.push(num);
                    }
                    else{
                        if (!t.isEmpty() &&(t.peek()=='*' || t.peek()=='/')){
                            int tmp = s.pop();
                            s.push(t.pop()=='*'?tmp*num:tmp/num);
                        }
                    }
                    num = 0;
                    i--;
                }
        }
        int res = 0;
        //if (s.isEmpty()) return 0;
        while (!t.isEmpty()){
            char mm = t.pop();
            res += (mm=='+')?s.pop():s.pop()*(-1);
        }
        res += s.pop();
        return res;
    }
}
--------------------------------------------------------------------------------------------------------------------------------
