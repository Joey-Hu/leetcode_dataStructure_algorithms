package datastructure4;

/**
 * @author: huhao
 * @time: 2020/2/11 9:59
 * @desc: 使用子结点指向父节点的树结构来实现并查集
 */
public class UnionFind2 implements UF{

    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];
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

        parent[pRoot] = qRoot;

    }
}
