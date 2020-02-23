package fuckleetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/2/12 13:20
 * @desc:
 */
public class BinaryTreeInorderTraversal {
    private class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * recursively
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ret = new ArrayList<Integer>();

        inorderTraversal(root, ret);
        return ret;
    }

    /**
     * 递归遍历节点node
     * @param node
     * @param ret
     */
    public void inorderTraversal(TreeNode node, List<Integer> ret){
        if(node != null){
            inorderTraversal(node.left, ret);
            ret.add(node.val);
            inorderTraversal(node.right, ret);
        }

    }

    /**
     * iteratively
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while (true){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            TreeNode node = stack.pop();
            ret.add(node.val);
            cur = cur.right;
        }
        return ret;
    }

}
