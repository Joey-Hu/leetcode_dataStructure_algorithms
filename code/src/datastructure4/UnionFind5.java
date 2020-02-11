package datastructure4;

/**
 * @author: huhao
 * @time: 2020/2/11 10:52
 * @desc: 路径压缩
 */
public class UnionFind5 implements UF {
    /**
     * parent parent[i]表示元素i的父节点
     * rank 此时的rank[i]不再表示以元素i为根节点的树的高度，不再维护
     */
    private int[] parent;
    private int[] rank;

    public UnionFind5(int size) {
        parent = new int[size];
        rank = new int[size];

        for(int i=0; i<size; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    /**
     * 查找过程，查找元素p所对应的集合编号
     * 复杂度O(h)，h为树的高度
     * @param p
     * @return
     */
    public int find(int p){
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }


    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查看元素p和元素q是否所属一个集合
     * 复杂度O(h)，h为树的高度
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
     * 复杂度O(h)，h为树的高度
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot){
            return;
        }

        if(rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }else if(rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        }else {
            parent[qRoot] = pRoot;
            rank[pRoot]++;
        }


    }
}
