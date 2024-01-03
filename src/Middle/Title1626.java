package Middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author urey.liu
 * @description
 * @date 2023/3/22 2:45 下午
 */
public class Title1626 {

    public int bestTeamScore(int[] scores, int[] ages) {
        int length = ages.length;
        List<Member> memberList = new ArrayList<>();
        for (int i = 0;i < length;i++){
            memberList.add(new Member(ages[i], scores[i]));
        }
        memberList.sort((o1, o2) -> {
            if (o1.age == o2.age) {
                if (o1.score == o2.score){
                    return 0;
                }
                return o1.score < o2.score ? -1 : 1;
            } else {
                return o1.age < o2.age ? -1 : 1;
            }
        });
        System.out.println(memberList.toString());
        int[] dp = new int[length];
        dp[length - 1] = memberList.get(length - 1).score;
        for (int i = length - 2;i >= 0;i--){
            int index = i + 1;
            while (index < length){
                if (memberList.get(i).score <= memberList.get(index).score){
                    dp[i] = dp[index] + memberList.get(i).score;
                    break;
                }
                index++;
            }
            if (dp[i] == 0){
                dp[i] = Math.max(dp[i + 1], memberList.get(i).score);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Title1626 title1626 = new Title1626();
//        System.out.println(title1626.bestTeamScore(new int[]{1,3,5,10,15},new int[]{1,2,3,4,5}));
//        System.out.println(title1626.bestTeamScore(new int[]{4,5,6,5}, new int[]{2,1,2,1}));
//        System.out.println(title1626.bestTeamScore(new int[]{1,2,3,5}, new int[]{8,9,10,1}));
//        System.out.println(title1626.bestTeamScore(new int[]{319776,611683,835240,602298,430007,574,142444,858606,734364,896074},
//new int[]{1,1,1,1,1,1,1,1,1,1}));
        System.out.println(title1626.bestTeamScore(new int[]{6,5,1,7,6,5,5,4,10,4},
new int[]{3,2,5,3,2,1,4,4,5,1}));
    }

    class Member {
        public int age;
        public int score;

        public Member(int age, int score) {
            this.age = age;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Member{" +
                    "age=" + age +
                    ", score=" + score +
                    '}';
        }
    }
}
