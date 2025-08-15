class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair<Integer, Integer>>> adjList = getAdjList(flights, n);
        // We are not taking priority queue based on distance, because we are using min heap on stops. As every time stops increases by 1, the queue is already a min heap of stops.
        Deque<int[]> minHeap = new ArrayDeque<>();
        int[] distArr = new int[n];
        Arrays.fill(distArr, Integer.MAX_VALUE);
        // Initializing the start
        distArr[src] = 0;
        minHeap.offer(new int[] { 0, src, 0 });
        while (!minHeap.isEmpty()) {
            int[] pick = minHeap.poll();
            int dist = pick[0];
            int node = pick[1];
            int stops = pick[2];
            for (Pair<Integer, Integer> adjNode : adjList.get(node)) {
                int key = adjNode.getKey();
                int value = adjNode.getValue();
                if (dist + value < distArr[key] && stops <= k) {
                    distArr[key] = dist + value;
                    minHeap.offer(new int[] { distArr[key], key, stops + 1 });
                }

            }
        }
        return distArr[dst] == Integer.MAX_VALUE ? -1 : distArr[dst];

    }

    public List getAdjList(int[][] flights, int n) {
        List<List<Pair<Integer, Integer>>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int price = flights[i][2];
            adjList.get(src).add(new Pair<>(dest, price));
        }

        return adjList;
    }
}
