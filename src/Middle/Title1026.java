package Middle;

import Simple.TreeNode;

import java.util.*;

/**
 * @author urey.liu
 * @description
 * @date 2023/4/19 5:17 下午
 */
public class Title1026 {
    
    int diff = 0;
    
    Queue<Integer> minQueue = new PriorityQueue<>(Integer::compareTo);
    Queue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());

    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return diff;
    }

    private void dfs(TreeNode root) {
        if (root != null){
            minQueue.offer(root.val);
            maxQueue.offer(root.val);
            diff = Math.max(maxQueue.peek() - minQueue.peek(), diff);
            dfs(root.left);
            dfs(root.right);
            maxQueue.remove(root.val);
            minQueue.remove(root.val);
        }
    }
}
