package com.handler;

import com.dao.UserDAO;
import com.dao.impl.UserDAOImpl;
import com.entity.User;
import com.view.LoginViewComponent.RegistrationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterHandler implements ActionListener {
    private final RegistrationView registrationView;

    public RegisterHandler(RegistrationView registrationView) {
        this.registrationView = registrationView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if (text.equals("注册")) {
            String user = registrationView.getUserText().getText();
            char[] passwordChar1 = registrationView.getPasswordText().getPassword();
            String password = new String(passwordChar1);
            char[] passwordChar2 = registrationView.getRepeatPasswordText().getPassword();
            String repeatPassword = new String(passwordChar2);
            System.out.println(user);
            System.out.println(password);
            System.out.println(repeatPassword);
            if (user.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
                JOptionPane.showMessageDialog(null, "输入不能为空");
            }
            else if (password.equals(repeatPassword)) {

                UserDAO ud = new UserDAOImpl();
                User u = new User(user, password);
                boolean a = ud.addUser(u);
                if (a) {
                    System.out.println("添加成功");
                    JOptionPane.showMessageDialog(null,"注册成功");
                } else {
                    JOptionPane.showMessageDialog(null, "用户名重复");
                }

            } else {
                JOptionPane.showMessageDialog(null, "两次密码不一致, 请重新输入");
                System.out.println("两次输入不一致");
                registrationView.getPasswordText().setText("");
                registrationView.getRepeatPasswordText().setText("");
            }

        }
    }
}
