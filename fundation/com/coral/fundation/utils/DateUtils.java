/**
 * 
 */
package com.coral.fundation.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>Title: eBaoTech System Infrastructure</p>
 * <p>Description: This class is the utility class to manipulate dates</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBaoTech Co., Ltd.</p>
 * <p>Create Time:</p>
 * @author eBaoTech
 * @version 1.0
 * $Id: DateUtils.java,v 1.24 2005/05/23 05:39:20 jason.shi Exp $
 * $Log: DateUtils.java,v $
 * Revision 1.24  2005/05/23 05:39:20  jason.shi
 * change new DBean para to false
 *
 * Revision 1.23  2005/05/23 05:31:50  jason.shi
 * change new DBean para to false
 *
 * Revision 1.22  2005/04/25 03:32:30  tus.liu
 * add method of get workday amount between 2 date
 *
 * Revision 1.21  2005/04/22 05:41:31  tus.liu
 * working calendar samsung initial version
 *
 * Revision 1.20  2005/04/20 08:08:51  tus.liu
 * add get next workday procedure
 *
 * Revision 1.19  2005/04/11 09:25:25  mindy.lu
 * change isMaxDayOfMonth() and getMaxDayOfMonth() to public
 *
 * Revision 1.18  2005/04/04 07:15:20  brian.hu
 * *** empty log message ***
 *
 * Revision 1.17  2005/03/02 08:44:12  qiang.zhao
 * <No Comment Entered>
 *
 * Revision 1.16  2005/01/19 08:14:12  qiang.zhao
 * <No Comment Entered>
 *
 * Revision 1.15  2004/12/21 06:58:10  jerry.min
 * <No Comment Entered>
 *
 * Revision 1.14  2004/11/29 10:33:21  qiang.zhao
 * <No Comment Entered>
 *
 * Revision 1.13  2004/10/21 02:59:19  tairs.zhang
 * add toSqlDate(Date utilDate)
 *
 * Revision 1.12  2004/09/27 02:35:04  qiang.zhao
 * <No Comment Entered>
 *
 * Revision 1.11  2004/09/01 04:07:08  jerry.min
 * add new date2string
 *
 * Revision 1.10  2004/08/12 04:18:36  jerry.min
 * add getShortYear javadoc
 *
 * Revision 1.9  2004/08/12 04:17:25  jerry.min
 * update getShortYear
 *
 * Revision 1.8  2004/08/12 04:15:56  jerry.min
 * add getShortYear
 *
 * Revision 1.7  2004/08/03 02:46:02  tairs.zhang
 * amend getMonthAmount() arithmetic.
 *
 * Revision 1.5  2004/07/30 10:37:09  qiang.zhao
 * <No Comment Entered>
 *
 */
public class DateUtils {
  private static final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd";
  public static String[] optionDateFormats = new String[]{
      "yyyy-MM-dd HH:mm:ss.S a", "yyyy-MM-dd HH:mm:ssz", "yyyy-MM-dd HH:mm:ss",
      "yyyy-MM-dd HH:mm:ssa", "dd/MM/yyyy HH:mm", "yyyy-MM-dd", "MM-dd"}; // backwards compatability

  private DateUtils() {
  }

  /**
   * get the year of a date
   * @param date Date the date which the date get from
   * @return int the year of the date
   */
  public static int getYear(java.util.Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(Calendar.YEAR);
  }

  /**
   * get the last two numbers of the year
   * @param date the date
   * @return the short format year
   */
  public static String getShortYear(java.util.Date date) {
    String year = getYear(date) + "";
    int length = year.length();
    return year.substring(length - 2, length);
  }

  /**
   * get the month of a date
   * @param date Date the date which the month get from
   * @return int the month of the date
   */
  public static int getMonth(java.util.Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(Calendar.MONTH) + 1;
  }

  /**
   * get the day of a date
   * @param date Date the date which the day get from
   * @return int the day of the date
   */
  public static int getDay(java.util.Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(Calendar.DAY_OF_MONTH);
  }

  /**
   * get the hour of a date
   * @param date Date the date which the hour get from
   * @return int the hour of the date
   */
  public static int getHour(java.util.Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(Calendar.HOUR_OF_DAY);
  }

  /**
   * get the minute of a date
   * @param date Date the date which the minute get from
   * @return int the minute of the date
   */
  public static int getMinute(java.util.Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(Calendar.MINUTE);
  }

  /**
   * get the second of a date
   * @param date Date the date which the second get from
   * @return int the second of the date
   */
  public static int getSecond(java.util.Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(Calendar.SECOND);
  }

