package offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Urey
 * @Date: 2020/12/23
 */
public class Title12 {

    // 回溯法
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        // 遍历找第一个符合条件的
        for (int a = 0; a < board.length;a++) {
            for (int b = 0; b < board[a].length;b++) {
                if (dfs(board,a,b,chars,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] chars, int index) {
        if (board.length <= i || j < 0 || board[0].length <= j || i < 0 || board[i][j] != chars[index]){
            return false;
        }
        if (chars.length - 1 == index){
            return true;
        }
        index++;
        board[i][j] = '\0';
        boolean flag = dfs(board,i + 1,j,chars,index) || dfs(board,i,j + 1,chars,index)
                || dfs(board, i,j - 1,chars,index) || dfs(board,i - 1, j,chars,index);
        board[i][j] = chars[index - 1];
        return flag;
    }

    public static void main(String[] args) {
        Title12 title12 = new Title12();
        System.out.println(title12.exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
                },"ABCESEEEFS"));
//        System.out.println(title12.exist(new char[][]{
//                {'C','A','A'},
//                {'A','A','A'},
//                {'B','C','D'}
//        },"AAB"));
    }
}
