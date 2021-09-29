package Middle;

/**
 * @Author: Urey
 * @Date: 2021/1/7
 */
public class Title547 {

    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, provinces, i);
                circles++;
            }
        }
        return circles;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int provinces, int i) {
        for (int j = 0; j < provinces; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, provinces, j);
            }
        }
    }

    public static void main(String[] args) {
        Title547 title547 = new Title547();
        System.out.println(title547.findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
    }
}
