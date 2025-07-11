package Base;

import java.time.*;
import java.text.*;
import java.util.*;
// import java.util.Calendar;
// import java.util.Date;

public class Time8 {
    public static void main(String[] args) {
        Time8 getTime = new Time8();
        getTime.TimeChange();
        getTime.DateChange();
    }

    // Time
    public void TimeChange() {
        // 获取当前日期
        LocalDate today = LocalDate.now();
        System.out.println("当前日期: " + today);

        // 创建特定日期
        LocalDate nationalDay = LocalDate.of(2025, 10, 1);
        System.out.println("国庆节: " + nationalDay);

        // 日期加减
        LocalDate tomorrow = today.plusDays(1);
        LocalDate nextMonth = today.plusMonths(1);
        LocalDate lastYear = today.minusYears(1);

        System.out.println("明天: " + tomorrow);
        System.out.println("下个月: " + nextMonth);
        System.out.println("去年今天: " + lastYear);


        //1. LocalDate (日期)
        LocalDate date = LocalDate.of(2023, Month.JUNE, 15);
        int year = date.getYear();  // 2023
        Month month = date.getMonth();  // JUNE
        int day = date.getDayOfMonth();  // 15
        LocalDate nextWeek = today.plusWeeks(1);
        boolean isLeap = date.isLeapYear();  // 是否闰年

        //2. LocalTime (时间)
        LocalTime now = LocalTime.now();
        LocalTime time = LocalTime.of(14, 30, 45);  // 14:30:45
        int hour = time.getHour();  // 14
        int minute = time.getMinute();  // 30
        LocalTime nextHour = time.plusHours(1);

        //3. LocalDateTime (日期时间)
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime dt = LocalDateTime.of(2023, 6, 15, 14, 30);
        LocalDateTime nextMonth1 = dt.plusMonths(1);

        //4. ZonedDateTime (带时区日期时间)
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime nyTime = zdt.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZoneId zone = zdt.getZone();  // 获取时区

        //5. Instant (时间戳)
        Instant instant = Instant.now();  // 获取当前时间戳
        Instant later = instant.plusSeconds(60);  // 60秒后
        long epochMilli = instant.toEpochMilli();  // 获取毫秒时间戳
    }

    // Date
    public void DateChange() {
        // 初始化 Date 对象
        Date date = new Date();
        // 使用 toString() 函数显示日期时间
        System.out.println(date);

        //使用 getTime() 方法比较
        Date date1 = new Date(121, Calendar.JUNE, 15); // 2021年6月15日
        Date date2 = new Date(121, Calendar.JUNE, 20); // 2021年6月20日
        // 比较毫秒数
        if (date1.getTime() < date2.getTime()) {
            System.out.println("date1 在 date2 之前");
        } else if (date1.getTime() > date2.getTime()) {
            System.out.println("date1 在 date2 之后");
        } else {
            System.out.println("两个日期相同");
        }


        //使用 SimpleDateFormat 格式化日期
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("当前时间为: " + ft.format(dNow));
    }
}
