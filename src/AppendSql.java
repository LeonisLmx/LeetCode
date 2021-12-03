/**
 * @author urey.liu
 * @description
 * @date 2021/11/29 11:12 上午
 */
public class AppendSql {

    public static void main(String[] args) {
        String sql = "UPDATE user_prop_%d set prop_delete_time = NULL where prop_id = 100050055 or prop_id = 100050056;";
        for (int i = 1;i < 100;i++) {
            System.out.println(String.format(sql, i));
            System.out.println("");
        }
    }
}
