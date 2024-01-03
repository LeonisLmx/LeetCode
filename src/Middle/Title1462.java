package Middle;

import java.util.*;

/**
 * @author urey.liu
 * @description
 * @date 2023/4/4 5:34 下午
 */
public class Title1462 {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Boolean[][] dp = new Boolean[numCourses][numCourses];
        List<Boolean> list = new ArrayList<>();
        for (int i = 0;i < prerequisites.length;i++){
            dp[prerequisites[i][0]][prerequisites[i][1]] = true;
        }
        for (int i = 0;i < numCourses;i++){
            for (int j = 0;j < numCourses;j++){
                for (int z = 0;z < numCourses;z++){
                    if (dp[j][i] && dp[i][z]){
                        dp[j][z] = true;
                    }
                }
            }
        }
        for (int[] query : queries) {
            list.add(dp[query[0]][query[1]]);
        }
        return list;
    }
}
