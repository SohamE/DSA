class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int[][] visited = new int[row][col];
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[][] traverse = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        minHeap.add(new int[] { 0, 0, 0 });
        int minDist = Integer.MIN_VALUE;
        while (!minHeap.isEmpty()) {
            int[] pick = minHeap.poll();
            minDist = Math.max(minDist, pick[0]);
            int i = pick[1];
            int j = pick[2];
            visited[i][j] = 1;
            if (i == row - 1 && j == col - 1)
                break;
            for (int[] t : traverse) {
                int newI = i + t[0];
                int newJ = j + t[1];
                if (newI < 0 || newJ < 0 || newI >= row || newJ >= col || visited[newI][newJ] == 1)
                    continue;
                int absDist = Math.abs(heights[i][j] - heights[newI][newJ]);
                minHeap.add(new int[] { absDist, newI, newJ });
            }
        }
        return minDist;
    }
}
