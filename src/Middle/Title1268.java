package Middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author urey.liu
 * @description
 *
 * 给你一个产品数组products和一个字符串searchWord，products 数组中每个产品都是一个字符串。
 *
 * 请你设计一个推荐系统，在依次输入单词searchWord 的每一个字母后，推荐products 数组中前缀与searchWord 相同的最多三个产品。如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。
 *
 * 请你以二维列表的形式，返回在输入searchWord每个字母后相应的推荐产品的列表。
 *
 *
 * 示例 1：
 *
 * 输入：products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * 输出：[
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * 解释：按字典序排序后的产品列表是 ["mobile","moneypot","monitor","mouse","mousepad"]
 * 输入 m 和 mo，由于所有产品的前缀都相同，所以系统返回字典序最小的三个产品 ["mobile","moneypot","monitor"]
 * 输入 mou， mous 和 mouse 后系统都返回 ["mouse","mousepad"]
 * 示例 2：
 *
 * 输入：products = ["havana"], searchWord = "havana"
 * 输出：[["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * 示例 3：
 *
 * 输入：products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
 * 输出：[["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 * 示例 4：
 *
 * 输入：products = ["havana"], searchWord = "tatiana"
 * 输出：[[],[],[],[],[],[],[]]
 *
 *  队列
 *
 * @date 2023/4/14 5:20 下午
 */
public class Title1268 {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        products = Arrays.stream(products).sorted(Comparator.naturalOrder()).toArray(String[]::new);
        for (int i = 0;i < searchWord.length();i++){
            res.add(new ArrayList<>());
            for (int j = 0;j < products.length;j++){
                if (!products[j].equals("") && i < products[j].length() && searchWord.charAt(i) == products[j].charAt(i)){
                    if (res.get(i).size() < 3) {
                        res.get(i).add(products[j]);
                    }
                }else{
                    products[j] = "";
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Title1268 title1268 = new Title1268();
        System.out.println(title1268.suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"},"mouse"));
    }
}
