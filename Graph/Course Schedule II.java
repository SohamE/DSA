class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inOrder = new int[numCourses];
        List<List<Integer>> adj = getAdjacencyList(numCourses, prerequisites);
        Deque<Integer> bfs = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        int[] res = new int[numCourses];
        for (List<Integer> adjNode : adj)
            for (int node : adjNode)
                inOrder[node]++;
        for (int i = 0; i < numCourses; i++) {
            if (inOrder[i] == 0)
                bfs.add(i);
        }
        while (!bfs.isEmpty()) {
            int pick = bfs.poll();
            result.add(pick);
            List<Integer> nodes = adj.get(pick);
            for (int node : nodes) {
                inOrder[node]--;
                if (inOrder[node] == 0)
                    bfs.add(node);
            }
        }
        if (result.size() < numCourses)
            return new int[0];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(result.size() - i - 1);
        }
        return res;

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
