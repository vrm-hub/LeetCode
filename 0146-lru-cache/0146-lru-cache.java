class Node {
    int key, value;
    Node next, prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = this.prev = null;
    }
}

class LRUCache {
    private HashMap<Integer, Node> cache;
    private int cap;
    private Node left, right;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.cap = capacity;
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    private void remove(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
    private void insert(Node n){
        n.prev = this.right.prev;
        this.right.prev.next = n;
        this.right.prev = n;
        n.next = this.right;

    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }

        Node n = cache.get(key);
        remove(n);
        insert(n);

        return n.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node n = cache.get(key);
            n.value = value;
            remove(n);
            insert(n);

            return;
        }

        if(cache.size() == cap) {
            cache.remove(this.left.next.key);
            remove(this.left.next);
        }

        Node n = new Node(key, value);
        insert(n);
        cache.put(key, n);
    }
}