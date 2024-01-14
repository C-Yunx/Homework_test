/*
 * Created by JFormDesigner on Tue Jan 09 20:56:27 CST 2024
 */

package View;

import Dao.ApplyDao;
import Dao.StudentDao;
import Entity.Apply;
import Entity.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * 辅导员登录后界面
 * @author 13425
 */
public class TeacherManagement extends JFrame {
    public TeacherManagement() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // 根据姓名查询学生
        loadstudent(textField1.getText());
    }

    private void button3(ActionEvent e) {
        // 刷新审核结果
        loadApply();
    }

    private void button5(ActionEvent e) {
        // 通过审核
        int row = table2.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(contentPane, "请选择一条记录", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int result = JOptionPane.showConfirmDialog(contentPane, "确定通过审核吗?", "系统提示", JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            int id = Integer.parseInt(table2.getValueAt(row, 0).toString());
            boolean flag = new ApplyDao().TeacherSetYse(id);
            if (flag) {
                JOptionPane.showMessageDialog(contentPane, "审核通过", "系统提示", JOptionPane.WARNING_MESSAGE);
                loadApply();
            } else {
                JOptionPane.showMessageDialog(contentPane, "审核失败", "系统提示", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void button6(ActionEvent e) {
        // 不通过申请
        int row = table2.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(contentPane, "请选择一条记录", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int result = JOptionPane.showConfirmDialog(contentPane, "确定不通过审核吗?", "系统提示", JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            int id = Integer.parseInt(table2.getValueAt(row, 0).toString());
            boolean flag = new ApplyDao().TeacherSetNo(id);
            if (flag) {
                JOptionPane.showMessageDialog(contentPane, "修改成功", "系统提示", JOptionPane.WARNING_MESSAGE);
                loadApply();
            } else {
                JOptionPane.showMessageDialog(contentPane, "修改失败", "系统提示", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

//    private void button4(ActionEvent e) {
//    }

//    private void button7(ActionEvent e) {
//    }

    private void initComponents() {
        TeacherManagement = new JFrame();
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel2 = new JPanel();
        button3 = new JButton();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        button5 = new JButton();
        button6 = new JButton();
        panel3 = new JPanel();
        button4 = new JButton();
        scrollPane3 = new JScrollPane();
        table3 = new JTable();
        panel4 = new JPanel();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        passwordField1 = new JPasswordField();
        label5 = new JLabel();
        passwordField2 = new JPasswordField();
        button7 = new JButton();

        //======== TeacherManagement ========
        {
            TeacherManagement.setTitle("\u767b\u5f55\u8eab\u4efd\uff1a\u8f85\u5bfc\u5458");
            TeacherManagement.setResizable(false);
            TeacherManagement.setBackground(new Color(0x333333));
            var TeacherManagementContentPane = TeacherManagement.getContentPane();
            TeacherManagementContentPane.setLayout(null);

            //======== tabbedPane1 ========
            {
                tabbedPane1.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 16));

                //======== panel1 ========
                {
                    panel1.setLayout(null);

                    //---- label1 ----
                    label1.setText("学生姓名：");
                    label1.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                    panel1.add(label1);
                    label1.setBounds(20, 15, 100, 22);
                    panel1.add(textField1);
                    textField1.setBounds(115, 15, 120, 25);

                    //---- button1 ----
                    button1.setText("\u67e5\u8be2");
                    button1.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button1.addActionListener(e -> button1(e));
                    panel1.add(button1);
                    button1.setBounds(250, 15, 65, 25);

                    //======== scrollPane1 ========
                    {
                        String[] columns = {"学号", "姓名", "性别", "生日", "电话", "邮箱", "专业", "是否违纪", "是否贫困"};
                        Object[][] data = null;
                        DefaultTableModel model = new DefaultTableModel(data, columns);

                        table1 = new JTable(model){
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        JTableHeader head = table1.getTableHeader();
                        head.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));

                        loadstudent(null);

                        scrollPane1.setViewportView(table1);
                    }
                    panel1.add(scrollPane1);
                    scrollPane1.setBounds(5, 50, 770, 425);
                }
                tabbedPane1.addTab("学生信息查询", panel1);

                //======== panel2 ========
                {
                    panel2.setLayout(null);

                    //---- button3 ----
                    button3.setText("刷新结果");
                    button3.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button3.addActionListener(e -> button3(e));
                    panel2.add(button3);
                    button3.setBounds(20, 15, 85, 25);

                    //======== scrollPane2 ========
                    {
                        String[] columns = {"申请序号", "申请人姓名", "申请人班级", "申请奖学金ID", "奖学金名称", "申请理由", "审核状态"};
                        Object[][] data = null;
                        DefaultTableModel model = new DefaultTableModel(data, columns);
                        table2 = new JTable(model){
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        JTableHeader head = table2.getTableHeader();
                        head.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));

                        loadApply();

                        scrollPane2.setViewportView(table2);
                    }
                    panel2.add(scrollPane2);
                    scrollPane2.setBounds(5, 50, 770, 425);

                    //---- button5 ----
                    button5.setText("通过");
                    button5.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button5.addActionListener(e -> button5(e));
                    panel2.add(button5);
                    button5.setBounds(120, 15, 85, 25);

                    //---- button6 ----
                    button6.setText("不通过");
                    button6.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button6.addActionListener(e -> button6(e));
                    panel2.add(button6);
                    button6.setBounds(220, 15, 85, 25);
                }
                tabbedPane1.addTab("审核奖学金申请", panel2);

                //======== panel3 ========
//                {
//                    panel3.setLayout(null);
//
//                    //---- button4 ----
//                    button4.setText("\u67e5\u8be2\u6240\u6709");
//                    button4.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
//                    button4.addActionListener(e -> button4(e));
//                    panel3.add(button4);
//                    button4.setBounds(20, 15, 85, 25);
//
//                    //======== scrollPane3 ========
//                    {
//                        scrollPane3.setViewportView(table3);
//                    }
//                    panel3.add(scrollPane3);
//                    scrollPane3.setBounds(5, 50, 770, 425);
//                }
//                tabbedPane1.addTab("\u5df2\u901a\u8fc7\u7533\u8bf7", panel3);

                //======== panel4 ========
//                {
//                    panel4.setLayout(null);
//
//                    //---- label3 ----
//                    label3.setText("\u539f\u8d26\u53f7\u5bc6\u7801\uff1a");
//                    label3.setFont(new Font("LXGW WenKai", Font.PLAIN, 26));
//                    panel4.add(label3);
//                    label3.setBounds(160, 65, 160, 60);
//
//                    //---- textField2 ----
//                    textField2.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
//                    panel4.add(textField2);
//                    textField2.setBounds(345, 80, 260, 35);
//
//                    //---- label4 ----
//                    label4.setText("\u65b0\u8d26\u53f7\u5bc6\u7801\uff1a");
//                    label4.setFont(new Font("LXGW WenKai", Font.PLAIN, 28));
//                    panel4.add(label4);
//                    label4.setBounds(160, 145, 180, 65);
//
//                    //---- passwordField1 ----
//                    passwordField1.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
//                    panel4.add(passwordField1);
//                    passwordField1.setBounds(345, 165, 260, 35);
//
//                    //---- label5 ----
//                    label5.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
//                    label5.setFont(new Font("LXGW WenKai", Font.PLAIN, 28));
//                    panel4.add(label5);
//                    label5.setBounds(160, 225, 170, 75);
//
//                    //---- passwordField2 ----
//                    passwordField2.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
//                    panel4.add(passwordField2);
//                    passwordField2.setBounds(345, 250, 260, 35);
//
//                    //---- button7 ----
//                    button7.setText("\u786e\u5b9a\u4fee\u6539");
//                    button7.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
//                    button7.addActionListener(e -> button7(e));
//                    panel4.add(button7);
//                    button7.setBounds(340, 365, 117, 37);
//                }
//                tabbedPane1.addTab("\u767b\u5f55\u5bc6\u7801\u4fee\u6539", panel4);
            }
            TeacherManagementContentPane.add(tabbedPane1);
            tabbedPane1.setBounds(0, 0, 800, 515);

            TeacherManagementContentPane.setPreferredSize(new Dimension(640, 440));
            TeacherManagement.setSize(800, 550);
            TeacherManagement.setLocationRelativeTo(null);
            TeacherManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            TeacherManagement.setVisible(true);
        }
    }

    /**
     * 加载奖学金申请数据
     */
    private void loadApply() {
        List<Apply> list = applyDao.queryList1(null, null, null);
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        model.setRowCount(0);
        //填充数据
        //{"申请序号", "申请人姓名", "申请人班级", "申请奖学金ID", "奖学金名称", "申请理由", "审核状态"}
        for (Apply apply : list) {
            String[] arr = new String[7];
            arr[0] = String.valueOf(apply.getId());
            arr[1] = apply.getApplyNickName();
            arr[2] = apply.getApplyClass();
            arr[3] = String.valueOf(apply.getScholarshipId());
            arr[4] = apply.getScholarshipName();
            arr[5] = apply.getReason();
            String teacherState = apply.getTeacherState();
            if ("yes".equals(teacherState)) {
                arr[6] = "已通过";
            } else if ("no".equals(teacherState)) {
                arr[6] = "未通过";
            } else if (teacherState == null || teacherState.isEmpty()) {
                arr[6] = "未审核";
            }
            model.addRow(arr);
        }
    }

    /**
     * 根据学生名字筛选情况来加载当前学生的数据
     * @param nickName
     */
    protected void loadstudent(String nickName) {
        List<Student> list = studentDao.queryList(null, nickName, null);
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        //填充数据
        //{"学号", "姓名", "性别", "生日", "电话", "邮箱", "专业", "是否违纪", "是否贫困"}
        for (Student student : list) {
            String[] arr = new String[9];
            arr[0] = student.getClassNumber();
            arr[1] = student.getNickname();
            arr[2] = student.getSex() == 0 ? "男" : "女";
            arr[3] = student.getBirthday();
            arr[4] = student.getTelephone();
            arr[5] = student.getEmail();
            arr[6] = student.getProfession();
            arr[7] = student.getIfViolationOfDiscipline() == 0 ? "否" : "是";
            arr[8] = student.getIfPool() == 0 ? "否" : "是";
            model.addRow(arr);
        }
    }

    private JFrame TeacherManagement;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel2;
    private JButton button3;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JButton button5;
    private JButton button6;
    private JPanel panel3;
    private JButton button4;
    private JScrollPane scrollPane3;
    private JTable table3;
    private JPanel panel4;
    private JLabel label3;
    private JTextField textField2;
    private JLabel label4;
    private JPasswordField passwordField1;
    private JLabel label5;
    private JPasswordField passwordField2;
    private JButton button7;
    private StudentDao studentDao = new StudentDao();
    private ApplyDao applyDao = new ApplyDao();
    private JPanel contentPane;
}
