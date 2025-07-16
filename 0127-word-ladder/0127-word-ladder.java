class Solution {
    HashMap<String, List<String>> map = new HashMap<>();
    HashSet<String> visited = new HashSet<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int n = wordList.size();
        int m = wordList.get(0).length();
        
        if (!wordList.contains(endWord)) return 0;

        for(int i = 0 ; i < n; i++) {
            map.putIfAbsent(wordList.get(i), new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int cnt = 0;
                for(int k = 0; k < m; k++) {
                    if(wordList.get(i).charAt(k) == wordList.get(j).charAt(k)) continue;
                    cnt++;
                }
                if(cnt == 1) {
                    map.get(wordList.get(i)).add(wordList.get(j));
                    map.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }

        if(map.get(endWord).size() == 0) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int steps = 1;

        while(!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) {
                String word = q.poll();
                if (word.equals(endWord)) return steps;
                for(String w : map.get(word)) {
                    if(!visited.contains(w)) {
                        q.offer(w);
                        visited.add(w);
                    }
                }
            }
            steps++;
        }



        return 0;
    }
}
