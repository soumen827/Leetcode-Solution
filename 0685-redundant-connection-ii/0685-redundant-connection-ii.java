class Solution {

    static int[] parent;
    static int[] size;

    // Find leader with path compression
    public int leader(int u) {

        if(parent[u] == u) return u;

        return parent[u] = leader(parent[u]);
    }

    // Union by size
    public void Union(int u, int v) {

        int a = leader(u);
        int b = leader(v);

        if(a != b) {

            if(size[a] >= size[b]) {
                parent[b] = a;
                size[a] += size[b];
            }
            else {
                parent[a] = b;
                size[b] += size[a];
            }
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {

        int n = edges.length;

        parent = new int[n + 1];
        size = new int[n + 1];

        // DSU initialization
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // This parent array is for DIRECTED graph
        int[] directParent = new int[n + 1];

        int[] edge1 = null;
        int[] edge2 = null;

        // Check if any node has two parents
        for(int[] arr : edges) {

            int u = arr[0];
            int v = arr[1];

            if(directParent[v] == 0) {

                directParent[v] = u;

            }
            else {

                // v already has a parent
                // So v has two parents

                edge1 = new int[]{directParent[v], v};
                edge2 = new int[]{u, v};
            }
        }

        // Now apply DSU
        for(int[] arr : edges) {

            int u = arr[0];
            int v = arr[1];

            // Skip second edge temporarily
            if(edge2 != null &&
               u == edge2[0] &&
               v == edge2[1]) {

                continue;
            }

            // Cycle detected
            if(leader(u) == leader(v)) {

                // If there was a two-parent problem
                if(edge1 != null) {
                    return edge1;
                }

                // Only cycle problem
                return new int[]{u, v};
            }

            // No cycle, union them
            Union(u, v);
        }

        // No cycle after removing edge2
        // Therefore edge2 is the answer
        return edge2;
    }
}