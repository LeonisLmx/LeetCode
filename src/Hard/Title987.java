package Hard;

import Simple.Title897;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @Author: Urey
 * @Date: 2021/7/31
 */
public class Title987 {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this .val = val;}
        TreeNode(int val, TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<List<Integer>> lists = new LinkedList<>();

    List<int[]> list = new ArrayList<>();

    // 根节点是0，每次左节点就-1，右节点就+1
    public List<List<Integer>> verticalTraversal(TreeNode root){
        dfs(root,0,0);
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]){
                    if (o1[0] == o2[0]){
                        return Integer.compare(o1[2],o2[2]);
                    }else{
                        return Integer.compare(o1[0],o2[0]);
                    }
                }else{
                    return Integer.compare(o1[1],o2[1]);
                }
            }
        });
        int index = 0;
        int last = Integer.MIN_VALUE;
        for (int[] ints : list) {
            if (ints[1] != last){
                last = ints[1];
                index++;
                lists.add(new ArrayList<>());
            }
            lists.get(index - 1).add(ints[2]);
        }
        return lists;
    }

    private void dfs(TreeNode root, int x,int y) {
        if (root == null){
            return;
        }
        list.add(new int[]{x,y,root.val});
        if (root.left != null){
            dfs(root.left,x + 1,y - 1);
        }
        if (root.right != null){
            dfs(root.right,x + 1,y + 1);
        }
    }

    public static void main(String[] args) {
        Title987 title = new Title987();
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(8);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(2);
        root.right.left.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.left.right.left = new TreeNode(7);
        root.right.left.right.right = new TreeNode(6);
        //System.out.println(title.verticalTraversal(node));
        System.out.println(title.verticalTraversal(root));
    }
}
