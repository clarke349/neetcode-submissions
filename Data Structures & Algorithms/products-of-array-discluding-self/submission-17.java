class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixes = new int[n];
        int[] postfixes = new int[n];
        int[] result = new int[n];

        // populate prefix array
        int product = 1;
        for (int i = 0; i < n; i++) {
            product *= nums[i];
            prefixes[i] = product;
        }

        // populate postfix array
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            product *= nums[i];
            postfixes[i] = product;
        }

        for (int i = 0; i < n; i++) {
            int prefix = 1;
            int postfix = 1;

            if (i > 0) {
                prefix = prefixes[i - 1];
            }
            if ( i < n - 1) {
                postfix = postfixes[i + 1];
            }

            result[i] = prefix * postfix;
        }

        return result;
    }
}  
