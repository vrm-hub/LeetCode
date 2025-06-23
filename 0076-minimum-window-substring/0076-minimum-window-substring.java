class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> tMap = new HashMap<>();
        for(char c : t.toCharArray()) {
                tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int target = tMap.size();
        int counter = 0;

        int begin = 0 , end = 0;
        int minLen = Integer.MAX_VALUE, minStart = 0;;
        HashMap<Character, Integer> sMap = new HashMap<>();
        while(end < s.length()) {
            char c = s.charAt(end);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            if(tMap.containsKey(c)) {
                if(sMap.get(c).intValue() == tMap.get(c).intValue()) {
                    counter++;
                }
            }

            while(begin <= end && counter == target) {
                if(end - begin + 1 < minLen) {
                    minLen = end - begin + 1;
                    minStart = begin;
                }

                char ch = s.charAt(begin);
                sMap.put(ch, sMap.get(ch) - 1);
                if(tMap.containsKey(ch) && sMap.get(ch).intValue() < tMap.get(ch).intValue()) {
                    counter--;
                }
                begin++;
            }
            end++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}