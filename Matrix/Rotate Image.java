class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // Matrix transpose.
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= i; j--) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        // Reverse each row.
        for (int i=0;i<n;i++) {
            int j=0;
            while (j<m/2) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m-1-j];
                matrix[i][m-1-j] = temp;
                j++;
            }
        }
    }
}
