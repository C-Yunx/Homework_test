/*
 * Created by JFormDesigner on Thu Jan 11 00:52:11 CST 2024
 */

package View;

import Dao.StudentDao;
import Entity.Student;
import Util.DateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * 添加学生信息的视图
 * @author 13425
 */
public class AdminStudentAddView extends JFrame{
    private void radioButton1(ActionEvent e) {
        radioButton1.setSelected(true);
        radioButton2.setSelected(false);
    }

    private void radioButton2(ActionEvent e) {
        radioButton1.setSelected(false);
        radioButton2.setSelected(true);
    }

    private void radioButton3(ActionEvent e) {
        radioButton3.setSelected(true);
        radioButton4.setSelected(false);
    }

    private void radioButton4(ActionEvent e) {
        radioButton3.setSelected(false);
        radioButton4.setSelected(true);
    }

    private void radioButton5(ActionEvent e) {
        radioButton5.setSelected(true);
        radioButton6.setSelected(false);
    }

    private void radioButton6(ActionEvent e) {
        radioButton5.setSelected(false);
        radioButton6.setSelected(true);
    }

    private void button1(ActionEvent e) {
        String id = textField1.getText();
        String classNumber = textField2.getText();
        String username = textField3.getText();
        String password = textField4.getText();
        String nickname = textField5.getText();
        String birthday = textField6.getText();
        String telephone = textField7.getText();
        String email = textField8.getText();
        String profession = textField9.getText();
        String proClassGrade = textField10.getText();
        String peClassGrade = textField11.getText();
        String cultureClassGrade = textField12.getText();
        String comprehensiveTestGrade = textField13.getText();

        if (username == null || username.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "账号不能为空", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (password == null || password.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "密码不能为空", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (nickname == null || nickname.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "姓名不能为空", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int sex = 0;
        //获取性别
        if (radioButton2.isSelected()) {
            sex = 1;
        }
        int ifPool = 0;
        if (radioButton4.isSelected()) {
            ifPool = 1;
        }
        int ifViolationOfDiscipline = 0;
        if (radioButton6.isSelected()) {
            ifViolationOfDiscipline = 1;
        }

        try {
            if (birthday == null || birthday.isEmpty()) {
                JOptionPane.showMessageDialog(contentPane, "生日不能为空", "系统提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            DateUtil.formatString(birthday, "yyyy-MM-dd");
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(contentPane, "生日格式不正确", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (telephone == null || telephone.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "手机号码不能为空", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (email == null || email.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "邮箱不能为空", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (profession == null || profession.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "专业不能为空", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (proClassGrade == null || proClassGrade.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "专业课成绩不能为空", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (peClassGrade == null || peClassGrade.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "体测不能为空", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cultureClassGrade == null || cultureClassGrade.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "文化成绩不能为空", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (comprehensiveTestGrade == null || comprehensiveTestGrade.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "综测成绩不能为空", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }


        Student student = new Student();
        student.setId(id);
        student.setClassNumber(classNumber);
        student.setUsername(username);
        student.setPassword(password);
        student.setNickname(nickname);
        student.setSex(sex);
        student.setBirthday(birthday);
        student.setTelephone(telephone);
        student.setEmail(email);
        student.setProfession(profession);
        student.setIfPool(ifPool);
        student.setProClassGrade(Integer.valueOf(proClassGrade));
        student.setPeClassGrade(Integer.valueOf(peClassGrade));
        student.setCultureClassGrade(Integer.valueOf(cultureClassGrade));
        student.setComprehensiveTestGrade(Integer.valueOf(comprehensiveTestGrade));
        student.setTotalClassGrade(Integer.valueOf(proClassGrade) + Integer.valueOf(peClassGrade) + Integer.valueOf(cultureClassGrade) + Integer.valueOf(comprehensiveTestGrade));
        student.setIfViolationOfDiscipline(ifViolationOfDiscipline);

        boolean flag = studentDao.save(student);
        if (flag) {
            frame.load(null, null, null);
            dispose();
            JOptionPane.showMessageDialog(contentPane, "添加成功", "系统提示", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(contentPane, "添加失败", "系统提示", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void button2(ActionEvent e) {
        this.StudentAddView.dispose();
    }

    public AdminStudentAddView(final AdminManagement frame) {
        this.frame = frame;
        StudentAddView = new JFrame();
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
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        label7 = new JLabel();
        textField6 = new JTextField();
        label8 = new JLabel();
        label9 = new JLabel();
        textField7 = new JTextField();
        label10 = new JLabel();
        textField8 = new JTextField();
        label11 = new JLabel();
        textField9 = new JTextField();
        label12 = new JLabel();
        radioButton3 = new JRadioButton();
        radioButton4 = new JRadioButton();
        label13 = new JLabel();
        textField10 = new JTextField();
        label14 = new JLabel();
        textField11 = new JTextField();
        label15 = new JLabel();
        textField12 = new JTextField();
        label16 = new JLabel();
        textField13 = new JTextField();
        label17 = new JLabel();
        radioButton5 = new JRadioButton();
        radioButton6 = new JRadioButton();
        button1 = new JButton();
        button2 = new JButton();

        //======== StudentAddView ========
        {
            StudentAddView.setTitle("学生信息添加");
            var StudentAddViewContentPane = StudentAddView.getContentPane();
            StudentAddViewContentPane.setLayout(null);

            //---- label1 ----
            label1.setText("学生学号：");
            label1.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentAddViewContentPane.add(label1);
            label1.setBounds(new Rectangle(new Point(15, 20), label1.getPreferredSize()));

            //---- textField1 ----
            textField1.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            StudentAddViewContentPane.add(textField1);
            textField1.setBounds(95, 15, 140, 35);

            //---- label2 ----
            label2.setText("学生班级：");
            label2.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentAddViewContentPane.add(label2);
            label2.setBounds(300, 20, 80, 22);

            //---- textField2 ----
            textField2.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            StudentAddViewContentPane.add(textField2);
            textField2.setBounds(380, 15, 140, 35);

            //---- label3 ----
            label3.setText("学生账号：");
            label3.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentAddViewContentPane.add(label3);
            label3.setBounds(15, 80, 80, 22);

            //---- textField3 ----
            textField3.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            StudentAddViewContentPane.add(textField3);
            textField3.setBounds(95, 75, 140, 35);

            //---- label4 ----
            label4.setText("账号密码：");
            label4.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentAddViewContentPane.add(label4);
            label4.setBounds(300, 80, 80, 22);

            //---- textField4 ----
            textField4.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            StudentAddViewContentPane.add(textField4);
            textField4.setBounds(380, 75, 140, 35);

            //---- label5 ----
            label5.setText("学生姓名：");
            label5.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentAddViewContentPane.add(label5);
            label5.setBounds(15, 140, 80, 22);

            //---- textField5 ----
            textField5.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            StudentAddViewContentPane.add(textField5);
            textField5.setBounds(95, 135, 140, 35);

            //---- label6 ----
            label6.setText("学生性别：");
            label6.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentAddViewContentPane.add(label6);
            label6.setBounds(300, 140, 80, 22);

            //---- radioButton1 ----
            radioButton1.setText("男");
            radioButton1.addActionListener(e -> radioButton1(e));
            StudentAddViewContentPane.add(radioButton1);
            radioButton1.setBounds(new Rectangle(new Point(400, 140), radioButton1.getPreferredSize()));

            //---- radioButton2 ----
            radioButton2.setText("女");
            radioButton2.addActionListener(e -> radioButton2(e));
            StudentAddViewContentPane.add(radioButton2);
            radioButton2.setBounds(new Rectangle(new Point(460, 140), radioButton2.getPreferredSize()));

            //---- label7 ----
            label7.setText("学生生日：");
            label7.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentAddViewContentPane.add(label7);
            label7.setBounds(15, 200, 80, 22);

            //---- textField6 ----
            textField6.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            StudentAddViewContentPane.add(textField6);
            textField6.setBounds(95, 195, 140, 35);

            //---- label8 ----
            label8.setText("yyyy-MM-dd");
            label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 3f));
            StudentAddViewContentPane.add(label8);
            label8.setBounds(250, 200, 120, label8.getPreferredSize().height);

            //---- label9 ----
            label9.setText("\u5b66\u751f\u7535\u8bdd\uff1a");
            label9.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentAddViewContentPane.add(label9);
            label9.setBounds(15, 265, 80, 22);

            //---- textField7 ----
            textField7.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            StudentAddViewContentPane.add(textField7);
            textField7.setBounds(95, 260, 140, 35);

            //---- label10 ----
            label10.setText("\u5b66\u751f\u90ae\u7bb1\uff1a");
            label10.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentAddViewContentPane.add(label10);
            label10.setBounds(300, 265, 80, 22);

            //---- textField8 ----
            textField8.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            StudentAddViewContentPane.add(textField8);
            textField8.setBounds(380, 260, 140, 35);

            //---- label11 ----
            label11.setText("\u5b66\u751f\u4e13\u4e1a\uff1a");
            label11.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentAddViewContentPane.add(label11);
            label11.setBounds(15, 330, 80, 22);

            //---- textField9 ----
            textField9.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            StudentAddViewContentPane.add(textField9);
            textField9.setBounds(95, 325, 140, 35);

            //---- label12 ----
            label12.setText("\u662f\u5426\u8d2b\u56f0\uff1a");
            label12.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentAddViewContentPane.add(label12);
            label12.setBounds(300, 330, 80, 22);

            //---- radioButton3 ----
            radioButton3.setText("\u662f");
            radioButton3.addActionListener(e -> radioButton3(e));
            StudentAddViewContentPane.add(radioButton3);
            radioButton3.setBounds(400, 330, 37, 23);

            //---- radioButton4 ----
            radioButton4.setText("\u5426");
            radioButton4.addActionListener(e -> radioButton4(e));
            StudentAddViewContentPane.add(radioButton4);
            radioButton4.setBounds(460, 330, 37, 23);

            //---- label13 ----
            label13.setText("\u5b66\u751f\u4e13\u4e1a\u8bfe\u7a0b\u6210\u7ee9\uff1a");
            label13.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentAddViewContentPane.add(label13);
            label13.setBounds(15, 395, 145, 22);

            //---- textField10 ----
            textField10.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            StudentAddViewContentPane.add(textField10);
            textField10.setBounds(160, 390, 140, 35);

            //---- label14 ----
            label14.setText("\u4f53\u6d4b\u6210\u7ee9\uff1a");
            label14.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentAddViewContentPane.add(label14);
            label14.setBounds(300, 395, 85, 22);

            //---- textField11 ----
            textField11.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            StudentAddViewContentPane.add(textField11);
            textField11.setBounds(380, 390, 140, 35);

            //---- label15 ----
            label15.setText("\u6587\u5316\u8bfe\u7a0b\u6210\u7ee9\uff1a");
            label15.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentAddViewContentPane.add(label15);
            label15.setBounds(15, 460, 115, 22);

            //---- textField12 ----
            textField12.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            StudentAddViewContentPane.add(textField12);
            textField12.setBounds(130, 455, 140, 35);

            //---- label16 ----
            label16.setText("\u7efc\u6d4b\u6210\u7ee9\uff1a");
            label16.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentAddViewContentPane.add(label16);
            label16.setBounds(300, 460, 85, 22);

            //---- textField13 ----
            textField13.setFont(new Font("LXGW WenKai", Font.PLAIN, 14));
            StudentAddViewContentPane.add(textField13);
            textField13.setBounds(385, 455, 140, 35);

            //---- label17 ----
            label17.setText("\u662f\u5426\u6709\u8fdd\u7eaa\u60c5\u51b5\uff1a");
            label17.setFont(new Font("LXGW WenKai", Font.PLAIN, 16));
            StudentAddViewContentPane.add(label17);
            label17.setBounds(15, 525, 130, 22);

            //---- radioButton5 ----
            radioButton5.setText("\u662f");
            radioButton5.addActionListener(this::radioButton5);
            StudentAddViewContentPane.add(radioButton5);
            radioButton5.setBounds(150, 525, 37, 23);

            //---- radioButton6 ----
            radioButton6.setText("\u5426");
            radioButton6.addActionListener(this::radioButton6);
            StudentAddViewContentPane.add(radioButton6);
            radioButton6.setBounds(205, 525, 37, 23);

            //---- button1 ----
            button1.setText("保存");
            button1.setFont(new Font("LXGW WenKai", Font.PLAIN, 18));
            button1.addActionListener(this::button1);
            StudentAddViewContentPane.add(button1);
            button1.setBounds(new Rectangle(new Point(140, 570), button1.getPreferredSize()));

            //---- button2 ----
            button2.setText("取消");
            button2.setFont(new Font("LXGW WenKai", Font.PLAIN, 18));
            button2.addActionListener(this::button2);
            StudentAddViewContentPane.add(button2);
            button2.setBounds(315, 570, 78, 31);

            StudentAddViewContentPane.setPreferredSize(new Dimension(446, 540));
            StudentAddView.setSize(557, 675);
            StudentAddView.setLocationRelativeTo(null);
            StudentAddView.setResizable(false);
            StudentAddView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            StudentAddView.setVisible(true);
        }
    }

    private JFrame StudentAddView;
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
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JLabel label7;
    private JTextField textField6;
    private JLabel label8;
    private JLabel label9;
    private JTextField textField7;
    private JLabel label10;
    private JTextField textField8;
    private JLabel label11;
    private JTextField textField9;
    private JLabel label12;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JLabel label13;
    private JTextField textField10;
    private JLabel label14;
    private JTextField textField11;
    private JLabel label15;
    private JTextField textField12;
    private JLabel label16;
    private JTextField textField13;
    private JLabel label17;
    private JRadioButton radioButton5;
    private JRadioButton radioButton6;
    private JButton button1;
    private JButton button2;
    private JPanel contentPane;
    private StudentDao studentDao = new StudentDao();
    private AdminManagement frame;
}
