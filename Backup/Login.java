/*
 * Created by JFormDesigner on Tue Jan 09 17:30:36 CST 2024
 */

package Backup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author 13425
 */
public class Login {
    public Login() {
        initComponents();
    }

    private void login(ActionEvent e) {
        // TODO add your code here
    }

    private void comboBox1(ActionEvent e) {
        // TODO add your code here
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
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
            Hero.setTitle("\u9ad8\u6821\u5956\u5b66\u91d1\u7ba1\u7406\u7cfb\u7edf");
            Hero.setResizable(false);
            Hero.setBackground(new Color(0x333333));
            Hero.setForeground(SystemColor.window);
            var HeroContentPane = Hero.getContentPane();
            HeroContentPane.setLayout(null);

            //---- Hometext ----
            Hometext.setText("\u9ad8\u6821\u5956\u5b66\u91d1\u7ba1\u7406\u7cfb\u7edf");
            Hometext.setFont(new Font("LXGW WenKai", Font.PLAIN, 30));
            Hometext.setHorizontalAlignment(SwingConstants.CENTER);
            HeroContentPane.add(Hometext);
            Hometext.setBounds(185, 25, 275, 60);

            //---- usertext ----
            usertext.setText("\u8d26\u53f7");
            usertext.setFont(new Font("LXGW WenKai", Font.PLAIN, 24));
            HeroContentPane.add(usertext);
            usertext.setBounds(140, 130, 50, 35);

            //---- username ----
            username.setFont(new Font("LXGW WenKai", Font.PLAIN, 18));
            username.setBackground(Color.white);
            HeroContentPane.add(username);
            username.setBounds(230, 125, 260, 45);

            //---- pwdtext ----
            pwdtext.setText("\u5bc6\u7801");
            pwdtext.setFont(new Font("LXGW WenKai", Font.PLAIN, 24));
            HeroContentPane.add(pwdtext);
            pwdtext.setBounds(140, 220, 50, 35);

            //---- login ----
            login.setText("\u767b\u5f55");
            login.setFont(new Font("LXGW WenKai", Font.PLAIN, 20));
            login.addActionListener(e -> login(e));
            HeroContentPane.add(login);
            login.setBounds(285, 395, 105, 40);

            //---- passwordField ----
            passwordField.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
            passwordField.setBackground(Color.white);
            HeroContentPane.add(passwordField);
            passwordField.setBounds(230, 215, 260, 45);

            //---- pwdtext2 ----
            pwdtext2.setText("\u767b\u5f55\u8eab\u4efd\uff1a");
            pwdtext2.setFont(new Font("LXGW WenKai", Font.PLAIN, 24));
            HeroContentPane.add(pwdtext2);
            pwdtext2.setBounds(140, 315, 180, 35);

            //---- comboBox1 ----
            comboBox1.setFont(new Font("LXGW WenKai", Font.BOLD, 16));
            comboBox1.addActionListener(e -> comboBox1(e));
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
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JFrame Hero;
    private JLabel Hometext;
    private JLabel usertext;
    private JTextField username;
    private JLabel pwdtext;
    private JButton login;
    private JPasswordField passwordField;
    private JLabel pwdtext2;
    private JComboBox comboBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
