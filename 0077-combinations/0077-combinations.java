class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k, new ArrayList<>());
        return res;
    }

    void backtrack(int start, int n, int k, List<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);                       // choose
            backtrack(i + 1, n, k, path);      // explore
            path.remove(path.size() - 1);      // un-choose
        }
    }
}