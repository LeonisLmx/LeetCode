/**
 * @author urey.liu
 * @description
 * @date 2021/11/29 11:12 上午
 */
public class AppendSql {

    public static void main(String[] args) {
        String sql =
                        "CREATE TABLE `user_privilege_record_%d` (\n" +
                                "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',\n" +
                                "  `user_id` bigint(20) NOT NULL COMMENT '用户id',\n" +
                                "  `type` int(2) NOT NULL COMMENT '权益类型',\n" +
                                "  `award_time` datetime NOT NULL COMMENT '领取时间',\n" +
                                "  `extra` varchar(255) DEFAULT NULL COMMENT '权益领取详情',\n" +
                                "  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
                                "  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',\n" +
                                "  PRIMARY KEY (`id`),\n" +
                                "  KEY `IDX_USER_ID_TYPE_AWARD_TIME` (`user_id`,`type`,`award_time`) USING BTREE COMMENT '权益索引',\n" +
                                "  KEY `IDX_CREATE_TIME` (`create_time`) USING BTREE COMMENT '时间索引'\n" +
                                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户权益详情表';";
        for (int i = 0;i <= 99;i++) {
            if (i % 2 != 0) {
                System.out.println(sql.replaceAll("%d", i + ""));
            }
        }
    }
}
