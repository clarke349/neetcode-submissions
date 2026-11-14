class RandomizedSet {
    private Map<Integer, Integer> numMap;
    private List<Integer> nums;
    private Random random;

    public RandomizedSet() {
        numMap = new HashMap<>();
        nums = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (numMap.containsKey(val)) return false;
        nums.add(val);
        numMap.put(val, nums.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!numMap.containsKey(val)) return false;
        int index = numMap.get(val);
        int lastNum = nums.get(nums.size() - 1);
        nums.set(index, lastNum);
        numMap.put(lastNum, index);
        nums.remove(nums.size() - 1);
        numMap.remove(val);
        return true;
    }
    
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */