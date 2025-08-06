class KthLargest {
    Queue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);
    int k = 0;
    public KthLargest(int k, int[] nums) {
        for (int num: nums) {
            heap.offer(num);
            if (heap.size() > k)
                heap.poll();
        }
        this.k = k;
    }
    
    public int add(int val) {
        heap.offer(val);
        if (heap.size() > this.k)
            heap.poll();
        return heap.peek();
    }
}

// class IntCompare implements Comparator<Integer> {
//     public int compare(int a, int b) {
//         return b - a;
//     }
// } 

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
