/*
 * Created by JFormDesigner on Tue Jan 09 17:30:36 CST 2024
 */

package View;

import Dao.AdminDao;
import Dao.StudentDao;
import Dao.TeacherDao;
import Entity.Admin;
import Entity.Student;
import Entity.Teacher;
import Util.DataTemp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

/**
 * @author 13425
 */
public class Login extends JFrame{
    public Login() {
        initComponents();
    }

    /**
     * 实现登录功能
     * ——监听登录按钮
     */
    private void login(ActionEvent e) {
        String userName = username.getText();
        String passWord = new String(passwordField.getPassword());
        String roleText = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
        if (userName.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "用户名不能为空！", "系统提示", JOptionPane.WARNING_MESSAGE);
            passwordField.setText("");
            return;
        }
        if (passWord.isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "密码不能为空！", "系统提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if ("请选择身份".equals(roleText)) {
            JOptionPane.showMessageDialog(contentPane, "请选择你需要登录的身份！", "系统提示", JOptionPane.WARNING_MESSAGE);
            passwordField.setText("");
            return;
        }
        try {
            Integer role = null;
            if ("管理员".equals(roleText)) {
                role = 0;
            } else if ("辅导员".equals(roleText)) {
                role = 1;
            } else if ("学生".equals(roleText)) {
                role = 2;
            }
            DataTemp.role = role;
            if (role == 0) {
                Admin admin = adminDao.login(userName, passWord);
                if (admin == null) {
                    JOptionPane.showMessageDialog(contentPane, "用户名或者密码错误0！", "系统提示", JOptionPane.WARNING_MESSAGE);
                    passwordField.setText("");
                    return;
                }
                DataTemp.uid = admin.getUsername();
                DataTemp.password = admin.getPassword();
                new AdminManagement();
                Hero.dispose();
            }
            if (role == 1) {
                Teacher teacher = teacherDao.login(userName, passWord);
                if (teacher == null) {
                    JOptionPane.showMessageDialog(contentPane, "用户名或者密码错误1！", "系统提示", JOptionPane.WARNING_MESSAGE);
                    passwordField.setText("");
                    return;
                }
                DataTemp.uid = teacher.getUsername();
                DataTemp.password = teacher.getPassword();
                DataTemp.teacherId = teacher.getId();
                new TeacherManagement();
                Hero.dispose();
            }
            else if (role == 2) {
                Student student = studentDao.login(userName, passWord);
                if (student == null) {
                    JOptionPane.showMessageDialog(contentPane, "用户名或者密码错误2！", "系统提示", JOptionPane.WARNING_MESSAGE);
                    passwordField.setText("");
                    return;
                }
                DataTemp.studentId = student.getId();
                DataTemp.studentName = student.getUsername();
                DataTemp.studentClass = student.getClassNumber();
                DataTemp.uid = student.getUsername();
                DataTemp.password = student.getPassword();
                new StudentManagement();
                Hero.dispose();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(contentPane, "登录异常！", "系统提示", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * 初始化登录窗口
     */
    private void initComponents() {
        Hero = new JFrame();
        Hometext = new JLabel();
        usertext = new JLabel();
        username = new JTextField();
        pwdtext = new JLabel();
        login = new JButton();
        passwordField = new JPasswordField();
        pwdtext2 = new JLabel();
        comboBox1 = new JComboBox();

        //======== Hero ========
        {
            Hero.setTitle("高校奖学金管理系统");
            Hero.setResizable(false);
            Hero.setBackground(new Color(0x333333));
            Hero.setForeground(SystemColor.window);
            var HeroContentPane = Hero.getContentPane();
            HeroContentPane.setLayout(null);

            //---- Hometext ----
            Hometext.setText("高校奖学金管理系统");
            Hometext.setFont(new Font("LXGW WenKai", Font.PLAIN, 30));
            Hometext.setHorizontalAlignment(SwingConstants.CENTER);
            HeroContentPane.add(Hometext);
            Hometext.setBounds(185, 25, 275, 60);

            //---- usertext ----
            usertext.setText("账号");
            usertext.setFont(new Font("LXGW WenKai", Font.PLAIN, 24));
            HeroContentPane.add(usertext);
            usertext.setBounds(140, 130, 50, 35);

            //---- username ----
            username.setFont(new Font("LXGW WenKai", Font.PLAIN, 18));
            username.setBackground(Color.white);
            HeroContentPane.add(username);
            username.setBounds(230, 125, 260, 45);

            //---- pwdtext ----
            pwdtext.setText("密码");
            pwdtext.setFont(new Font("LXGW WenKai", Font.PLAIN, 24));
            HeroContentPane.add(pwdtext);
            pwdtext.setBounds(140, 220, 50, 35);

            //---- login ----
            login.setText("登录");
            login.setFont(new Font("LXGW WenKai", Font.PLAIN, 20));
            login.addActionListener(this::login);
            HeroContentPane.add(login);
            login.setBounds(285, 395, 105, 40);

            //---- passwordField ----
            passwordField.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
            passwordField.setBackground(Color.white);
            HeroContentPane.add(passwordField);
            passwordField.setBounds(230, 215, 260, 45);

            //---- pwdtext2 ----
            pwdtext2.setText("登录身份：");
            pwdtext2.setFont(new Font("LXGW WenKai", Font.PLAIN, 24));
            HeroContentPane.add(pwdtext2);
            pwdtext2.setBounds(140, 315, 180, 35);

            //---- comboBox1 ----
            comboBox1.setFont(new Font("LXGW WenKai", Font.BOLD, 16));
            comboBox1.setModel(new DefaultComboBoxModel(new String[] {"请选择身份", "学生", "辅导员", "管理员"}));
            HeroContentPane.add(comboBox1);
            comboBox1.setBounds(285, 315, 165, 40);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < HeroContentPane.getComponentCount(); i++) {
                    Rectangle bounds = HeroContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = HeroContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                HeroContentPane.setMinimumSize(preferredSize);
                HeroContentPane.setPreferredSize(preferredSize);
            }
            Hero.setSize(675, 500);
            Hero.setLocationRelativeTo(null);
            Hero.setVisible(true);
            Hero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    private JFrame Hero;
    private JLabel Hometext;
    private JLabel usertext;
    private JTextField username;
    private JLabel pwdtext;
    private JButton login;
    private JPasswordField passwordField;
    private JLabel pwdtext2;
    private JComboBox comboBox1;
    private AdminDao adminDao = new AdminDao();
    private TeacherDao teacherDao = new TeacherDao();
    private StudentDao studentDao = new StudentDao();
    private JPanel contentPane;
}
