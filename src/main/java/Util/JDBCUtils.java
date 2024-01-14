package Util;

import java.sql.*;

/**
 * 数据库连接类
 * @author 13425
 */
public class JDBCUtils {
    //数据库连接地址
    public static String URL = "jdbc:mysql://192.168.207.136:3306/homework_test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String USER = "root";
    public static String PWD = "password";

    /**
     * 数据库连接
     * @return	数据库连接
     */
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PWD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 关闭连接资源
     * @param con	连接对象
     * @param pstmt	预编译对象
     * @param rs	结果集
     */
    public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
