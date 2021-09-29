package Middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2021/1/15
 */
public class Title947 {

    List<Integer> list;
    public int removeStones(int[][] stones) {
        list = new ArrayList<>();
        for (int i = 0; i < stones.length; i++) {
            list.add(i);
        }
        int res = stones.length;
        for (int i = 0;i < stones.length - 1;i++){
            for (int j = i + 1;j < stones.length;j++){
                int a = find(i),b = find(j);
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    if (a != b){
                        list.set(a,b);
                        res--;
                    }
                }
            }
        }
        return stones.length - res;
    }

    private int find(int j) {
        if (list.get(j) != j){
            list.set(j,find(list.get(j)));
        }
        return list.get(j);
    }

    public int removeStones2(int[][] stones) {
        UnionFind unionFind = new UnionFind();
        for (int[] stone : stones) {
            unionFind.union(stone[0],stone[1]);
        }
        return stones.length - unionFind.getCount();
    }

    class UnionFind{
        Map<Integer,Integer> map;
        int count = 0;

        public UnionFind(){
            this.map = new HashMap<>();
        }

        public int getCount(){
            return this.count;
        }

        public int find(int x){
            if (!map.containsKey(x)){
                map.put(x,x);
                count++;
            }
            if (map.get(x) != x){
                map.put(x,find(map.get(x)));
            }
            return map.get(x);
        }

        public void union(int x,int y){
            int a = find(x),b = find(y);
            if (a == b){
                return;
            }
            map.put(a,b);
            count--;
        }
    }

    public static void main(String[] args) {
        Title947 title947 = new Title947();
        System.out.println(title947.removeStones2(new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}}));
        System.out.println(title947.removeStones2(new int[][]{{0,0},{0,2},{1,1},{2,0},{2,2}}));
        System.out.println(title947.removeStones2(new int[][]{{0,0},{1,2},{1,3},{3,3},{2,3},{0,2}}));
    }
}
