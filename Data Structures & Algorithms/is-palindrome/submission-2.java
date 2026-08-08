class Solution {
    public boolean isPalindrome(String s) {
        String cleanStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int l = 0, r = cleanStr.length() - 1;

        while(l < r) {
            if (cleanStr.charAt(l) != cleanStr.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
