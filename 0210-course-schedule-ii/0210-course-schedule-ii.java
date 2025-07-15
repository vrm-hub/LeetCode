class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> compCourses = new HashSet<>();
    LinkedList<Integer> order = new LinkedList<>();
    private boolean dfs(int crs) {
        if(visited.contains(crs)) return false;

        if(compCourses.contains(crs)) return true;

        visited.add(crs);
        for(int i : map.get(crs)) {
            if(!dfs(i)) return false;
        }
        map.put(crs, new ArrayList<>());
        visited.remove(crs);
        compCourses.add(crs);
        order.add(crs);

        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites) {
            map.get(prereq[0]). add(prereq[1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i)) return new int[0];
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = order.get(i);
        }

        return res;
    }
}
