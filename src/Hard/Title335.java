package Hard;

/**
 * @author urey.liu
 * @description
 * @date 2021/10/29 3:14 下午
 */
public class Title335 {

    public boolean isSelfCrossing(int[] distance){
        int len = distance.length;
        for (int i = 3;i < len;i++){
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]){
                return true;
            }
            if (i == 4 && distance[i - 1] == distance[i - 3] && distance[i - 4] + distance[i] >= distance[i - 2] && distance[i] < distance[i - 2]){
                return true;
            }
            if (i >= 5 && (distance[i - 3] - distance[i - 5] <= distance[i - 1]
                    && distance[i - 1] <= distance[i - 3]
                    && distance[i] >= distance[i - 2] - distance[i - 4]
                    && distance[i - 2] > distance[i - 4])) {
                return true;
            }
        }
        return false;
    }
}
