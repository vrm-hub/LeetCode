class Solution {
    private boolean isPalindrome(String s) {
        for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) return false;
        }

        return true;
    }
    public String longestPalindrome(String s) {
        for(int i = s.length(); i > 0; i--) {
            for(int j = 0; j < s.length() - i + 1; j++) {
                String str = s.substring(j, j + i);
                if(isPalindrome(str)) return str;
            }
        }

        return " ";
    }
}
