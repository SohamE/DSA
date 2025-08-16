class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+": {
                    stack.add(stack.pop() + stack.pop());
                    break;
                }
                case "-": {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.add(b - a);
                    break;
                }
                case "*": {
                    stack.add(stack.pop() * stack.pop());
                    break;
                }
                case "/": {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.add(b / a);
                    break;
                }
                default: {
                    stack.add(Integer.parseInt(token));
                }
            }
        }
        return stack.pop();
    }
}
