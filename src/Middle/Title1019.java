package Middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author urey.liu
 * @description
 *
 * 给定一个长度为n的链表head
 *
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
 *
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置answer[i] = 0。
 * 输入：head = [2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * @date 2023/4/10 4:24 下午
 */
public class Title1019 {

    public static int[] nextLargerNodes(Title725.ListNode head) {
        int[] arr = new int[10000];
        int length = 0;
        while (head != null){
            arr[length] = head.val;
            length++;
            head = head.next;
        }
        for (int i = 0;i < length;i++){
            if (arr[i] < arr[i + 1]){
                for (int j = i + 1;j < length;j++){
                    if (arr[i] < arr[j]){
                        arr[i] = arr[j];
                        break;
                    }
                }
            }
        }
        return Arrays.copyOfRange(arr, 0, length);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextLargerNodes(null)));
    }
}
