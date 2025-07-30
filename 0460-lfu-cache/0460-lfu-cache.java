class Node {
    int val, key;
    Node next;
    Node prev;
    int freq;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
        this.next = this.prev = null;
    }

    public int getFreq() {
        return this.freq;
    }
}

class DoublyLinkedList {
    Node head, tail;

    public DoublyLinkedList() {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    void insert(Node n) {
        n.prev = this.tail.prev;
        n.prev.next = n;
        this.tail.prev = n;
        n.next = this.tail;
    }

    void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    boolean isEmpty() {
        return this.head.next == this.tail;
    }

    Node removeLRU() {
        Node lru = head.next;
        remove(lru);
        return lru;
    }
}


class LFUCache {
    Map<Integer, DoublyLinkedList> dllMap = new HashMap<>();
    int minFreq, cap;
    Map<Integer, Node> keyToNode = new HashMap<>();

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.minFreq = 0;
    }
    
    public int get(int key) {
        if(!keyToNode.containsKey(key)) return -1;
        Node n = keyToNode.get(key);
        update(n);
        
        return n.val;
    }
    
    public void put(int key, int value) {
        if(keyToNode.containsKey(key)) {
            Node n = keyToNode.get(key);
            n.val = value;
            update(n);

            return;
        }

        if(keyToNode.size() == cap) {
            Node lru = dllMap.get(minFreq).removeLRU();
            keyToNode.remove(lru.key);
        }

        Node n = new Node(key, value);
        keyToNode.put(key, n);
        minFreq = 1;
        dllMap.computeIfAbsent(minFreq, k -> new DoublyLinkedList()).insert(n);
    }

    private void update(Node n) {
        int freq = n.getFreq();
        DoublyLinkedList dll = dllMap.get(freq);
        dll.remove(n);
        if(freq == minFreq && dll.isEmpty()) {
                minFreq++;
        }

        n.freq = freq + 1;
        dllMap.computeIfAbsent(n.freq, k -> new DoublyLinkedList()).insert(n);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */