class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) && dfs(i, j, n, m, word.length(), 0, board, word))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, int n, int m, int len, int curr, char[][] board, String word) {
        if (curr == len) {
            return true;
        }
        if (i < 0 || j < 0 || i >= n || j >= m || board[i][j] != word.charAt(curr) || board[i][j] == '*')
            return false;
        board[i][j] = '*';
        boolean left = dfs(i, j - 1, n, m, len, curr + 1, board, word);
        boolean right = dfs(i, j + 1, n, m, len, curr + 1, board, word);
        boolean top = dfs(i - 1, j, n, m, len, curr + 1, board, word);
        boolean bottom = dfs(i + 1, j, n, m, len, curr + 1, board, word);
        board[i][j] = word.charAt(curr);
        return left || right || top || bottom;
    }
}
