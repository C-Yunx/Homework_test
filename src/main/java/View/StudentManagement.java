/*
 * Created by JFormDesigner on Tue Jan 09 20:49:03 CST 2024
 */

package View;

import Dao.ApplyDao;
import Dao.ScholarshipDao;
import Entity.Apply;
import Entity.Scholarship;
import Util.DataTemp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * @author 13425
 */
public class StudentManagement extends JFrame {
    public StudentManagement() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // 对奖学金表的筛选功能
        String roleText = (String) comboBox1.getSelectedItem();
        loadTable1(textField1.getText(), roleText);
    }

    private void button2(ActionEvent e) {
        // 申请奖学金
        StudentApplyScholarshipView view = new StudentApplyScholarshipView(frame);
    }

    private void button3(ActionEvent e) {
        // 撤回申请
        int row = table2.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(contentPane, "请先选择要取消的申请", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int result = JOptionPane.showConfirmDialog(contentPane, "确定要取消该申请吗？", "系统提示", JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            String studentId = DataTemp.studentId;
            String scholarshipIdStr = (String) table2.getValueAt(row, 0);
            int scholarshipId = Integer.parseInt(scholarshipIdStr);
            boolean flag = new ApplyDao().delete(studentId, scholarshipId);
            if (flag) {
                JOptionPane.showMessageDialog(contentPane, "取消成功", "系统提示", JOptionPane.WARNING_MESSAGE);
                loadTable2();
            } else {
                JOptionPane.showMessageDialog(contentPane, "该申请已被辅导员或管理员处理，无法删除！", "系统提示", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void button4(ActionEvent e) {
        //刷新表格数据
        loadTable2();
    }

//    private void button5(ActionEvent e) {
//        // 完成密码修改
//    }

    private void initComponents() {
        StudentManagement = new JFrame();
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        label2 = new JLabel();
        comboBox1 = new JComboBox();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        panel2 = new JPanel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        button3 = new JButton();
        panel3 = new JPanel();
        button4 = new JButton();
        scrollPane3 = new JScrollPane();
        table3 = new JTable();
        panel4 = new JPanel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        textField2 = new JTextField();
        passwordField1 = new JPasswordField();
        passwordField2 = new JPasswordField();
        button5 = new JButton();

        //======== StudentManagement ========
        {
            StudentManagement.setTitle("登录身份：学生");
            StudentManagement.setResizable(false);
            StudentManagement.setBackground(new Color(0x333333));
            var StudentManagementContentPane = StudentManagement.getContentPane();
            StudentManagementContentPane.setLayout(null);

            //======== tabbedPane1 ========
            {
                tabbedPane1.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 16));

                //======== panel1 ========
                {
                    panel1.setLayout(null);

                    //---- label1 ----
                    label1.setText("奖学金名称：");
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
                    button1.setBounds(470, 15, 65, 25);

                    //---- label2 ----
                    label2.setText("\u5956\u5b66\u91d1\u7c7b\u522b\uff1a");
                    label2.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                    panel1.add(label2);
                    label2.setBounds(245, 15, 100, 22);

                    //---- comboBox1 ----
//                    comboBox1.addActionListener(e -> comboBox1(e));
                    comboBox1.setModel(new DefaultComboBoxModel(new String[] {"","院级奖学金", "校级奖学金", "市级奖学金", "省级奖学金", "国家级奖学金", "个人自设奖学金", "贫困生补助金", "社会励学金"}));
                    panel1.add(comboBox1);
                    comboBox1.setBounds(345, 15, 105, comboBox1.getPreferredSize().height);

                    //---- button2 ----
                    button2.setText("\u7533\u8bf7");
                    button2.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button2.addActionListener(e -> button2(e));
                    panel1.add(button2);
                    button2.setBounds(550, 15, 65, 25);

                    //======== scrollPane1 ========
                    {
                        String[] columns = {"奖学金ID","奖学金名称", "奖学金类别", "奖学金金额", "奖学金申请条件", "奖学金介绍"};
                        Object[][] data = null;
                        DefaultTableModel model = new DefaultTableModel(data, columns);

                        table1 = new JTable(model){
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return false;
                            }
                        };
                        JTableHeader head = table1.getTableHeader();
                        head.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                        table1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
                        table1.setShowHorizontalLines(true);
                        table1.setShowVerticalLines(true);
                        scrollPane1.setViewportView(table1);

                        loadTable1(null, null);
                    }
                    panel1.add(scrollPane1);
                    scrollPane1.setBounds(5, 50, 770, 425);
                }
                tabbedPane1.addTab("现有奖学金查询", panel1);

                //======== panel2 ========
                {
                    panel2.setLayout(null);

                    //======== scrollPane2 ========
                    {
                        String[] columns = {"奖学金ID", "奖学金名称", "申请理由", "预审核情况", "终审核情况"};
                        Object[][] data = null;
                        DefaultTableModel model = new DefaultTableModel(data, columns);

                        table2 = new JTable(model){
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return false;
                            }
                        };
                        JTableHeader head = table2.getTableHeader();
                        head.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                        table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                        table2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
                        table2.setShowHorizontalLines(true);
                        table2.setShowVerticalLines(true);
                        scrollPane2.setViewportView(table2);

                        loadTable2();
                    }
                    panel2.add(scrollPane2);
                    scrollPane2.setBounds(5, 50, 770, 425);

                    //---- button3 ----
                    button3.setText("取消申请");
                    button3.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button3.addActionListener(this::button3);
                    panel2.add(button3);
                    button3.setBounds(20, 15, 85, 25);

                    //---- button4 ----
                    button4.setText("\u5237\u65b0\u7ed3\u679c");
                    button4.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button4.addActionListener(e -> button4(e));
                    panel2.add(button4);
                    button4.setBounds(120, 15, 85, 25);
                }
                tabbedPane1.addTab("\u5df2\u63d0\u4ea4\u7533\u8bf7", panel2);

                //======== panel3 ========
//                {
//                    panel3.setLayout(null);
//
//                    //---- button4 ----
//                    button4.setText("查询所有");
//                    button4.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
//                    panel3.add(button4);
//                    button4.setBounds(20, 15, 85, 25);
//
//                    //======== scrollPane3 ========
//                    {
//                        String[] columns = {"奖学金ID", "奖学金名称", "奖学金金额"};
//
//                        scrollPane3.setViewportView(table3);
//                    }
//                    panel3.add(scrollPane3);
//                    scrollPane3.setBounds(5, 50, 770, 425);
//                }
//                tabbedPane1.addTab("已通过结果查询", panel3);

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
//                    //---- label4 ----
//                    label4.setText("\u65b0\u8d26\u53f7\u5bc6\u7801\uff1a");
//                    label4.setFont(new Font("LXGW WenKai", Font.PLAIN, 28));
//                    panel4.add(label4);
//                    label4.setBounds(160, 145, 180, 65);
//
//                    //---- label5 ----
//                    label5.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
//                    label5.setFont(new Font("LXGW WenKai", Font.PLAIN, 28));
//                    panel4.add(label5);
//                    label5.setBounds(160, 225, 170, 75);
//
//                    //---- textField2 ----
//                    textField2.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
//                    panel4.add(textField2);
//                    textField2.setBounds(345, 80, 260, 35);
//
//                    //---- passwordField1 ----
//                    passwordField1.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
//                    panel4.add(passwordField1);
//                    passwordField1.setBounds(345, 165, 260, 35);
//
//                    //---- passwordField2 ----
//                    passwordField2.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
//                    panel4.add(passwordField2);
//                    passwordField2.setBounds(345, 250, 260, 35);
//
//                    //---- button5 ----
//                    button5.setText("\u786e\u5b9a\u4fee\u6539");
//                    button5.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
//                    button5.addActionListener(e -> button5(e));
//                    panel4.add(button5);
//                    button5.setBounds(new Rectangle(new Point(340, 365), button5.getPreferredSize()));
//                }
//                tabbedPane1.addTab("\u767b\u5f55\u5bc6\u7801\u4fee\u6539", panel4);
            }
            StudentManagementContentPane.add(tabbedPane1);
            tabbedPane1.setBounds(0, 0, 800, 515);

            StudentManagementContentPane.setPreferredSize(new Dimension(640, 440));
            StudentManagement.setSize(800, 550);
            StudentManagement.setLocationRelativeTo(null);
            StudentManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            StudentManagement.setVisible(true);
        }
    }

    protected void loadTable2() {
        List<Apply> list = new ApplyDao().queryList(DataTemp.studentId);
        DefaultTableModel tableModel = (DefaultTableModel) table2.getModel();
        tableModel.setRowCount(0);
        //填充已选择奖学金表数据
        //{"奖学金ID", "奖学金名称", "申请理由", "预审核情况", "终审核情况"}
        for (Apply item : list) {
            String[] arr = new String[6];
            arr[0] = String.valueOf(item.getScholarshipId());
            arr[1] = item.getScholarshipName();
            arr[2] = item.getReason();
            String teacherState = item.getTeacherState();
            if ("yes".equals(teacherState)) {
                arr[3] = "已通过";
            } else if ("no".equals(teacherState)) {
                arr[3] = "未通过";
            } else if (teacherState == null || teacherState.isEmpty()) {
                arr[3] = "未审核";
            }
            String adminState = item.getAdminState();
            if ("yes".equals(adminState)) {
                arr[4] = "已通过";
            } else if ("no".equals(adminState)) {
                arr[4] = "未通过";
            } else if (adminState == null || adminState.isEmpty()) {
                arr[4] = "未审核";
            }
            tableModel.addRow(arr);
        }
    }

    protected void loadTable1(String scholarshipName, String roleText) {
        List<Scholarship> list = new ScholarshipDao().queryList(scholarshipName, roleText);
        DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
        tableModel.setRowCount(0);
        //填充可选奖学金表数据
        //{"奖学金ID", "奖学金名称", "奖学金类别", "奖学金金额", "奖学金申请条件", "奖学金介绍"}
        for (Scholarship item : list) {
            String[] arr = new String[6];
            arr[0] = String.valueOf(item.getId());
            arr[1] = item.getScholarshipName();
            arr[2] = item.getScholarshipType();
            arr[3] = item.getBonusAmount();
            arr[4] = item.getScholarshipRequirements();
            arr[5] = item.getScholarshipIntroductions();
            tableModel.addRow(arr);
        }
    }

    private JFrame StudentManagement;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JLabel label2;
    private JComboBox comboBox1;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel2;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JButton button3;
    private JPanel panel3;
    private JButton button4;
    private JScrollPane scrollPane3;
    private JTable table3;
    private JPanel panel4;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField2;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton button5;
    private StudentManagement frame = this;
    private JPanel contentPane;
}
