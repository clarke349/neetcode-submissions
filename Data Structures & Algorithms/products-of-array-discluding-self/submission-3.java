class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // 1. Define prefix array
        int[] prefixArr = new int[n];
        int product = 1;
        for(int i = 0; i < n; i++) {
            product *= nums[i];
            prefixArr[i] = product;
        }

        // 2. Define postfix array
        int[] postfixArr = new int[n];
        product = 1;
        for(int i = n - 1; i >= 0; i--) {
            product *= nums[i];
            postfixArr[i] = product;
        }

        // 3. Find result
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int prefix = 1;
            int postfix = 1;

            if (i > 0) {
                prefix = prefixArr[i - 1];
            }
            if (i < n - 1) {
                postfix = postfixArr[i + 1];
            }

            result[i] = prefix * postfix;
        }

        return result;
    }
}  
