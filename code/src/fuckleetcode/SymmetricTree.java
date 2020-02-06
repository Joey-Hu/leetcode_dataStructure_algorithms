package fuckleetcode;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

/**
 * @author: huhao
 * @time: 2020/2/6 11:49
 * @desc:
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode node1, TreeNode node2){
        if(node1.val != node2.val){
            return false;
        }
        if(node1.left != null){
            if(node2.right == null){
                return false;
            }
            // 一旦发现存在不对称，立即退出
//            if(!dfs(node1.left, node2.right)){
//                return false;
//            }
            dfs(node1.left, node2.right);
        }

        if(node1.right != null){
            if(node2.left == null){
                return false;
            }
            // 一旦发现存在不对称，立即退出
//            if(!dfs(node1.right, node2.left)){
//                return false;
//            }
            dfs(node1.right, node2.left);
        }
        return true;
    }
}


