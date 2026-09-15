class Solution {
    static boolean ans;
    public boolean canFinish(int n, int[][] edges) {
        ans = true; // no cycle 
        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)   adj.add(new ArrayList<>());
        // Build graph
        for(int[] edge : edges) {
            int a = edge[0] , b = edge[1];
            adj.get(b).add(a);
             
        }
        boolean[] vis = new boolean[n];
        boolean[] path = new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i]==false) dfs(i,adj,vis,path); // for mulipale dfs
        }
        return ans;
          
    }
    public void dfs(int i,List<List<Integer>> adj,boolean[]vis,boolean[]path){
        vis[i] = true;
        path[i] = true;
        for(int ele: adj.get(i)){
            if(path[ele]==true){
                ans = false; // false means cycle hay
                return;
            }
            if(vis[ele]==false) dfs(ele,adj,vis,path);
        }
        path[i] = false;
    }
}