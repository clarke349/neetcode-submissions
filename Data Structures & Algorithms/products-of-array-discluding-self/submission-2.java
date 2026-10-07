class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixArr = new int[n];
        int[] suffixArr = new int[n];
        int[] result = new int[n];

        // 1. Populate prefix array
        int product = 1;
        for (int i = 0; i < n; i++) {
            product *= nums[i];
            prefixArr[i] = product;
        }

        // 2. Populate suffix array
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            product *= nums[i];
            suffixArr[i] = product;
        }

        // 3. Populate result
        for (int i = 0; i < n; i++) {
            int prefix = 1;
            int suffix = 1;
            if ((i - 1) >= 0) {
                prefix = prefixArr[i - 1];
            }

            if ((i + 1) < n) {
                suffix = suffixArr[i + 1];
            }

            result[i] = prefix * suffix;
        }

        return result;
    }
}  
