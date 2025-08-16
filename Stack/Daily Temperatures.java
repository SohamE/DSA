class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] res = new int[t.length];

        for (int i=0; i<t.length;i++) {
            stack.add(i);

            while (!stack.isEmpty() && i+1 < t.length && t[i+1] > t[stack.peek()]) {
                int lastIndex = stack.pop();
                res[lastIndex] = i + 1 - lastIndex;
            }
        }
        
        return res;
    }
}
