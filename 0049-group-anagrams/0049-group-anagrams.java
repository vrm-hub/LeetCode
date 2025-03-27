class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);
            if(!map.containsKey(str)) {
                map.put(str, new ArrayList<>(Arrays.asList(strs[i])));
            } else {
                List<String> list = map.get(str);
                list.add(strs[i]);
                map.put(str, list);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
        
    }
}