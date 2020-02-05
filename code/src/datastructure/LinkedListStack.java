package datastructure;

import java.util.List;

/**
 * @author: huhao
 * @time: 2020/2/3 16:26
 * @desc:
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }


    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("Stack: top ");
        ret.append(list);
        return ret.toString();
    };
}
