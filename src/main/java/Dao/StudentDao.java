package Dao;

import Entity.Student;
import Util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 学生登录数据库操作
 */
public class StudentDao {
    /**
     * 学生登录
     * @param username 学生账号
     * @param password 学生密码
     */
    public Student login(String username, String password) {
        Student student = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JDBCUtils.getConnection();
            String sql = "select * from t_student where username = ? and password = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setObject(1, username);
            pstmt.setObject(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                student = new Student();
                student.setId(rs.getString("id"));
                student.setClassNumber(rs.getString("classNumber"));
                student.setUsername(rs.getString("username"));
                student.setPassword(rs.getString("password"));
                student.setNickname(rs.getString("nickname"));
                student.setSex(rs.getInt("sex"));
                student.setBirthday(rs.getString("birthday"));
                student.setTelephone(rs.getString("telephone"));
                student.setEmail(rs.getString("email"));
                student.setProfession(rs.getString("profession"));
                student.setIfPool(rs.getInt("ifPool"));
                student.setProClassGrade(rs.getInt("proClassGrade"));
                student.setPeClassGrade(rs.getInt("peClassGrade"));
                student.setCultureClassGrade(rs.getInt("cultureClassGrade"));
                student.setComprehensiveTestGrade(rs.getInt("comprehensiveTestGrade"));
                student.setTotalClassGrade(rs.getInt("totalClassGrade"));
                student.setIfViolationOfDiscipline(rs.getInt("ifViolationOfDiscipline"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, pstmt, rs);
        }
        return student;
    }

    /**
     * 查询学生信息
     * @param id 学生账号
     * @param nickname 学生姓名
     * @param classNumber 学生班级
     */
    public List<Student> queryList(String id, String nickname, String classNumber) {
        List<Student> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JDBCUtils.getConnection();
            List<Object> params = new ArrayList<>();
            StringBuffer sb = new StringBuffer("select * from t_student where 1 = 1");
            if (id != null && !id.isEmpty()) {
                sb.append(" and id like ?");
                params.add("%" + id + "%");
            }
            if (nickname != null && !nickname.isEmpty()) {
                sb.append(" and nickname like ?");
                params.add("%" + nickname + "%");
            }
            if (classNumber != null && !classNumber.isEmpty()) {
                sb.append(" and classNumber like ?");
                params.add("%" + classNumber + "%");
            }
            pstmt = con.prepareStatement(sb.toString());
            if (!params.isEmpty()) {
                for (int i = 0; i < params.size(); i++) {
                    pstmt.setObject(i + 1, params.get(i));
                }
            }
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student = new Student();
                student.setId(rs.getString("id"));
                student.setClassNumber(rs.getString("classNumber"));
                student.setUsername(rs.getString("username"));
                student.setPassword(rs.getString("password"));
                student.setNickname(rs.getString("nickname"));
                student.setSex(rs.getInt("sex"));
                student.setBirthday(rs.getString("birthday"));
                student.setTelephone(rs.getString("telephone"));
                student.setEmail(rs.getString("email"));
                student.setProfession(rs.getString("profession"));
                student.setIfPool(rs.getInt("ifPool"));
                student.setProClassGrade(rs.getInt("proClassGrade"));
                student.setPeClassGrade(rs.getInt("peClassGrade"));
                student.setCultureClassGrade(rs.getInt("cultureClassGrade"));
                student.setComprehensiveTestGrade(rs.getInt("comprehensiveTestGrade"));
                student.setTotalClassGrade(rs.getInt("totalClassGrade"));
                student.setIfViolationOfDiscipline(rs.getInt("ifViolationOfDiscipline"));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, pstmt, rs);
        }
        return list;
    }

    /**
     * 保存学生信息
     * @param student 学生信息
     */
    public boolean save(Student student) {
        Connection con = null;
        String sql = "insert into t_student(id, classNumber, username, password, nickname, sex, birthday, telephone, email, profession, ifPool, proClassGrade, peClassGrade, cultureClassGrade, comprehensiveTestGrade, totalClassGrade, ifViolationOfDiscipline, create_time, update_time) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            con = JDBCUtils.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, student.getId());
            pstmt.setString(2, student.getClassNumber());
            pstmt.setString(3, student.getUsername());
            pstmt.setString(4, student.getPassword());
            pstmt.setString(5, student.getNickname());
            pstmt.setInt(6, student.getSex());
            pstmt.setString(7, student.getBirthday());
            pstmt.setString(8, student.getTelephone());
            pstmt.setString(9, student.getEmail());
            pstmt.setString(10, student.getProfession());
            pstmt.setInt(11, student.getIfPool());
            pstmt.setInt(12, student.getProClassGrade());
            pstmt.setInt(13, student.getPeClassGrade());
            pstmt.setInt(14, student.getCultureClassGrade());
            pstmt.setInt(15, student.getComprehensiveTestGrade());
            pstmt.setInt(16, student.getTotalClassGrade());
            pstmt.setInt(17, student.getIfViolationOfDiscipline());
            Date date = new Date();
            pstmt.setTimestamp(18, new Timestamp(date.getTime()));
            pstmt.setTimestamp(19, new Timestamp(date.getTime()));
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, pstmt, null);
        }
        return false;
    }

    /**
     * 根据学号查询学生
     * @param id 主键学号
     * @return
     */
    public Student getById(int id) {
        Student student = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JDBCUtils.getConnection();
            String sql = "select * from t_student where id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setObject(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                student = new Student();
                student.setId(rs.getString("id"));
                student.setClassNumber(rs.getString("classNumber"));
                student.setUsername(rs.getString("username"));
                student.setPassword(rs.getString("password"));
                student.setNickname(rs.getString("nickname"));
                student.setSex(rs.getInt("sex"));
                student.setBirthday(rs.getString("birthday"));
                student.setTelephone(rs.getString("telephone"));
                student.setEmail(rs.getString("email"));
                student.setProfession(rs.getString("profession"));
                student.setIfPool(rs.getInt("ifPool"));
                student.setProClassGrade(rs.getInt("proClassGrade"));
                student.setPeClassGrade(rs.getInt("peClassGrade"));
                student.setCultureClassGrade(rs.getInt("cultureClassGrade"));
                student.setComprehensiveTestGrade(rs.getInt("comprehensiveTestGrade"));
                student.setIfViolationOfDiscipline(rs.getInt("ifViolationOfDiscipline"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(con, pstmt, rs);
        }
        return student;
    }

    /**
     * 根据账号来查询学生
     * @param username 账号
     */
    public Student getByUsername(String username) {
        Student student = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JDBCUtils.getConnection();
            String sql = "select * from t_student where username = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setObject(1, username);
            while (rs.next()) {
                student = new Student();
                student.setId(rs.getString("id"));
                student.setClassNumber(rs.getString("classNumber"));
                student.setUsername(rs.getString("username"));
                student.setPassword(rs.getString("password"));
                student.setNickname(rs.getString("nickname"));
                student.setSex(rs.getInt("sex"));
                student.setBirthday(rs.getString("birthday"));
                student.setTelephone(rs.getString("telephone"));
                student.setEmail(rs.getString("email"));
                student.setProfession(rs.getString("profession"));
                student.setIfPool(rs.getInt("ifPool"));
                student.setProClassGrade(rs.getInt("proClassGrade"));
                student.setPeClassGrade(rs.getInt("peClassGrade"));
                student.setCultureClassGrade(rs.getInt("cultureClassGrade"));
                student.setComprehensiveTestGrade(rs.getInt("comprehensiveTestGrade"));
                student.setIfViolationOfDiscipline(rs.getInt("ifViolationOfDiscipline"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(con, pstmt, rs);
        }
        return student;
    }

    /**
     * 修改学生信息
     * @param student
     */
    public boolean update(Student student) {
        Connection con = null;
        String sql = "update t_student set id =?, classNumber =?, username =?, password =?, nickname =?, sex =?, birthday =?, telephone =?, email =?, profession =?, ifPool =?, proClassGrade =?, peClassGrade =?, cultureClassGrade =?, comprehensiveTestGrade =?, totalClassGrade =?, ifViolationOfDiscipline =?, update_time =? where id =?";
        PreparedStatement pstmt = null;
        try {
            con = JDBCUtils.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, student.getId());
            pstmt.setString(2, student.getClassNumber());
            pstmt.setString(3, student.getUsername());
            pstmt.setString(4, student.getPassword());
            pstmt.setString(5, student.getNickname());
            pstmt.setInt(6, student.getSex());
            pstmt.setString(7, student.getBirthday());
            pstmt.setString(8, student.getTelephone());
            pstmt.setString(9, student.getEmail());
            pstmt.setString(10, student.getProfession());
            pstmt.setInt(11, student.getIfPool());
            pstmt.setInt(12, student.getProClassGrade());
            pstmt.setInt(13, student.getPeClassGrade());
            pstmt.setInt(14, student.getCultureClassGrade());
            pstmt.setInt(15, student.getComprehensiveTestGrade());
            pstmt.setInt(16, student.getTotalClassGrade());
            pstmt.setInt(17, student.getIfViolationOfDiscipline());
            pstmt.setTimestamp(18, new Timestamp(new Date().getTime()));
            pstmt.setString(19, student.getId());
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
     * 删除学生
     * @param id 学生id
     */
    public boolean delete(int id) {
        Connection con = null;
        String sql = "delete from t_student where id =?";
        PreparedStatement pstmt = null;
        try {
            con = JDBCUtils.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
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
