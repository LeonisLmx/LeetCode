package Middle;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author urey.liu
 * @description
 * @date 2023/2/24 2:33 下午
 */
public class Title90 {

    List<List<Integer>> list = new ArrayList<>();

    int length;

    int[] res;

    Set<String> stacks = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        length = nums.length;
        res = nums;
        list.add(new ArrayList<>());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < length;i++){
            stack.add(nums[i]);
            if (isContain(stack)) {
                list.add(new ArrayList<>(stack));
            }
            recuirt(stack, i);
            stack.pop();
        }
        return list;
    }

    public void recuirt(Stack<Integer> stack, Integer i){
        if (i == length - 1){
            return;
        }
        while (i < length - 1) {
            i++;
            stack.add(res[i]);
            if (isContain(stack)) {
                list.add(new ArrayList<>(stack));
            }
            recuirt(stack, i);
            stack.pop();
        }
    }

    public boolean isContain(Stack<Integer> stack){
        return stacks.add(stack.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()).toString());
    }

    public static void main(String[] args) {
        Title90 title90 = new Title90();
//        System.out.println(title90.subsetsWithDup(new int[]{1,2,2}));
//        System.out.println(title90.subsetsWithDup(new int[]{1,2,3}));
//        System.out.println(title90.subsetsWithDup(new int[]{1,2,3,4}));
        // [[],[1],[1,4],[1,4,4],[1,4,4,4],[1,4,4,4,4],[4],[4,4],[4,4,4],[4,4,4,4]]
        System.out.println(title90.subsetsWithDup(new int[]{4,4,4,1,4}));
//        Stack<Integer> stack = new Stack<>();
//        stack.add(1);
//        stack.add(2);
//        stack.add(3);
//        System.out.println(stack.pop());
//        System.out.println(stack.toString());
    }
}
