class DisjointSet {
    int[] parent;
    int[] size;

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findUParent(int node) {
        if (node == parent[node])
            return node;
        int a = findUParent(parent[node]);
        parent[node] = a;
        return a;
    }

    public void unionBySize(int u, int v) {
        int up_u = findUParent(u);
        int up_v = findUParent(v);
        if (up_u == up_v) return;
        if (size[up_u] < size[up_v]) {
            parent[up_u] = up_v;
            size[up_v] += size[up_u];
        } else {
            parent[up_v] = up_u;
            size[up_u] += size[up_v];
        }
    }

    public int totalComponets() {
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i)
                count++;
        }
        return count;
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet djs = new DisjointSet(n);
        int extraEdges = 0;
        for(int[] connection: connections) {
            int u = connection[0];
            int v = connection[1];
            if (djs.findUParent(u) == djs.findUParent(v)) {
                extraEdges++;
            } else {
                djs.unionBySize(u,v);
            }
        }
        int totalComponents = djs.totalComponets();
        return extraEdges < totalComponents - 1 ? -1 : totalComponents - 1;
    }
}
