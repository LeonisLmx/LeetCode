package Middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2021/9/29
 *
 * 1  10
 * 2  15 7
 * 3  18 17 18
 */
public class Title437 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val;}
        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 以某个节点出发所有的和的条数
    public int pathSum(TreeNode root,int targetSum){
        if (root == null){
            return 0;
        }

        int ret = revert(root,targetSum);
        ret += pathSum(root.left,targetSum);
        ret += pathSum(root.right,targetSum);

        return ret;
    }

    // 计算所有可能的条数
    private int revert(TreeNode root,int targetSum) {
        if (root == null){
            return 0;
        }
        int ret = 0;
        if (root.val == targetSum){
            ret++;
        }
        ret += revert(root.left,targetSum - root.val);
        ret += revert(root.right,targetSum - root.val);

        return ret;
    }

    public int pathSum2(TreeNode root,int targetSum){
        Map<Long,Integer> map = new HashMap<>();
        map.put(0L,1);
        return dfs(root,map,0,targetSum);
    }

    private int dfs(TreeNode root, Map<Long, Integer> map,long cur,int targetSum) {
        if (root == null){
            return 0;
        }
        int ret = 0;
        cur += root.val;
        // 获取当前节点往前能撮合的次数
        ret += map.getOrDefault(cur - targetSum,0);
        // 将当前节点的值加入到 map 里面去
        map.put(cur,map.getOrDefault(cur,0) + 1);
        ret += dfs(root.left,map,cur,targetSum);
        ret += dfs(root.right,map,cur,targetSum);
        // 回溯
        map.put(cur,map.get(cur) - 1);
        return ret;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.left.left = new TreeNode(3);
        node.left.left.left = new TreeNode(3);
        node.left.right = new TreeNode(2);
        node.left.left.right = new TreeNode(-2);
        node.left.right.right = new TreeNode(1);
        node.right = new TreeNode(-3);
        node.right.right = new TreeNode(11);
        Title437 title437 = new Title437();
        System.out.println(title437.pathSum2(node,8));
    }
}
