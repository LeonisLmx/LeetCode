package offer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: Urey
 * @Date: 2020/12/18
 */
public class Title07 {

    //节点结构
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    // 前序遍历
    public static void preorder(TreeNode treeNode){
        List<Integer> list = new LinkedList<>();
        printNode(list,treeNode);
        System.out.println(list.toString());
    }

    private static void printNode(List<Integer> list, TreeNode treeNode) {
        if (treeNode == null){
            return;
        }
        list.add(treeNode.value);
        printNode(list,treeNode.left);
        printNode(list,treeNode.right);
    }

    // 中序遍历
    public static void inorder(TreeNode treeNode){
        List<Integer> list = new LinkedList<>();
        printNode2(list,treeNode);
        System.out.println(list.toString());
    }

    private static void printNode2(List<Integer> list, TreeNode treeNode) {
        if(treeNode == null){
            return;
        }
        printNode2(list,treeNode.left);
        list.add(treeNode.value);
        printNode2(list,treeNode.right);
    }

    // 后序遍历
    public static void lastorder(TreeNode treeNode){
        List<Integer> list = new LinkedList<>();
        printNode3(list,treeNode);
        System.out.println(list.toString());
    }

    private static void printNode3(List<Integer> list, TreeNode treeNode) {
        if (treeNode == null){
            return;
        }
        printNode3(list,treeNode.left);
        printNode3(list,treeNode.right);
        list.add(treeNode.value);
    }

    // 宽度优先遍历
    public static void widthorder(TreeNode treeNode){
        Map<Integer,List<Integer>> leftMap = new HashMap<>();
        Map<Integer,List<Integer>> rightMap = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        list.add(treeNode.value);
        printNode4(leftMap,treeNode.left,1);
        printNode4(rightMap,treeNode.right,1);
        leftMap.forEach((k,v) -> {
            list.addAll(v);
            List<Integer> lists = rightMap.get(k);
            if (lists != null){
                list.addAll(lists);
            }
        });
        System.out.println(list.toString());
    }

    // step 维护层级
    private static void printNode4(Map<Integer, List<Integer>> map, TreeNode treeNode, int step) {
        if (treeNode == null){
            return;
        }
        List<Integer> list = map.getOrDefault(step,new ArrayList<>());
        list.add(treeNode.value);
        map.put(step,list);
        step = step + 1;
        printNode4(map,treeNode.left,step);
        printNode4(map,treeNode.right,step);
    }

    // 前序遍历的第一个节点就是根节点
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int root, int left, int right) {
        if(left > right) return null;                          // 递归终止
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        node.right = recur( i - left + root + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(10);
//        treeNode.left = new TreeNode(6);
//        treeNode.left.left = new TreeNode(4);
//        treeNode.left.right = new TreeNode(8);
//        treeNode.right = new TreeNode(14);
//        treeNode.right.left = new TreeNode(12);
//        treeNode.right.right = new TreeNode(16);
//        preorder(treeNode);
//        inorder(treeNode);
//        lastorder(treeNode);
//        widthorder(treeNode);
        Title07 title07 = new Title07();
        TreeNode treeNode = title07.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        preorder(treeNode);
    }
}
