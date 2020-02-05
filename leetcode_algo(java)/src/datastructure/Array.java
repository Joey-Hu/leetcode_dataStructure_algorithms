package datastructure;


/**
 * @author: huhao
 * @time: 2020/1/30 16:08
 * @desc:
 */
public class Array<E> {
    private E[] data;
    // data 数组的长度
    private int size;

    /**
     * 带参数构造函数
     * @param capacity
     */
    public Array(int capacity) {
        /* java中不支持这样new一个泛型数组
        data = new E[capacity];*/
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 无参数构造函数，默认数组容量是10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中元素的个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向数组末尾添加一个元素
     * @param e
     */
    public void addLast(E e){
        insert(size, e);
    }

    /**
     * 向数组头位置添加一个元素
     * @param e
     */
    public void addFirst(E e){
        insert(0, e);
    }
    /**
     * 向数组指定位置添加元素
     * @param pos
     * @param e
     */
    public void insert(int pos, E e){
        if(size == data.length){
//            throw new IllegalArgumentException("insert failed cause array is full.");
            resize(2*data.length);
        }

        if(pos<0 || pos>size){
            throw new IllegalArgumentException("insert failed cause require pos>=0 and pos<=size.");
        }

        for(int i=size-1; i>=pos; i --){
            data[i+1]=data[i];
        }
        data[pos] = e;
        size ++;
    }

    /**
     * 获取索引为index的数组元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Get failed cause index is illegal.");
        }
        return data[index];
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public E getLast(){
        return this.get(size-1);
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public E getFirst(){
        return get(0);

    }

    /**
     * 修改索引为index的数组元素为e
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Set failed cause index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否包含元素e
     * @param e
     * @return
     */
    public boolean isContain(E e){
        for(int i=0; i<size; i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     *查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     * @param e
     * @return
     */
    public int find(E e){
        for(int i=0; i<size; i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }



    /**
     * 删除指定位置的元素，并返回删除的元素
     * @param index
     */
    public E remove(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("Remove failed cause index is illegal.");
        }
        E temp = data[index];
//        for(int i=index; i<size; i++){
//            data[i]=data[i+1];    会导致访问到最后一个值时，i+1会越界
//        }
        for(int i=index+1; i<size; i++){
            data[i-1] = data[i];
        }
        size --;
        data[size] = null;

        if(size == data.length / 4 && data.length/2 != 0){
            resize(data.length/2);
        }
        return temp;
    }

    /**
     * 删除第一个元素，并返回删除的元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除最后一个元素，并返回删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 删除元素e
     * @param e
     */
    public void removeElement(E e){
        int indexOfE = this.find(e);
        if(indexOfE != -1){
            this.remove(indexOfE);
        }

    }



    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", this.size, this.data.length));
        res.append("[");
        for(int i=0; i<size; i++){
            res.append(data[i]);
            if(i!=size-1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    /**
     * 扩容数组对象
     * @param newCapacity
     */
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i=0; i<size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

}
