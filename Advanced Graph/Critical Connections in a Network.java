class Solution {
    int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> bridges = new ArrayList<>();
        int[] lowNode = new int[n];
        int[] tin = new int[n];
        int[] visited = new int[n];
        dfs(0, -1, bridges, getAdjList(connections, n), lowNode, tin, visited);
        return bridges;
    }

    public void dfs(int node, int parent, List<List<Integer>> bridges, List<List<Integer>> adjList, int[] lowNode,
            int[] tin, int[] visited) {
        visited[node] = 1;
        lowNode[node] = timer;
        tin[node] = timer;
        timer++;
        for (int lt : adjList.get(node)) {
            if (lt == parent)
                continue;
            if (visited[lt] == 1) {
                lowNode[node] = Math.min(lowNode[lt], lowNode[node]);
            } else {
                dfs(lt, node, bridges, adjList, lowNode, tin, visited);
                lowNode[node] = Math.min(lowNode[lt], lowNode[node]);
                if (lowNode[lt] > tin[node]) // check
                    bridges.add(Arrays.asList(node, lt));
            }
        }
    }

    public List<List<Integer>> getAdjList(List<List<Integer>> connections, int n) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());
        for (int i = 0; i < connections.size(); i++) {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return adjList;
    }
}
