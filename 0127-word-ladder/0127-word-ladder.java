class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        int L = beginWord.length();
        Map<String, List<String>> patternMap = new HashMap<>();

        // Step 1: Build the pattern map
        for (String word : wordList) {
            for (int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + '*' + word.substring(i + 1);
                patternMap.computeIfAbsent(pattern, x -> new ArrayList<>()).add(word);
            }
        }

        // Step 2: BFS
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int steps = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                if (word.equals(endWord)) return steps;

                for (int j = 0; j < L; j++) {
                    String pattern = word.substring(0, j) + '*' + word.substring(j + 1);
                    for (String nei : patternMap.getOrDefault(pattern, new ArrayList<>())) {
                        if (!visited.contains(nei)) {
                            visited.add(nei);
                            q.offer(nei);
                        }
                    }
                }
            }
            steps++;
        }

        return 0;
    }
}