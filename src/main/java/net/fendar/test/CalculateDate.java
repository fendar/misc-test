package net.fendar.test;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * Created by zhongchao on 16/6/22.
 */
public class CalculateDate {
    public static void main(String[] args) {
        Date now = new Date();
        String startDate = DateFormatUtils.format(now, "yyyyMMdd");
        String endDate = DateFormatUtils.format(DateUtils.addDays(now, 0 - 30), "yyyyMMdd");
        System.out.println(String.format("%s %s", startDate, endDate));
    }
}
