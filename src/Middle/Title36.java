package Middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2020/11/27
 */
public class Title36 {

    public boolean isValidSudoku(char[][] board){
        Map<Integer,List<Character>> map = new HashMap<>();
        Map<String,List<Character>> stringListMap = new HashMap<>();
        for (int i = 0;i < 9;i++){
            // 判断每一行
            List<Character> list = new ArrayList<>();
            for (int j = 0;j < 9;j++){
                if (board[i][j] == '.'){
                    continue;
                }
                int m = i / 3,n = j / 3;
                String key = m + "_" + n;
                List<Character> lists = map.getOrDefault(j,new ArrayList<>());
                List<Character> characterList = stringListMap.getOrDefault(key,new ArrayList<>());
                if (list.contains(board[i][j]) || lists.contains(board[i][j]) || characterList.contains(board[i][j])){
                    return false;
                }
                lists.add(board[i][j]);
                map.put(j,lists);
                characterList.add(board[i][j]);
                stringListMap.put(key,characterList);
                list.add(board[i][j]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Title36 title36 = new Title36();
        System.out.println(title36.isValidSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        }));
    }
}
