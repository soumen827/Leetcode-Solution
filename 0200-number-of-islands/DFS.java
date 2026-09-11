class Solution {
    public int numIslands(char[][] grid) { // 1- land 
        int m = grid.length, n = grid[0].length;
        boolean [][] vis = new boolean [m][n];
        int count =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]== false && grid[i][j]=='1'){
                    //bfs(i,j,grid,vis);
                    dfs(i,j,grid,vis);
                    count ++;
                }
            }
        }
        return count;

    }

    public void dfs(int i, int j,char[][] grid,boolean [][] vis ){
        int m = grid.length, n = grid[0].length;
        vis[i][j] = true;
        //top
    if(i-1>=0 && vis[i-1][j]==false && grid[i-1][j]=='1')
        dfs(i-1,j,grid,vis);
        //down
    if(i+1<=m-1 && vis[i+1][j]==false && grid[i+1][j]=='1')
        dfs(i+1,j,grid,vis);
        //left
    if(j-1>=0 && vis[i][j-1]==false && grid[i][j-1]=='1')
        dfs(i,j-1,grid,vis);
        //right
    if(j+1<=n-1 && vis[i][j+1]==false && grid[i][j+1]=='1')
        dfs(i,j+1,grid,vis);

    }
}
