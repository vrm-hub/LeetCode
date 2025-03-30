class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l = 0;
        int length = 0;
        int maxF = 0;

        for(int r = 0; r < s.length(); r++){
            freq[s.charAt(r) - 'A']++;
            maxF = Math.max(maxF, freq[s.charAt(r) - 'A']);

            while((r - l + 1) - maxF > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            length = Math.max(length, r - l + 1);
        }

        return length;
        
    }
}