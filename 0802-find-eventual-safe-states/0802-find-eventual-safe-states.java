class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //reverse the graph
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            for(int ele: graph[i]){
                // original graph, me edge is from i to ele;
                // in reverse ele to i hoga
                adj.get(ele).add(i);
                indegree[i]++;
            }
        }
        // Apply kahn's Algo
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
        Collections.sort(ans);
        return ans;
    }
}