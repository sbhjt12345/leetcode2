/*
idea : when it is E still stores the value but the res would be zero.


*/


public class Solution {
    class Point{
            int row, col;
            Point(int row, int col){
                this.row = row;
                this.col = col;
            }
        }
    
    public int maxKilledEnemies(char[][] grid) {
        if (grid==null || grid.length==0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        Point[][] dp = new Point[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]=='W') dp[i][j] = new Point(0,0);
                else{
                    int tmpcol = 0, tmprow = 0;
                    if (i==0 || (i>0 && grid[i-1][j]=='W')){
                        for (int k = i;k<m;k++) {
                            if (grid[k][j]=='E') tmpcol++;
                            if (grid[k][j]=='W') break;
                        }
                    }
                    else tmpcol = dp[i-1][j].col;
                    if (j==0 || (j>0 && grid[i][j-1] == 'W')){
                        for (int k=j;k<n;k++){
                            if (grid[i][k]=='E') tmprow++;
                            if (grid[i][k]=='W') break;
                        }
                    }
                    else tmprow = dp[i][j-1].row;   // dp not grid
                    res = Math.max(res,grid[i][j]=='E'?0:tmprow+tmpcol);
                    dp[i][j] = new Point(tmprow, tmpcol);
                }
            }
        }
        return res;
        
    }
}