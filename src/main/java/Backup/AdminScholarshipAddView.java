/*
 * Created by JFormDesigner on Thu Jan 11 10:22:31 CST 2024
 */

package Backup;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author 13425
 */
public class AdminScholarshipAddView {
    public AdminScholarshipAddView() {
        initComponents();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ScholarshipAddView = new JFrame();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        comboBox1 = new JComboBox();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label5 = new JLabel();
        scrollPane2 = new JScrollPane();
        textArea2 = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();

        //======== ScholarshipAddView ========
        {
            ScholarshipAddView.setTitle("\u6dfb\u52a0\u5956\u5b66\u91d1");
            var ScholarshipAddViewContentPane = ScholarshipAddView.getContentPane();
            ScholarshipAddViewContentPane.setLayout(null);

            //---- label1 ----
            label1.setText("\u5956\u5b66\u91d1\u540d\u79f0\uff1a");
            label1.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            ScholarshipAddViewContentPane.add(label1);
            label1.setBounds(20, 35, 110, 22);

            //---- textField1 ----
            textField1.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            ScholarshipAddViewContentPane.add(textField1);
            textField1.setBounds(115, 30, 140, 35);

            //---- label2 ----
            label2.setText("\u5956\u5b66\u91d1\u7c7b\u578b\uff1a");
            label2.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            ScholarshipAddViewContentPane.add(label2);
            label2.setBounds(275, 35, 110, 22);

            //---- comboBox1 ----
            comboBox1.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            ScholarshipAddViewContentPane.add(comboBox1);
            comboBox1.setBounds(375, 25, 135, 40);

            //---- label3 ----
            label3.setText("\u5956\u5b66\u91d1\u91d1\u989d\uff1a");
            label3.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            ScholarshipAddViewContentPane.add(label3);
            label3.setBounds(20, 85, 105, 22);

            //---- textField2 ----
            textField2.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            ScholarshipAddViewContentPane.add(textField2);
            textField2.setBounds(115, 80, 140, 35);

            //---- label4 ----
            label4.setText("\u5956\u5b66\u91d1\u7533\u8bf7\u6761\u4ef6\uff1a");
            label4.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            ScholarshipAddViewContentPane.add(label4);
            label4.setBounds(20, 135, 135, 22);

            //======== scrollPane1 ========
            {

                //---- textArea1 ----
                textArea1.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.PLAIN, 14));
                textArea1.setRows(8);
                textArea1.setLineWrap(true);
                scrollPane1.setViewportView(textArea1);
            }
            ScholarshipAddViewContentPane.add(scrollPane1);
            scrollPane1.setBounds(25, 165, 540, 105);

            //---- label5 ----
            label5.setText("\u5956\u5b66\u91d1\u4ecb\u7ecd\uff1a");
            label5.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            ScholarshipAddViewContentPane.add(label5);
            label5.setBounds(20, 295, 135, 22);

            //======== scrollPane2 ========
            {

                //---- textArea2 ----
                textArea2.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.PLAIN, 14));
                textArea2.setRows(8);
                textArea2.setLineWrap(true);
                scrollPane2.setViewportView(textArea2);
            }
            ScholarshipAddViewContentPane.add(scrollPane2);
            scrollPane2.setBounds(25, 325, 540, 105);

            //---- button1 ----
            button1.setText("\u4fdd\u5b58");
            button1.setFont(new Font("LXGW WenKai", Font.PLAIN, 18));
            button1.addActionListener(e -> button1(e));
            ScholarshipAddViewContentPane.add(button1);
            button1.setBounds(165, 455, 78, 31);

            //---- button2 ----
            button2.setText("\u53d6\u6d88");
            button2.setFont(new Font("LXGW WenKai", Font.PLAIN, 18));
            button2.addActionListener(e -> button2(e));
            ScholarshipAddViewContentPane.add(button2);
            button2.setBounds(315, 455, 78, 31);

            ScholarshipAddViewContentPane.setPreferredSize(new Dimension(480, 440));
            ScholarshipAddView.setSize(600, 550);
            ScholarshipAddView.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JFrame ScholarshipAddView;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JComboBox comboBox1;
    private JLabel label3;
    private JTextField textField2;
    private JLabel label4;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label5;
    private JScrollPane scrollPane2;
    private JTextArea textArea2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
