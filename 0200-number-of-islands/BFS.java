 
class Solution {
    public int numIslands(char[][] grid) { // 1- land 
        int m = grid.length, n = grid[0].length;
        boolean [][] vis = new boolean [m][n];
        int count =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]== false && grid[i][j]=='1'){
                    bfs(i,j,grid,vis);
                    count ++;
                }
            }
        }
        return count;

    }
    class Pair {
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public void bfs(int i, int j,char[][] grid,boolean [][] vis ){
        int m = grid.length, n = grid[0].length;
        //Map<Integer,Integer> Pair = new HasMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        while(q.size()>0){
            Pair front = q.remove();
            int row = front.row, col = front.col;
            //left and top dektei hobe ni . already hoya ache 
            // top >- row-1, col
            if(row>0){
                if(vis[row-1][col]==false && grid[row-1][col]=='1'){
                    q.add(new Pair(row-1,col));
                    vis[row-1][col] = true;
                }
            }
            // niche >- row+1, col
            if(row+1<m){
                if(vis[row+1][col]==false && grid[row+1][col]=='1'){
                    q.add(new Pair(row+1,col));
                    vis[row+1][col] = true;
                }
            }
            // Right >- row, col+1
            if(col+1<n){
                if(vis[row][col+1]==false && grid[row][col+1]=='1'){
                    q.add(new Pair(row,col+1));
                    vis[row][col+1] = true;
                }
            }
            //  // Left >- row, col-1
            if(col>0){
                if(vis[row][col-1]==false && grid[row][col-1]=='1'){
                    q.add(new Pair(row,col-1));
                    vis[row][col-1] = true;
                }
            }
        }

    }
}
