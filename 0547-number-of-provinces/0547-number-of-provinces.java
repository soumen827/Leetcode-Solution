class Solution {
    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        boolean [] Visited = new boolean [n];
        int count =0;

        for(int i=0;i<n;i++){
            if(!Visited[i]){
                //bfs(i,Visited,adj);
                dfs(i,Visited,adj);
                count ++;
            }
        }
        return count ;
    }
    public void bfs(int i,boolean [] Visited,int[][] adj){
        int n = adj.length;
        Visited[i] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
         while(q.size()>0){
            int front = q.remove();
            for(int j=0;j<n;j++){
                if(Visited[j]== false && adj[front][j]==1){ // adj matix me koi connection hoga to AND adjacency matrix false hona hoga 
                    q.add(j);
                    Visited[j] = true;
                }
            }

         }
    }
    public void dfs(int i,boolean [] Visited,int[][] adj){
        int n = adj.length;
        Visited[i] = true;
        for(int j=0;j<n;j++){
            if(adj[i][j]==1 && Visited[j]==false){
                dfs(j,Visited,adj);
            }
        }
    }
}