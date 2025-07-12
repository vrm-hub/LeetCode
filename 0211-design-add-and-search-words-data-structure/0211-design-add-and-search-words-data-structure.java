class Node {
    Node[] links;
    boolean end;

    Node() {
        links = new Node[26];
        end = false;
    }

    boolean containsKey(char c) {
        return (links[c - 'a'] != null);
    }

    Node getNode(char c) {
        return links[c - 'a'];
    }

    Node getNode(int i) {
        return links[i];
    }

    void putNode(char c, Node n) {
        links[c - 'a'] = n;
    }

    void setEnd() {
        end = true;
    }

    boolean isEnd() {
        return end;
    }
}
class WordDictionary {

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node n = root;
        for(char c : word.toCharArray()) {
            if(!n.containsKey(c)) {
                n.putNode(c, new Node());
            }

            n = n.getNode(c);
        }

        n.setEnd();
    }

    private boolean checkNext(Node n, int i, String word) {
        if(i == word.length()) {
            return n.isEnd();
        }

        if(word.charAt(i) == '.') {
            for(int j = 0; j < 26; j++) {
                if(n.getNode(j) == null) {
                    continue;
                }

                if(checkNext(n.getNode(j), i+1, word)) {
                    return true;
                } 
            }
            return false;
        } else {
            if(!n.containsKey(word.charAt(i))) return false;
            return checkNext(n.getNode(word.charAt(i)), i+1, word);
        }
    }

    public boolean search(String word) {
        Node n = root;
        return checkNext(n, 0, word);
    }
}
