package Simple;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author urey.liu
 * @description
 * @date 2022/10/19 2:03 下午
 */
public class Title1700 {

    public static int countStudents(int[] students, int[] sandwiches){
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> sandQueue = new ArrayDeque<>();
        for (int i = 0;i < students.length;i++){
            queue.offer(students[i]);
            sandQueue.offer(sandwiches[i]);
        }
        int count = 0;
        while (!queue.isEmpty()){
            if (count >= queue.size()){
                return count;
            }
            int a = queue.poll();
            if (a == sandQueue.peek()){
                sandQueue.poll();
                count = 0;
                continue;
            }else{
                queue.offer(a);
                count++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(countStudents(new int[]{1,1,0,0},new int[]{0,1,0,1}));
        System.out.println(countStudents(new int[]{1,1,1,0,0,1},new int[]{1,0,0,0,1,1}));
        System.out.println(countStudents(new int[]{},new int[]{}));
    }
}
