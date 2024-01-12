/*
 * Created by JFormDesigner on Tue Jan 09 20:49:03 CST 2024
 */

package Backup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author 13425
 */
public class StudentManagement extends JFrame {
    public StudentManagement() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void comboBox1(ActionEvent e) {
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
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
        table1 = new JTable();
        panel2 = new JPanel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        button3 = new JButton();
        button4 = new JButton();
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
            StudentManagement.setTitle("\u767b\u5f55\u8eab\u4efd\uff1a\u5b66\u751f");
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
                    label1.setText("\u5956\u5b66\u91d1\u540d\u79f0\uff1a");
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
                    comboBox1.addActionListener(e -> comboBox1(e));
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
                        scrollPane1.setViewportView(table1);
                    }
                    panel1.add(scrollPane1);
                    scrollPane1.setBounds(5, 50, 770, 425);
                }
                tabbedPane1.addTab("\u53ef\u7533\u8bf7\u5956\u5b66\u91d1\u67e5\u8be2", panel1);

                //======== panel2 ========
                {
                    panel2.setLayout(null);

                    //======== scrollPane2 ========
                    {
                        scrollPane2.setViewportView(table2);
                    }
                    panel2.add(scrollPane2);
                    scrollPane2.setBounds(5, 50, 770, 425);

                    //---- button3 ----
                    button3.setText("\u53d6\u6d88\u7533\u8bf7");
                    button3.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 12));
                    button3.addActionListener(e -> button3(e));
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

                //======== panel4 ========
                {
                    panel4.setLayout(null);

                    //---- label3 ----
                    label3.setText("\u539f\u8d26\u53f7\u5bc6\u7801\uff1a");
                    label3.setFont(new Font("LXGW WenKai", Font.PLAIN, 26));
                    panel4.add(label3);
                    label3.setBounds(160, 65, 160, 60);

                    //---- label4 ----
                    label4.setText("\u65b0\u8d26\u53f7\u5bc6\u7801\uff1a");
                    label4.setFont(new Font("LXGW WenKai", Font.PLAIN, 28));
                    panel4.add(label4);
                    label4.setBounds(160, 145, 180, 65);

                    //---- label5 ----
                    label5.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
                    label5.setFont(new Font("LXGW WenKai", Font.PLAIN, 28));
                    panel4.add(label5);
                    label5.setBounds(160, 225, 170, 75);

                    //---- textField2 ----
                    textField2.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
                    panel4.add(textField2);
                    textField2.setBounds(345, 80, 260, 35);

                    //---- passwordField1 ----
                    passwordField1.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
                    panel4.add(passwordField1);
                    passwordField1.setBounds(345, 165, 260, 35);

                    //---- passwordField2 ----
                    passwordField2.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
                    panel4.add(passwordField2);
                    passwordField2.setBounds(345, 250, 260, 35);

                    //---- button5 ----
                    button5.setText("\u786e\u5b9a\u4fee\u6539");
                    button5.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
                    button5.addActionListener(e -> button5(e));
                    panel4.add(button5);
                    button5.setBounds(new Rectangle(new Point(340, 365), button5.getPreferredSize()));
                }
                tabbedPane1.addTab("\u767b\u5f55\u5bc6\u7801\u4fee\u6539", panel4);
            }
            StudentManagementContentPane.add(tabbedPane1);
            tabbedPane1.setBounds(0, 0, 800, 515);

            StudentManagementContentPane.setPreferredSize(new Dimension(640, 440));
            StudentManagement.setSize(800, 550);
            StudentManagement.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
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
    private JButton button4;
    private JPanel panel4;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField2;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
