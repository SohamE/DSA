class Solution {
    public void setZeroes(int[][] m) {
        int n = m.length;
        int k = m[0].length;
        int row0 = 1;
      // use m[0][i] and m[j][0] to store the 0s with one buffer row0.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (m[i][j] == 0) {
                    if (i == 0) {
                        row0 = 0;
                    } else {
                        m[i][0] = 0;
                    }
                    m[0][j] = 0;
                }
            }
        }
        // mark rest matrix zero expect first row and coloum. If not there is a possibility all data will be zero.
        for (int i=1;i<n;i++) {
            for (int j=1;j<k;j++) {
                if (m[0][j] == 0 || m[i][0] == 0)
                    m[i][j] = 0;
            }
        }
        // then mark the first row and column.
        for (int i=0;i<n;i++) {
            if (m[0][0] == 0) {
                m[i][0] = 0;
            }
        }
        for (int j=0;j<k;j++) {
            if (row0 == 0) {
                m[0][j] = 0;
            }
        }
    }
}
