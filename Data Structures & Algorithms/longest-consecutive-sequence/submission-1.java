class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int result = 0;

        // Create a set containing the unique intgeres
        // in nums[].
        Set<Integer> set = new HashSet<>();
        for (int i = 0 ; i < nums.length ; i++) {
            set.add(nums[i]);
        }

        // Find starting values of each potential sequence.
        List<Integer> starts = new ArrayList<>();
        for (int num : set) {
            // If there's no number less than the 
            // current num in oiur set, then the current
            // num is the start of a sequence.
            if (!set.contains(num - 1)) {
                starts.add(num);
            }
        }

        // find longest sequence
        for (int num : starts) {
            int count = 0;
            int current = num;
            while(set.contains(current)) {
                count++;
                current++;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
