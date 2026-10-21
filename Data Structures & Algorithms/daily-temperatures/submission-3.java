class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] output = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++){
            int current = temperatures[i];
            int count = 0;
            int j = i + 1;
            int temp = current;
            while (j < temperatures.length&& temp <= current){
                temp = temperatures[j];
                count++;
                if (temp > current) {
                    output[i] = count;
                    count = 0;
                } 
                j++;
            }
        }
        return output;
    }
}
