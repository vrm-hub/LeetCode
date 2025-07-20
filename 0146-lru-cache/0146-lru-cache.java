class Node {
    int key, val;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.val = value;
        this.next = this.prev = null;
    }
}

class LRUCache {
    HashMap<Integer, Node> cache;
    Node left;
    Node right;
    int cap;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.cap = capacity;
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void insert(Node n) {
        Node temp = this.right.prev;
        this.right.prev = n;
        n.prev = temp;
        temp.next = n;
        n.next = this.right; 
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node n = cache.get(key);
        remove(n);
        insert(n);

        return n.val;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node n = cache.get(key);
            n.val = value;
            remove(n);
            insert(n);

            return;
        }

        if(cache.size() == this.cap) {
            cache.remove(this.left.next.key);
            remove(this.left.next);
        }

        Node n = new Node(key, value);
        insert(n);
        cache.put(key, n);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */