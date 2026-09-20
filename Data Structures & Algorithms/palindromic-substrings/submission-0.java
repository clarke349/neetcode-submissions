class Solution {
    // A substring is palindromic if:
    // 1. The end characters match: s[i] == s[j].
    // 2. The inside substring s[i+1..j-1] is also a palindrome.
    // 
    // Therefore, istead of re-checking characters each time, we
    // use previous results. 
    // Algorithm:
    // 1. We will store whether a substring is palindromic in a DP table
    // 2. Build solutions for longer substrings using shorter ones.
    public int countSubstrings(String s) {
        int palindromeCount = 0;
        int n = s.length();

        // 1. Create a 2D table dp[i][j].
        // dp[i][j] = true if substring s[i..j] is a palindrome.
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 2 || dp[i + 1][j - 1])) {

                    dp[i][j] = true;
                    palindromeCount++;
                }
            }
        }

    return palindromeCount;
    }
}
