class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0, j = i; j < s.length(); j++) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                maxLen = Math.max(maxLen, j - i + 1);
                continue;
            }

            while(s.charAt(i) != s.charAt(j)) {
                set.remove(s.charAt(i));
                i++;
            }
            i++;
            set.add(s.charAt(j));
        }

        return maxLen;
    }
}