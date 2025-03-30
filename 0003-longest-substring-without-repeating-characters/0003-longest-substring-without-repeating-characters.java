class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int i = 0;
        String subStr = "";

        for(int j = 0; j < s.length(); j++) {
            int index = subStr.indexOf(s.charAt(j));
            if(index != -1) {
                i = i + index + 1;
            }
            subStr = s.substring(i, j + 1);
            l = Math.max(l , subStr.length());
        }

        return l;
    }
}