class Solution {
    public String processStr(String s) {
        StringBuilder str = new StringBuilder();
       for(char c : s.toCharArray()) {
        if(c - 'a' >=0 && c - 'a' < 26) {
            str.append(c);
        } else if(c == '*') {
            if(str.length() > 0) str.deleteCharAt(str.length() - 1);
        } else if(c == '#') {
            if(str.length() > 0) str.append(str.toString());
        } else {
            str.reverse();
        }
       }

       return str.toString();
    }
}