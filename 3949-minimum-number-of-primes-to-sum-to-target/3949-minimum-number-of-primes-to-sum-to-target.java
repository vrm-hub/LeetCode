class Solution {
    private HashMap<Integer, Integer> dp;
    private int dfs(List<Integer> primes, int n) {
        if(dp.containsKey(n)) return dp.get(n);

        int res = Integer.MAX_VALUE;

        for(int prime : primes) {
            if(n - prime < 0) continue;
            int result = dfs(primes, n - prime);
            if(result != Integer.MAX_VALUE) res = Math.min(res, 1 + result);
        }
        dp.put(n, res);

        return res;
    }
    public int minNumberOfPrimes(int n, int m) {
        List<Integer> primes = new ArrayList<>();
        int num = 2;
        dp = new HashMap<>();
        dp.put(0, 0);

        while (primes.size() < m) {
            if (isPrime(num)) {
                primes.add(num);
            }
            num++;
        }

        int min = dfs(primes, n);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}