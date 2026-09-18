class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();
        dfs(nums, 0, target, sublist, result);
        return result;
    }

    private void dfs(int[] nums, int i, int target, List<Integer> sublist, List<List<Integer>> result) {
        if (i >= nums.length) return;
        int currentSum = getSum(sublist);
        if (currentSum == target && result.indexOf(sublist) == -1) {
            result.add(new ArrayList<>(sublist));
            return;
        }

        if (currentSum < target) {
            // check path with nums[i]
            sublist.add(nums[i]);
            dfs(nums, i, target, sublist, result); // check path where nums[i] is included again
            dfs(nums, i + 1, target, sublist, result); // check path where nums[i + 1] is included
            sublist.remove(sublist.size() - 1);
            
            // check path without nums[i]
            dfs(nums, i + 1, target, sublist, result);
        } else {
            return;
        }
    }

    private int getSum(List<Integer> sublist) {
        int sum = 0;
        for (int num : sublist) {
            sum += num;
        }
        return sum;
    }
}
