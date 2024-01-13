/*
 * Created by JFormDesigner on Tue Jan 09 19:22:53 CST 2024
 */

package Backup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author 13425
 */
public class AdminManagement {
    public AdminManagement() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
    }

    private void button4(ActionEvent e) {
        // TODO add your code here
    }

    private void button5(ActionEvent e) {
        // TODO add your code here
    }

    private void button6(ActionEvent e) {
        // TODO add your code here
    }

    private void button7(ActionEvent e) {
        // TODO add your code here
    }

    private void button8(ActionEvent e) {
        // TODO add your code here
    }

    private void comboBox1(ActionEvent e) {
        // TODO add your code here
    }

    private void button9(ActionEvent e) {
        // TODO add your code here
    }

    private void button10(ActionEvent e) {
        // TODO add your code here
    }

    private void button11(ActionEvent e) {
        // TODO add your code here
    }

    private void button12(ActionEvent e) {
        // TODO add your code here
    }

    private void button13(ActionEvent e) {
        // TODO add your code here
    }

    private void button14(ActionEvent e) {
        // TODO add your code here
    }

    private void button15(ActionEvent e) {
        // TODO add your code here
    }

    private void button16(ActionEvent e) {
        // TODO add your code here
    }

    private void button17(ActionEvent e) {
        // TODO add your code here
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
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
            AdminHero.setTitle("\u767b\u5f55\u8eab\u4efd\uff1a\u7ba1\u7406\u5458");
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
                    label1.setText("\u8d26\u53f7\uff1a");
                    label1.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                    panel1.add(label1);
                    label1.setBounds(new Rectangle(new Point(25, 20), label1.getPreferredSize()));
                    panel1.add(textField1);
                    textField1.setBounds(80, 20, 120, 25);

                    //---- label2 ----
                    label2.setText("\u59d3\u540d\uff1a");
                    label2.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                    panel1.add(label2);
                    label2.setBounds(210, 20, 48, 22);
                    panel1.add(textField2);
                    textField2.setBounds(265, 20, 120, 25);

                    //---- button1 ----
                    button1.setText("\u67e5\u8be2");
                    button1.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button1.addActionListener(e -> button1(e));
                    panel1.add(button1);
                    button1.setBounds(new Rectangle(new Point(605, 20), button1.getPreferredSize()));

                    //---- button2 ----
                    button2.setText("\u6dfb\u52a0");
                    button2.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button2.addActionListener(e -> button2(e));
                    panel1.add(button2);
                    button2.setBounds(840, 20, 70, 25);

                    //---- button3 ----
                    button3.setText("\u4fee\u6539");
                    button3.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button3.addActionListener(e -> button3(e));
                    panel1.add(button3);
                    button3.setBounds(920, 20, 70, 25);

                    //---- button4 ----
                    button4.setText("\u5220\u9664");
                    button4.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button4.addActionListener(e -> button4(e));
                    panel1.add(button4);
                    button4.setBounds(1000, 20, 70, 25);
                    panel1.add(textField7);
                    textField7.setBounds(460, 20, 120, 25);

                    //---- label7 ----
                    label7.setText("\u73ed\u7ea7\uff1a");
                    label7.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                    panel1.add(label7);
                    label7.setBounds(405, 20, 48, 22);

                    //======== scrollPane1 ========
                    {

                        //---- studentTable ----
                        studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                        studentTable.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
                        studentTable.setShowHorizontalLines(true);
                        studentTable.setShowVerticalLines(true);
                        scrollPane1.setViewportView(studentTable);
                    }
                    panel1.add(scrollPane1);
                    scrollPane1.setBounds(10, 65, 1065, 440);
                }
                StudentManagementTab.addTab("\u5b66\u751f\u4fe1\u606f\u7ba1\u7406", panel1);

                //======== panel2 ========
                {
                    panel2.setLayout(null);

                    //---- label3 ----
                    label3.setText("\u8d26\u53f7\uff1a");
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

                        //---- studentTable2 ----
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
                    label5.setText("\u5956\u9879\uff1a");
                    label5.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                    panel3.add(label5);
                    label5.setBounds(25, 20, 48, 22);
                    panel3.add(textField5);
                    textField5.setBounds(80, 20, 120, 25);

                    //---- label6 ----
                    label6.setText("\u7c7b\u522b\uff1a");
                    label6.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                    panel3.add(label6);
                    label6.setBounds(210, 20, 48, 22);

                    //---- button9 ----
                    button9.setText("\u67e5\u8be2");
                    button9.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button9.addActionListener(e -> button9(e));
                    panel3.add(button9);
                    button9.setBounds(410, 20, 90, 25);

                    //---- button10 ----
                    button10.setText("\u6dfb\u52a0");
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
                    button12.setText("\u5220\u9664");
                    button12.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button12.addActionListener(e -> button12(e));
                    panel3.add(button12);
                    button12.setBounds(1000, 20, 70, 25);

                    //======== scrollPane3 ========
                    {

                        //---- studentTable3 ----
                        studentTable3.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                        studentTable3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
                        studentTable3.setShowHorizontalLines(true);
                        studentTable3.setShowVerticalLines(true);
                        scrollPane3.setViewportView(studentTable3);
                    }
                    panel3.add(scrollPane3);
                    scrollPane3.setBounds(10, 65, 1065, 440);

                    //---- comboBox1 ----
                    comboBox1.addActionListener(e -> comboBox1(e));
                    panel3.add(comboBox1);
                    comboBox1.setBounds(265, 20, 120, comboBox1.getPreferredSize().height);
                }
                StudentManagementTab.addTab("\u5956\u5b66\u91d1\u7ba1\u7406", panel3);

                //======== panel4 ========
                {
                    panel4.setLayout(null);

                    //---- label8 ----
                    label8.setText("\u59d3\u540d\uff1a");
                    label8.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
                    panel4.add(label8);
                    label8.setBounds(25, 20, 48, 22);
                    panel4.add(textField8);
                    textField8.setBounds(80, 20, 120, 25);

                    //---- label9 ----
                    label9.setText("\u7533\u8bf7\u5956\u9879\uff1a");
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
                    button14.setText("\u6dfb\u52a0");
                    button14.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button14.addActionListener(e -> button14(e));
                    panel4.add(button14);
                    button14.setBounds(840, 20, 70, 25);

                    //---- button15 ----
                    button15.setText("\u4fee\u6539");
                    button15.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button15.addActionListener(e -> button15(e));
                    panel4.add(button15);
                    button15.setBounds(920, 20, 70, 25);

                    //---- button16 ----
                    button16.setText("\u5220\u9664");
                    button16.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button16.addActionListener(e -> button16(e));
                    panel4.add(button16);
                    button16.setBounds(1000, 20, 70, 25);

                    //======== scrollPane4 ========
                    {

                        //---- studentTable4 ----
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
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
