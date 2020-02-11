package datastructure4;

/**
 * @author: huhao
 * @time: 2020/2/10 16:03
 * @desc: 用数组实现并查集
 */
public class UnionFind1 implements UF{

    /**
     * 用于存放数组中元素所属集合的集合编号
     */
    private int[] id;

    public UnionFind1(int size){
        id = new int[size];

        // 起始所有元素的id都是不一样的
        for(int i=0; i<id.length; i++){
            id[i] = i;
        }
    }

    @Override
    public int getSize(){
        return id.length;
    }

    /**
     * 判断元素p和元素q是否所属一个集合
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p和元素q所属的集合
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {

        int pID = id[p];
        int qID = id[q];

        if(pID == qID){
            return;
        }

        for(int i=0; i<id.length; i++){
            if(id[i] == pID){
                id[i] = qID;
            }
        }
    }

    /**
     * 查找元素p对应的集合编号
     * @param p
     * @return
     */
    public int find(int p){
        if(p < 0 && p >= id.length){
            throw new IllegalArgumentException("P is out of bound.");
        }
        return id[p];
    }

}
