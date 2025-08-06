class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        Queue<int[]> heap = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );

        for (int[] point: points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            heap.offer(new int[]{dist, point[0], point[1]});
        }
        
        while (k>0) {
            int[] point = heap.poll();
            result[k-1][0] = point[1];
            result[k-1][1] = point[2];
            k--;
        }
        return result;

    }
}
