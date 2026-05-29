class Solution {
    public int calPoints(String[] operations) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (String op: operations) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
                res += newTop;
            }else if (op.equals("C")) {
                int top = stack.pop();
                res -= top;
            }else if (op.equals("D")) {
                stack.push(2 * stack.peek());
                res += stack.peek();
            }else {
                stack.push(Integer.parseInt(op));
                res += Integer.parseInt(op);
            }
        }

        return res;
    }
}