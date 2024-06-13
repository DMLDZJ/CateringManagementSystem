package com.view.MainViewComponent.dishView;

import com.dao.DineTableDAO;
import com.dao.impl.DineTableImpl;
import com.entity.DineTable;
import com.util.BeautifyUI;
import com.util.DBUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddDishView {
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

    JButton addButton = null;
    public AddDishView() {
        BeautifyUI.beautify();
        jFrame = new JFrame("新增菜品");

        container = jFrame.getContentPane();
        container.setLayout(new BorderLayout());
        // 北方块组件
        nameLabel = new JLabel("新增菜品", JLabel.CENTER);
        nameLabel.setFont(new Font("华文行楷", Font.PLAIN, 50));

        // 中间块组件
        centerPanel = new JPanel(null);
        // 姓名
        userNameLabel = new JLabel("菜品号：");
        userNameLabel.setFont(new Font("楷体", Font.PLAIN, 30));
        userNameLabel.setBounds(100, 0, 300, 50);
        userNameText = new JTextField(20);
        userNameText.setBounds(250, 10, 200, 30);
        // 年龄
        ageLabel = new JLabel("菜品名：");
        ageLabel.setFont(new Font("楷体", Font.PLAIN, 30));
        ageLabel.setBounds(100, 50, 300, 50);
        ageText = new JTextField(20);
        ageText.setBounds(250, 60, 200, 30);
        // 职位
        positionLabel = new JLabel("收费：");
        positionLabel.setFont(new Font("楷体", Font.PLAIN, 30));
        positionLabel.setBounds(100, 100, 300, 50);
        positionText = new JTextField(20);
        positionText.setBounds(250, 110, 200, 30);
        // 新增按钮
        addButton = new JButton("添加");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(userNameText.getText());
                int num = Integer.parseInt(positionText.getText());
                String dishName = ageText.getText();
                Connection conn = DBUtil.getConn();
                try {
                    String sql = "insert into dishes(dishId, dishName, dishCost) values(?, ?, ?)";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1,id);
                    ps.setString(2, dishName);
                    ps.setInt(3, num);
                    ps.executeUpdate();
                    DBUtil.closePs(ps);
                    DBUtil.closeConn(conn);
                    JOptionPane.showMessageDialog(null, "添加成功");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
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
        centerPanel.add(addButton);

        container.add(nameLabel, BorderLayout.NORTH);
        container.add(centerPanel, BorderLayout.CENTER);

        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(600, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
