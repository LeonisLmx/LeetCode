package Middle;

import java.util.concurrent.Semaphore;

/**
 * @Author: Urey
 * @Date: 2021/2/2
 */
public class Title424 {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] nums = new int[26];
        int max = 0,left = 0,right = 0;
        while (right < n){
            nums[s.charAt(right) - 'A']++;
            max = Math.max(max, nums[s.charAt(right) - 'A']);
            if (right - left + 1 - max > k){
                nums[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }

    public static void main(String[] args) throws InterruptedException {
        Title424 title424 = new Title424();
        System.out.println(title424.characterReplacement("AABCB",1));
        System.out.println(title424.characterReplacement("AABCBBA",1));
        System.out.println(title424.characterReplacement("AABBCBBA",1));
        System.out.println(title424.characterReplacement("AABABBA",1));
    }
}
