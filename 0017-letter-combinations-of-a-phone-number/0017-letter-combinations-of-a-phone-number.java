class Solution {
    List<String> res;
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    private void dfs(String digits, int i, String s) {
        if(i >= digits.length()) {
            res.add(s);
            return;
        }

        int num = Character.getNumericValue(digits.charAt(i));
        for(int j = 0; j < digitToChar[num].length(); j++) {
            dfs(digits, i+1, s + digitToChar[num].substring(j, j+1));
        }
    }

    public List<String> letterCombinations(String digits) {
        res= new ArrayList<>();
        if (digits.isEmpty()) return res;
        dfs(digits, 0, "");

        return res;
    }
}
