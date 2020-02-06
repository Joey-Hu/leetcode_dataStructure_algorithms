package datastructure2;

/**
 * @author: huhao
 * @time: 2020/2/6 15:43
 * @desc:
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
