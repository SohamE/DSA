class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adjList = findAdjList(n, flights);
        // Any one of the below works.
        // Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        Deque<int[]> minHeap = new ArrayDeque<>();
        int[] distArr = new int[n];
        Arrays.fill(distArr, Integer.MAX_VALUE);
        distArr[src] = 0;
        minHeap.add(new int[] { 0, src, 0 });
        while (!minHeap.isEmpty()) {
            int[] pick = minHeap.poll();
            int dist = pick[0];
            int node = pick[1];
            int stops = pick[2];
            for (int[] adjNode : adjList.get(node)) {
                if (dist + adjNode[1] < distArr[adjNode[0]] && stops <= k) {
                    distArr[adjNode[0]] = dist + adjNode[1];
                    minHeap.offer(new int[] { distArr[adjNode[0]], adjNode[0], stops + 1 });
                }
            }
        }
        return distArr[dst] == Integer.MAX_VALUE ? -1 : distArr[dst];
    }

    public List<List<int[]>> findAdjList(int n, int[][] flights) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());
        for (int i = 0; i < flights.length; i++) {
            int[] flight = flights[i];
            adjList.get(flight[0]).add(new int[] { flight[1], flight[2] });
        }
        return adjList;
    }
}

// *** we cannot use minheap on distance in this problem as if we can reach the destination by taking large edge with all stops, rather than small edge with less stop.
//     hence we have to use priority queue on steps
//     or we can use a simple array deque as the steps is always increasing order when we add in the minheap
