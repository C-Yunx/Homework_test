package Dao;

import Entity.Apply;
import Util.DataTemp;
import Util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 * @description: 对于奖学金申请表的操作类
 */

public class ApplyDao {
    /**
     * 保存奖学金申请
     * @param apply
     * @return
     */
    public boolean save(Apply apply) {
        Connection con = null;
        String sql = "insert into t_apply(scholarshipId,userId,applyNickName,applyClass,scholarshipName,reason,create_time) values(?,?,?,?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            con = JDBCUtils.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, apply.getScholarshipId());
            pstmt.setString(2, apply.getUserId());
            pstmt.setString(3, apply.getApplyNickName());
            pstmt.setString(4, apply.getApplyClass());
            pstmt.setString(5, apply.getScholarshipName());
            pstmt.setString(6, apply.getReason());
            pstmt.setTimestamp(7, new Timestamp(new java.util.Date().getTime()));
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
     * 查询申请列表
     * @param userId
     */
    public List<Apply> queryList(String userId) {
        List<Apply> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JDBCUtils.getConnection();
            String sql = "select * from t_apply where userId = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Apply apply = new Apply();
                apply.setId(rs.getInt("id"));
                apply.setApplyNickName(rs.getString("applyNickName"));
                apply.setApplyClass(rs.getString("applyClass"));
                apply.setScholarshipId(rs.getInt("scholarshipId"));
                apply.setScholarshipName(rs.getString("scholarshipName"));
                apply.setReason(rs.getString("reason"));
                apply.setTeacherId(rs.getString("teacherId"));
                apply.setTeacherState(rs.getString("teacherState"));
                apply.setAdminState(rs.getString("adminState"));
                list.add(apply);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, pstmt, rs);
        }
        return list;
    }

    /**
     * 根据姓名，班级，学号，查询申请的奖学金
     * @param nickName
     * @param classNumber
     * @param scholarshipName
     * @return 
     */
    public List<Apply> queryList1(String nickName, String classNumber, String scholarshipName) {
        List<Apply> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JDBCUtils.getConnection();
            List<String> params = new ArrayList<>();
            StringBuffer sql = new StringBuffer("select * from t_apply where 1 = 1");
            if (nickName != null && !nickName.isEmpty()) {
                sql.append(" and applyNickName like ?");
                params.add("%" + nickName + "%");
            }
            if (classNumber != null && !classNumber.isEmpty()) {
                sql.append(" and applyClass like ?");
                params.add("%" + classNumber + "%");
            }
            if (scholarshipName != null && !scholarshipName.isEmpty()) {
                sql.append(" and scholarshipName like ?");
                params.add("%" + scholarshipName + "%");
            }
            pstmt = con.prepareStatement(sql.toString());
            if (!params.isEmpty()) {
                for (int i = 0; i < params.size(); i++) {
                    pstmt.setObject(i + 1, params.get(i));
                }
            }
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Apply apply = new Apply();
                apply.setId(rs.getInt("id"));
                apply.setApplyNickName(rs.getString("applyNickName"));
                apply.setApplyClass(rs.getString("applyClass"));
                apply.setScholarshipId(rs.getInt("scholarshipId"));
                apply.setScholarshipName(rs.getString("scholarshipName"));
                apply.setReason(rs.getString("reason"));
                apply.setTeacherId(rs.getString("teacherId"));
                apply.setTeacherState(rs.getString("teacherState"));
                apply.setAdminState(rs.getString("adminState"));
                list.add(apply);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, pstmt, rs);
        }
        return list;
    }

    /**
     * 管理员通过奖项名来查询已经通过申请的申请
     * @param scholarshipName
     * @return
     */
    public List<Apply> queryList2(String scholarshipName) {
        List<Apply> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JDBCUtils.getConnection();
            List<String> params = new ArrayList<>();
            StringBuffer sql = new StringBuffer("select * from t_apply where 1 = 1 and teacherState = 'yes' and adminState = 'yes'");
            if (scholarshipName != null && !scholarshipName.isEmpty()) {
                sql.append(" and scholarshipName like ?");
                params.add("%" + scholarshipName + "%");
            }
            pstmt = con.prepareStatement(sql.toString());
            if (!params.isEmpty()) {
                for (int i = 0; i < params.size(); i++) {
                    pstmt.setObject(i + 1, params.get(i));
                }
            }
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Apply apply = new Apply();
                apply.setId(rs.getInt("id"));
                apply.setApplyNickName(rs.getString("applyNickName"));
                apply.setApplyClass(rs.getString("applyClass"));
                apply.setScholarshipName(rs.getString("scholarshipName"));
                apply.setReason(rs.getString("reason"));
                apply.setTeacherId(rs.getString("teacherId"));
                list.add(apply);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, pstmt, rs);
        }
        return list;
    }

    /**
     * 学生通过自己的学号和奖学金的Id删除自己的奖学金申请
     * @param studentId
     * @param scholarshipId
     * @return
     */
    public boolean delete(String studentId, int scholarshipId) {
        Connection con = null;
        PreparedStatement selectStmt = null, deleteStmt = null;
        ResultSet rs = null;
        String selectSql = "SELECT teacherState, adminState FROM t_apply WHERE userId = ? AND scholarshipId = ?";
        String deleteSql = "DELETE FROM t_apply WHERE userId = ? AND scholarshipId = ?";

        try {
            con = JDBCUtils.getConnection();
            // 首先根据学号和奖学金ID查询记录状态
            selectStmt = con.prepareStatement(selectSql);
            selectStmt.setString(1, studentId);
            selectStmt.setInt(2, scholarshipId);
            rs = selectStmt.executeQuery();

            if (rs.next()) {
                String teacherState = rs.getString("teacherState");
                String adminState = rs.getString("adminState");

                // 判断teacherState或adminState是否为空
                if (teacherState != null && !teacherState.isEmpty() || adminState != null && !adminState.isEmpty()) {
                    return false;
                }

                // 如果可以删除，执行删除操作
                deleteStmt = con.prepareStatement(deleteSql);
                deleteStmt.setString(1, studentId);
                deleteStmt.setInt(2, scholarshipId);
                int rows = deleteStmt.executeUpdate();

                if (rows > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, selectStmt, rs);
            JDBCUtils.close(con, deleteStmt, rs);
        }
        return false;
    }

    /**
     * 管理员通过申请表的id删除申请表
     * @param id
     * @return
     */
    public boolean delete(int id) {
        Connection con = null;
        PreparedStatement deleteStmt = null;
        String deleteSql = "DELETE FROM t_apply WHERE id = ?";
        try {
            con = JDBCUtils.getConnection();
            deleteStmt = con.prepareStatement(deleteSql);
            deleteStmt.setInt(1, id);
            int rows = deleteStmt.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, deleteStmt, null);
        }
        return false;
    }

    /**
     * 管理员通过奖学金审核
     * @param id
     * @return
     */
    public boolean setYse(int id) {
        Connection con = null;
        PreparedStatement updateStmt = null;
        String updateSql = "UPDATE t_apply SET adminState = 'yes', update_time = ? WHERE id = ?";
        try {
            con = JDBCUtils.getConnection();
            updateStmt = con.prepareStatement(updateSql);
            updateStmt.setDate(1, new Date(System.currentTimeMillis()));
            updateStmt.setInt(2, id);
            int rows = updateStmt.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, updateStmt, null);
        }
        return false;
    }

    /**
     * 管理员不通过申请
     * @param id
     * @return
     */
    public boolean setNo(int id) {
        Connection con = null;
        PreparedStatement updateStmt = null;
        String updateSql = "UPDATE t_apply SET adminState = 'no', update_time = ? WHERE id = ?";
        try {
            con = JDBCUtils.getConnection();
            updateStmt = con.prepareStatement(updateSql);
            updateStmt.setDate(1, new Date(System.currentTimeMillis()));
            updateStmt.setInt(2, id);
            int rows = updateStmt.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, updateStmt, null);
        }
        return false;
    }

    /**
     * 辅导员通过申请
     * @param id
     * @return
     */
    public boolean TeacherSetYse(int id) {
        Connection con = null;
        PreparedStatement updateStmt = null;
        String updateSql = "UPDATE t_apply SET teacherState = 'yes', update_time = ?, teacherId = ? WHERE id = ?";
        try {
            con = JDBCUtils.getConnection();
            updateStmt = con.prepareStatement(updateSql);
            updateStmt.setDate(1, new Date(System.currentTimeMillis()));
            updateStmt.setString(2, DataTemp.teacherId);
            updateStmt.setInt(3, id);
            int rows = updateStmt.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, updateStmt, null);
        }
        return false;
    }

    /**
     * 辅导员不通过审请
     * @param id
     * @return
     */
    public boolean TeacherSetNo(int id) {
        Connection con = null;
        PreparedStatement updateStmt = null;
        String updateSql = "UPDATE t_apply SET teacherState = 'no', teacherId = ?, update_time = ?  WHERE id = ?";
        try {
            con = JDBCUtils.getConnection();
            updateStmt = con.prepareStatement(updateSql);
            updateStmt.setString(1, DataTemp.teacherId);
            updateStmt.setDate(2, new Date(System.currentTimeMillis()));
            updateStmt.setInt(3, id);
            int rows = updateStmt.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, updateStmt, null);
        }
        return false;
    }
}
