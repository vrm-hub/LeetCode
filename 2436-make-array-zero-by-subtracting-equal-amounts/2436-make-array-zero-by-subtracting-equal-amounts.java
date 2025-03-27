class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
            }
        if(hashSet.contains(0)) {
            hashSet.remove(0);
        }

        return hashSet.size();
        
    }
}