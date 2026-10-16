class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // We first update the current element in our result array
        // with the current running product. Then we update running product
        // by multiplying the current value of nums into it. We do this because
        // we want result[i] to have the product of everything to the left of it, excluding
        // nums[i];
        int product = 1;
        for (int i = 0; i < n; i++) {
            result[i] = product;
            product *= nums[i];
        }

        // We first update the current element in our result array
        // with the current running product. Then we update running product
        // by multiplying the current value of nums into it. We do this because
        // we want result[i] to have the product of everything to the right of it, excluding
        // nums[i];
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= product;
            product *= nums[i];
        }

        return result;
    }
}
