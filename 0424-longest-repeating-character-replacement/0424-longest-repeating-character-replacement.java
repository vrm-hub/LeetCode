class Solution {
    public int characterReplacement(String s, int k) {
        HashMap <Character, Integer> map = new HashMap<Character, Integer>();
        int l = 0;
        int length = 0;
        int maxF = 0;

        for(int r = 0; r < s.length(); r++){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(maxF, map.get(s.charAt(r)));

            while((r - l + 1) - maxF > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            length = Math.max(length, r - l + 1);
        }

        return length;
        
    }
}
