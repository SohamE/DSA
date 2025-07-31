class Solution {
    public void solve(char[][] grid) {
        Deque<Pair<Integer, Integer>> bfs = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i=0;i<n;i++) {
            if (grid[i][0] == 'O') {
                grid[i][0] = 'A';
                bfs.add(new Pair<>(i,0));
            }
            if (grid[i][m - 1] == 'O') {
                grid[i][m - 1] = 'A';
                bfs.add(new Pair<>(i, m-1));
            }
        }
        for (int i=0;i<m;i++) {
            if (grid[0][i] == 'O') {
                grid[0][i] = 'A';
                bfs.add(new Pair<>(0, i));
            }
            if (grid[n - 1][i] == 'O') {
                grid[n - 1][i] = 'A';
                bfs.add(new Pair<>(n-1,i));
            }
        }
        edgeRegion(bfs, grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'A')
                    grid[i][j] = 'O';
                else if (grid[i][j] == 'O') 
                    grid[i][j] = 'X';
            }
        }
    }

    public void edgeRegion(Deque<Pair<Integer, Integer>> bfs, char[][] grid) {
        int[][] traversal = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        while (!bfs.isEmpty()) {
            Pair<Integer, Integer> pick = bfs.poll();
            int pickedI = pick.getKey();
            int pickedJ = pick.getValue();
            for (int[] t: traversal) {
                int i = t[0] + pickedI;
                int j = t[1] + pickedJ;
                if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 'X' || grid[i][j] == 'A')
                    continue;
                grid[i][j] = 'A';
                bfs.add(new Pair<>(i, j));
            }
        }
    }
}
