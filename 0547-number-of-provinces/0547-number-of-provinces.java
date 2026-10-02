class Solution {
    static int[] parent;
    public int find(int a){
        if(parent[a]==a) return a; // nijer paernt nije(khud group leader)
        return find(parent[a]); // else recursion
    }
    public void Union(int a, int b){
        int leaderA = find(a);
        int leaderB = find(b);
        if(leaderA != leaderB){ // if same component then ignore
            parent[leaderB] = leaderA; // connect 2 group leader
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n+1]; // parent arry
        for(int i=1;i<=n;i++){
            parent[i] =i; // at first all are leader 
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                // edges is from i+1 to j+1
                if(i!=j && isConnected[i][j]==1) Union(i+1,j+1); // Connection Group leaders of i+1 to j+1
            }
        }
        int count =0;
        for(int i=1;i<=n;i++){
            if(parent[i]==i) count++;
        }
        return count;
    }
}