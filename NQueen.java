public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        helper(res,n,board,0);
        return res;
     }
     
     public void helper(List<List<String>> res, int n, char[][] board, int row){
         if (row == n) {
             res.add(get(board));
             return;
         }
         for (int i=0;i<n;i++){
             if (validate(row,i,board)){
                 board[row][i] = 'Q';
                 helper(res,n,board,row+1);
                 board[row][i] = '.';
             }
         }
     }
     
     public boolean validate(int row, int col, char[][] board){
         for (int i=0;i<row;i++){
             for (int j=0;j<board[0].length;j++){
                 if (board[i][j]=='Q' && (j==col||i+j==col+row||i+col==j+row)){
                     return false;
                 }
             }
         }
         return true;
     }
     
     public List<String> get(char[][] board){
         List<String> res = new ArrayList<>();
         for (char[] x : board){
             res.add(new String(x));
         }
         return res;
     }
}