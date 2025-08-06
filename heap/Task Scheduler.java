class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        Deque<int[]> q = new ArrayDeque<>();
        int[] a = new int[26];
        for (char task : tasks) {
            a[task - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (a[i] > 0)
                heap.offer(a[i]);
        }
        // Start timer.
        int time = 0;
        while (!heap.isEmpty() || !q.isEmpty()) {
            if (!heap.isEmpty()) {
                int m = heap.poll();
                if (m - 1 > 0) {
                    q.add(new int[] { m - 1, time + n });
                }
            }
            while (!q.isEmpty() && q.peek()[1] <= time) {
                heap.offer(q.poll()[0]);
            }
            time += 1;
        }

        return time;
    }
}
