package Dao;

import Entity.Admin;
import Util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 管理员登录数据库操作
 * @author 13425
 */
public class AdminDao {
    /**
     * 管理员登录
     *
     * @param username 账号
     * @param password 密码
     */
    public Admin login(String username, String password) {
        Admin admin = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JDBCUtils.getConnection();
            String sql = "select * from t_admin where username = ? and password = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setObject(1, username);
            pstmt.setObject(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getString("id"));
                admin.setUsername(rs.getString("username"));
                admin.setNickname(rs.getString("nickname"));
                admin.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, pstmt, rs);
        }
        return admin;
    }

//    /**
//     * 根据ID查询管理员
//     */
//    public Admin getById(int id) {
//        Admin admin = null;
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try {
//            con = JDBCUtils.getConnection();
//            String sql = "select * from t_admin where id = ?";
//            pstmt = con.prepareStatement(sql);
//            pstmt.setObject(1, id);
//            rs = pstmt.executeQuery();
//            while(rs.next()){
//                admin = new Admin();
//                admin.setId(rs.getInt("id"));
//                admin.setUsername(rs.getString("username"));
//                admin.setNickname(rs.getString("nickname"));
//                admin.setPassword(rs.getString("password"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            JDBCUtils.close(con, pstmt, rs);
//        }
//        return admin;
//    }

//    /**
//     * 修改管理员密码
//     */
//    public boolean updatePwd(Admin admin){
//
//        Connection con = null;
//        String sql = "update t_admin set password=? where id=?";
//        PreparedStatement pstmt = null;
//        try {
//            con = JDBCUtils.getConnection();
//            pstmt = con.prepareStatement(sql);
//            pstmt.setString(1, admin.getPassword());
//            pstmt.setInt(2, admin.getId());
//            int rows = pstmt.executeUpdate();
//            if(rows > 0){
//                return true;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            JDBCUtils.close(con, pstmt, null);
//        }
//        return false;
//    }
}
