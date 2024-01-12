package Dao;

import Entity.Scholarship;
import Util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 奖学金数据库操作类
 */
public class ScholarshipDao {
    /**
     * 查询奖学金列表
     */
    public List<Scholarship> queryList(String scholarshipName, String roleText) {
        List<Scholarship> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            List<String> params = new ArrayList<>();
            StringBuffer sb = new StringBuffer("select * from t_scholarship where 1=1");
            if (scholarshipName != null && !scholarshipName.isEmpty()) {
                sb.append(" and scholarshipName like?");
                params.add("%" + scholarshipName + "%");
            }
            if (roleText != null && !roleText.isEmpty()) {
                sb.append(" and scholarshipType =?");
                params.add(roleText);
            }
            pstmt = conn.prepareStatement(sb.toString());
            if (params != null && !params.isEmpty()) {
                for (int i = 0; i < params.size(); i++) {
                    pstmt.setObject(i + 1, params.get(i));
                }
            }
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Scholarship scholarship = new Scholarship();
                scholarship.setId(rs.getInt("id"));
                scholarship.setScholarshipName(rs.getString("scholarshipName"));
                scholarship.setScholarshipType(rs.getString("scholarshipType"));
                scholarship.setBonusAmount(rs.getString("bonusAmount"));
                scholarship.setScholarshipRequirements(rs.getString("scholarshipRequirements"));
                scholarship.setScholarshipIntroductions(rs.getString("scholarshipIntroductions"));
                list.add(scholarship);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return list;
    }

    /**
     * 保存奖学金信息
     * @param scholarship
     * @return
     */
    public boolean save(Scholarship scholarship) {
        Connection conn = null;
        String sql = "insert into t_scholarship(scholarshipName,scholarshipType,bonusAmount,scholarshipRequirements,scholarshipIntroductions,scholarshipGrade,create_time,update_time) values(?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, scholarship.getScholarshipName());
            pstmt.setString(2, scholarship.getScholarshipType());
            pstmt.setString(3, scholarship.getBonusAmount());
            pstmt.setString(4, scholarship.getScholarshipRequirements());
            pstmt.setString(5, scholarship.getScholarshipIntroductions());
            pstmt.setInt(6, Integer.parseInt(scholarship.getScholarshipRequirements()));
            pstmt.setTimestamp(7, new Timestamp(new Date().getTime()));
            pstmt.setTimestamp(8, new Timestamp(new Date().getTime()));
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn, pstmt, null);
        }
        return false;
    }

    /**
     * 通过id查询奖学金
     * @param ids
     * @return
     */
    public Scholarship getById(int ids) {
        Scholarship scholarship = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement("select * from t_scholarship where id =?");
            pstmt.setObject(1, ids);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                scholarship = new Scholarship();
                scholarship.setId(rs.getInt("id"));
                scholarship.setScholarshipName(rs.getString("scholarshipName"));
                scholarship.setScholarshipType(rs.getString("scholarshipType"));
                scholarship.setBonusAmount(rs.getString("bonusAmount"));
                scholarship.setScholarshipRequirements(rs.getString("scholarshipRequirements"));
                scholarship.setScholarshipIntroductions(rs.getString("scholarshipIntroductions"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return scholarship;
    }

    /**
     * 通过奖学金名称查询奖学金
     *
     * @param scholarshipName
     * @return
     */
    public Scholarship getByName(String scholarshipName) {
        Scholarship scholarship = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement("select * from t_scholarship where scholarshipName =?");
            pstmt.setObject(1, scholarshipName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                scholarship = new Scholarship();
                scholarship.setId(rs.getInt("id"));
                scholarship.setScholarshipName(rs.getString("scholarshipName"));
                scholarship.setScholarshipType(rs.getString("scholarshipType"));
                scholarship.setBonusAmount(rs.getString("bonusAmount"));
                scholarship.setScholarshipRequirements(rs.getString("scholarshipRequirements"));
                scholarship.setScholarshipIntroductions(rs.getString("scholarshipIntroductions"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return scholarship;
    }

    /**
     * 更新Scholarship
     * @param scholarship
     * @return
     */
    public boolean update(Scholarship scholarship) {
        Connection conn = null;
        String sql = "update t_scholarship set scholarshipName =?,scholarshipType =?,bonusAmount =?,scholarshipRequirements =?,scholarshipIntroductions =?,update_time =? where id =?";
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, scholarship.getScholarshipName());
            pstmt.setString(2, scholarship.getScholarshipType());
            pstmt.setString(3, scholarship.getBonusAmount());
            pstmt.setString(4, scholarship.getScholarshipRequirements());
            pstmt.setString(5, scholarship.getScholarshipIntroductions());
            pstmt.setTimestamp(6, new Timestamp(new Date().getTime()));
            pstmt.setInt(7, scholarship.getId());
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn, pstmt, null);
        }
        return false;
    }

    /**
     * 删除奖学金信息
     * @param id
     * @return
     */
    public boolean delete(int id) {
        Connection conn = null;
        String sql = "delete from t_scholarship where id =?";
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, null);
        }
        return false;
    }
}

