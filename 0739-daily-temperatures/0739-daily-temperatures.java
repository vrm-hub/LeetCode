class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer[]> s = new Stack<>();

        for(int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while(!s.isEmpty() && t > s.peek()[0]) {
                Integer[] temp = s.pop();
                res[temp[1]] = i - temp[1];
            }
            s.push(new Integer[]{t, i});
        }

        return res;
    }
}
