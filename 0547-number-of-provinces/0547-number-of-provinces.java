    class Solution {
    static int[] parent;
    static int[] size;

    public int find(int a){
        if(parent[a]==a) return a; // nijer paernt nije(khud group leader)
        
        // int leader = find(parent[a]);
        // parent[a] = leader // path compressssssssssssss
        // return leader;
        return parent[a] = find(parent[a]); // path compresssion
    }
    public void Union(int a, int b){
         a = find(a);
         b = find(b);
        if(a != b){ // if same component then ignore
            if(size[a]>b){
                parent[b] =a;
                size[a] +=size[b]; //a ka size me b ka size add
            }
            else{
                parent[a] =b;
                size[b] +=size[a]; //b ka size me a ka size add
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n+1]; // parent arry
        size = new int[n+1]; // size arry
        for(int i=1;i<=n;i++){
            parent[i] =i; // at first all are leader 
            size[i] =1; // initial sabke size 1
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
