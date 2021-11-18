package Hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author urey.liu
 * @description
 * @date 2021/11/9 10:24 上午
 */
public class Title488 {

    private static int res = 0;
    private static Map<Character,Integer> map = new HashMap<>();

    public int findMinStep(String board, String hand){
        for (int i = 0;i < hand.length();i++){
            map.merge(hand.charAt(i),1,Integer::sum);
        }
        dfs(board,0);
        return board.length() > 0?-1:res;
    }

    private void dfs(String board,int len) {
        if (len == board.length()){
            return;
        }
        char last = '0';
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < board.length();i++){
            if (last == board.charAt(i)){
                int j = i + 1;
                while (j < board.length()){
                    if (last != board.charAt(j)){
                        break;
                    }
                }
                if (j - (i - 1) > 2){
                    sb.append(board.substring(j));
                    break;
                }else if (map.getOrDefault(last,0) > 0){
                    map.merge(last,-1,Integer::sum);
                    res++;
                    sb.append(board.substring(j));
                    break;
                }
            }
            sb.append(board.charAt(i));
        }
        dfs(sb.toString(),board.length());
    }

    public static void main(String[] args) {
        String tableName = "user_pet_interactive_record_%d";
        String str = "DROP TABLE IF EXISTS `%s`;";
        for (int i = 0;i < 100;i++){
            String tab = String.format(tableName,i);
            System.out.println(String.format(str,tab));
            System.out.println();
        }
    }
}
