package Middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author urey.liu
 * @description
 *
 * 如果我们可以将小写字母插入模式串pattern得到待查询项query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
 *
 * 给定待查询列表queries，和模式串pattern，返回由布尔值组成的答案列表answer。只有在待查项queries[i] 与模式串pattern 匹配时，answer[i]才为 true，否则为 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 * 输出：[true,false,true,true,false]
 * 示例：
 * "FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
 * "FootBall" 可以这样生成："F" + "oot" + "B" + "all".
 * "FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
 * 示例 2：
 *
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * 输出：[true,false,true,false,false]
 * 解释：
 * "FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
 * "FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
 * 示例 3：
 *
 * 输出：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 * 输入：[false,true,false,false,false]
 * 解释：
 * "FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
 *
 * @date 2023/4/14 4:37 下午
 */
public class Title1023 {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list = new ArrayList<>();
        int ans = pattern.length();
        loop:
        for (String query : queries) {
            int length = query.length(),i = 0,j = 0;
            while (i < ans && j < length){
                if (Character.isUpperCase(query.charAt(j))){
                    if (pattern.charAt(i) == query.charAt(j)){
                        i++;
                        j++;
                    }else{
                        list.add(false);
                        continue loop;
                    }
                }else{
                    if (pattern.charAt(i) == query.charAt(j)){
                        i++;
                    }
                    j++;
                }
            }
            if (i == ans) {
                list.add(query.substring(j,length).equals(query.substring(j,length).toLowerCase()));
            }else{
                list.add(false);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Title1023 title1023 = new Title1023();
        System.out.println(title1023.camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"},"FB"));
    }
}
