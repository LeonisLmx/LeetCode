package Middle;

import offer.Title07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: Urey
 * @Date: 2020/12/22
 */
public class Title103 {

    //节点结构
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.val = value;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        recur(root,0,map);
        return new ArrayList<>(map.values());
    }

    private void recur(TreeNode node, int step,Map<Integer,List<Integer>> map) {
        if (node == null){
            return;
        }
        List<Integer> list = map.getOrDefault(step,new ArrayList<>());
        if (step % 2 == 0) {
            list.add(node.val);
        }else{
            list.add(0, node.val);
        }
        map.put(step,list);
        step++;
        recur(node.left,step,map);
        recur(node.right,step,map);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        Title103 title103 = new Title103();
        System.out.println(title103.zigzagLevelOrder(treeNode).toString());
    }
}
