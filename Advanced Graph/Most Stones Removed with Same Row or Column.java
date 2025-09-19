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
    public int removeStones(int[][] stones) {
        HashSet<Integer> used = new HashSet<>();
        int maxRow = 0;
        int maxCol = 0;
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        int n = maxRow + maxCol + 2;
        DisjointSet djs = new DisjointSet(maxRow + maxCol + 2);
        for (int[] stone : stones) {
            djs.unionBySize(stone[0], stone[1] + maxRow + 1);
            used.add(stone[0]);
            used.add(stone[1] + maxRow + 1);
        }
        int count = 0;
        for (int node : used) {
            if (djs.findUParent(node) == node)
                count++;
        }
        return stones.length - count;
    }
}

// Why are we using hashset to check only used points
// if input is [[0,3]]:
// maxRow = 0, maxCol = 3, so n = 0 + 3 + 2 = 5
// DSU nodes = {0,1,2,3,4}
// row 0 = node 0
// col 3 = node 3 + 0 + 1 = 4
// Used nodes = {0,4}
// Unused nodes = {1,2,3} (they exist in DSU but no stone connects to them).
// Now, your totalComponents() looks at all nodes {0,1,2,3,4}, and will count 1,2,3 as extra components, even though they don’t represent any real stone.
