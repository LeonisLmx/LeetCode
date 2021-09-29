package Middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Urey
 * @Date: 2021/7/28
 */
public class Title863 {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    Map<Integer,TreeNode> parentMap = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k){
        set.add(target.val);

        dfs(root);

        findKNode(target,0,k);

        return list;
    }

    private void findKNode(TreeNode node,int index, int k) {
        if (node == null){
            return;
        }
        if (index == k){
            list.add(node.val);
            return;
        }
        TreeNode parentNode = parentMap.get(node.val);
        if (parentNode != null && !set.contains(parentNode.val)){
            set.add(parentNode.val);
            findKNode(parentNode,index + 1,k);
        }
        if (node.left != null && !set.contains(node.left.val)){
            set.add(node.left.val);
            findKNode(node.left,index + 1,k);
        }
        if (node.right != null && !set.contains(node.right.val)){
            set.add(node.right.val);
            findKNode(node.right,index + 1,k);
        }
    }

    private void dfs(TreeNode root) {
        if (root.left != null){
            dfs(root.left);
            parentMap.put(root.left.val,root);
        }
        if (root.right != null){
            dfs(root.right);
            parentMap.put(root.right.val,root);
        }
    }

    public static void main(String[] args) {
        Title863 title863 = new Title863();
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(5);
        node.right = new TreeNode(1);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(2);
        node.left.right.left = new TreeNode(7);
        node.left.right.right = new TreeNode(4);
        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(8);
        System.out.println(title863.distanceK(node,node.left,2));
    }
}
