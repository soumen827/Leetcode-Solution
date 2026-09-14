class Solution {
    public boolean canFinish(int n, int[][] edges) {
        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)   adj.add(new ArrayList<>());
        // Build graph
        for(int[] edge : edges) {
            int a = edge[0] , b = edge[1];
            adj.get(b).add(a);
             
        }
            // Kahn's Algorithm
            int[] indegree = new int[n];

       // Calculate indegree
        for(int i = 0; i < n; i++) {
            for(int ele : adj.get(i)) indegree[ele]++;
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        // Add all indegree 0 nodes
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.add(i);
        }
        // BFS
        while(q.size()>0) {
            int front = q.remove();
            ans.add(front);
            for(int ele : adj.get(front)) {
                indegree[ele]--;
                if(indegree[ele] == 0) q.add(ele);
            }
        }
        return (ans.size()==n);
    }
}
