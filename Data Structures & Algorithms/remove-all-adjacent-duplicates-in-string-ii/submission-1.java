class Solution {
    // Approach: walk the string while keeping a stack of run lengths.
    // Each stack entry is how long the current run of equal characters is.
    // When a run reaches k, delete it from the string and step back,
    // so the characters on either side of it can merge into a new run.
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s); // editable copy of the string; we delete from it in place
        Deque<Integer> stack = new ArrayDeque<>(); // run lengths, one entry per run, newest on top
        int i = 0; // index of the current character in sb

        while (i < sb.length()) { // sb shrinks as we delete, so check its live length
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                // A different character from the one before it: start a new run of length 1.
                stack.push(1);
            } else {
                // Same character as the one before it: the current run grows by 1.
                stack.push(stack.pop() + 1);
                if (stack.peek() == k) {
                    // The run has reached k: remove it.
                    stack.pop(); // drop its count; the top is now the previous run's count
                    sb.delete(i - k + 1, i + 1); // delete the k characters ending at i (end index is exclusive)
                    i -= k; // move back to just before the deleted run
                    // After i++ below, i points at the character that slid into the gap,
                    // and it gets compared with the character before the deleted run.
                    // If they match, it adds to that earlier run.
                }
            }
            i++;
        }

        return sb.toString();
    }
}