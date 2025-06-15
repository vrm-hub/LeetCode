class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }

        int y = x;
        int temp = 0;
        while(y > 0) {
            temp = temp * 10;
            temp = temp + y % 10;
            y = y / 10;
        }

        if(x == temp) {
            return true;
        }

        return false;
    }
}