package datastructure;

/**
 * @author: huhao
 * @time: 2020/2/3 10:58
 * @desc:
 */
public class LinkedList<E> {
    private  class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node dummyHead;    // 虚拟头节点，解决在头节点插入元素的逻辑与在其他位置插入元素逻辑不一致的问题
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在链表的index（0-based）位置添加新的元素e
     * 在链表中不是一个常见操作，练习用:)
     * @param e
     * @param index
     */
    public void add(E e, int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("Add failed cause require pos>=0 and pos<=size.");
        }

        Node prev = dummyHead;
        for(int i=0; i<index ; i++){
            prev = prev.next;
        }

        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;

        size++;
    }

    /**
     * 在链表头添加元素
     * @param e
     */
    public void addFirst(E e){
//        Node newNode = new Node(e);
//        newNode.next =  head;
//        head = newNode;

        add(e, 0);
    }

    /**
     * 在链表末尾添加元素
     * @param e
     */
    public void addLast(E e){
        add(e, size);
    }

    /**
     * 获得链表的第index（0-based）位置元素，并返回值
     * 在链表中不是一个常见操作，练习用:)
     * @param index
     * @return
     */
    public E get(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Get failed cause require pos>=0 and pos<=size.");
        }

        Node cur = dummyHead.next;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }

        return cur.e;
    }

    /**
     * 获取链表的第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取链表的最后一个元素
     * @return
     */
    public E get(){
        return get(getSize()-1);
    }

    /**
     * 修改链表的第index（0-based）位置元素
     * 在链表中不是一个常见操作，练习用:)
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Get failed cause require pos>=0 and pos<=size.");
        }

        Node cur = dummyHead.next;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否存在元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur!=null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除链表的第index（0-based）位置元素，返回删除的元素
     * 在链表中不是一个常见操作，练习用:)
     * @param index
     */
    public E remove(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Remove failed cause require pos>=0 and pos<=size.");
        }
        Node prev = dummyHead.next;
        for(int i=0; i<index-1; i++){
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;

        return retNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while(cur!=null){
            res.append(cur + " -> ");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
