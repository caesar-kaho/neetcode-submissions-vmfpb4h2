class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> combo = new HashMap<>();
        combo.put(']' , '[');
        combo.put('}' , '{');
        combo.put(')' , '(');

        Stack<Character> stack = new Stack<>();

        if (s.length() % 2 != 0) {
            return false;
        }

        for (char c: s.toCharArray()) {
            if (combo.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != combo.get(c)) {
                    return false;
                }
            }else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
