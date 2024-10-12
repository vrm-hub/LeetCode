class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char []arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String str = String.valueOf(arr);
            
            if(!map.containsKey(str)) {
                List<String> anagramList = new ArrayList<String>();
                anagramList.add(strs[i]);
                map.put(str, anagramList);
            } else {
                List<String> anagramList = map.get(str);
                anagramList.add(strs[i]);
            }
        }

        List anagrams = new ArrayList<> ();
        for (Map.Entry<String, List<String>> set :
             map.entrySet()) {
                anagrams.add(set.getValue());
             }
        return anagrams;

    }
        
}