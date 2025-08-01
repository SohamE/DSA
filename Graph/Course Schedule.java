class Solution {
    boolean result = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        int[] pathVisited = new int[numCourses];
        List<List<Integer>> adj = getAdjacencyList(numCourses, prerequisites);
        boolean res = true;
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                pathVisited[i] = 1;
                dfs(visited, pathVisited, adj, i);
                pathVisited[i] = 0;
            }
        }
        return result;
    }

    public void dfs(int[] visited, int[] pathVisited, List<List<Integer>> adj, int node) {
        List<Integer> adjNodes = adj.get(node);
        for (int adjNode : adjNodes) {
            if (visited[adjNode] == 1 && pathVisited[adjNode] == 1) {
                result = false;
            }
            if (visited[adjNode] == 1)
                continue;
            visited[adjNode] = 1;
            pathVisited[adjNode] = 1;
            dfs(visited, pathVisited, adj, adjNode);
            pathVisited[adjNode] = 0;
        }
        return;
    }

    public List<List<Integer>> getAdjacencyList(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] p : prerequisites)
            adj.get(p[0]).add(p[1]);
        return adj;
    }

}
