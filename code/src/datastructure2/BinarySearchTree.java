package datastructure2;


import datastructure.Array;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.nio.file.Path;
import java.util.*;

/**
 * @author: huhao
 * @time: 2020/2/4 11:32
 * @desc:
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left;
        public Node right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向BST中添加一个新的元素
     * @param e
     */
    public void add(E e){
//        if(root == null){
//            root = new Node(e);
//            size ++;
//        }else{
//            add(root, e);
//        }
        root = add(root, e);
    }

//    /**
//     * 向以node为根节点的BST中插入元素e，递归算法
//     * @param node
//     * @param e
//     */
//    private void add(Node node, E e){
//        // 递归终止条件
//        if(e.equals(node.e)){
//            return;
//        }else if(e.compareTo(node.e) < 0 && node.left == null){
//            node.left = new Node(e);
//            size++;
//            return;
//        }else if(e.compareTo(node.e) > 0 && node.right == null){
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if(e.compareTo(node.e) < 0){
//            add(node.left, e);
//        }else{
//            add(node.right, e);
//        }
//    }

    /**
     * 向以node为根节点的BST中插入元素e，递归算法
     * 返回插入新节点后二分搜索树的根
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node, E e){
        if(node == null){
            size ++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 查看当前BST中是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root, e);
    }

    /**
     * 查找以node为根节点的BST中是否包含元素e,递归算法
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e){
        if(root == null){
            return false;
        }

        if(e.compareTo(node.e) == 0){
            return true;
        }else if(e.compareTo(node.e) < 0){
            return contains(node.left, e);
        }else{
            return contains(node.right, e);
        }
    }

    /**
     * 先序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * 先序遍历以node为根的BST，递归算法
     * @param node
     */
    private void preOrder(Node node){
        if(node == null){
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * BST的非递归前序遍历
     * 采用栈这一种数据结构来辅助实现，先将根节点入栈，当栈不为空时，弹出栈顶元素；
     * 当当前节点右子树不为空时，入栈；然后判断左子树不为空时，入栈
     */
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }

    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的BST，递归算法
     * @param node
     */
    private void inOrder(Node node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * BST的非递归中序遍历
     */
    public void inOrderNR(){
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.pop();
                System.out.println(cur.e);
                cur = cur.right;
            }
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * 后序遍历以node为根的BST，递归算法
     * @param node
     */
    private void postOrder(Node node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * BST的非递归后序遍历
     */
    public void postOrderNR(){
        Stack<Node> stack = new Stack<>();
        //辅助栈，用来判断子节点返回父节点时处于左节点还是右节点
        Stack<Integer> stack2 = new Stack<>();
        //在辅助栈里表示左节点
        int left = 1;
        //在辅助栈里表示右节点
        int right = 2;

        Node cur = root;

        while(cur != null || !stack.isEmpty()){
            while (cur != null){
                //将节点压入栈1，并在栈2将节点标记为左节点
                stack.push(cur);
                stack2.push(left);
                cur = cur.left;
            }

            while(!stack.isEmpty() && stack2.peek() == right){
                //如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack2.pop();
                System.out.println(stack.pop().e);
            }

            if(!stack.isEmpty() && stack2.peek() == left){
                //如果是从左子节点返回父节点，则将标记改为右子节点
                stack2.pop();
                stack2.push(right);
                cur = stack.peek().right;
            }
        }
    }

    /**
     * 层次遍历
     */
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);

            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }

        }
    }

    /**
     * 寻找整个二分搜索树的最小元素
     * @return
     */
    public E minimum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty.");
        }
        return minimum(root).e;
    }

    /**
     * 返回以node为根节点的BST的最小值所在的节点
     * @param node
     * @return
     */
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }else{
            return minimum(node.left);
        }
    }

    /**
     * 寻找整个二分搜索树的最大元素
     * @return
     */
    public E maximum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty.");
        }
        return maximum(root).e;
    }

    /**
     * 返回以node为根节点的BST的最大值所在的节点
     * @param node
     * @return
     */
    private Node maximum(Node node){
        if(node.right == null){
            return node;
        }else{
            return maximum(node.right);
        }
    }

    /**
     * 从BST中删除最小值所在的节点，返回最小值
     * @return
     */
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除以node为根节点的BST中的最小节点，
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从BST中删除最大值所在的节点，返回最大值
     * @return
     */
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除以node为根节点的BST中的最大节点，
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMin(node.right);
        return node;
    }

    /**
     * 从BST中删除元素为e的节点
     * @param e
     */
    public void remove(E e){
        root = remove(root, e);
    }

    private Node remove(Node node, E e){
        if(node == null){
            return null;
        }
        if(e.compareTo(node.e) < 0){
            remove(node.left, e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            remove(node.right, e);
            return node;
        }else{
            // 待删除节点左子树为空
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // 待删除节点右子树为空
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            // 待删除节点左右子树都不为空
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }

    }




    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Random random = new Random();

        int n = 1000;

        for(int i=0; i<n; i++){
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while(!bst.isEmpty()){
            nums.add(bst.removeMin());
        }

        System.out.println(nums);
    }


}
