class MyHashMap {
    Node[] nodes = new Node[10000];
    /** Initialize your data structure here. */
    public MyHashMap() {}
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = key % nodes.length;
        if(nodes[i] == null){
            nodes[i] = new Node(-1, -1);
        }
        Node prev = find(nodes[i], key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
    }
    
    public Node find(Node node, int key){
        Node n = node;
        Node prev = null;
        while(n != null && n.key != key){
            prev = n;
            n = n.next;
        }
        return prev;
    }
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = key % nodes.length;
        if(nodes[i] == null){
            return -1;
        } else {
            Node prev = find(nodes[i], key);
            return prev.next == null ? -1 : prev.next.val;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = key % nodes.length;
        if(nodes[i] == null){
            return;
        }
        Node prev = find(nodes[i], key);
        if(prev.next == null){
            return;
        }
        prev.next = prev.next.next;
    }
    
    public class Node {
        int key;
        int val;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
