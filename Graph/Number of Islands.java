// TC - m * n
class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == '1') {
                    result++;
                    findIslands(grid, i, j);
                }
            }
        }
        return result;
    }

    public void findIslands(char[][] grid, int i, int j) {
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        findIslands(grid, i+1,j);
        findIslands(grid, i,j+1);
        findIslands(grid, i-1,j);
        findIslands(grid, i,j-1);
        return;
    }
}
