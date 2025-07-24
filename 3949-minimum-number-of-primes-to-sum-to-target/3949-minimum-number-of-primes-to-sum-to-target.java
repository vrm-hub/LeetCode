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
        List<Integer> primes = isPrime(m);
        int num = 2;
        dp = new HashMap<>();
        dp.put(0, 0);

        int min = dfs(primes, n);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private List<Integer> isPrime(int n) {
        int limit = (int)(n * (Math.log(n) + Math.log(Math.log(n)))) + 10;
        List<Integer> primes = new ArrayList<>();
        if (n <= 5) {
            limit = 15;
        }

        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for(int i = 2; i <= limit && primes.size() < n; i++) {
            if(isPrime[i]) primes.add(i);
        }

        return primes;
    }
}