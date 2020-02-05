package datastructure;

/**
 * @author: huhao
 * @time: 2020/1/30 17:11
 * @desc:
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> ls = new LinkedList<>();
        for(int i=0; i<5; i++){
            ls.addFirst(i);
            System.out.println(ls);
        }
        ls.add(666, 2);
        System.out.println(ls);

        ls.set(1, 555);
        System.out.println(ls);

        ls.remove(1);
        System.out.println(ls);


    }

}
