package datastructure;

/**
 * @author: huhao
 * @time: 2020/2/3 9:58
 * @desc:
 */
public class LoopQueue<E> implements Queue<E>{
    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }


    @Override
    public void enqueue(E e) {
        if((tail+1)%data.length == front){
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity + 1];
        for(int i=0; i<size; i++){
            newData[i] = data[(i+front)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Dequeue failed cause loopQueue is Empty.");
        }
        E result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity() / 4 && getCapacity()/2 != 0){
            resize(getCapacity() / 2);
        }
        return result;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("GetFront failed cause loopQueue is Empty.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", this.size, getCapacity()));
        res.append("front [");
        for(int i=front; i!= tail; i = (i + 1)% data.length){
            res.append(data[i]);
            if((i+1) % data.length != tail){
                res.append(", ");
            }
        }
//        for(int i = 0; i < (tail + data.length - front) % data.length; i ++){
//            res.append(data[i]);
//            if(i != (tail + data.length - front) % data.length){
//                res.append(", ");
//            }
//        }
        res.append("] tail");
        return res.toString();
    }

}
