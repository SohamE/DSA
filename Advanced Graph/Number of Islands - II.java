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
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        DisjointSet djs = new DisjointSet(m * n);
        List<Integer> ans = new ArrayList<>();
        int[] visited = new int[m * n];
        int count = 0;
        int[][] traverses = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        for (int[] position : positions) {
            int node = (position[0] * n) + position[1];
            if (visited[node] == 1) {
                ans.add(count);
                continue;
            }
            count++;
            visited[node] = 1;
            for (int[] traverse : traverses) {
                int newi = position[0] + traverse[0];
                int newj = position[1] + traverse[1];
                int newNode = (newi * n) + newj;
                if (newi < 0 || newj < 0 || newi >= m || newj >= n || visited[newNode] == 0)
                    continue;
                if (djs.findUParent(node) != djs.findUParent(newNode)) {
                    djs.unionBySize(node, newNode);
                    count--;
                }
            }
            ans.add(count);
        }
        return ans;
    }
}
