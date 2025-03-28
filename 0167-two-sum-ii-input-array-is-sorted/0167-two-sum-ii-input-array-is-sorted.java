class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0, j= numbers.length - 1; i < j;) {
            if(numbers[i] + numbers[j] < target) {
                i++;
            } else if(numbers[i] + numbers[j] > target) {
                j--;
            } else {
                return new int[]{i+1, j+1};
            }          
        }
        
        return new int[]{};
    }
}
