package com.view.MainViewComponent.StaffView;

import com.dao.StaffDAO;
import com.dao.impl.StaffDAOImpl;
import com.entity.Staff;
import com.util.BeautifyUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addStaffView {
    JFrame jFrame = null;
    Container container = null;
    JLabel nameLabel = null;

    JPanel centerPanel = null;
    JLabel userNameLabel = null;
    JTextField userNameText = null;
    JLabel ageLabel = null;
    JTextField ageText = null;
    JLabel positionLabel = null;
    JTextField positionText = null;
    JLabel idLabel = null;
    JTextField idText = null;

    JButton addButton = null;
    public addStaffView() {
        BeautifyUI.beautify();
        jFrame = new JFrame("新增员工");

        container = jFrame.getContentPane();
        container.setLayout(new BorderLayout());
        // 北方块组件
        nameLabel = new JLabel("新增员工", JLabel.CENTER);
        nameLabel.setFont(new Font("华文行楷", Font.PLAIN, 50));

        // 中间块组件
        centerPanel = new JPanel(null);
        // 姓名
        userNameLabel = new JLabel("员工名：");
        userNameLabel.setFont(new Font("楷体", Font.PLAIN, 30));
        userNameLabel.setBounds(100, 0, 300, 50);
        userNameText = new JTextField(20);
        userNameText.setBounds(250, 10, 200, 30);
        // 年龄
        ageLabel = new JLabel("年龄：");
        ageLabel.setFont(new Font("楷体", Font.PLAIN, 30));
        ageLabel.setBounds(100, 50, 300, 50);
        ageText = new JTextField(20);
        ageText.setBounds(250, 60, 200, 30);
        // 职位
        positionLabel = new JLabel("职位：");
        positionLabel.setFont(new Font("楷体", Font.PLAIN, 30));
        positionLabel.setBounds(100, 100, 300, 50);
        positionText = new JTextField(20);
        positionText.setBounds(250, 110, 200, 30);
        // id
        idLabel = new JLabel("工号：");
        idLabel.setFont(new Font("楷体", Font.PLAIN, 30));
        idLabel.setBounds(100, 150, 300, 50);
        idText = new JTextField(20);
        idText.setBounds(250, 160, 200, 30);
        // 新增按钮
        addButton = new JButton("添加职工");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = userNameText.getText();
                int age = Integer.parseInt(ageText.getText());
                String position = positionText.getText();
                int id = Integer.parseInt(idText.getText());

                Staff staff = new Staff(id, name, age, position);
                StaffDAO sd = new StaffDAOImpl();
                sd.addStaff(staff);
                jFrame.dispose();

            }
        });
        addButton.setBounds(200, 210, 200, 50);

        centerPanel.add(userNameLabel);
        centerPanel.add(userNameText);
        centerPanel.add(ageLabel);
        centerPanel.add(ageText);
        centerPanel.add(positionLabel);
        centerPanel.add(positionText);
        centerPanel.add(idLabel);
        centerPanel.add(idText);
        centerPanel.add(addButton);

        container.add(nameLabel, BorderLayout.NORTH);
        container.add(centerPanel, BorderLayout.CENTER);

        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(600, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }


    public static void main(String[] args) {
        new addStaffView();
    }
}
