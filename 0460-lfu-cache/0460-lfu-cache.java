class Node {
    int key, val, freq;
    Node prev, next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
    }
}

class DoublyLinkedList {
    Node head, tail;

    DoublyLinkedList() {
        head = new Node(0, 0); // dummy head
        tail = new Node(0, 0); // dummy tail
        head.next = tail;
        tail.prev = head;
    }

    void insert(Node node) {
        // insert before tail
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    boolean isEmpty() {
        return head.next == tail;
    }

    Node removeLRU() {
        Node lru = head.next;
        remove(lru);
        return lru;
    }
}

class LFUCache {
    int cap, minFreq;
    Map<Integer, Node> keyToNode = new HashMap<>();
    Map<Integer, DoublyLinkedList> freqToDLL = new HashMap<>();

    public LFUCache(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) return -1;
        Node node = keyToNode.get(key);
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cap == 0) return;

        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.val = value;
            update(node);
        } else {
            if (keyToNode.size() == cap) {
                // evict LRU from minFreq list
                Node lru = freqToDLL.get(minFreq).removeLRU();
                keyToNode.remove(lru.key);
            }

            Node node = new Node(key, value);
            keyToNode.put(key, node);
            freqToDLL.computeIfAbsent(1, f -> new DoublyLinkedList()).insert(node);
            minFreq = 1;
        }
    }

    private void update(Node node) {
        int oldFreq = node.freq;
        freqToDLL.get(oldFreq).remove(node);
        if (freqToDLL.get(oldFreq).isEmpty() && oldFreq == minFreq) {
            minFreq++;
        }

        node.freq++;
        freqToDLL.computeIfAbsent(node.freq, f -> new DoublyLinkedList()).insert(node);
    }
}

