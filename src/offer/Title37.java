package offer;

import Middle.Title34;
import Simple.Title872;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2021/6/30
 */
public class Title37 {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val){
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    StringBuilder sb = new StringBuilder("");
    List<Integer> leftList = new LinkedList<>();
    List<Integer> rightList = new LinkedList<>();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        return sb.toString();
    }

    private void dfs(TreeNode root) {
        if (root.left != null){
            dfs(root.left);
            leftList.add(root.left.val);
        }
        sb.append(root.val).append(",");
        if (root.right != null){
            dfs(root.right);
            rightList.add(root.right.val);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = sb.toString();
        return new TreeNode();
    }

    Map<Integer,Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder,int[] inorder){
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i],i);
        }
        // 前序遍历的0节点就是根节点
        return recur(0,0,inorder.length - 1,preorder);
    }

    private TreeNode recur(int root,int left,int right,int[] preorder) {
        if (left > right){
            return null;
        }
        TreeNode node = new TreeNode(preorder[root]);
        // 找到根节点的位置，在中序遍历的排列中，[0,index)即是根节点的左边节点，(index,right]即是跟节点的右边节点
        int index = dic.get(preorder[root]);
        // 前序遍历中，根节点的下一个节点必定是左节点的根节点
        node.left = recur(root + 1,left,index - 1,preorder);
        // 右子树的根节点在前序遍历中是当前的根节点 + 左子树的长度 + 1
        node.right = recur(root + (index - left) + 1,index + 1,right,preorder);
        return node;
    }

    public static void main(String[] args) {
        Title37 title37 = new Title37();
        System.out.println(title37.buildTree(new int[]{1,2,3},new int[]{2,3,1}).val);
    }
}
