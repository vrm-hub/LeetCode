class Solution {
    private String res = " ";
    private int resLen = 0;
    private void checkPalindrome(String s, int i, int j) {

        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            if(j - i + 1 > resLen) {
                res = s.substring(i, j + 1);
                resLen = j - i + 1;
            }

            i--;
            j++;
        }
    }
    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length(); i++) {
            checkPalindrome(s, i, i);
            checkPalindrome(s, i, i+1);
        }

        return resLen == 0 ? s.substring(0, 1) : res;
    }
}
