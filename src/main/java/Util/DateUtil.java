package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期和数据处理方法
 * @ClassName: DateUtil
 * 用于检验输入的生日格式
 */
public class DateUtil {
    public static String formatDate(Date date, String format) {
        String result = "";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        //可以让程序严格校验,不合法的日期格式不自动转换
        sdf.setLenient(false);
        if (date != null) {
            result = sdf.format(date);
        }
        return result;
    }

    /**
     * 格式化输入的字符串
     * @param str
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date formatString(String str, String format) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        //可以让程序严格校验,不合法的日期格式不自动转换
        sdf.setLenient(false);
        return sdf.parse(str);
    }
}
