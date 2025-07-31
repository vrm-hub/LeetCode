class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (a,b) -> a.length() - b.length());
        boolean b = false;
        for(int i = 0, j=strs[0].length() - 1; j >= 0; j--) {
            String str = strs[0].substring(i, j+1);
            for(String s : strs) {
                if(!str.equals(s.substring(i, j + 1))) {
                    b = false;
                    break;
                } else {
                    b = true;
                }
            }
            if(b) return str;
        }

        return "";
    }
}