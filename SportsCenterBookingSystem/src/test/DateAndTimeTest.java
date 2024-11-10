package test;

import execute.DateAndTime;
import org.junit.Assert;
import org.junit.Test;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DateAndTimeTest {

    @Test
    public void testValidDateAndTime() {
        Assert.assertTrue(DateAndTime.isDateAndTimeValid("20240531 9-17"));
    }

    @Test
    public void testInvalidDateAndTime1() {
        Assert.assertFalse(DateAndTime.isDateAndTimeValid("00002024-05-31 9-17"));
    }

    @Test
    public void testInvalidDateAndTime_InvalidDate() {
        Assert.assertFalse(DateAndTime.isDateAndTimeValid("20240532 9-17")); // 5月没有32日
    }

    @Test
    public void testInvalidDateAndTime_InvalidTime() {
        Assert.assertFalse(DateAndTime.isDateAndTimeValid("20240531 25-17")); // 小时不能超过23
    }

    @Test
    public void testInvalidDateAndTime_NegativeTime() {
        Assert.assertFalse(DateAndTime.isDateAndTimeValid("20240531 -5-17")); // 负数时间
    }

    @Test
    public void testInvalidDateAndTime_NegativeDate() {
        Assert.assertFalse(DateAndTime.isDateAndTimeValid("-20240531 9-17")); // 负数日期
    }

    @Test
    public void testInvalidDateAndTime_WrongMonth() {
        Assert.assertFalse(DateAndTime.isDateAndTimeValid("20241301 9-17")); // 月份不能超过12
    }

    @Test
    public void testInvalidDateAndTime_WrongDay() {
        Assert.assertFalse(DateAndTime.isDateAndTimeValid("20240230 9-17")); // 非闰年2月没有30日
    }

    @Test
    public void testLeapYear() {
        Assert.assertTrue(DateAndTime.isDateAndTimeValid("20240229 9-17")); // 2024年是闰年，2月有29日
    }

    @Test
    public void testNonLeapYear() {
        Assert.assertFalse(DateAndTime.isDateAndTimeValid("20190229 9-17")); // 2019年不是闰年，2月没有29日
    }
 
    @Test
    public void testValidYearMonth() {
        Assert.assertTrue(DateAndTime.isValidYearMonth(2024, 5)); // 有效的年月
    }
    @Test
    public void testInvalidYearMonth() {
        Assert.assertFalse(DateAndTime.isValidYearMonth(2024, 13)); // 无效的月份
    }
    @Test
    public void testCalculateHours_SameDay() {
        Assert.assertEquals(5, DateAndTime.calculateHours(9, 14));
    }

    @Test
    public void testCalculateHours_NextDay() {
        Assert.assertEquals(5, DateAndTime.calculateHours(23, 4)); // 从晚上11点到第二天凌晨4点
    }

    @Test
    public void testCalculateHours_CompleteDay() {
        Assert.assertEquals(24, DateAndTime.calculateHours(0, 0)); // 从午夜到午夜
    }

    @Test
    public void testIsTimeValid_InvalidTime_LetterInTime() {
        Assert.assertFalse(DateAndTime.isTimeValid("a-9"));
    }
    @Test
    public void testIsDateValid_ValidDate_31st() {
        Assert.assertFalse(DateAndTime.isDateValid("00000000")); // 3月31日
    }

    @Test
    public void testIsDateValid_ValidDate_30th() {
        Assert.assertTrue(DateAndTime.isDateValid("20240430")); // 5月30日
    }
}