package Util;

/**
 * 登录信息保存静态类
 *
 * @author 13425
 */
public class DataTemp {
    /**
     * 学生的学号（不是登录账号）
     */
    public static String studentId;

    /**
     * 辅导员的工号
     */
    public static String teacherId;

    /**
     * 学生的姓名（保留备用）
     */
    public static String studentName;

    /**
     * 学生所在的班级（保留备用）
     */
    public static String studentClass;

    /**
    管理员、辅导员或者学生的登录账号
     */
    public static String uid;

    /**
    管理员、辅导员或者学生的密码
     */
    public static String password;

    /**
    管理员、辅导员、学生身份选择
    0-管理员
    1-辅导员
    2-学生
     */
    public static Integer role;

    /**
     * 奖学金的ID(保留备用)
     */
    public static Integer scholarshipId;
}
