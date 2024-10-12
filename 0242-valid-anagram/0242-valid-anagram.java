class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        if(s.length() != t.length()) {
            return false;
        }
        for(int i = 0; i < s.length(); i++) {
            if(!charCount.containsKey(s.charAt(i))) {
                charCount.put(s.charAt(i), 1);
            } else {
                int count = charCount.get(s.charAt(i));
                count++;
                charCount.put(s.charAt(i), count);
            }
        }

        for(int i = 0; i < t.length(); i++) {
            if(!charCount.containsKey(t.charAt(i))) {
                return false;
            } else {
                int count = charCount.get(t.charAt(i));
                count--;
                if(count == 0) {
                    charCount.remove(t.charAt(i));
                } else {
                    charCount.put(t.charAt(i), count);
                }
            }
        }

        return true;
    }
}