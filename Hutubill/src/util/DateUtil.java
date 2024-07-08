package util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private static final long MILLISECOND_DAY = 1000*60*60*24;

    public static java.sql.Date util2sql(java.util.Date d){
        return new java.sql.Date(d.getTime());
    }

    public static Date today(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    public static Date monthBegin(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DATE, 1);

        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTime();
    }

    public static Date monthEnd(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.DATE, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, -1);
        return c.getTime();
    }

    /*
    * 本月总日数
    * */
    public static int thisMonthTotalDay(){
        long lastDay = monthEnd().getTime();
        long firstDay = monthBegin().getTime();
        return  (int) ((lastDay-firstDay)/MILLISECOND_DAY) +1;
    }


    /*
    * 计算本月剩余日数
    * */
    public static int thisMonthLeftDay(){
        long lastDay = monthEnd().getTime();
        long toDay = today().getTime();
        return  (int) ((lastDay-toDay)/MILLISECOND_DAY) +1;
    }


    public static void main(String[] args) {
//		System.out.println(DateUtil.today());
//		System.out.println(DateUtil.monthBegin());
        System.out.println(DateUtil.monthEnd());
//		System.out.println(thisMonthLeftDay());
//		System.out.println(thisMonthTotalDay());
    }

}
