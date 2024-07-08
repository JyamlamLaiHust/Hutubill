package test;

import java.util.Calendar;
import java.util.Date;

public class sample_Date {
    public static Date monthEnd() {
        Calendar c = Calendar.getInstance();

        c.setTime(new Date());
        c.set(Calendar.HOUR_OF_DAY, 0); // 使用 24 小时制
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0); // 将毫秒设置为 0
        c.set(Calendar.DATE, 1); // 设置为当月第一天
        c.add(Calendar.MONTH, 1); // 增加一个月
        c.add(Calendar.DATE, -1); // 减去一天，即为上个月的最后一天
        return c.getTime();
    }

    public static void main(String[] args) {
        System.out.println("本月最后一天: " + monthEnd());
    }
}

