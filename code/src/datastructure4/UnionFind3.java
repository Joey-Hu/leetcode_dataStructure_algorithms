package datastructure4;

/**
 * @author: huhao
 * @time: 2020/2/11 10:18
 * @desc: 基于size的优化
 */
public class UnionFind3 implements UF{

    /**
     * parent parent[i]表示元素i的父节点
     * sz sz[i]表示以i为根节点的集合中元素的个数
     */
    private int[] parent;
    private int[] sz;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];

        for(int i=0; i<size; i++){
            parent[i] = i;
            sz[i] = 1;
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

        if(sz[pRoot] < sz[qRoot]){
            parent[pRoot] = qRoot;
            sz[pRoot] += sz[qRoot];
        }else{
            parent[qRoot] = pRoot;
            sz[qRoot] += sz[pRoot];
        }


    }
}
