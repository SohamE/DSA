class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        n=n+1;
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(new EdgeComparator());
        ArrayList<ArrayList<Pair<Integer, Integer>>> adjList = getAdjList(times, n);
        int[] dist = new int[n];
        for (int i=0;i<n;i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        heap.offer(new Pair<>(k, 0));
        while(!heap.isEmpty()) {
            Pair<Integer, Integer> pick = heap.poll();
            int u = pick.getKey();
            int uw = pick.getValue();

            for (Pair<Integer, Integer> adjNode: adjList.get(u)) {
                if (uw + adjNode.getValue() < dist[adjNode.getKey()]) {
                    dist[adjNode.getKey()] = uw + adjNode.getValue();
                    heap.add(new Pair<>(adjNode.getKey(), dist[adjNode.getKey()]));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i=1; i<n;i++) {
            max = Math.max(max, dist[i]);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }

    public ArrayList<ArrayList<Pair<Integer, Integer>>> getAdjList(int[][] times, int n) {
        ArrayList<ArrayList<Pair<Integer, Integer>>> adjList = new ArrayList<>();
        for (int i=0;i<n;i++) {
            adjList.add(new ArrayList<>());
        }
        for (int time[]: times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            adjList.get(u).add(new Pair<>(v, w));
        }
        return adjList;
    }
}

class EdgeComparator implements Comparator<Pair<Integer, Integer>> {
    public int compare(Pair<Integer, Integer> s1, Pair<Integer, Integer> s2) {
        if (s1.getValue() < s2.getValue())
            return 1;
        else if (s1.getValue() > s2.getValue())
            return -1;
        return 0;
    }

}
