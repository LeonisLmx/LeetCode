package Middle;

import java.util.*;

/**
 * @author urey.liu
 * @description
 * @date 2023/4/28 4:54 下午
 */
public class Title1048 {

    public int longestStrChain(String[] words) {
        int min = 1000,max = -1,ans = 1;
        Map<Integer, List<String>> map  = new HashMap<>();
        for (String word : words) {
            int length = word.length();
            List<String> list = map.getOrDefault(length, new ArrayList<>());
            list.add(word);
            min = Math.min(min, length);
            max = Math.max(max, length);
            map.put(length, list);
        }
        loop:
        while (min < max){
            if (ans >= (max - min)){
                return ans;
            }
            List<String> list = map.get(min);
            List<String> target = map.get(min + 1);
            for (String s : list) {
                for (String aim : target) {
                    if (isChild(s, aim)){
                        min++;
                        ans++;
                        continue loop;
                    }
                }
            }
        }
        return ans;
    }

    public boolean isChild(String source, String target){
        int ans = 0;
        for (int i = 0,j = 0;i < source.length() && j < target.length();i++,j++){
            if (source.charAt(i) != target.charAt(j)){
                if (ans == 0){
                    ans++;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023,Calendar.JANUARY,1);
        for (int i = 0;i < 5;i++){
            calendar.add(Calendar.DAY_OF_YEAR,73);
            System.out.println(calendar.getTime());
        }
    }
}
