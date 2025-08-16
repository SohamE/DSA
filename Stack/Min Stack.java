class MinStack {
    private Stack<Pair<Integer, Integer>> store;
    public MinStack() {
        store = new Stack<>();
    }

    public void push(int val) {
        if (!this.store.isEmpty()) {
            Pair<Integer, Integer> lastElement = this.store.peek();
            this.store.add(new Pair<>(val, Math.min(val, lastElement.getValue())));
        } else {
            this.store.add(new Pair<>(val, Math.min(val, Integer.MAX_VALUE)));
        }

    }

    public void pop() {
        Pair<Integer, Integer> lastElement = this.store.pop();
    }

    public int top() {
        Pair<Integer, Integer> lastElement = this.store.peek();
        return lastElement.getKey();
    }

    public int getMin() {
        Pair<Integer, Integer> lastElement = this.store.peek();
        return lastElement.getValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
