package Middle;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author urey.liu
 * @description
 * @date 2022/1/6 1:43 下午
 */
public class Title71 {

    public String simplifyPath(String path){
        String[] res = path.split("/");
        Deque<String> deque = new ArrayDeque<String>();
        for (String str : res) {
            if (str.equals("..")){
                if (!deque.isEmpty()){
                    deque.pollLast();
                }
            }else if (str.length() > 0 && !".".equals(str)){
                deque.offerLast(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (deque.isEmpty()){
            sb.append("/");
        }else{
            while (!deque.isEmpty()){
                sb.append("/").append(deque.pollFirst());
            }
        }
        return sb.toString();
    }
}
