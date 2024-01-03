package Middle;

import java.util.*;

/**
 * @author urey.liu
 * @description
 * @date 2023/3/21 7:59 下午
 */
public class Title690 {

    Map<Integer, Employee> map = new HashMap<>();
    Map<Integer, Integer> res = new HashMap<>();
    int ans = 0;

    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Employee employee = map.get(id);
        dfs(employee, 0);
        return ans;
    }

    private void dfs(Employee employee, int val) {
        if (res.containsKey(employee.id)){
            ans += res.get(employee.id);
            return;
        }
        ans += employee.importance;
        while (!employee.subordinates.isEmpty()){
            for (int i = 0;i < employee.subordinates.size();i++){
                dfs(map.get(employee.subordinates.get(i)), val);
            }
        }
        res.put(employee.id, val);
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
}
