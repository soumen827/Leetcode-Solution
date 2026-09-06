class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        List<List<Integer>> adj = new ArrayList<>();
        if(start == end ) return true;
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0], b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean [] vis = new boolean[n];
        bfs(start,vis,adj);
        return vis[end]; // false hoga to same nehi hay T to same hay
    }

    public void bfs(int start,boolean [] vis,List<List<Integer>> adj){
        vis[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(q.size()>0){
            int front = q.remove();
            for( int ele : adj.get(front)){ // us idx ka all ele
                if(!vis[ele]) {
                    vis[ele] = true;
                    q.add(ele);
                }
            }

        }
    } 
}