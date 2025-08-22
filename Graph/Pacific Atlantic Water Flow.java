class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        Deque<int[]> bfs = new ArrayDeque<>();

        // Directions: up, down, left, right
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // ---- Atlantic ----
        for (int i = 0; i < m; i++) {
            bfs.add(new int[]{n - 1, i});
            atlantic[n - 1][i] = true;
        }
        for (int i = 0; i < n; i++) {
            bfs.add(new int[]{i, m - 1});
            atlantic[i][m - 1] = true;
        }
        bfsBFS(bfs, heights, atlantic, dirs);

        // ---- Pacific ----
        for (int i = 0; i < m; i++) {
            bfs.add(new int[]{0, i});
            pacific[0][i] = true;
        }
        for (int i = 0; i < n; i++) {
            bfs.add(new int[]{i, 0});
            pacific[i][0] = true;
        }
        bfsBFS(bfs, heights, pacific, dirs);

        // Collect results
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void bfsBFS(Deque<int[]> bfs, int[][] heights, boolean[][] visited, int[][] dirs) {
        int n = heights.length;
        int m = heights[0].length;
        while (!bfs.isEmpty()) {
            int[] pick = bfs.poll();
            int i = pick[0];
            int j = pick[1];
            for (int[] d : dirs) {
                int ni = i + d[0];
                int nj = j + d[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < m
                        && !visited[ni][nj]
                        && heights[ni][nj] >= heights[i][j]) {
                    visited[ni][nj] = true;
                    bfs.add(new int[]{ni, nj});
                }
            }
        }
    }
}
