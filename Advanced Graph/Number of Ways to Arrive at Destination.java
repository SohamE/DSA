class Solution {
    public int countPaths(int n, int[][] roads) {
        int[] ways = new int[n];
        long[] distArr = new long[n];
        int mod = (int)(1e9 + 7);
        Arrays.fill(distArr, Long.MAX_VALUE);
        Queue<long[]> minHeap = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        List<List<int[]>> adjList = findAdjacencyList(n, roads);
        minHeap.offer(new long[] { 0, 0 });
        distArr[0] = 0;
        ways[0] = 1;
        while (!minHeap.isEmpty()) {
            long[] pick = minHeap.poll();
            long dist = pick[0];
            int node = (int)pick[1];
            for (int[] adjNode : adjList.get(node)) {
                if (dist + adjNode[0] == distArr[adjNode[1]])
                    ways[adjNode[1]] = (ways[adjNode[1]] + ways[node]) % mod;
                if (dist + adjNode[0] < distArr[adjNode[1]]) {
                    distArr[adjNode[1]] = dist + adjNode[0];
                    ways[adjNode[1]] = ways[node];
                    minHeap.offer(new long[] { distArr[adjNode[1]], adjNode[1] });
                }
            }
        }
        return ways[n - 1] % mod;
    }

    public List<List<int[]>> findAdjacencyList(int n, int[][] roads) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());
        for (int i = 0; i < roads.length; i++) {
            int[] road = roads[i];
            adjList.get(road[0]).add(new int[] { road[2], road[1] });
            adjList.get(road[1]).add(new int[] { road[2], road[0] });
        }
        return adjList;
    }
}
