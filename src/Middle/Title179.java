package Middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2021/4/12
 */
public class Title179 {

    public String largesNumber(int[] nums){
        Map<String, List<Integer>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder("");
        for (int num : nums) {
            String key = (num + "").substring(0,1);
            List<Integer> list = map.getOrDefault(key,new ArrayList<>());
            list.add(num);
            map.put(key,list);
        }
        for (int i = 9;i >= 0;i--){
            List<Integer> list = map.getOrDefault(i + "",new ArrayList<>());
            if (list.size() > 0){
                sb.append(sort(list,i));
            }
        }
        return "0".equals(sb.substring(0, 1)) ?"0":sb.toString();
    }

    private String sort(List<Integer> list,int num) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i;j < list.size();j++){
                int a = list.get(i),b = list.get(j),aLen = (a + "").length(),bLen = (b + "").length();
                // 长度相等的情况下，正常排序
                if (aLen == bLen){
                    if (a < b){
                        list.set(i,b);
                        list.set(j,a);
                    }
                }else{
                    // 长度不相等时
                    if ((a + "" + b).compareTo(b + "" + a) < 0){
                        list.set(i,b);
                        list.set(j,a);
                    }
                }
            }
        }
        String str = list.toString();
        return str.substring(1,str.length() - 1).replaceAll(",","").replaceAll(" ","");
    }

    private String fill(int i,int num) {
        StringBuilder sb = new StringBuilder("");
        while (i > 0){
            sb.append(num);
            i--;
        }
        return sb.toString();
    }

    String test(){
        try {
            return "1";
        }catch (Exception e){
            return "2";
        }finally {
            return "3";
        }
    }

    public static void main(String[] args) {
        Title179 title179 = new Title179();
//        System.out.println(title179.sort(Arrays.asList(432,43243),4));
        //System.out.println("0000".compareTo("0") > 0);
        System.out.println(title179.test());
    }
}
