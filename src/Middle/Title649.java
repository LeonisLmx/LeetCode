package Middle;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: Urey
 * @Date: 2020/12/11
 */
public class Title649 {

    public String predictPartyVictory(String senate) {
        String[] c = senate.split("");
        Stack<Integer> stackR = new Stack<>();
        Stack<Integer> stackD = new Stack<>();
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();
        dfs(c,stackR,stackD,stackA,stackB);
        System.out.println(Arrays.toString(c));
        for (String s : c) {
            if (!"0".equals(s)){
                return "R".equals(s)?"Radiant":"Dire";
            }
        }
        return null;
    }

    // R 代表R有权限的数量，A代表D的总数，  D 代表D有权限的数量，B代表没权限的
    private void dfs(String[] s,Stack<Integer> stackR,Stack<Integer> stackD,Stack<Integer> stackA,Stack<Integer> stackB) {
        stackR.clear();
        stackD.clear();
        for (int j = 0; j < s.length; j++) {
            if ("R".equals(s[j])){
                // D 有权限
                if (stackD.size() > 0){
                    s[j] = "0";
                    // 放到没权限的里面
                    stackB.push(stackD.pop());
                }else{
                    // D 没权限了
                    if (stackB.size() > 0){
                        s[stackB.pop()] = "0";
                        stackA.push(j);
                    }else{
                        stackR.push(j);
                    }
                }
            }else if ("D".equals(s[j])){
                if (stackR.size() > 0){
                    // R 有权限
                    s[j] = "0";
                    stackA.push(stackR.pop());
                }else{
                    // R 没权限
                    if (stackA.size() > 0){
                        s[stackA.pop()] = "0";
                        stackB.push(j);
                    }else{
                        stackD.push(j);
                    }
                }
            }
        }
        if ((stackD.isEmpty() && stackB.isEmpty()) || (stackA.isEmpty() && stackR.isEmpty())){
            return;
        }
        stackA.empty();
        stackB.empty();
        stackD.empty();
        stackR.empty();
        dfs(s,stackR,stackD,stackA,stackB);
    }

    public static void main(String[] args) {
        Title649 title69 = new Title649();
        System.out.println(title69.predictPartyVictory("RD"));
        System.out.println(title69.predictPartyVictory("RDD"));
        System.out.println(title69.predictPartyVictory("DDRRRR"));
        System.out.println(title69.predictPartyVictory("DDRRR"));
        System.out.println(title69.predictPartyVictory("DR"));
        System.out.println(title69.predictPartyVictory("DRR"));
        System.out.println(title69.predictPartyVictory("DRRDRDRDR"));
        System.out.println(title69.predictPartyVictory("DRRDRDRDRDDR"));
        System.out.println(title69.predictPartyVictory("DRRDRDRDRDDRDR"));
        System.out.println(title69.predictPartyVictory("DRRDRDRDRDDRDRDR"));
    }
}
