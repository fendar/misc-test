package net.fendar.test.mybatis;

import java.util.Random;

/**
 * Created by zhongchao on 16/4/5.
 */
public class TypeHandler {
//     select max(id) from ims_ewei_shop_order where uniacid =13 and status = 3 and paytime >= UNIX_TIMESTAMP('2016-04-21 00:00:01') and paytime <= UNIX_TIMESTAMP('2016-04-21 23:00:01');

    public static void main(String[] args) {
        int count = 2371;
        int mc = count / 12;
        int startId =  3241;
        int i = 5;
        Random r = new Random(System.currentTimeMillis()/1000);
        String sql = "update ims_ewei_shop_order set  \n" +
                "createtime = UNIX_TIMESTAMP('2016-#{m}-#{date} 00:00:01') + createtime % 86400, \n" +
                "fetchtime = UNIX_TIMESTAMP('2016-#{m}-#{date} 00:00:01') + fetchtime % 86400, \n" +
                "sendtime = UNIX_TIMESTAMP('2016-#{m}-#{date} 00:00:01') + sendtime % 86400, \n" +
                "paytime = UNIX_TIMESTAMP('2016-#{m}-#{date} 00:00:01') + paytime % 86400\n" +
                " where uniacid =13 and status = 3 and createtime >= UNIX_TIMESTAMP('2016-01-01 00:00:01') AND id > #{sid} limit " + mc;

            String m = i < 10 ? ("0" + i) : String.valueOf(i);
            int dn = r.nextInt(28) + 1;
            String d = dn < 10 ? ("0" + dn) : String.valueOf(dn);
            System.out.println(
                    sql.replace("#{m}", m)
                    .replace("#{date}", d)
                    .replace("#{sid}", String.valueOf(startId))
            );

    }
}
