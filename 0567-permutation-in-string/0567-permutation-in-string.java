class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        if(k > s2.length()) {
            return false;
        }

        for(int i = 0; i < k; i++) {
            freq1[s1.charAt(i) - 'a']++;
        }
        int l = 0;
        int length = 0;
        for(int r = 0; r < s2.length(); r++) {
            freq2[s2.charAt(r) - 'a']++;
            
            if(freq2[s2.charAt(r) - 'a'] > freq1[s2.charAt(r) - 'a']) {
                while(freq2[s2.charAt(r) - 'a'] > freq1[s2.charAt(r) - 'a']) {
                    freq2[s2.charAt(l) - 'a']--;
                    l++;                    
                }
            }

            if(r-l+1 == k) {
                return true;
            }
        }

        return false;
    }
}