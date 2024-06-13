package com.view;

import com.handler.LoginHandler;
import com.util.BeautifyUI;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginView {
    JFrame jFrame;
    JLabel nameLabel = new JLabel("欢迎使用餐饮管理系统", JLabel.CENTER);
    Date date = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // 组件
    SpringLayout springLayout = new SpringLayout();
    JPanel centerPanel = new JPanel(springLayout);
    JLabel userLabel = new JLabel("用户名:");
    JTextField userText = new JTextField(20);
    JLabel pwdLabel = new JLabel("密码:");
    JPasswordField pwdText = new JPasswordField(20);
    JButton loginBtn = new JButton("登录");
    JButton resetBtn = new JButton("注册");

    LoginHandler loginHandler;

    public LoginView() {
        BeautifyUI.beautify();

        jFrame = new JFrame("登录-餐饮管理系统");
        System.out.println("此次系统使用时间：" + ft.format(date));

        // 用Container容器获取窗口
        Container contentPane = jFrame.getContentPane();

        nameLabel.setForeground(Color.RED);
        nameLabel.setFont(new Font("华文行楷", Font.PLAIN, 60));
        nameLabel.setPreferredSize(new Dimension(0, 80));

        // 设置字体
        Font centerFont = new Font("楷体", Font.PLAIN, 30);
        Font textFont = new Font("楷体", Font.PLAIN, 25);
        userLabel.setFont(centerFont);
        userText.setPreferredSize(new Dimension(200, 30));
        pwdLabel.setFont(centerFont);
        pwdText.setPreferredSize(new Dimension(200, 30));
        loginBtn.setFont(centerFont);
        resetBtn.setFont(centerFont);

        // 添加监听器
        loginHandler = new LoginHandler(this);
        loginBtn.addActionListener(loginHandler);
        resetBtn.addActionListener(loginHandler);

        // 中心块添加组件
        centerPanel.add(userLabel);
        centerPanel.add(userText);
        centerPanel.add(pwdLabel);
        centerPanel.add(pwdText);
        centerPanel.add(loginBtn);
        centerPanel.add(resetBtn);

        // 弹簧布局
        // userLabel
        Spring spaceWidth = Spring.constant(20);
        Spring childWidth = Spring.sum(Spring.sum(Spring.width(userLabel), Spring.width(userText)), spaceWidth);
        int offsetX = childWidth.getValue() / 2;
        springLayout.putConstraint(SpringLayout.WEST, userLabel, -offsetX, SpringLayout.HORIZONTAL_CENTER, centerPanel);
        // userText
        springLayout.putConstraint(SpringLayout.WEST, userText, 20, SpringLayout.EAST, userLabel);
        springLayout.putConstraint(SpringLayout.NORTH, userText, 0, SpringLayout.NORTH, userLabel);
        // pwdLabel
        springLayout.putConstraint(SpringLayout.EAST, pwdLabel, 0, SpringLayout.EAST, userLabel);
        springLayout.putConstraint(SpringLayout.NORTH, pwdLabel, 20, SpringLayout.SOUTH, userLabel);
        // pwdTxt
        springLayout.putConstraint(SpringLayout.WEST, pwdText, 20, SpringLayout.EAST, pwdLabel);
        springLayout.putConstraint(SpringLayout.NORTH, pwdText, 0, SpringLayout.NORTH, pwdLabel);
        // loginBtn
        springLayout.putConstraint(SpringLayout.NORTH, loginBtn, 50, SpringLayout.SOUTH, pwdLabel);
        springLayout.putConstraint(SpringLayout.EAST, loginBtn, 70, SpringLayout.EAST, pwdLabel);
        // resetBtn
        springLayout.putConstraint(SpringLayout.NORTH, resetBtn, 0, SpringLayout.NORTH, loginBtn);
        springLayout.putConstraint(SpringLayout.WEST, resetBtn, 40, SpringLayout.EAST, loginBtn);

        // 容器添加组件
        contentPane.add(nameLabel, BorderLayout.NORTH);
        contentPane.add(centerPanel, BorderLayout.CENTER);

        // 窗口的设置
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public JTextField getUserText() {
        return userText;
    }

    public JPasswordField getPwdText() {
        return pwdText;
    }

    public void close() {
        jFrame.dispose();
    }


    public static void main(String[] args) {
        new LoginView();
    }
}
