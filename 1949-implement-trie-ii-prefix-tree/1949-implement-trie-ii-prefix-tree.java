class Node {
    Node[] links;
    int ends;
    int startsWith;

    Node() {
        links = new Node[26];
        ends = 0;
        startsWith = 0;
    }

    boolean containsKey(char c) {
        return (links[c - 'a'] != null);
    }

    Node getNode(char c) {
        return links[c - 'a'];
    }

    void putNode(char c, Node n) {
        links[c - 'a'] = n;
    }

    void increaseEnds() {
        ends++;
    }

    void decreaseEnds() {
        ends--;
    }

    void increaseStartsWith() {
        startsWith++;
    }

    void decreaseStartsWith() {
        startsWith--;
    }

    int getEnds() {
        return ends;
    }

    int getStartsWith() {
        return startsWith;
    }
}
class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;

        for(char c : word.toCharArray()) {
            if(!node.containsKey(c)) {
                node.putNode(c, new Node());
            }

            node = node.getNode(c);
            node.increaseStartsWith();
        }
        node.increaseEnds();
    }
    
    public int countWordsEqualTo(String word) {
        Node node = root;
        for(char c : word.toCharArray()) {
            if(!node.containsKey(c)) {
                return 0;
            }

            node = node.getNode(c);
        }

        return node.getEnds();
    }
    
    public int countWordsStartingWith(String prefix) {
        Node node = root;
        for(char c : prefix.toCharArray()) {
            if(!node.containsKey(c)) {
                return 0;
            }

            node = node.getNode(c);
        }

        return node.getStartsWith();
    }
    
    public void erase(String word) {
        Node node = root;
        for(char c : word.toCharArray()) {
            if(!node.containsKey(c)) {
                return;
            }

            node = node.getNode(c);
            node.decreaseStartsWith();
        }
        
        node.decreaseEnds();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */