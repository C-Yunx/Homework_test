/*
 * Created by JFormDesigner on Tue Jan 09 20:56:27 CST 2024
 */

package Backup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author 13425
 */
public class TeacherManagement extends JFrame {
    public TeacherManagement() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
    }

    private void button5(ActionEvent e) {
        // TODO add your code here
    }

    private void button6(ActionEvent e) {
        // TODO add your code here
    }

    private void button4(ActionEvent e) {
        // TODO add your code here
    }

    private void button7(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
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
                    label1.setText("\u5b66\u751f\u59d3\u540d\uff1a");
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
                        scrollPane1.setViewportView(table1);
                    }
                    panel1.add(scrollPane1);
                    scrollPane1.setBounds(5, 50, 770, 425);
                }
                tabbedPane1.addTab("\u73ed\u7ea7\u5b66\u751f\u4fe1\u606f\u67e5\u8be2", panel1);

                //======== panel2 ========
                {
                    panel2.setLayout(null);

                    //---- button3 ----
                    button3.setText("\u67e5\u8be2\u6240\u6709");
                    button3.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button3.addActionListener(e -> button3(e));
                    panel2.add(button3);
                    button3.setBounds(20, 15, 85, 25);

                    //======== scrollPane2 ========
                    {
                        scrollPane2.setViewportView(table2);
                    }
                    panel2.add(scrollPane2);
                    scrollPane2.setBounds(5, 50, 770, 425);

                    //---- button5 ----
                    button5.setText("\u901a\u8fc7");
                    button5.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button5.addActionListener(e -> button5(e));
                    panel2.add(button5);
                    button5.setBounds(120, 15, 85, 25);

                    //---- button6 ----
                    button6.setText("\u6253\u56de");
                    button6.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button6.addActionListener(e -> button6(e));
                    panel2.add(button6);
                    button6.setBounds(220, 15, 85, 25);
                }
                tabbedPane1.addTab("\u672a\u5ba1\u6838\u7533\u8bf7", panel2);

                //======== panel3 ========
                {
                    panel3.setLayout(null);

                    //---- button4 ----
                    button4.setText("\u67e5\u8be2\u6240\u6709");
                    button4.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button4.addActionListener(e -> button4(e));
                    panel3.add(button4);
                    button4.setBounds(20, 15, 85, 25);

                    //======== scrollPane3 ========
                    {
                        scrollPane3.setViewportView(table3);
                    }
                    panel3.add(scrollPane3);
                    scrollPane3.setBounds(5, 50, 770, 425);
                }
                tabbedPane1.addTab("\u5df2\u901a\u8fc7\u7533\u8bf7", panel3);

                //======== panel4 ========
                {
                    panel4.setLayout(null);

                    //---- label3 ----
                    label3.setText("\u539f\u8d26\u53f7\u5bc6\u7801\uff1a");
                    label3.setFont(new Font("LXGW WenKai", Font.PLAIN, 26));
                    panel4.add(label3);
                    label3.setBounds(160, 65, 160, 60);

                    //---- textField2 ----
                    textField2.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
                    panel4.add(textField2);
                    textField2.setBounds(345, 80, 260, 35);

                    //---- label4 ----
                    label4.setText("\u65b0\u8d26\u53f7\u5bc6\u7801\uff1a");
                    label4.setFont(new Font("LXGW WenKai", Font.PLAIN, 28));
                    panel4.add(label4);
                    label4.setBounds(160, 145, 180, 65);

                    //---- passwordField1 ----
                    passwordField1.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
                    panel4.add(passwordField1);
                    passwordField1.setBounds(345, 165, 260, 35);

                    //---- label5 ----
                    label5.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
                    label5.setFont(new Font("LXGW WenKai", Font.PLAIN, 28));
                    panel4.add(label5);
                    label5.setBounds(160, 225, 170, 75);

                    //---- passwordField2 ----
                    passwordField2.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
                    panel4.add(passwordField2);
                    passwordField2.setBounds(345, 250, 260, 35);

                    //---- button7 ----
                    button7.setText("\u786e\u5b9a\u4fee\u6539");
                    button7.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
                    button7.addActionListener(e -> button7(e));
                    panel4.add(button7);
                    button7.setBounds(340, 365, 117, 37);
                }
                tabbedPane1.addTab("\u767b\u5f55\u5bc6\u7801\u4fee\u6539", panel4);
            }
            TeacherManagementContentPane.add(tabbedPane1);
            tabbedPane1.setBounds(0, 0, 800, 515);

            TeacherManagementContentPane.setPreferredSize(new Dimension(640, 440));
            TeacherManagement.setSize(800, 550);
            TeacherManagement.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
