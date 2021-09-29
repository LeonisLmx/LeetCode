package Middle;

import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Urey
 * @Date: 2021/1/6
 */
public class Title399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Double> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < equations.size(); i++) {
            set.addAll(equations.get(i));
            map.put(equations.get(i).get(0) + "-" + equations.get(i).get(1),values[i]);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            if (!set.contains(queries.get(i).get(0)) || !set.contains(queries.get(i).get(1))) {
                result[i] = -1d;
            } else {
                String base = queries.get(i).get(0), quote = queries.get(i).get(1);
                double s = convert(map, base, quote,new ArrayList<>());
                result[i] = s == 0?-1:s;
            }
        }
        return result;
    }

    private double convert(Map<String, Double> map, String base,String quote,List<String> list) {
        list.add(base + "-" + quote);
        if (base.equals(quote)){
            return 1;
        }
        if (map.get(base + "-" + quote) != null){
            return map.get(base + "-" + quote);
        }
        if (map.get(quote + "-" + base) != null){
            return 1 / map.get(quote + "-" + base);
        }
        for (String s : map.keySet()) {
            String[] str = s.split("-");
            if (map.get(s) == 0){
                return 0;
            }
            if (str[0].equals(base) || str[1].equals(base)){
                if (str[0].equals(base)){
                    if (list.contains(str[1] + "-" + quote)){
                        continue;
                    }
                    map.put(str[1] + "-" + quote,convert(map,str[1],quote,list));
                    return map.get(s) * map.get(str[1] + "-" + quote);
                }else{
                    if (list.contains(str[0] + "-" + quote)){
                        continue;
                    }
                    map.put(str[0] + "-" + quote,convert(map,str[0],quote,list));
                    return map.get(str[0] + "-" + quote) / map.get(s);
                }
            }else if (str[0].equals(quote) || str[1].equals(quote)){
                if (str[0].equals(quote)){
                    if (list.contains(base + "-" + str[1])){
                        continue;
                    }
                    map.put(base + "-" + str[1],convert(map,base,str[1],list));
                    return map.get(base + "-" + str[1]) * (1 / map.get(s))  ;
                }else{
                    if (list.contains(base + "-" + str[0])){
                        continue;
                    }
                    map.put(base + "-" + str[0],convert(map,base,str[0],list));
                    return map.get(s) * map.get(base + "-" + str[0]);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Title399 title399 = new Title399();
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a","b"));
        equations.add(Arrays.asList("c","d"));
        equations.add(Arrays.asList("e","f"));
        equations.add(Arrays.asList("g","h"));
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a","c"));
        queries.add(Arrays.asList("d","f"));
        queries.add(Arrays.asList("h","e"));
        queries.add(Arrays.asList("b","e"));
        queries.add(Arrays.asList("d","h"));
        queries.add(Arrays.asList("g","f"));
        queries.add(Arrays.asList("c","g"));
        System.out.println(Arrays.toString(title399.calcEquation(equations, new double[]{4.5,2.3,8.9,0.44}, queries)));
    }
}
