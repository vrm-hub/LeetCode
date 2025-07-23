class Solution {
    int res = 0;
    private void checkPalindrome(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            res++;
            i--;
            j++;
        }
    }
    public int countSubstrings(String s) {
        for(int i = 0; i < s.length(); i++) {
            checkPalindrome(s, i, i);
            checkPalindrome(s, i, i+1);
        }

        return res;
    }
}
