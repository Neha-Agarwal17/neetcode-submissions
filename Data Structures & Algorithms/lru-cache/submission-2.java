class LRUCache {

    class Node
    {
        int key,val;
        Node next, prev;
        Node(int k, int v)
        {
            this.key=k;
            this.val=v;
        }
    }
    Node head,tail;
    int capacity;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
    this.capacity=capacity;
    map = new HashMap<>();
    head = new Node(0,0);
    tail = new Node(0,0);
    head.next = tail;
    tail.prev = head;
    }

    public void addNode(Node newNode)
    {
        Node oldNext = head.next;
        head.next = newNode;
        oldNext.prev = newNode;
        newNode.next = oldNext;
        newNode.prev = head;
        map.put(newNode.key, newNode);
    }

    public void deleteNode(Node oldNode)
    {
        Node oldPrev = oldNode.prev;
        Node oldNext = oldNode.next;
        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
        map.remove(oldNode.key);
        oldNode = null;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
        Node getNode = map.get(key);
        deleteNode(getNode);
        addNode(getNode);
        return getNode.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            deleteNode(map.get(key));
        }
        if(map.size() >= capacity)
        {
            deleteNode(tail.prev);
        }
        Node newNode=new Node(key,value);
        addNode(newNode);
    }
}
