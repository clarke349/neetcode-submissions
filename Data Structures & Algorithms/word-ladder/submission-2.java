class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() != endWord.length()) return 0;
        if (beginWord.equals(endWord)) return 0;
        if (!wordList.contains(endWord)) return 0;

        // ---- Build the graph ----
        // Each word is a node, identified by its index in wordList.
        // adj.get(i) = indexes of all words exactly one letter different from word 
        // i.
        int n = wordList.size();
        int m = endWord.length();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // word -> index, so we can look up a word's node in O(1).
        // Used below to connect beginWord, which may not be in wordList.
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0 ; i < n ; i++) {
            map.put(wordList.get(i), i);
        }

        // Compare every pair of words (j starts at i + 1 so each pair is checked 
        // once).
        // If they differ in exactly one position, add an undirected edge.
        // This is the expensive step: O(n^2 * m).
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = 0; // number of positions where the two words differ
                for (int k = 0; k < m ; k++) {
                    if (wordList.get(i).charAt(k) != wordList.get(j).charAt(k)) {
                        count++;
                    }
                }
                if (count == 1) {
                    adjList.get(i).add(j); // edge in both directions
                    adjList.get(j).add(i);
                }
            }
        }

        // ---- BFS from beginWord ----
        // BFS explores level by level, so the first time we reach endWord
        // is guaranteed to be the shortest transformation sequence.
        Queue<Integer> q = new LinkedList<>();
        int res = 1;                      // length of the sequence so far: just beginWord
        Set<Integer> visit = new HashSet<>(); // nodes already queued; prevents cycles and repeats

        // beginWord might not be in wordList, so it has no node or edges.
        // Instead, find its neighbors directly: try every one-letter change
        // (m positions x 25 other letters) and keep the ones in the dictionary.
        // These are level 1 of the BFS.
        for (int i = 0; i < m; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == beginWord.charAt(i)) {
                    continue; // skip: that's the same word
                }
                String word = beginWord.substring(0, i) + c + beginWord.substring(i + 1);
                if (map.containsKey(word) && !visit.contains(map.get(word))) {
                    q.add(map.get(word));
                    visit.add(map.get(word)); // mark visited when enqueued, not when polled
                }
            }
        }

        while (!q.isEmpty()) {
            res++; // entering a new level: every word in it extends the sequence by one

            // Snapshot the queue size so we process exactly this level;
            // neighbors added during the loop belong to the next level.
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();

                // Reached the target: res counts words in the sequence,
                // including beginWord and endWord.
                if (wordList.get(node).equals(endWord)) {
                    return res;
                }

                // Queue all unvisited one-letter neighbors for the next level.
                for (int nei : adjList.get(node)) {
                    if (!visit.contains(nei)) {
                        visit.add(nei);
                        q.add(nei);
                    }
                }
            }
        }

        // The queue emptied without reaching endWord, so no path exists.
        return 0;

    }
}
