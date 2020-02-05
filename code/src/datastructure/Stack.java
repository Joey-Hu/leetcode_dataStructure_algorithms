package datastructure;

/**
 * @author: huhao
 * @time: 2020/2/2 14:27
 * @desc:
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
