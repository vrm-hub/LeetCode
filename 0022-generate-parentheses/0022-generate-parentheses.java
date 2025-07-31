class Solution {
    List<String> res = new ArrayList<>();
    private void backtracking(int n, int o, int c, String s) {
        if(o + c == 2 * n) {
            res.add(s);
            return;
        }

        if(o < n) backtracking(n, o + 1, c, s + "(");
        if(o != c && c < n) backtracking(n, o, c + 1, s + ")");

    }
    public List<String> generateParenthesis(int n) {
        backtracking(n, 0, 0, "");
        
        return res;
    }
}