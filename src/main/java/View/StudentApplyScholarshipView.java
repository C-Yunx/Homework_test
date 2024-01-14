/*
 * Created by JFormDesigner on Thu Jan 11 18:09:59 CST 2024
 */

package View;

import Dao.ApplyDao;
import Entity.Apply;
import Util.DataTemp;
import Util.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 学生申请奖学金的视图
 * @author 13425
 */
public class StudentApplyScholarshipView extends JFrame{
    private void button1(ActionEvent e) {
        /*
         * 提交申请奖学金并检查学生是否满足要求
         */
        //提取输入的奖学金ID，检查无误后将其转换为int类型
        String scholarshipIdText = textField1.getText().trim();
        if (!scholarshipIdText.isEmpty()) {
            try {
                int checkId = Integer.parseInt(scholarshipIdText);
            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(contentPane, "输入的奖学金ID必须为整数", "提示", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(contentPane, "请输入需要申请的奖学金ID", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //获取申请的奖学金ID
        int scholarshipId = Integer.parseInt(scholarshipIdText);

        //studentID为申请人学号
        String studentId = textField2.getText();
        String applyNickname = textField3.getText();
        String applyClass = textField4.getText();
        String scholarshipName = textField5.getText();
        String reason = textArea1.getText();
        if (studentId == null || studentId.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "请输入申请人学号", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (applyNickname == null || applyNickname.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "请输入申请人姓名", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (applyClass == null || applyClass.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "请输入申请人班级", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (scholarshipName == null || scholarshipName.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "请输入需要申请的奖学金名称", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (reason == null || reason.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "请输入申请理由", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        /* 传入申请人学号
           和申请的奖学金ID并检查是否满足奖学金的要求
            */
        if (checkScholarshipIfExist(scholarshipId)) {
            if (checkStudentEligibility(studentId, scholarshipId)) {
                Apply apply = new Apply();

                apply.setScholarshipId(scholarshipId);
                apply.setUserId(studentId);
                apply.setApplyNickName(applyNickname);
                apply.setApplyClass(applyClass);
                apply.setScholarshipName(scholarshipName);
                apply.setReason(reason);

                if (checkStudentIfHaveThisScholarship(studentId, scholarshipId)) {
                    boolean flag = new ApplyDao().save(apply);
                    if (flag) {
                        dispose();
                        JOptionPane.showMessageDialog(contentPane, "申请成功", "提示", JOptionPane.WARNING_MESSAGE);
                        frame.loadTable2();
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "申请失败", "提示", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
    }

    /**
     * 检查学生申请的奖学金是否存在
     *
     * @param scholarshipId
     */
    private boolean checkScholarshipIfExist(int scholarshipId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT id FROM t_scholarship WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, scholarshipId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                JOptionPane.showMessageDialog(contentPane, "该奖学金不存在", "提示", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return false;
    }

    /**
     * 检查学生是否已经申请过当前奖学金
     *
     * @param studentId
     * @param scholarshipId
     * @return
     */
    private boolean checkStudentIfHaveThisScholarship(String studentId, int scholarshipId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT id FROM t_apply WHERE userId = ? AND scholarshipId = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentId);
            pstmt.setInt(2, scholarshipId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(contentPane, "你已经申请过该奖学金", "提示", JOptionPane.WARNING_MESSAGE);
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return false;
    }

    /**
     * 检查申请的学生是否满足奖学金对于成绩的要求
     *
     * @param studentId
     * @return
     */
    private boolean checkStudentEligibility(String studentId, int scholarshipId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT proClassGrade, peClassGrade, cultureClassGrade, comprehensiveTestGrade FROM t_student WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int proClassGrade = rs.getInt("proClassGrade");
                int peClassGrade = rs.getInt("peClassGrade");
                int cultureClassGrade = rs.getInt("cultureClassGrade");
                int comprehensiveTestGrade = rs.getInt("comprehensiveTestGrade");

                //传入申请的奖学金ID，获取奖学金要求，用于比较
                if (checkScholarshipRequirements(scholarshipId, proClassGrade, peClassGrade, cultureClassGrade, comprehensiveTestGrade)) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(contentPane, "申请条件不满足", "提示", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return false;
    }

    private boolean checkScholarshipRequirements(Integer id, int proClassGrade, int peClassGrade, int cultureClassGrade, int comprehensiveTestGrade) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT scholarshipGrade FROM t_scholarship WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int scholarshipGrade = rs.getInt("scholarshipGrade");
                int realTotalGrade = proClassGrade + peClassGrade + cultureClassGrade + comprehensiveTestGrade;
                return realTotalGrade >= scholarshipGrade;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, rs);
        }
        return false;
    }

    private void button2(ActionEvent e) {
        // 关闭窗口的方法
        this.StudentApplyScholarship.dispose();
    }

    protected StudentApplyScholarshipView(final StudentManagement frame) {
        this.frame = frame;
        StudentApplyScholarship = new JFrame();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        textField2.setEditable(false);
        label3 = new JLabel();
        textField3 = new JTextField();
        textField3.setEditable(false);
        label4 = new JLabel();
        textField4 = new JTextField();
        textField4.setEditable(false);
        label5 = new JLabel();
        textField5 = new JTextField();
        label6 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();

        //======== StudentApplyScholarship ========
        {
            StudentApplyScholarship.setTitle("\u5956\u5b66\u91d1\u7533\u8bf7");
            var StudentApplyScholarshipContentPane = StudentApplyScholarship.getContentPane();
            StudentApplyScholarshipContentPane.setLayout(null);

            //---- label1 ----
            label1.setText("\u9700\u8981\u7533\u8bf7\u7684\u5956\u5b66\u91d1ID\uff1a");
            label1.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentApplyScholarshipContentPane.add(label1);
            label1.setBounds(new Rectangle(new Point(20, 20), label1.getPreferredSize()));
            StudentApplyScholarshipContentPane.add(textField1);
            textField1.setBounds(185, 15, 100, 35);

            //---- label2 ----
            label2.setText("\u7533\u8bf7\u4eba\u5b66\u53f7\uff1a");
            label2.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentApplyScholarshipContentPane.add(label2);
            label2.setBounds(300, 20, 105, 22);
            StudentApplyScholarshipContentPane.add(textField2);
            textField2.setBounds(400, 15, 100, 35);

            //---- label3 ----
            label3.setText("\u7533\u8bf7\u4eba\u59d3\u540d\uff1a");
            label3.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentApplyScholarshipContentPane.add(label3);
            label3.setBounds(20, 75, 110, 22);
            StudentApplyScholarshipContentPane.add(textField3);
            textField3.setBounds(120, 70, 100, 35);

            //---- label4 ----
            label4.setText("\u7533\u8bf7\u4eba\u6240\u5728\u73ed\u7ea7\uff1a");
            label4.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentApplyScholarshipContentPane.add(label4);
            label4.setBounds(250, 75, 135, 22);
            StudentApplyScholarshipContentPane.add(textField4);
            textField4.setBounds(385, 70, 100, 35);

            //---- label5 ----
            label5.setText("\u9700\u8981\u7533\u8bf7\u7684\u5956\u5b66\u91d1\u540d\u79f0\uff1a");
            label5.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentApplyScholarshipContentPane.add(label5);
            label5.setBounds(20, 135, 185, 22);
            StudentApplyScholarshipContentPane.add(textField5);
            textField5.setBounds(200, 130, 165, 35);

            //---- label6 ----
            label6.setText("\u7533\u8bf7\u8be5\u5956\u5b66\u91d1\u7684\u7406\u7531\uff1a");
            label6.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentApplyScholarshipContentPane.add(label6);
            label6.setBounds(20, 190, 165, 30);

            //======== scrollPane1 ========
            {

                //---- textArea1 ----
                textArea1.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.PLAIN, 14));
                textArea1.setRows(8);
                textArea1.setLineWrap(true);
                scrollPane1.setViewportView(textArea1);
            }
            StudentApplyScholarshipContentPane.add(scrollPane1);
            scrollPane1.setBounds(15, 225, 540, 105);

            //---- button1 ----
            button1.setText("\u63d0\u4ea4");
            button1.setFont(new Font("LXGW WenKai", Font.PLAIN, 18));
            button1.addActionListener(e -> button1(e));
            StudentApplyScholarshipContentPane.add(button1);
            button1.setBounds(140, 365, 78, 31);

            //---- button2 ----
            button2.setText("\u53d6\u6d88");
            button2.setFont(new Font("LXGW WenKai", Font.PLAIN, 18));
            button2.addActionListener(e -> button2(e));
            StudentApplyScholarshipContentPane.add(button2);
            button2.setBounds(320, 365, 78, 31);

            StudentApplyScholarshipContentPane.setPreferredSize(new Dimension(460, 380));
            StudentApplyScholarship.setSize(575, 475);
            StudentApplyScholarship.setLocationRelativeTo(null);
            StudentApplyScholarship.setResizable(false);
            StudentApplyScholarship.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            StudentApplyScholarship.setVisible(true);
        }
        try {
            textField2.setText(DataTemp.studentId);
            textField3.setText(DataTemp.studentName);
            textField4.setText(DataTemp.studentClass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contentPane,"获取当前登录信息异常", "系统提示", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JFrame StudentApplyScholarship;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JTextField textField5;
    private JLabel label6;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    private StudentManagement frame;
    private JPanel contentPane;
}
