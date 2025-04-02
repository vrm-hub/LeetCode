class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       // 4(i-1) + j
       int i;
       int j = matrix[0].length - 1;
       int l = 0;
       int r;


       for(i = 0; i < matrix.length; i++) {
        if(target >= matrix[i][0] && target <= matrix[i][j]) {
            while(l <= j){
                int mid = (l + j)/2;
                if(target < matrix[i][mid]) {
                    j = mid - 1;
                } else if(target > matrix[i][mid]) {
                    l = mid + 1;
                } else {
                    return true;
                }
            }
        }
       }

       return false;
    }
}
