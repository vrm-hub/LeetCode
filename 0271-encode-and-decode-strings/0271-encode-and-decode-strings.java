public class Codec {
    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for(String string : strs) {
            str.append(string.length()).append('#').append(string);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        ArrayList<String> strs = new ArrayList<>();
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int t = Integer.parseInt(str.substring(i, j));
            j++;
            strs.add(str.substring(j, j + t));
            i = j+t;
        }

        return strs;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));