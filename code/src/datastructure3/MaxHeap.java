package datastructure3;

import java.util.Random;

/**
 * @author: huhao
 * @time: 2020/2/8 9:56
 * @desc: 利用动态数组实现最大堆
 *        最大堆性质：父亲节点大于两个子结点
 *
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    /**
     * 将一个数组构造成最大堆形式：
     * 1. 将数组中的元素逐个插入到空堆中 -- O(nlogn)
     * 2. Heapify过程：将数组看成一个完全二叉树，逐个对最后一个非叶子节点进行下沉操作 -- O(n)
     * @param arr
     */
    public MaxHeap(int[] arr){
        data = new Array<>();
        for(int i = parent(arr.length - 1); i >= 0; i--){
            siftDown(i);
        }
    }

    /**
     * 返回堆的元素个数
     * @return
     */
    public int size(){
        return data.getSize();
    }

    /**
     * 判断堆是否为空
     * @return
     */
    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所代表的的元素的父节点的索引
     * @param index
     * @return
     */
    private int parent(int index){
        if(index == 0){
            throw  new IllegalArgumentException("Index-0 doesn't have parent.");
        }

        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所代表的的元素的左孩子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index){
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所代表的的元素的左孩子节点的索引
     * @param index
     * @return
     */
    private int rightChild(int index){
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     * 先将元素添加到数组的末尾，再将添加的元素与其完全二叉树中的父节点相比较，
     * 判断是否交换元素
     * @param e
     */
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k){
        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 查看堆中的最大元素
     * @return
     */
    public E findMax(){
        if(data.getSize() == 0){
            throw new IllegalArgumentException("Can not find max cause heap is Empty.");
        }

        return data.get(0);
    }

    /**
     * 取出堆中的最大元素
     * 取出堆顶根节点之后，需要将其两个子树合并，做法如下:
     * 先将堆中最后一个元素与根节点交换，数组长度减一，然后将先堆顶元素与其两个子结点比较，取出最大子结点交换，
     * 迭代进行直到满足堆中所有父节点都大于子结点
     * @return
     */
    public E extractMax(){
        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    private void siftDown(int k){
        // 当k节点不是子结点时(有左孩子)
        while(leftChild(k) < data.getSize()){
            int j = leftChild(k);
            // k节点有右孩子并且右孩子大于左孩子
            if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0){
                j = rightChild(k);
            }
            if(data.get(k).compareTo(data.get(j)) >= 0){
                break;
            }

            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 取出堆中最大的元素，并且替换成e
     * @param e
     * @return
     */
    public E replace(E e){

        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    public static void main(String[] args) {
        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
        Random random = new Random();

        for(int i=0; i<n; i++){
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = maxHeap.extractMax();
        }

        for(int i=1; i<n; i++){
            if(arr[i-1] < arr[i]){
                throw new IllegalArgumentException("ERROR.");
            }
        }

        System.out.println("Test MaxHeap complete.");
    }
}
