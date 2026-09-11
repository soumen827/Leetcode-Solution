class Solution {
    static boolean ans;
    public boolean isBipartite(int[][] adj) {
        ans = true;
        int n = adj.length;
        int[] vis = new int[n];
        for(int i=0;i<n;i++){
            vis[i] = -1;
        }
        for(int i=0;i<n;i++){
            if(ans == false) return ans;
            if(vis[i]== -1) bfs(i,adj,vis);
        }
        return ans;
    }
    public void bfs(int i, int[][]adj,int[]vis){
        Queue<Integer> q = new LinkedList<>();
        vis[i] =1; // 1- Red, 0- Blue. i
        q.add(i);
        while(q.size()>0){
            int front = q.remove();
            int color = vis[front];
            for(int ele: adj[front]){
                if(vis[ele]==vis[front]){ // aikhane ans mile geche to return 
                    ans = false;
                    return;
                }
                if(vis[ele] == -1){
                    vis[ele] = 1-color;// alternative color
                    q.add(ele);
                }
            }
        }
    }
}