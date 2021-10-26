package Middle;

import java.util.*;

public class Title229 {

    public List<Integer> majorityElement(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>();
        int len = nums.length;
        for (int i = 0;i < len;i++){
            queue.offer(nums[i]);
        }
        List<Integer> list = new ArrayList<>();
        int count = 0,ret = len / 3,last = 0;
        while (!queue.isEmpty()){
            int num = queue.poll();
            if (count == 0){
                last = num;
                count = 1;
            }else{
                if (last == num){
                    count++;
                }else{
                    if (count > ret){
                        list.add(last);
                    }
                    count = 1;
                    last = num;
                }
            }
        }
        if (count > ret){
            list.add(last);
        }
        return list;
    }

    public List<Integer> majorityElement2(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length,ret = len / 3;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            int count = map.getOrDefault(num,0);
            count++;
            map.put(num,count);
            if (count > ret){
                set.add(num);
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        Title229 title229 = new Title229();
        //System.out.println(title229.majorityElement2(new int[]{1,1,1,2}));
        Map<String,Integer> map = new HashMap<>();
        map.put("userId",1);
        map.put("petId",1);
        map.put("propId",1);
        System.out.println(map.toString());
    }
}
