class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int l = 1;
        int r = piles[piles.length - 1]; 
        int k = r;
        while(l <= r) {
            int mid = (l + r)/2;
            long t= 0;
            for(int i = 0; i <= piles.length - 1; i++) {
                if(piles[i]%mid != 0) {
                    t = t + piles[i]/mid + 1;
                } else {
                    t = t + piles[i]/mid;
                }
            }

            if(t <= h) {
                    k = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
        }

        return k;
    }
}
