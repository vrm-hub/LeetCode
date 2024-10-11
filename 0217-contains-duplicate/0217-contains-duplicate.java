class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numList = new HashSet<>();
        for(int i : nums) {
            if(numList.contains(i)) {
                return true;
            }

            numList.add(i);
        }

        return false;
    }
}