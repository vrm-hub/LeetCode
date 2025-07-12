class TrieNode {
    TrieNode[] links;
    boolean ends;

    public TrieNode() {
        links = new TrieNode[26];
        ends = false;
    }

    boolean containsKey(char c) {
        return (links[c - 'a'] != null);
    }

    TrieNode getLinks(char c) {
        return links[c - 'a'];
    }

    void putLinks(char c, TrieNode node) {
        links[c - 'a'] = node;
    }

    void setEnd() {
        ends = true;
    }

    boolean isEnd() {
        return ends;
    }
}
class Trie {
    TrieNode root;

    public Trie() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            if(!node.containsKey(c)) {
                node.putLinks(c, new TrieNode());
            }
            node = node.getLinks(c);
        }

        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            if(!node.containsKey(c)) {
                return false;
            }

            node = node.getLinks(c);
        }

        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()) {
            if(!node.containsKey(c)) {
                return false;
            }

            node = node.getLinks(c);
        }

        return true;
    }
}
