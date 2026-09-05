class Solution {
    public boolean isPalindrome(String s) {
        String cleanStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int l = 0;
        int r = cleanStr.length() - 1;
        while (l < r) {
            char a = cleanStr.charAt(l);
            char b = cleanStr.charAt(r);
            if (a != b) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
