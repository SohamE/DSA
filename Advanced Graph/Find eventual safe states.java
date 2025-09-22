class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[graph.length];
        // Reverse the edges
        for (int i = 0; i < graph.length; i++)
            adjList.add(new ArrayList<>());
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adjList.get(graph[i][j]).add(i);
            }
        }
        for (int i = 0; i < graph.length; i++)
            for (int adjNode : adjList.get(i))
                inDegree[adjNode]++;
        return topoSort(adjList, inDegree);
    }

    public List<Integer> topoSort(List<List<Integer>> adjList, int[] inDegree) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        int n = adjList.size();
        for (int i = 0; i < n; i++)
            if (inDegree[i] == 0)
                q.add(i);
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for (int adjNode : adjList.get(node)) {
                inDegree[adjNode]--;
                if (inDegree[adjNode] == 0)
                    q.add(adjNode);
            }
        }
        Collections.sort(res);
        return res;
    }
}
