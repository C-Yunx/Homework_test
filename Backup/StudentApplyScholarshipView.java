/*
 * Created by JFormDesigner on Thu Jan 11 18:09:59 CST 2024
 */

package Backup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author 13425
 */
public class StudentApplyScholarshipView {
    public StudentApplyScholarshipView() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        StudentApplyScholarship = new JFrame();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
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
            button2.addActionListener(e -> button1(e));
            StudentApplyScholarshipContentPane.add(button2);
            button2.setBounds(320, 365, 78, 31);

            StudentApplyScholarshipContentPane.setPreferredSize(new Dimension(460, 380));
            StudentApplyScholarship.setSize(575, 475);
            StudentApplyScholarship.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
