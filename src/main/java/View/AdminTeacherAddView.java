/*
 * Created by JFormDesigner on Thu Jan 11 06:11:25 CST 2024
 */

package View;

import Dao.TeacherDao;
import Entity.Teacher;
import Util.DateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * 添加辅导员信息的视图
 * @author 13425
 */
public class AdminTeacherAddView extends JFrame{
    private void radioButton1(ActionEvent e) {
        radioButton1.setSelected(true);
        radioButton2.setSelected(false);
    }

    private void radioButton2(ActionEvent e) {
        radioButton2.setSelected(true);
        radioButton1.setSelected(false);
    }

    private void button1(ActionEvent e) {
        String id = textField1.getText();
        String username = textField2.getText();
        String password = textField3.getText();
        String nickname = textField4.getText();
        String birthday = textField5.getText();
        String telephone = textField6.getText();
        String email = textField7.getText();
        String profession = textField8.getText();

        if (username == null || username.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "账号不能为空！", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (password == null || password.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "密码不能为空！", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (nickname == null || nickname.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "姓名不能为空！", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (telephone == null || telephone.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "手机号码不能为空！", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (profession == null || profession.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "管理班级不能为空！", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int sex = 0;
        if (radioButton2.isSelected()) {
            sex = 1;
        }

        try {
            if (birthday == null || birthday.isEmpty()) {
                JOptionPane.showMessageDialog(contentPane, "生日不能为空！", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            DateUtil.formatString(birthday, "yyyy-MM-dd");
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(contentPane, "生日格式不正确！", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setUsername(username);
        teacher.setPassword(password);
        teacher.setNickname(nickname);
        teacher.setSex(sex);
        teacher.setBirthday(birthday);
        teacher.setTelephone(telephone);
        teacher.setEmail(email);
        teacher.setProfession(profession);

        boolean flag = teacherDao.save(teacher);
        if (flag) {
            frame.load1(null, null);
            dispose();
            JOptionPane.showMessageDialog(contentPane, "添加成功！", "系统提示", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(contentPane, "添加失败！", "系统提示", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void button2(ActionEvent e) {
        this.TeacherAddView.dispose();
    }

    public AdminTeacherAddView(final AdminManagement frame) {
        this.frame = frame;
        TeacherAddView = new JFrame();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        label6 = new JLabel();
        textField5 = new JTextField();
        label8 = new JLabel();
        label7 = new JLabel();
        textField6 = new JTextField();
        label9 = new JLabel();
        textField7 = new JTextField();
        label10 = new JLabel();
        textField8 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== TeacherAddView ========
        {
            TeacherAddView.setTitle("\u8f85\u5bfc\u5458\u4fe1\u606f\u6dfb\u52a0");
            var TeacherAddViewContentPane = TeacherAddView.getContentPane();
            TeacherAddViewContentPane.setLayout(null);

            //---- label1 ----
            label1.setText("\u5de5\u53f7\uff1a");
            label1.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            TeacherAddViewContentPane.add(label1);
            label1.setBounds(20, 15, 50, 22);

            //---- textField1 ----
            textField1.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            TeacherAddViewContentPane.add(textField1);
            textField1.setBounds(70, 10, 140, 35);

            //---- label2 ----
            label2.setText("\u767b\u5f55\u8d26\u53f7\uff1a");
            label2.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            TeacherAddViewContentPane.add(label2);
            label2.setBounds(225, 15, 80, 22);

            //---- textField2 ----
            textField2.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            TeacherAddViewContentPane.add(textField2);
            textField2.setBounds(310, 10, 140, 35);

            //---- label3 ----
            label3.setText("\u5bc6\u7801\uff1a");
            label3.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            TeacherAddViewContentPane.add(label3);
            label3.setBounds(20, 70, 55, 22);

            //---- textField3 ----
            textField3.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            TeacherAddViewContentPane.add(textField3);
            textField3.setBounds(70, 65, 140, 35);

            //---- label4 ----
            label4.setText("\u59d3\u540d\uff1a");
            label4.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            TeacherAddViewContentPane.add(label4);
            label4.setBounds(225, 70, 55, 22);

            //---- textField4 ----
            textField4.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            TeacherAddViewContentPane.add(textField4);
            textField4.setBounds(275, 65, 140, 35);

            //---- label5 ----
            label5.setText("\u6027\u522b\uff1a");
            label5.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            TeacherAddViewContentPane.add(label5);
            label5.setBounds(20, 130, 55, 22);

            //---- radioButton1 ----
            radioButton1.setText("\u7537");
            radioButton1.addActionListener(e -> radioButton1(e));
            TeacherAddViewContentPane.add(radioButton1);
            radioButton1.setBounds(75, 130, 37, 23);

            //---- radioButton2 ----
            radioButton2.setText("\u5973");
            radioButton2.addActionListener(e -> radioButton2(e));
            TeacherAddViewContentPane.add(radioButton2);
            radioButton2.setBounds(130, 130, 48, 23);

            //---- label6 ----
            label6.setText("\u751f\u65e5\uff1a");
            label6.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            TeacherAddViewContentPane.add(label6);
            label6.setBounds(200, 130, 50, 22);

            //---- textField5 ----
            textField5.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            TeacherAddViewContentPane.add(textField5);
            textField5.setBounds(250, 125, 140, 35);

            //---- label8 ----
            label8.setText("yyyy-MM-dd");
            label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 3f));
            TeacherAddViewContentPane.add(label8);
            label8.setBounds(390, 130, 100, 23);

            //---- label7 ----
            label7.setText("\u7535\u8bdd\uff1a");
            label7.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            TeacherAddViewContentPane.add(label7);
            label7.setBounds(20, 185, 50, 22);

            //---- textField6 ----
            textField6.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            TeacherAddViewContentPane.add(textField6);
            textField6.setBounds(70, 180, 140, 35);

            //---- label9 ----
            label9.setText("\u90ae\u7bb1\uff1a");
            label9.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            TeacherAddViewContentPane.add(label9);
            label9.setBounds(225, 185, 50, 22);

            //---- textField7 ----
            textField7.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            TeacherAddViewContentPane.add(textField7);
            textField7.setBounds(275, 180, 140, 35);

            //---- label10 ----
            label10.setText("\u7ba1\u7406\u73ed\u7ea7\uff1a");
            label10.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            TeacherAddViewContentPane.add(label10);
            label10.setBounds(20, 240, 80, 22);

            //---- textField8 ----
            textField8.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            TeacherAddViewContentPane.add(textField8);
            textField8.setBounds(100, 235, 140, 35);

            //---- button1 ----
            button1.setText("\u4fdd\u5b58");
            button1.setFont(new Font("LXGW WenKai", Font.PLAIN, 18));
            button1.addActionListener(e -> button1(e));
            TeacherAddViewContentPane.add(button1);
            button1.setBounds(145, 305, 78, 31);

            //---- button2 ----
            button2.setText("\u53d6\u6d88");
            button2.setFont(new Font("LXGW WenKai", Font.PLAIN, 18));
            button2.addActionListener(e -> button2(e));
            TeacherAddViewContentPane.add(button2);
            button2.setBounds(270, 305, 78, 31);

            TeacherAddViewContentPane.setPreferredSize(new Dimension(410, 320));
            TeacherAddView.setSize(512, 400);
            TeacherAddView.setLocationRelativeTo(null);
            TeacherAddView.setVisible(true);
            TeacherAddView.setResizable(false);
            TeacherAddView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    private JFrame TeacherAddView;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JLabel label6;
    private JTextField textField5;
    private JLabel label8;
    private JLabel label7;
    private JTextField textField6;
    private JLabel label9;
    private JTextField textField7;
    private JLabel label10;
    private JTextField textField8;
    private JButton button1;
    private JButton button2;
    private AdminManagement frame;
    private JPanel contentPane;
    private TeacherDao teacherDao = new TeacherDao();
}
