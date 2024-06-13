package com.handler;

import com.dao.UserDAO;
import com.dao.impl.UserDAOImpl;
import com.entity.User;
import com.view.LoginView;
import com.view.MainView;
import com.view.LoginViewComponent.RegistrationView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginHandler implements ActionListener {
    private final LoginView loginView;
    public LoginHandler(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if (text.equals("登录")) {
            login();
        } else if (text.equals("注册")){
            new RegistrationView();
        }
    }


    private void login() {
        String user = loginView.getUserText().getText();
        char[] passwordChars = loginView.getPwdText().getPassword();
        String password = new String(passwordChars);

        System.out.println(user);
        System.out.println(password);

        User u = new User(user, password);
        UserDAO ud = new UserDAOImpl();
        if (ud.haveUser(u)) {
            loginView.close();
            new MainView();
        } else {
            System.out.println("查无此人");
        }
    }

}
