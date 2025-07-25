class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;

        // Step 1: Build a list of visits
        List<int[]> visits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visits.add(new int[]{timestamp[i], i}); // store timestamp and index
        }

        // Step 2: Sort by timestamp
        visits.sort(Comparator.comparingInt(a -> a[0]));

        // Step 3: Map from user to their visited websites (in timestamp order)
        Map<String, List<String>> userToWebs = new HashMap<>();
        for (int[] visit : visits) {
            String user = username[visit[1]];
            String web = website[visit[1]];
            userToWebs.computeIfAbsent(user, k -> new ArrayList<>()).add(web);
        }

        // Step 4: Count 3-sequences with user sets
        Map<List<String>, Set<String>> patternToUsers = new HashMap<>();

        for (String user : userToWebs.keySet()) {
            List<String> webs = userToWebs.get(user);
            if (webs.size() < 3) continue;

            Set<List<String>> seen = new HashSet<>();

            // All combinations of size 3
            for (int i = 0; i < webs.size(); i++) {
                for (int j = i + 1; j < webs.size(); j++) {
                    for (int k = j + 1; k < webs.size(); k++) {
                        List<String> pattern = Arrays.asList(webs.get(i), webs.get(j), webs.get(k));
                        if (seen.add(pattern)) { // only count once per user
                            patternToUsers.computeIfAbsent(pattern, key -> new HashSet<>()).add(user);
                        }
                    }
                }
            }
        }

        // Step 5: Find the most frequent pattern
        int max = 0;
        List<String> result = new ArrayList<>();

        for (List<String> pattern : patternToUsers.keySet()) {
            int count = patternToUsers.get(pattern).size();
            if (count > max || (count == max && pattern.toString().compareTo(result.toString()) < 0)) {
                max = count;
                result = pattern;
            }
        }

        return result;
    }
}
