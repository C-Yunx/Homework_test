/*
 * Created by JFormDesigner on Tue Jan 09 20:59:59 CST 2024
 */

package View;

import javax.swing.*;
import java.awt.*;

/**
 * 备用的信息显示窗口，但其实没有用到
 * @author 13425
 */
public class Message {
    public Message() {
        initComponents();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        Message = new JFrame();
        label1 = new JLabel();

        //======== Message ========
        {
            Message.setResizable(false);
            Message.setTitle("\u63d0\u793a\uff01\uff01\uff01");
            Message.setAutoRequestFocus(false);
            Message.setAlwaysOnTop(true);
            var MessageContentPane = Message.getContentPane();
            MessageContentPane.setLayout(null);

            //---- label1 ----
            label1.setText("\u767b\u5f55\u5931\u8d25\uff01");
            label1.setFont(new Font("\u971e\u9e5c\u6587\u6977", Font.BOLD, 14));
            MessageContentPane.add(label1);
            label1.setBounds(20, 5, 205, 85);

            MessageContentPane.setPreferredSize(new Dimension(190, 106));
            Message.setSize(237, 132);
            Message.setLocationRelativeTo(null);
            Message.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Message.setVisible(true);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JFrame Message;
    JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
