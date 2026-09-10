class ListNode {
    int key;
    int value;
    ListNode prev;
    ListNode next;

    ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getKey(){
        return key;
    }
}
class LRUCache {
    HashMap<Integer, ListNode> hm = new HashMap<>();
    ListNode head = new ListNode(0, 0);
    ListNode tail = new ListNode(0, 0);
    int maxCapacity;
    int count = 0;
    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        maxCapacity = capacity;
    }

    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void insertAtMRU(ListNode nn, ListNode tail) {
        tail.prev.next = nn;
        nn.prev = tail.prev;
        nn.next = tail;
        tail.prev = nn;
    }

    public int get(int key) {
        if (hm.containsKey(key)) {
            ListNode ans = hm.get(key);
            remove(ans);
            insertAtMRU(ans, tail);
            return ans.getValue();
        }

        return -1;
    }

    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            ListNode node = hm.get(key);
            node.value = value;
            remove(node);
            insertAtMRU(node, tail);
            return;
        }
        if (hm.size() == maxCapacity) {
            ListNode leastRecentyUsed = head.next;
            remove(leastRecentyUsed);
            hm.remove(leastRecentyUsed.getKey());
        }

        ListNode nn = new ListNode(key, value);
        insertAtMRU(nn, tail);
        hm.put(key, nn);
    }
}
