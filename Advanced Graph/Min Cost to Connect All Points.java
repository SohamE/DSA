// Prims Algo

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int[] visited = new int[points.length];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        List<List<Integer>> mst = new ArrayList<>();
        q.offer(new int[] { 0, 0, -1 });
        int sum = 0;
        while (!q.isEmpty()) {
            int[] pick = q.poll();
            int wt = pick[0];
            int node = pick[1];
            int parent = pick[2];
            // Check if node is already visited.
            if (visited[node] == 1)
                continue;
            // Add to the mst and add weight to sum.
            sum += pick[0];
            visited[pick[1]] = 1;
            if (pick[0] > 0) {
                mst.add(Arrays.asList(pick[1], pick[2]));
            }
            int[] pointA = points[pick[1]];
            // Mark the node visited.
            // Check the adjacent nodes
            for (int i = 0; i < points.length; i++) {
                if (i == node || visited[i] == 1)
                    continue;
                int[] pointB = points[i];
                int edgeWt = Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
                q.offer(new int[] { edgeWt, i, pick[1] });
            }
        }
        return sum;
    }
}
