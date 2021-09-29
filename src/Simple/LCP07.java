package Simple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Urey
 * @Date: 2021/7/1
 */
public class LCP07 {

    public int numWays(int n,int[][] relation,int k){
        int end = n - 1,step = 0,num = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()){
            int size = queue.size();
            step++;
            for (int j = 0;j < size;j++) {
                int start = queue.poll();
                for (int i = 0; i < relation.length && step <= k; i++) {
                    if (step == k) {
                        if (start == relation[i][0] && relation[i][1] == end) {
                            num++;
                        }
                    } else {
                        if (relation[i][0] == start) {
                            queue.offer(relation[i][1]);
                        }
                    }
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        LCP07 lcp07 = new LCP07();
        System.out.println(lcp07.numWays(5,new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}},3));
        System.out.println(lcp07.numWays(3,new int[][]{{0,2},{2,1}},2));
        System.out.println(lcp07.numWays(3,new int[][]{{0,2},{0,1},{1,2},{2,1},{2,0},{1,0}},1));
        System.out.println(lcp07.numWays(3,new int[][]{{0,1},{0,2},{2,1},{1,2},{1,0},{2,0}},5));
    }
}
