package com.view.LoginViewComponent;

import com.handler.RegisterHandler;

import javax.swing.*;
import java.awt.*;

public class RegistrationView {
    JLabel explain;
    JLabel userLabel;
    JTextField userText;
    JLabel passwordLabel;
    JPasswordField passwordText;
    JLabel repeatPasswordLabel;
    JPasswordField repeatPasswordText;
    JButton register;

    RegisterHandler registerHandler;

    public RegistrationView() {
        JFrame jFrame = new JFrame("注册账户");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // 窗口容器
        Container contentpane = jFrame.getContentPane();
        contentpane.setLayout(new BorderLayout());

        // 北方组件
        explain = new JLabel("注册", JLabel.CENTER);
        explain.setFont(new Font("华文行楷", Font.PLAIN, 50));
        contentpane.add(explain, BorderLayout.NORTH);

        // 中间组件
        Font centerFont = new Font("楷体", Font.PLAIN, 20);
        JPanel centerPane = new JPanel();
        centerPane.setLayout(null);
        // 用户名
        userLabel = new JLabel("用户名：");
        userText = new JTextField(20);
        userLabel.setFont(centerFont);
        userText.setFont(centerFont);
        userLabel.setBounds(80, 0, 120, 40);
        userText.setBounds(200, 5, 200, 30);
        // 密码
        passwordLabel = new JLabel("密码：");
        passwordText = new JPasswordField(20);
        passwordLabel.setFont(centerFont);
        passwordLabel.setBounds(80, 60, 120, 40);
        passwordText.setBounds(200, 60, 200, 30);
        // 重复密码
        repeatPasswordLabel = new JLabel("重复密码：");
        repeatPasswordText = new JPasswordField(20);
        repeatPasswordLabel.setFont(centerFont);
        repeatPasswordLabel.setBounds(80, 120, 120, 40);
        repeatPasswordText.setBounds(200, 120, 200, 30);
        // 注册
        register = new JButton("注册");
        register.setFont(centerFont);
        register.setBounds(200, 180, 80, 40);

        // 添加监听器
        registerHandler = new RegisterHandler(this);
        register.addActionListener(registerHandler);

        centerPane.add(userLabel);
        centerPane.add(userText);
        centerPane.add(passwordLabel);
        centerPane.add(passwordText);
        centerPane.add(repeatPasswordLabel);
        centerPane.add(repeatPasswordText);
        centerPane.add(register);
        contentpane.add(centerPane, BorderLayout.CENTER);



        jFrame.setSize(500, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public JTextField getUserText() {
        return userText;
    }



    public JPasswordField getPasswordText() {
        return passwordText;
    }



    public JPasswordField getRepeatPasswordText() {
        return repeatPasswordText;
    }



    public static void main(String[] args) {
        new RegistrationView();
    }

}
