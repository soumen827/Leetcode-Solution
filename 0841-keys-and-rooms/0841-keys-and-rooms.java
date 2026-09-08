class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n = adj.size();
        boolean [] Visited = new boolean[n];
        
        bfs(0,Visited,adj);
        for(int i=0;i<n;i++){
            if(Visited[i]==false) return false; 
        }
        return true;
    }
    public void bfs(int i,boolean [] Visited,List<List<Integer>> adj){
        int n =  adj.size();
        Visited[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(q.size()>0){
            int front = q.remove();
            for( int ele : adj.get(front)){ // us idx ka all ele
                if(!Visited[ele]) {
                    Visited[ele] = true;
                    q.add(ele);
                }
            }

        }
    }
}