  /**
   * add days to a date
   * @param oldDate Date the date to be added to
   * @param addDays int the day to be added
   * @return Date the result date
   */
  public static Date addDay(java.util.Date oldDate, int addDays) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(oldDate);
    calendar.add(Calendar.DATE, addDays);
    return calendar.getTime();
  }

  /**
   * add hours to a date
   * @param oldDate Date the date to be added to
   * @param addHours int the hour to be added
   * @return Date the result date
   */
  public static Date addHour(java.util.Date oldDate, int addHours) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(oldDate);
    calendar.add(Calendar.HOUR, addHours);
    return calendar.getTime();
  }

  /**
   * add months to a date
   * @param oldDate Date the date to be added to
   * @param addMonths int the day to be added
   * @return Date the result date
   */
  public static Date addMonth(java.util.Date oldDate, int addMonths) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(oldDate);
    calendar.add(Calendar.MONTH, addMonths);
    return calendar.getTime();
  }

  /**
   * add years to a date
   * @param oldDate Date the date to be added to
   * @param addYears int the day to be added
   * @return Date the result date
   */
  public static Date addYear(java.util.Date oldDate, int addYears) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(oldDate);
    calendar.add(Calendar.YEAR, addYears);
    return calendar.getTime();
  }

  /**
   * round the year of a date
   * @param date Date the date to be rounded
   * @return Date the rounded date
   * 
   */
  public static Date roundYear(Date date) {
    return org.apache.commons.lang.time.DateUtils.round(date, Calendar.YEAR);
  }

  /**
   * round the month of a date
   * @param date Date the date to be rounded
   * @return Date the rounded date
   */
  public static Date roundMonth(Date date) {
    return org.apache.commons.lang.time.DateUtils.round(date, Calendar.MONTH);
  }

  /**
   * round the day of a date
   * @param date Date the date to be rounded
   * @return Date the rounded date
   */
  public static Date roundDay(Date date) {
    return org.apache.commons.lang.time.DateUtils.round(date, Calendar.DATE);
  }

  /**
   * round the hour of a date
   * @param date Date the date to be rounded
   * @return Date the rounded date
   */
  public static Date roundHour(Date date) {
    return org.apache.commons.lang.time.DateUtils.round(date, Calendar.HOUR);
  }

  /**
   * round the minute of a date
   * @param date Date the date to be rounded
   * @return Date the rounded date
   */
  public static Date roundMinute(Date date) {
    return org.apache.commons.lang.time.DateUtils.round(date, Calendar.MINUTE);
  }

  /**
   * round the second of a date
   * @param date Date the date to be rounded
   * @return Date the rounded date
   */
  public static Date roundSencond(Date date) {
    return org.apache.commons.lang.time.DateUtils.round(date, Calendar.SECOND);
  }

  /**
   * truncate the year of a date
   * @param date Date the date to be truncated
   * @return Date the truncated date
   */
  public static Date truncateYear(Date date) {
    return org.apache.commons.lang.time.DateUtils.truncate(date, Calendar.YEAR);
  }

  /**
   * truncate the month of a date
   * @param date Date the date to be truncated
   * @return Date the truncated date
   */
  public static Date truncateMonth(Date date) {
    return org.apache.commons.lang.time.DateUtils
        .truncate(date, Calendar.MONTH);
  }

  /**
   * truncate the day of a date
   * @param date Date the date to be truncated
   * @return Date the truncated date
   */
  public static Date truncateDay(Date date) {
    return org.apache.commons.lang.time.DateUtils.truncate(date, Calendar.DATE);
  }

  /**
   * truncate the hour of a date
   * @param date Date the date to be truncated
   * @return Date the truncated date
   */
  public static Date truncateHour(Date date) {
    return org.apache.commons.lang.time.DateUtils.truncate(date, Calendar.HOUR);
  }

  /**
   * truncate the minute of a date
   * @param date Date the date to be truncated
   * @return Date the truncated date
   */
  public static Date truncateMinute(Date date) {
    return org.apache.commons.lang.time.DateUtils.truncate(date,
        Calendar.MINUTE);
  }

  /**
   * truncate the second of a date
   * @param date Date the date to be truncated
   * @return Date the truncated date
   */
  public static Date truncateSecond(Date date) {
    return org.apache.commons.lang.time.DateUtils.truncate(date,
        Calendar.SECOND);
  }

  public static String date2string(java.util.Date date, String format) {
    if (date == null)
      return null;
    else {
      if (format == null)
        format = "dd/MM/yyyy";
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
      return simpleDateFormat.format(date);
    }
  }

  /**
   * convert a date to a string
   * @param date Date the date to be transferred
   * @return String the transferred date string
   */
  public static String date2String(java.util.Date date) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
        DATE_DEFAULT_FORMAT);
    if (date == null)
      return null;
    else
      return simpleDateFormat.format(date);
  }

  /**
   * convert a string to a date according to the default format.
   * @param sDate String the string to be transferred
   * @exception Exception if the specified string cannot be parsed.
   * @return Date the transferred date
   */
  public static java.util.Date toDate(String sDate) throws Exception {
    if (sDate == null || sDate.equals(""))
      return null;
    return toDate(sDate, DATE_DEFAULT_FORMAT);
  }

  /**
   * convert a string to a date according to the indicated format.
   * @param sDate String the string to be transferred
   * @param format String the indicated format
   * @exception Exception if the specified string cannot be parsed.
   * @return Date the transferred date
   */
  public static java.util.Date toDate(String sDate, String format)
      throws Exception {
    if (sDate == null || sDate.equals(""))
      return null;
    //SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
    return parse(sDate, format);
  }

  private static Date parse(String date, String defaultFormat) throws Exception {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(defaultFormat);

    try {
      return simpleDateFormat.parse(date);
    } catch (ParseException e) {
      for (int i = 0; i < optionDateFormats.length; i++) {
        try {
          SimpleDateFormat format = new SimpleDateFormat(optionDateFormats[i]);
          return format.parse(date);
        } catch (ParseException e2) {
          // no worries, let's try the next format.
        }
      }
      // no dateFormats left to try
      throw new Exception("Cannot parse date " + date);

    }

  }

  /**
   * calculate age according to the birthday
   * @param birthday Date the birthday to be converted
   * @param endDate Date the destination date
   * @return int the age
   */
  public static int getAge(Date birthday, Date endDate) {
    int nAge = 0;
    nAge = endDate.getYear() - birthday.getYear();
    if (endDate.getMonth() * 100 + endDate.getDate() < birthday.getMonth()
        * 100 + birthday.getDate()) {
      nAge--;
    }
    return nAge;
  }

  /**
   * calculate age according to the birthday
   * @param startDate Date the birthday to be converted
   * @param endDate Date the destination date
   * @return int the age
   */
  public static double getYearAmount(Date startDate, Date endDate) {
    return getMonthAmount(startDate, endDate) / 12.0;
  }

  /**
   * calculate the days between two dates
   * @param startDate Date the start date to be calculated
   * @param endDate Date the end date to be calculated
   * @return int the result day amount
   */
  public static double getDayAmount(Date startDate, Date endDate) {
    return ((endDate.getTime() - startDate.getTime()) / (double) (1000 * 60 * 60 * 24));
  }

  /**
   * calculate the months between two dates
   * calculational logic(refer to months_between(date1,date2), a internal function of SQL):
   * if they have the same day of month or they both are
   * the max day of their own month, the result is a integer.
   * Otherwise, the result contains decimal part,
   * and the days of a month defined by CONST.DAYS_OF_MONTH.
   * @param startDate Date the start date to be calculated
   * @param endDate Date the end date to be calculated
   * @return int the result month amount
   */
  public static double getMonthAmount(Date startDate, Date endDate) {
    int years = 0;
    int nonths = 0;
    double days = 0;
    double monthAmount = 0;
    years = getYear(endDate) - getYear(startDate);
    nonths = getMonth(endDate) - getMonth(startDate);
    if ((getDay(endDate) == getDay(startDate))
        || (isMaxDayOfMonth(startDate) && isMaxDayOfMonth(endDate))) {
      days = 0;
    } else {
      //      //reckoning in hour, minute and second.
      //      Date tempDate = null;
      //      if(getDay(endDate)>getDay(startDate)){
      //        tempDate = new Date(startDate.getTime());
      //        tempDate.setYear(endDate.getYear());
      //        tempDate.setMonth(endDate.getMonth());
      //        days = getDayAmount(tempDate,endDate);
      //      }else{
      //        tempDate = new Date(endDate.getTime());
      //        tempDate.setYear(startDate.getYear());
      //        tempDate.setMonth(startDate.getMonth());
      //        days = getDayAmount(startDate,tempDate);
      //      }
      //not reckoning in hour, minute and second.
      days = getDay(endDate) - getDay(startDate);
    }
    monthAmount = years * 12 + nonths + days / 30;
    return monthAmount;
  }

  /**
   * to judge whether the date is the max day of its month.
   * @param date Date the date
   * @return boolean true if the date is the max day of its month.
   */
  public static boolean isMaxDayOfMonth(Date date) {
    return getDay(date) == getMaxDayOfMonth(date);
  }

  /**
   * get the max day of the indicated month by the date
   * @param date Date the date to indicate the month
   * @return int the max day of the month
   */
  public static int getMaxDayOfMonth(Date date) {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    return c.getActualMaximum(Calendar.DAY_OF_MONTH);
  }

  public static boolean isWeekend(java.util.Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    int i = cal.get(Calendar.DAY_OF_WEEK);
    return isWeekend(i);

  }

  public static boolean isWeekend(int currDayOfWeek) {
    return currDayOfWeek == Calendar.SATURDAY
        || currDayOfWeek == Calendar.SUNDAY;

  }

  public static boolean isWeekend(String strDate) throws Exception {
    Date date = parse(strDate, "yyyyMMdd");
    return isWeekend(date);

  }
  /**
   * transform java.util.Date to java.sql.Date
   * @param utilDate Date
   * @return Date
   */
  public static java.sql.Date toSqlDate(Date utilDate) {
    if (utilDate == null)
      return null;
    return new java.sql.Date(utilDate.getTime());
  }

  public static int getAgeNearest(Date birthday, Date endDate) {
    int nAge = 0;
    int nDistance = (endDate.getMonth() * 100 + endDate.getDate())
        - (birthday.getMonth() * 100 + birthday.getDate());
    nAge = endDate.getYear() - birthday.getYear();
    if (nDistance < 0)
      nDistance = 0 - nDistance;
    if (nDistance > 600) {
      nAge--;
    }
    return nAge;
  }
}
