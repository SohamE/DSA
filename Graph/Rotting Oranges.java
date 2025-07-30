// TC - m * n
class Solution {
    public int orangesRotting(int[][] grid) {
        int good = 0;
        int result = 0;
        int[][] traversal = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Deque<Pair<Integer, Integer>> bfs = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    bfs.add(new Pair<>(i, j));
                }
                if (grid[i][j] == 1) {
                    good++;
                }
            }
        }
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            boolean isFresh = false;
            while (size > 0) {
                Pair<Integer,Integer> a = bfs.poll();
                int currI = a.getKey();
                int currJ = a.getValue();
                for (int i = 0; i < 4; i++) {
                        int newI = traversal[i][0] + currI;
                        int newJ = traversal[i][1] + currJ;
                        if (newI < 0 || newJ < 0 || newI >= n || newJ >= m || grid[newI][newJ] != 1)
                            continue;
                        isFresh = true;
                        grid[newI][newJ] = 2;
                        good--;
                        bfs.add(new Pair<>(newI, newJ));
                }
                size--;
            }
            if (isFresh)
                result++;
        }
        return good == 0 ? result : -1;
    }
}
