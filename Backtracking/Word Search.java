class Solution {
    int[][] visited;
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        visited = new int[rows][cols];
        for(int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if (dfs(board, word, i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int len) {
        int rows = board.length;
        int cols = board[0].length;
        if (len == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= rows || j >= cols || board[i][j] != word.charAt(len) || visited[i][j] == 1)
            return false;
        visited[i][j] = 1;
        boolean ret = dfs(board, word, i + 1, j, len + 1) || dfs(board, word, i, j + 1, len + 1)
                || dfs(board, word, i - 1, j, len + 1) || dfs(board, word, i, j - 1, len + 1);
        visited[i][j] = 0;
        return ret;
    }
}
