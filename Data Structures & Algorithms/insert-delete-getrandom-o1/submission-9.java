class RandomizedSet {

    Map<Integer, Integer> numMap;
    List<Integer> nums;
    Random random;

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
        int indexOfVal = numMap.get(val);
        int lastNum = nums.get(nums.size() - 1);
        nums.set(indexOfVal, lastNum);
        numMap.put(lastNum, indexOfVal);
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