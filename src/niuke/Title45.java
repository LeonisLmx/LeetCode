package niuke;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2021/8/20
 */
public class Title45 {

    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public int[][] threeOrders(TreeNode root){
        List<Integer> preList = new ArrayList<>();
        dfs(root,1,preList);
        List<Integer> middleList = new ArrayList<>();
        dfs(root,2,middleList);
        List<Integer> nextList = new ArrayList<>();
        dfs(root,3,nextList);
        int[][] arr = new int[3][middleList.size()];
        arr[0] = middleList.stream().mapToInt(Integer::intValue).toArray();
        arr[1] = preList.stream().mapToInt(Integer::intValue).toArray();
        arr[2] = nextList.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }

    private void dfs(TreeNode root,int n,List<Integer> list) {
        if (n == 1){
            list.add(root.val);
        }
        if (root.left != null){
            dfs(root.left,n,list);
        }
        if (n == 2){
            list.add(root.val);
        }
        if (root.right != null){
            dfs(root.right,n,list);
        }
        if (n == 3) {
            list.add(root.val);
        }
    }
}
