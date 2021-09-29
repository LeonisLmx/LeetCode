package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2021/9/16
 */
public class Title212 {

    int m,n;

    public List<String> findWords(char[][] board, String[] words){
        final List<String> list = new ArrayList<>();
        m = board.length;
        n = board[0].length;
        loop:
        for (int i = 0;i < words.length;i++){
            char[] word = words[i].toCharArray();
            boolean[][] arr = new boolean[m][n];
            for (int j = 0;j < m;j++){
                Arrays.fill(arr[j],false);
            }
            int start = 0,max = word.length - 1;
            for (int a = 0;a < m;a++){
                for (int b = 0;b < n;b++){
                    if (board[a][b] == word[start]){
                        arr[a][b] = true;
                        if (dfs(new int[]{a,b},start,max,board,word,arr)){
                            list.add(words[i]);
                            continue loop;
                        }
                        arr[a][b] = false;
                    }
                }
            }
        }
        return list;
    }

    public boolean dfs(int[] nums,int start,int max,char[][] board,char[] word,boolean[][] arr){
        if (start == max){
            return true;
        }
        start++;
        int x = nums[0],y = nums[1];
        if (x + 1 < m && board[x + 1][y] == word[start] && !arr[x + 1][y]){
            arr[x + 1][y] = true;
            if (dfs(new int[]{x + 1,y},start,max,board,word,arr)){
                return true;
            }
            arr[x + 1][y] = false;
        }
        if (x - 1 >= 0 && board[x - 1][y] == word[start] && !arr[x - 1][y]){
            arr[x - 1][y] = true;
            if (dfs(new int[]{x - 1,y},start,max,board,word,arr)){
                return true;
            }
            arr[x - 1][y] = false;
        }
        if (y + 1 < n && board[x][y + 1] == word[start] && !arr[x][y + 1]){
            arr[x][y + 1] = true;
            if(dfs(new int[]{x,y + 1},start,max,board,word,arr)){
                return true;
            }
            arr[x][y + 1] = false;
        }
        if (y - 1 >= 0 && board[x][y - 1] == word[start] && !arr[x][y - 1]){
            arr[x][y - 1] = true;
            if(dfs(new int[]{x,y - 1},start,max,board,word,arr)){
                return true;
            }
            arr[x][y - 1] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        Title212 title212 = new Title212();
        char[][] arrs = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        System.out.println(title212.findWords(arrs,new String[]{"oath","pea","eat","rain"}));
        System.out.println(title212.findWords(new char[][]{{'a','a'}},new String[]{"aa"}));
        char[][] chars = new char[][]{{'a','b','c'},{'a','e','d'},{'a','f','g'}};
        System.out.println(title212.findWords(chars,new String[]{"eaabcdgfa"}));
    }
}
