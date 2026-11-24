class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;

        while (i < sb.length()) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                stack.push(1);
            } else {
                stack.push(stack.pop() + 1);
                if (stack.peek() == k) {
                    stack.pop();
                    sb.delete(i - k + 1, i + 1);
                    i -= k;
                }
            }
            i++;
        }

        return sb.toString();
    }
}