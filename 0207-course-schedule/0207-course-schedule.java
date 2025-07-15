class Solution {
    HashMap <Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    private boolean dfs(int crs) {
        if(visited.contains(crs)) {
            return false;
        }
        if(map.get(crs).isEmpty()) return true;

        visited.add(crs);

        for(int i : map.get(crs)) {
            if(!dfs(i)) return false;
        }
        map.put(crs, new ArrayList<>());
        visited.remove(crs);

        return true;
    }
    public boolean canFinish(int numCourses, int[][] prereqs) {
        if(prereqs.length == 0) return true;

        for(int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] prereq : prereqs) {
            map.get(prereq[0]).add(prereq[1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i)) return false;
        }

        return true;
    }
}
