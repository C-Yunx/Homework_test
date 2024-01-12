package Dao;

import Entity.Teacher;
import Util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 辅导员数据库操作
 */
public class TeacherDao {
    /**
     * 辅导员登录
     * @param username 账号
     * @param password 密码
     */
    public Teacher login(String username, String password) {
        Teacher teacher = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement("select * from t_teacher where username=? and password=?");
            pstmt.setObject(1, username);
            pstmt.setObject(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                teacher = new Teacher();
                teacher.setId(rs.getString("id"));
                teacher.setUsername(rs.getString("username"));
                teacher.setPassword(rs.getString("password"));
                teacher.setNickname(rs.getString("nickname"));
                teacher.setSex(rs.getInt("sex"));
                teacher.setBirthday(rs.getString("birthday"));
                teacher.setTelephone(rs.getString("telephone"));
                teacher.setEmail(rs.getString("email"));
                teacher.setProfession(rs.getString("profession"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return teacher;
    }

    /**
     * 查询辅导员列表
     * @param id 账号
     */
    public List<Teacher> queryList(String id, String nickname) {
        List<Teacher> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JDBCUtils.getConnection();
            List<String> params = new ArrayList<>();
            StringBuffer sb = new StringBuffer("select * from t_teacher where 1=1");
            if (nickname != null && !id.isEmpty()) {
                sb.append(" and id like?");
                params.add("%" + id + "%");
            }
            if (nickname != null && !nickname.isEmpty()) {
                sb.append(" and nickname like?");
                params.add("%" + nickname + "%");
            }
            pstmt = con.prepareStatement(sb.toString());
            if (params != null && !params.isEmpty()) {
                for (int i = 0; i < params.size(); i++) {
                    pstmt.setObject(i + 1, params.get(i));
                }
            }
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getString("id"));
                teacher.setUsername(rs.getString("username"));
                teacher.setPassword(rs.getString("password"));
                teacher.setNickname(rs.getString("nickname"));
                teacher.setSex(rs.getInt("sex"));
                teacher.setBirthday(rs.getString("birthday"));
                teacher.setTelephone(rs.getString("telephone"));
                teacher.setEmail(rs.getString("email"));
                teacher.setProfession(rs.getString("profession"));
                list.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(con, pstmt, rs);
        }
        return list;
    }

    /**
     * 保存辅导员信息
     * @param teacher
     * @return
     */
    public boolean save(Teacher teacher) {
        Connection con = null;
        String sql = "insert into t_teacher(id,username,password,nickname,sex,birthday,telephone,email,profession,create_time,update_time) values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            con = JDBCUtils.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, teacher.getId());
            pstmt.setString(2, teacher.getUsername());
            pstmt.setString(3, teacher.getPassword());
            pstmt.setString(4, teacher.getNickname());
            pstmt.setInt(5, teacher.getSex());
            pstmt.setString(6, teacher.getBirthday());
            pstmt.setString(7, teacher.getTelephone());
            pstmt.setString(8, teacher.getEmail());
            pstmt.setString(9, teacher.getProfession());
            pstmt.setTimestamp(10, new Timestamp(new java.util.Date().getTime()));
            pstmt.setTimestamp(11, new Timestamp(new java.util.Date().getTime()));
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(con, pstmt, null);
        }
        return false;
    }

    /**
     * 根据id查询辅导员信息
     * @param ids
     * @return
     */
    public Teacher getById(int ids) {
        Teacher teacher = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement("select * from t_teacher where id=?");
            pstmt.setObject(1, ids);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                teacher = new Teacher();
                teacher.setId(rs.getString("id"));
                teacher.setUsername(rs.getString("username"));
                teacher.setPassword(rs.getString("password"));
                teacher.setNickname(rs.getString("nickname"));
                teacher.setSex(rs.getInt("sex"));
                teacher.setBirthday(rs.getString("birthday"));
                teacher.setTelephone(rs.getString("telephone"));
                teacher.setEmail(rs.getString("email"));
                teacher.setProfession(rs.getString("profession"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return teacher;
    }

    /**
     * 根据账号查询辅导员信息
     * @param username
     * @return
     */
    public Teacher getByUsername(String username) {
        Teacher teacher = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement("select * from t_teacher where username=?");
            pstmt.setObject(1, username);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                teacher = new Teacher();
                teacher.setId(rs.getString("id"));
                teacher.setUsername(rs.getString("username"));
                teacher.setPassword(rs.getString("password"));
                teacher.setNickname(rs.getString("nickname"));
                teacher.setSex(rs.getInt("sex"));
                teacher.setBirthday(rs.getString("birthday"));
                teacher.setTelephone(rs.getString("telephone"));
                teacher.setEmail(rs.getString("email"));
                teacher.setProfession(rs.getString("profession"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return teacher;
    }

    /**
     * 更新辅导员信息
     * @param teacher
     * @return
     */
    public boolean update(Teacher teacher) {
        Connection con = null;
        String sql = "update t_teacher set id=?,username=?,password=?,nickname=?,sex=?,birthday=?,telephone=?,email=?,profession=?,update_time=? where id=?";
        PreparedStatement pstmt = null;
        try {
            con = JDBCUtils.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, teacher.getId());
            pstmt.setString(2, teacher.getUsername());
            pstmt.setString(3, teacher.getPassword());
            pstmt.setString(4, teacher.getNickname());
            pstmt.setInt(5, teacher.getSex());
            pstmt.setString(6, teacher.getBirthday());
            pstmt.setString(7, teacher.getTelephone());
            pstmt.setString(8, teacher.getEmail());
            pstmt.setString(9, teacher.getProfession());
            pstmt.setTimestamp(10, new Timestamp(new java.util.Date().getTime()));
            pstmt.setString(11, teacher.getId());
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(con, pstmt, null);
        }
        return false;
    }

    /**
     * 根据id删除辅导员信息
     * @param id
     * @return
     */
    public boolean delete(int id) {
        Connection con = null;
        String sql = "delete from t_teacher where id=?";
        PreparedStatement pstmt = null;
        try {
            con = JDBCUtils.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(id));
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(con, pstmt, null);
        }
        return false;
    }
}
