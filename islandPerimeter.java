public class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid==null || grid.length==0) return 0;
        int res = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==0) continue;   // the very important line forgotten
                if (grid[i][j]==1) res += 4;
                if (i>0 && grid[i-1][j]==1) res-=1;
                if (j>0 && grid[i][j-1]==1) res-=1;
                if (i<grid.length-1 && grid[i+1][j]==1) res-=1;
                if (j<grid[0].length-1 && grid[i][j+1]==1) res-=1;
               // System.out.println("gird[" + i + "][" + j + "] and the res is " + res);
            }
        }
        return res;
    }
}