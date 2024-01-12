/*
 * Created by JFormDesigner on Tue Jan 09 19:22:53 CST 2024
 */

package View;


import Dao.ApplyDao;
import Dao.ScholarshipDao;
import Dao.StudentDao;
import Dao.TeacherDao;
import Entity.Apply;
import Entity.Scholarship;
import Entity.Student;
import Entity.Teacher;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * @author 13425
 */
public class AdminManagement extends JFrame {
    /*
    创建窗口和组件初始化
     */
    public AdminManagement() {
        initComponents();
    }

    /*
    根据输入的查询条件来查询学生信息
     */
    private void button1(ActionEvent e) {
        load(textField1.getText(), textField2.getText(), textField7.getText());

    }

    /*
    添加学生信息的窗口
     */
    private void button2(ActionEvent e) {
        AdminStudentAddView view = new AdminStudentAddView(frame);
    }

    /*
    修改学生信息的窗口
     */
    private void button3(ActionEvent e) {
        int row = studentTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(contentPane, "请选择一条记录", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int ids = Integer.valueOf(studentTable.getValueAt(row, 0).toString());
        AdminStudentUpdateView view = new AdminStudentUpdateView(ids, frame);
    }

    /*
    删除学生信息
     */
    private void button4(ActionEvent e) {
        int row = studentTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(contentPane, "请选择一条记录", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int result = JOptionPane.showConfirmDialog(contentPane, "确定删除该记录吗？", "系统提示", JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            int id = Integer.valueOf(studentTable.getValueAt(row, 0).toString());
            boolean flag = new StudentDao().delete(id);
            if (flag) {
                JOptionPane.showMessageDialog(contentPane, "删除成功");
                load(null, null, null);
            } else {
                JOptionPane.showMessageDialog(contentPane, "删除失败", "系统提示", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /*
    根据账号和姓名来动态查询辅导员信息
     */
    private void button5(ActionEvent e) {
        load1(textField3.getText(), textField4.getText());
    }

    /*
    添加辅导员信息的窗口
     */
    private void button6(ActionEvent e) {
        AdminTeacherAddView view = new AdminTeacherAddView(frame);
    }

    /*
    修改辅导员信息的窗口
     */
    private void button7(ActionEvent e) {
        //辅导员信息修改
        int row = studentTable2.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(contentPane, "请选择一条记录", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int ids = Integer.valueOf(studentTable2.getValueAt(row, 0).toString());
        AdminTeacherUpdateView view = new AdminTeacherUpdateView(ids, frame);
    }

    /*
    删除辅导员信息的操作
     */
    private void button8(ActionEvent e) {
        // 辅导员表数据删除
        int row = studentTable2.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(contentPane, "请选择一条记录", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int result = JOptionPane.showConfirmDialog(contentPane, "确定删除该记录吗？", "系统提示", JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            int id = Integer.valueOf(studentTable2.getValueAt(row, 0).toString());
            boolean flag = new TeacherDao().delete(id);
            if (flag) {
                JOptionPane.showMessageDialog(contentPane, "删除成功");
                load1(null, null);
            } else {
                JOptionPane.showMessageDialog(contentPane, "删除失败", "系统提示", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /*
    根据奖学金名称和选择的类别来查询奖学金信息
     */
    private void button9(ActionEvent e) {
        // 实现奖学金表的按类型查询
        String roleText = (String) comboBox1.getSelectedItem();
        load2(textField5.getText(), roleText);
    }

    /*
    添加奖学金信息的窗口
     */
    private void button10(ActionEvent e) {
        AdminScholarshipAddView view = new AdminScholarshipAddView(frame);
    }

    /*
    修改奖学金信息的窗口
     */
    private void button11(ActionEvent e) {
        // 奖学金信息修改
        int row = studentTable3.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(contentPane, "请选择一条记录", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int ids = Integer.valueOf(studentTable3.getValueAt(row, 0).toString());
        AdminScholarshipUpdateView view = new AdminScholarshipUpdateView(ids, frame);
    }

    /*
    删除奖学金表中的数据
     */
    private void button12(ActionEvent e) {
        /*
        删除数据库中指定的奖学金记录
         */
        int row = studentTable3.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(contentPane, "请选择一条记录", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int result = JOptionPane.showConfirmDialog(contentPane, "确定删除该记录吗？", "系统提示", JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            int id = Integer.valueOf(studentTable3.getValueAt(row, 0).toString());
            boolean flag = new ScholarshipDao().delete(id);
            if (flag) {
                JOptionPane.showMessageDialog(contentPane, "删除成功");
                load2(null, null);
            } else {
                JOptionPane.showMessageDialog(contentPane, "删除失败", "系统提示", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    /*
    根据学生姓名和学生班级以及申请的奖学金名称来查询审核表
    */
    private void button13(ActionEvent e) {
        // 查询审核表
        load3(textField8.getText(), textField9.getText(), textField11.getText());
    }

    /*
    通过申请
     */
    private void button14(ActionEvent e) {
        // 通过申请
        int row = studentTable4.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(contentPane, "请选择一条记录", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int result = JOptionPane.showConfirmDialog(contentPane, "确定通过该申请吗？", "系统提示", JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            int id = Integer.valueOf(studentTable4.getValueAt(row, 0).toString());
            boolean flag = new ApplyDao().setYse(id);
            if (flag) {
                JOptionPane.showMessageDialog(contentPane, "通过成功");
                load3(null, null, null);
            } else {
                JOptionPane.showMessageDialog(contentPane, "通过失败", "系统提示", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /*
    不通过申请
     */
    private void button15(ActionEvent e) {
        // 管理员不通过申请
        int row = studentTable4.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(contentPane, "请选择一条记录", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int result = JOptionPane.showConfirmDialog(contentPane, "确定不通过该申请吗？", "系统提示", JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            int id = Integer.valueOf(studentTable4.getValueAt(row, 0).toString());
            boolean flag = new ApplyDao().setNo(id);
            if (flag) {
                JOptionPane.showMessageDialog(contentPane, "修改成功");
                load3(null, null, null);
            } else {
                JOptionPane.showMessageDialog(contentPane, "修改失败", "系统提示", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /*
    管理员删除申请信息
     */
    private void button16(ActionEvent e) {
        // 管理员删除申请信息
        int row = studentTable4.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(contentPane, "请选择一条记录", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int result = JOptionPane.showConfirmDialog(contentPane, "确定删除该申请吗？", "系统提示", JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            int id = Integer.valueOf(studentTable4.getValueAt(row, 0).toString());
            boolean flag = new ApplyDao().delete(id);
            if (flag) {
                JOptionPane.showMessageDialog(contentPane, "删除成功");
                load3(null, null, null);
            } else {
                JOptionPane.showMessageDialog(contentPane, "删除失败", "系统提示", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    /*
     根据奖学金名称查询已经发放的奖学金
    */
    private void button17(ActionEvent e) {
        load4(textField10.getText());
    }
    private void initComponents() {
        AdminHero = new JFrame();
        StudentManagementTab = new JTabbedPane();
        panel1 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        textField7 = new JTextField();
        label7 = new JLabel();
        scrollPane1 = new JScrollPane();
        studentTable = new JTable();
        panel2 = new JPanel();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        scrollPane2 = new JScrollPane();
        studentTable2 = new JTable();
        panel3 = new JPanel();
        label5 = new JLabel();
        textField5 = new JTextField();
        label6 = new JLabel();
        button9 = new JButton();
        button10 = new JButton();
        button11 = new JButton();
        button12 = new JButton();
        scrollPane3 = new JScrollPane();
        studentTable3 = new JTable();
        comboBox1 = new JComboBox();
        panel4 = new JPanel();
        label8 = new JLabel();
        textField8 = new JTextField();
        label9 = new JLabel();
        textField9 = new JTextField();
        button13 = new JButton();
        button14 = new JButton();
        button15 = new JButton();
        button16 = new JButton();
        scrollPane4 = new JScrollPane();
        studentTable4 = new JTable();
        label11 = new JLabel();
        textField11 = new JTextField();
        panel5 = new JPanel();
        label10 = new JLabel();
        textField10 = new JTextField();
        button17 = new JButton();
        scrollPane5 = new JScrollPane();
        studentTable5 = new JTable();

        //======== AdminHero ========
        {
            AdminHero.setTitle("登录身份：管理员");
            AdminHero.setResizable(false);
            AdminHero.setBackground(new Color(0x333333));
            var AdminHeroContentPane = AdminHero.getContentPane();
            AdminHeroContentPane.setLayout(null);

            //======== StudentManagementTab ========
            {
                StudentManagementTab.setFont(new Font("LXGW WenKai", Font.BOLD, 16));

                //======== panel1 ========
                {
                    panel1.setLayout(null);

                    //---- label1 ----
                    label1.setText("学号：");
                    label1.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                    panel1.add(label1);
                    label1.setBounds(new Rectangle(new Point(25, 20), label1.getPreferredSize()));
                    panel1.add(textField1);
                    textField1.setBounds(80, 20, 120, 25);

                    //---- label2 ----
                    label2.setText("姓名：");
                    label2.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                    panel1.add(label2);
                    label2.setBounds(210, 20, 48, 22);
                    panel1.add(textField2);
                    textField2.setBounds(265, 20, 120, 25);

                    //---- button1 ----
                    button1.setText("查询");
                    button1.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button1.addActionListener(e -> button1(e));
                    panel1.add(button1);
                    button1.setBounds(new Rectangle(new Point(605, 20), button1.getPreferredSize()));

                    //---- button2 ----
                    button2.setText("添加");
                    button2.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button2.addActionListener(e -> button2(e));
                    panel1.add(button2);
                    button2.setBounds(840, 20, 70, 25);

                    //---- button3 ----
                    button3.setText("修改");
                    button3.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button3.addActionListener(e -> button3(e));
                    panel1.add(button3);
                    button3.setBounds(920, 20, 70, 25);

                    //---- button4 ----
                    button4.setText("删除");
                    button4.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button4.addActionListener(e -> button4(e));
                    panel1.add(button4);
                    button4.setBounds(1000, 20, 70, 25);
                    panel1.add(textField7);
                    textField7.setBounds(460, 20, 120, 25);

                    //---- label7 ----
                    label7.setText("班级：");
                    label7.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                    panel1.add(label7);
                    label7.setBounds(405, 20, 48, 22);

                    //======== scrollPane1 ========
                    {

                        //---- studentTable ----
                        String[] columns = {"学号", "姓名", "性别", "班级", "电话号码", "学生专业", "专业成绩", "是否家境贫困", "是否违纪"};
                        Object[][] data = null;
                        DefaultTableModel model = new DefaultTableModel(data, columns);

                        studentTable = new JTable(model){
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return false;
                            }
                        };

                        JTableHeader head = studentTable.getTableHeader();
                        head.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));

                        load(null, null, null);


                        studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                        studentTable.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
                        studentTable.setShowHorizontalLines(true);
                        studentTable.setShowVerticalLines(true);
                        scrollPane1.setViewportView(studentTable);
                    }
                    panel1.add(scrollPane1);
                    scrollPane1.setBounds(10, 65, 1065, 440);
                }
                StudentManagementTab.addTab("学生信息管理", panel1);

                //======== panel2 ========
                {
                    panel2.setLayout(null);

                    //---- label3 ----
                    label3.setText("工号：");
                    label3.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                    panel2.add(label3);
                    label3.setBounds(25, 20, 48, 22);
                    panel2.add(textField3);
                    textField3.setBounds(80, 20, 120, 25);

                    //---- label4 ----
                    label4.setText("\u59d3\u540d\uff1a");
                    label4.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                    panel2.add(label4);
                    label4.setBounds(210, 20, 48, 22);
                    panel2.add(textField4);
                    textField4.setBounds(265, 20, 120, 25);

                    //---- button5 ----
                    button5.setText("\u67e5\u8be2");
                    button5.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button5.addActionListener(e -> button5(e));
                    panel2.add(button5);
                    button5.setBounds(410, 20, 90, 25);

                    //---- button6 ----
                    button6.setText("\u6dfb\u52a0");
                    button6.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button6.addActionListener(e -> button6(e));
                    panel2.add(button6);
                    button6.setBounds(840, 20, 70, 25);

                    //---- button7 ----
                    button7.setText("\u4fee\u6539");
                    button7.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button7.addActionListener(e -> button7(e));
                    panel2.add(button7);
                    button7.setBounds(920, 20, 70, 25);

                    //---- button8 ----
                    button8.setText("\u5220\u9664");
                    button8.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button8.addActionListener(e -> button8(e));
                    panel2.add(button8);
                    button8.setBounds(1000, 20, 70, 25);

                    //======== scrollPane2 ========
                    {

                        //---- TeacherTable2 ----
                        String[] columns = {"工号", "姓名", "性别", "管理班级", "电话号码", "邮箱地址"};
                        Object[][] data = null;
                        DefaultTableModel model = new DefaultTableModel(data, columns);

                        studentTable2 = new JTable(model){
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        JTableHeader head = studentTable2.getTableHeader();
                        head.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));

                        load1(null, null);

                        studentTable2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                        studentTable2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
                        studentTable2.setShowHorizontalLines(true);
                        studentTable2.setShowVerticalLines(true);
                        scrollPane2.setViewportView(studentTable2);
                    }
                    panel2.add(scrollPane2);
                    scrollPane2.setBounds(10, 65, 1065, 440);
                }
                StudentManagementTab.addTab("\u8f85\u5bfc\u5458\u4fe1\u606f\u7ba1\u7406", panel2);

                //======== panel3 ========
                {
                    panel3.setLayout(null);

                    //---- label5 ----
                    label5.setText("奖项：");
                    label5.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                    panel3.add(label5);
                    label5.setBounds(25, 20, 48, 22);
                    panel3.add(textField5);
                    textField5.setBounds(80, 20, 120, 25);

                    //---- label6 ----
                    label6.setText("类别：");
                    label6.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                    panel3.add(label6);
                    label6.setBounds(210, 20, 48, 22);

                    //---- button9 ----
                    button9.setText("查询");
                    button9.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button9.addActionListener(e -> button9(e));
                    panel3.add(button9);
                    button9.setBounds(460, 20, 90, 25);

                    //---- button10 ----
                    button10.setText("添加");
                    button10.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button10.addActionListener(e -> button10(e));
                    panel3.add(button10);
                    button10.setBounds(840, 20, 70, 25);

                    //---- button11 ----
                    button11.setText("\u4fee\u6539");
                    button11.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button11.addActionListener(e -> button11(e));
                    panel3.add(button11);
                    button11.setBounds(920, 20, 70, 25);

                    //---- button12 ----
                    button12.setText("删除");
                    button12.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button12.addActionListener(e -> button12(e));
                    panel3.add(button12);
                    button12.setBounds(1000, 20, 70, 25);

                    //======== scrollPane3 ========
                    {

                        //---- studentTable3 ----
                        String[] columns = {"奖学金序号（自增）", "奖学金名称", "奖学金的类型", "奖学金的金额", "奖学金申请条件", "奖学金介绍"};
                        Object[][] data = null;
                        DefaultTableModel model = new DefaultTableModel(data, columns);

                        studentTable3 = new JTable(model){
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return false;
                            }
                        };
                        JTableHeader head = studentTable3.getTableHeader();
                        head.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));

                        load2(null, null);

                        studentTable3.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                        studentTable3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
                        studentTable3.setShowHorizontalLines(true);
                        studentTable3.setShowVerticalLines(true);
                        scrollPane3.setViewportView(studentTable3);
                    }
                    panel3.add(scrollPane3);
                    scrollPane3.setBounds(10, 65, 1065, 440);

                    //---- comboBox1 ----
//                    comboBox1.addActionListener(e -> comboBox1(e));
                    comboBox1.setModel(new DefaultComboBoxModel(new String[] {"","院级奖学金", "校级奖学金", "市级奖学金", "省级奖学金", "国家级奖学金", "个人自设奖学金", "贫困生补助金", "社会励学金"}));
                    panel3.add(comboBox1);
                    comboBox1.setBounds(265, 20, 140, comboBox1.getPreferredSize().height);
                }
                StudentManagementTab.addTab("\u5956\u5b66\u91d1\u7ba1\u7406", panel3);

                //======== panel4 ========
                {
                    panel4.setLayout(null);

                    //---- label8 ----
                    label8.setText("姓名：");
                    label8.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                    panel4.add(label8);
                    label8.setBounds(25, 20, 48, 22);
                    panel4.add(textField8);
                    textField8.setBounds(80, 20, 120, 25);

                    //---- label9 ----
                    label9.setText("申请奖项：");
                    label9.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                    panel4.add(label9);
                    label9.setBounds(395, 20, 90, 22);
                    panel4.add(textField9);
                    textField9.setBounds(265, 20, 120, 25);

                    //---- button13 ----
                    button13.setText("\u67e5\u8be2");
                    button13.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button13.addActionListener(e -> button13(e));
                    panel4.add(button13);
                    button13.setBounds(615, 20, 90, 25);

                    //---- button14 ----
                    button14.setText("通过");
                    button14.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button14.addActionListener(e -> button14(e));
                    panel4.add(button14);
                    button14.setBounds(840, 20, 70, 25);

                    //---- button15 ----
                    button15.setText("不通过");
                    button15.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button15.addActionListener(e -> button15(e));
                    panel4.add(button15);
                    button15.setBounds(920, 20, 70, 25);

                    //---- button16 ----
                    button16.setText("删除");
                    button16.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button16.addActionListener(e -> button16(e));
                    panel4.add(button16);
                    button16.setBounds(1000, 20, 70, 25);

                    //======== scrollPane4 ========
                    {

                        //---- studentTable4 ----
                        String[] columns = {"申请序号", "申请人姓名", "申请人班级", "申请奖学金ID", "奖学金名称", "申请理由", "初审人工号","初审状态", "终审状态"};
                        Object[][] data = null;
                        DefaultTableModel model = new DefaultTableModel(data, columns);
                        studentTable4 = new JTable(model){
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return false;
                            }
                        };
                        JTableHeader head = studentTable4.getTableHeader();
                        head.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));

                        load3(null, null, null);


                        studentTable4.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                        studentTable4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
                        studentTable4.setShowHorizontalLines(true);
                        studentTable4.setShowVerticalLines(true);
                        scrollPane4.setViewportView(studentTable4);
                    }
                    panel4.add(scrollPane4);
                    scrollPane4.setBounds(10, 65, 1065, 440);

                    //---- label11 ----
                    label11.setText("\u73ed\u7ea7\uff1a");
                    label11.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                    panel4.add(label11);
                    label11.setBounds(210, 20, 60, 22);
                    panel4.add(textField11);
                    textField11.setBounds(480, 20, 120, 25);
                }
                StudentManagementTab.addTab("\u5956\u5b66\u91d1\u7ec8\u5ba1\u7ba1\u7406", panel4);

                //======== panel5 ========
                {
                    panel5.setLayout(null);

                    //---- label10 ----
                    label10.setText("\u5956\u9879\u540d\uff1a");
                    label10.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                    panel5.add(label10);
                    label10.setBounds(25, 20, 70, 22);
                    panel5.add(textField10);
                    textField10.setBounds(95, 20, 120, 25);

                    //---- button17 ----
                    button17.setText("\u67e5\u8be2");
                    button17.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button17.addActionListener(e -> button17(e));
                    panel5.add(button17);
                    button17.setBounds(235, 20, 90, 25);

                    //======== scrollPane5 ========
                    {

                        //---- studentTable5 ----
                        String[] columns = {"序号", "学生姓名", "学生班级", "奖学金名称", "申请理由", "辅导员工号"};
                        Object[][] data = null;
                        DefaultTableModel model = new DefaultTableModel(data, columns);
                        studentTable5 = new JTable(model){
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return false;
                            }
                        };
                        JTableHeader head = studentTable5.getTableHeader();
                        head.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));

                        load4(null);


                        studentTable5.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                        studentTable5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
                        studentTable5.setShowHorizontalLines(true);
                        studentTable5.setShowVerticalLines(true);
                        scrollPane5.setViewportView(studentTable5);
                    }
                    panel5.add(scrollPane5);
                    scrollPane5.setBounds(10, 65, 1065, 440);
                }
                StudentManagementTab.addTab("\u5df2\u53d1\u653e\u5956\u5b66\u91d1\u67e5\u8be2", panel5);
            }
            AdminHeroContentPane.add(StudentManagementTab);
            StudentManagementTab.setBounds(0, 0, 1090, 560);

            AdminHeroContentPane.setPreferredSize(new Dimension(880, 480));
            AdminHero.setSize(1100, 600);
            AdminHero.setLocationRelativeTo(null);
            AdminHero.setVisible(true);
            AdminHero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    private void load4(String applyNickName) {
        List<Apply> list = new ApplyDao().queryList2(applyNickName);
        DefaultTableModel tableModel = (DefaultTableModel) studentTable5.getModel();
        tableModel.setRowCount(0);
        //填充已发放奖学金表数据
        //{"序号", "学生姓名", "学生班级", "奖学金名称", "申请理由", "辅导员工号"}
        for (Apply item : list) {
            String[] arr = new String[6];
            arr[0] = String.valueOf(item.getId());
            arr[1] = item.getApplyNickName();
            arr[2] = item.getApplyClass();
            arr[3] = item.getScholarshipName();
            arr[4] = item.getReason();
            arr[5] = item.getTeacherId();
            tableModel.addRow(arr);
        }
    }
    private void load3(String nickName, String classNumber, String scholarshipName) {
        List<Apply> list = new ApplyDao().queryList1(nickName, classNumber, scholarshipName);
        DefaultTableModel tableModel = (DefaultTableModel) studentTable4.getModel();
        tableModel.setRowCount(0);
        //填充申请奖学金表数据
        //{"申请序号", "申请人姓名", "申请人班级", "申请奖学金ID", "奖学金名称", "申请理由", "初审人工号","初审状态", "终审状态"}
        for (Apply item : list) {
            String[] arr =  new String[9];
            arr[0] = String.valueOf(item.getId());
            arr[1] = item.getApplyNickName();
            arr[2] = item.getApplyClass();
            arr[3] = String.valueOf(item.getScholarshipId());
            arr[4] = item.getScholarshipName();
            arr[5] = item.getReason();
            arr[6] = item.getTeacherId();
            String teacherState = item.getTeacherState();
            if ("yes".equals(teacherState)) {
                arr[7] = "已通过";
            } else if ("no".equals(teacherState)) {
                arr[7] = "未通过";
            } else if (teacherState == null || teacherState.isEmpty()) {
                arr[7] = "未审核";
            }
            String adminState = item.getAdminState();
            if ("yes".equals(adminState)) {
                arr[8] = "已通过";
            } else if ("no".equals(adminState)) {
                arr[8] = "未通过";
            } else if (adminState == null || adminState.isEmpty()) {
                arr[8] = "未审核";
            }
            tableModel.addRow(arr);
        }
    }

    protected void load2(String scholarshipName, String roleText) {
        List<Scholarship> list = new ScholarshipDao().queryList(scholarshipName, roleText);
        DefaultTableModel tableModel = (DefaultTableModel) studentTable3.getModel();
        tableModel.setRowCount(0);
        //填充奖学金表数据
        //{"奖学金序号（自增）", "奖学金名称", "奖学金的类型", "奖学金的金额", "奖学金申请条件", "奖学金介绍"}
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

    protected void load1(String id, String nickname) {
        List<Teacher> list = new TeacherDao().queryList(id, nickname);
        DefaultTableModel tableModel = (DefaultTableModel) studentTable2.getModel();
        tableModel.setRowCount(0);
        //填充数据
        //{"工号", "姓名", "性别", "管理班级", "电话号码", "邮箱地址"}
        for (Teacher item : list) {
            String[] arr = new String[6];
            arr[0] = item.getId();
            arr[1] = item.getNickname();
            arr[2] = item.getSex() == 0? "男" : "女";
            arr[3] = item.getProfession();
            arr[4] = item.getTelephone();
            arr[5] = item.getEmail();
            tableModel.addRow(arr);
        }
    }

    protected void load(String id, String nickname, String classNumber) {
        List<Student> list = studentDao.queryList(id, nickname, classNumber);
        DefaultTableModel tableModel = (DefaultTableModel) studentTable.getModel();
        tableModel.setRowCount(0);      // 清空表格
        //填充数据
        //{"学号", "姓名", "性别", "班级", "电话号码", "学生专业", "专业成绩", "是否家境贫困", "是否违纪"}
        for (Student item : list) {
            String[] arr = new String[9];
            arr[0] = item.getId();  // 学生学号
            arr[1] = item.getNickname();    // 姓名
            arr[2] = item.getSex() == 0 ? "男" : "女";    // 性别
            arr[3] = item.getClassNumber(); // 班级
            arr[4] = item.getTelephone();   // 电话号码
            arr[5] = item.getProfession(); // 学生专业
            arr[6] = String.valueOf(item.getProClassGrade()); // 专业成绩
            arr[7] = item.getIfPool() == 0? "是" : "否";  // 是否家境贫困
            arr[8] = item.getIfViolationOfDiscipline() == 0? "有" : "无";
            tableModel.addRow(arr);
        }
    }

    private JFrame AdminHero;
    private JTabbedPane StudentManagementTab;
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTextField textField7;
    private JLabel label7;
    private JScrollPane scrollPane1;
    private JTable studentTable;
    private JPanel panel2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JScrollPane scrollPane2;
    private JTable studentTable2;
    private JPanel panel3;
    private JLabel label5;
    private JTextField textField5;
    private JLabel label6;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JScrollPane scrollPane3;
    private JTable studentTable3;
    private JComboBox comboBox1;
    private JPanel panel4;
    private JLabel label8;
    private JTextField textField8;
    private JLabel label9;
    private JTextField textField9;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;
    private JScrollPane scrollPane4;
    private JTable studentTable4;
    private JLabel label11;
    private JTextField textField11;
    private JPanel panel5;
    private JLabel label10;
    private JTextField textField10;
    private JButton button17;
    private JScrollPane scrollPane5;
    private JTable studentTable5;
    private StudentDao studentDao = new StudentDao();
    private AdminManagement frame = this;
    private JPanel contentPane;
    private String scholarshipName;
    private String roleText;
}
