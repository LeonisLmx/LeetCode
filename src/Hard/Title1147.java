package Hard;

/**
 * @author urey.liu
 * @description
 * @date 2023/4/12 10:42 上午
 */
public class Title1147 {

    int res = 0;

    public int longestDecomposition(String text) {
        res = 0;
        text = revert(text);
        return text.length() > 0?res + 1:res;
    }

    private String revert(String text) {
        int start = 0,end = text.length() - 1;
        loop:
        while (start < end){
            if (text.charAt(start) == text.charAt(end)){
                for (int i = start,j = end;i >= 0;i--,j--){
                    if (text.charAt(i) != text.charAt(j)){
                        start++;
                        continue loop;
                    }
                }
                res += 2;
                return revert(text.substring(start + 1,text.length() - start - 1));
            }
            start++;
        }
        return text;
    }

    public static void main(String[] args) {
        Title1147 title1147 = new Title1147();
        System.out.println(title1147.longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"));
        System.out.println(title1147.longestDecomposition("merchant"));
        System.out.println(title1147.longestDecomposition("antaprezatepzapreanta"));
        System.out.println(title1147.longestDecomposition("elvtoelvto"));
        System.out.println(title1147.longestDecomposition("nufbkflwjjlwjjnufbkf"));
    }
}
