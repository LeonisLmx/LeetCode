package Middle;

import java.util.Arrays;

/**
 * @author urey.liu
 * @description
 * 在无限的平面上，机器人最初位于(0, 0)处，面朝北方。注意:
 *
 * 北方向 是y轴的正方向。
 * 南方向 是y轴的负方向。
 * 东方向 是x轴的正方向。
 * 西方向 是x轴的负方向。
 * 机器人可以接受下列三条指令之一：
 *
 * "G"：直走 1 个单位
 * "L"：左转 90 度
 * "R"：右转 90 度
 * 机器人按顺序执行指令instructions，并一直重复它们。
 *
 * 只有在平面中存在环使得机器人永远无法离开时，返回true。否则，返回 false。
 *
 * @date 2023/4/11 11:28 上午
 */
public class Title1041 {

    public boolean isRobotBounded(String instructions) {
        int[][] arr = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
        int direction = 0,x = 0,y = 0;
        for (int i = 0;i < 4;i++) {
            for (int j = 0;j < instructions.length();j++) {
                if (instructions.charAt(j) == 'G'){
                    direction = (direction + 4 * 25) % 4;
                    x += arr[direction][0];
                    y += arr[direction][1];
                }else if (instructions.charAt(j) == 'L'){
                    direction++;
                }else{
                    direction--;
                }
            }
            if (x == 0 && y == 0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Title1041 title1041 = new Title1041();
        System.out.println(title1041.isRobotBounded("LLGRL"));
    }
}
