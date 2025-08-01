class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] visited = new int[n];
        List<List<Integer>> adj = getAdjacencyList(n, edges);
        Deque<Pair<Integer, Integer>> bfs = new ArrayDeque<>();
        bfs.add(new Pair<>(-1, 0));
        visited[0] = 1;
        while(!bfs.isEmpty()) {
            Pair<Integer, Integer> pickPair = bfs.poll();
            int parent = pickPair.getKey();
            int pick = pickPair.getValue();
            for(int node: adj.get(pick)) {
                if (node != parent) {
                // check if cycle exists.
                if (visited[node] == 1) return false;
                bfs.add(new Pair<>(pick, node));
                visited[node] = 1;
                }
            }
        }
        // Check if all nodes are connected.
        for(int node: visited) {
            if (node == 0) return false;
        }
        return true;

    }

    public List<List<Integer>> getAdjacencyList(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] p : prerequisites) {
            adj.get(p[0]).add(p[1]);
            adj.get(p[1]).add(p[0]);
        }
        return adj;
    }
}
