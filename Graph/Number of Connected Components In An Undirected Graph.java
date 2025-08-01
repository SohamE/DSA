class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] visited = new int[n];
        int result = 0;
        List<List<Integer>> adj = getAdjacencyList(n, edges);
        Deque<Pair<Integer, Integer>> bfs = new ArrayDeque<>();
        for(int i=0;i<n;i++) {
            if (visited[i] == 0) {   
                bfs.add(new Pair<>(-1, i));
                visited[i] = 1;
                result++;
                while(!bfs.isEmpty()) {
                    Pair<Integer, Integer> pickPair = bfs.poll();
                    int parent = pickPair.getKey();
                    int pick = pickPair.getValue();
                    for(int node: adj.get(pick)) {
                        if (node != parent) {
                        // check if cycle exists.
                        if (visited[node] == 1) continue;
                        bfs.add(new Pair<>(pick, node));
                        visited[node] = 1;
                        }
                    }
                }
            }
        }
        return result;

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
