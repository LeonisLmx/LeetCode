package Middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: Urey
 * @Date: 2021/7/6
 */
public class Title1418 {

    /**
     * 名字是没有用的，所以只有下标为1的桌号和下标为2的菜单有用
     * @param orders
     * @return
     */
    public List<List<String>> displayTable(List<List<String>> orders) {
        // 每个桌号点了哪些菜,每个菜点了几样
        Map<String,Map<String,Integer>> tableMap = new HashMap<>();
        // 维护所有的菜单
        List<String> orderName = new ArrayList<>();
        // 维护所有桌号
        List<String> tableList = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            Map<String,Integer> map = tableMap.getOrDefault(orders.get(i).get(1),new HashMap<>());
            int num = map.getOrDefault(orders.get(i).get(2),0);
            num += 1;
            map.put(orders.get(i).get(2),num);
            tableMap.put(orders.get(i).get(1),map);
            if (!orderName.contains(orders.get(i).get(2))) {
                orderName.add(orders.get(i).get(2));
            }
            if (!tableList.contains(orders.get(i).get(1))) {
                tableList.add(orders.get(i).get(1));
            }
        }
        List<List<String>> lists = new LinkedList<>();
        tableList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(Integer.parseInt(o1),Integer.parseInt(o2));
            }
        });
        List<String> list = new ArrayList<>();
        Collections.sort(orderName);
        list.add("Table");
        list.addAll(orderName);
        lists.add(list);
        for (int i = 0; i < tableList.size(); i++) {
            List<String> numList = new LinkedList<>();
            numList.add(tableList.get(i));
            for (int j = 1;j < list.size();j++){
                numList.add(tableMap.getOrDefault(tableList.get(i),new HashMap<>()).getOrDefault(list.get(j),0) + "");
            }
            lists.add(numList);
        }
        return lists;
    }
}
