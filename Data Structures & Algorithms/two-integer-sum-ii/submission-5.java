class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int[] output = new int[2];

        while(l < r) {
            int x = numbers[l], y = numbers[r];
            int sum = x + y;
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else{
                output[0] = l + 1;
                output[1] = r + 1;
                return output;
            }
        }
        return output;
    }
}
