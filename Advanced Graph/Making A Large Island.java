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
        if (up_u == up_v)
            return;
        if (size[up_u] < size[up_v]) {
            parent[up_u] = up_v;
            size[up_v] += size[up_u];
        } else {
            parent[up_v] = up_u;
            size[up_u] += size[up_v];
        }
    }

    public int maxSize() {
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            count = Math.max(count, size[i]);
        }
        return count;
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet djs = new DisjointSet(n * n);
        int[][] traverse = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1)
                    continue;
                int node = (i * n) + j;
                for (int[] t : traverse) {
                    int newi = i + t[0];
                    int newj = j + t[1];
                    int newNode = (newi * n) + newj;
                    if (newi < 0 || newj < 0 || newi >= n || newj >= n || grid[newi][newj] == 0)
                        continue;
                    djs.unionBySize(node, newNode);
                }
            }
        }
        int ans = djs.maxSize();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    continue;
                HashSet<Integer> parents = new HashSet<>();
                int count = 1;
                for (int[] t : traverse) {
                    int newi = i + t[0];
                    int newj = j + t[1];
                    int node = (newi * n) + newj;
                    if (newi < 0 || newj < 0 || newi >= n || newj >= n || grid[newi][newj] == 0)
                        continue;
                    int parent = djs.findUParent(node);
                    if (!parents.contains(parent)) {
                        parents.add(parent);
                        count += djs.size[parent];
                    }
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
