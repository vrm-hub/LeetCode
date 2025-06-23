class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer[]> map = new HashMap<>();
        int i = 0;
        for(Character c : s.toCharArray()) {
            if(map.containsKey(c)) {
                Integer[] r = map.get(c);
                r[0]++;
            } else {
                map.put(c, new Integer[]{1, i});
            }
            i++;
        }

        for(Character c : s.toCharArray()) {
            if(map.get(c)[0] == 1) {
                return map.get(c)[1];
            }
        }

        return -1;


    }
}