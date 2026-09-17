class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int l = 1;
        int r = piles[piles.length - 1];
        int k = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // try this value as a potential k value
            if (finishedEating(mid, h, piles) && mid < k) {
                k = mid;
                // check left half for smaller value of k
                r = mid - 1;
            } else {
                // need a larger value of k, so check right half of range
                l = mid + 1;
            }
        }

        return k;
    }

    private boolean finishedEating(int eatingRate, int h, int[] piles) {
        long hoursPassed = 0;
        for (int i = 0; i < piles.length; i++) {
            int current = piles[i];
            hoursPassed += Math.ceil((double) current / eatingRate);
        }

        return hoursPassed <= h;
    }
}
