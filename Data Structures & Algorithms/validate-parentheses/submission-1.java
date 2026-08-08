class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If the current character is a closing
            // paranthesis, we check to see if the
            // top element of the stack is the corresponding
            // open paranthesis.
            if (map.containsKey(c)) {
                if (stack.isEmpty() || map.get(c) != stack.peek()){
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
}
