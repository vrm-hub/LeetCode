class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder str = new StringBuilder();
        int j = s.length() - 1, i = j - 1;
        while(i > 0) {
            if(s.charAt(i) == ' ') {
                str.append(s.substring(i + 1, j + 1)).append(" ");
                while(s.charAt(i) == ' ') {
                    i--;
                }
                j = i;
                i = j - 1;
            } else {
                i--;
            }
        }

        str.append(s.substring(0, j + 1));

        return str.toString();
    }
}