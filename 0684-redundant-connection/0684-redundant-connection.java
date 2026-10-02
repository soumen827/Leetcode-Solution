class Solution {
    static int[] parent;
    static int[] size;
    public int leader(int u){
        if(parent[u]==u) return u;
        return leader(parent[u]);
    }
    public void Union(int u,int v){
        int a = leader(u);
        int b = leader(v);
        if(a!=b){
            if(size[a]>size[b]){
                parent[b] =a;
                size[a] += size[b];
            }
            else{
                parent[a] =b;
                size[b] += size[a];
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] =i;
            size[i] =1;
        }
        int ans[] = new int[2];
        for(int[]arr : edges){
            int u = arr[0];
            int v= arr[1];
            if(leader(u)==leader(v)){// cycle detected
                ans[0] =u ; ans[1] = v; break; // ans arr me var do 
            }
            else Union(u,v); // nehi to union ksrte jao

        }
        return ans;
    }
}