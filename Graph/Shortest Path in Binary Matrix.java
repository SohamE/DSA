// Note: Use BFS for shortest path, as DFS will cause TLE due to multiple routes.
//   mark the item visited during enqueue, such that same item does not appear again in the queue

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
            return -1;
        Queue<Pair<Integer, Integer>> bfs = new ArrayDeque<>();
        bfs.add(new Pair<>(0, 0));
        int distance = 0;
        int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 },
                { -1, 1 } };
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            while (size > 0) {
                Pair<Integer, Integer> pick = bfs.poll();
                int i = pick.getKey();
                int j = pick.getValue();
                // DONT DO THIS HERE
                // grid[nI][nJ] = 2;
                if (i == n - 1 && j == m - 1)
                    return distance + 1;
                for (int[] direction : directions) {
                    int nI = direction[0] + i;
                    int nJ = direction[1] + j;
                    if (nI < 0 || nI >= n || nJ < 0 || nJ >= m || grid[nI][nJ] != 0)
                        continue;
                    grid[nI][nJ] = 2;
                    bfs.add(new Pair<>(nI, nJ));
                }
                size--;
            }
            distance++;
        }
        return -1;
    }
}
