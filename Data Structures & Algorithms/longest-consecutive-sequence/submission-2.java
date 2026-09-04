class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 0) return 0;

        // Create set of unique integers for the array
        Set<Integer> set =new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }
        }

        // find start of each sequence in the array
        List<Integer> starts = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (!set.contains(nums[i] - 1)) {
                starts.add(nums[i]);
            }
        }

        // count length of each seq and update max if necessary
        int result = 0;
        for (int start : starts) {
            int count = 0;
            int current = start;
            while (set.contains(current)){
                count++;
                current++;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
