package datastructure3;

/**
 * @author: huhao
 * @time: 2020/2/2 16:20
 * @desc:
 */
public interface Queue<E> {
    void enqueue(E e);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();
}
