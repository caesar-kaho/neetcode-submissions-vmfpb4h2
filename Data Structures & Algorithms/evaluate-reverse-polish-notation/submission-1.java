class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String c: tokens) {
            if (c.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }else if (c.equals("-")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2 - val1);
            }else if (c.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }else if (c.equals("/")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2 / val1);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }

        return stack.pop();
    }
}
