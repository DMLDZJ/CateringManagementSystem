package com.view.MainViewComponent.StaffView;

import com.dao.StaffDAO;
import com.dao.impl.StaffDAOImpl;
import com.entity.Staff;
import com.util.BeautifyUI;
import com.util.DBUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStaffView {
    JFrame jFrame = null;
    Container container = null;
    JLabel nameLabel = null;

    JPanel centerPanel = null;
    JLabel idLabel = null;
    JTextField idText = null;
    JLabel userNameLabel = null;
    JTextField userNameText = null;
    JLabel ageLabel = null;
    JTextField ageText = null;
    JLabel positionLabel = null;
    JTextField positionText = null;


    JButton addButton = null;
    public UpdateStaffView() {
        BeautifyUI.beautify();
        jFrame = new JFrame("修改信息");

        container = jFrame.getContentPane();
        container.setLayout(new BorderLayout());
        // 北方块组件
        nameLabel = new JLabel("修改员工信息", JLabel.CENTER);
        nameLabel.setFont(new Font("华文行楷", Font.PLAIN, 50));

        // 中间块组件
        centerPanel = new JPanel(null);
        Font centerFont = new Font("楷体", Font.PLAIN, 30);
        // 工号
        idLabel = new JLabel("工号：");
        idLabel.setFont(centerFont);
        idLabel.setBounds(100,0,300,50);
        idText = new JTextField(20);
        idText.setBounds(250,10,200,30);
        // 请输入修改后的信息
        JLabel jLabel = new JLabel("请输入修改后的信息：");
        jLabel.setFont(centerFont);
        jLabel.setBounds(100, 50, 300, 50);
        // 姓名
        userNameLabel = new JLabel("姓名：");
        userNameLabel.setFont(centerFont);
        userNameLabel.setBounds(100, 100, 300, 50);
        userNameText = new JTextField(20);
        userNameText.setBounds(250, 110, 200, 30);
        // 年龄
        ageLabel = new JLabel("年龄：");
        ageLabel.setFont(centerFont);
        ageLabel.setBounds(100, 150, 300, 50);
        ageText = new JTextField(20);
        ageText.setBounds(250, 160, 200, 30);
        // 职位
        positionLabel = new JLabel("职位：");
        positionLabel.setFont(centerFont);
        positionLabel.setBounds(100, 210, 300, 50);
        positionText = new JTextField(20);
        positionText.setBounds(250, 210, 200, 30);
        // 修改
        JButton updateButton = new JButton("修改");
        updateButton.setFont(centerFont);
        updateButton.setBounds(200, 260, 200, 50);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = userNameText.getText();
                int age = Integer.parseInt(ageText.getText());
                String position = positionText.getText();
                int id = Integer.parseInt(idText.getText());
                Connection conn = DBUtil.getConn();
                try {
                    String sql = "UPDATE staff set name = ?, age = ?, position = ? WHERE id = ?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, name);
                    ps.setInt(2, age);
                    ps.setString(3, position);
                    ps.setInt(4, id);
                    int num = ps.executeUpdate();
                    if (num == 0) {
                        JOptionPane.showMessageDialog(null, "未找到该员工");
                    } else {
                        JOptionPane.showMessageDialog(null, "修改成功");
                    }
                    jFrame.dispose();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        centerPanel.add(idLabel);
        centerPanel.add(idText);
        centerPanel.add(jLabel);
        centerPanel.add(userNameLabel);
        centerPanel.add(userNameText);
        centerPanel.add(ageLabel);
        centerPanel.add(ageText);
        centerPanel.add(positionLabel);
        centerPanel.add(positionText);
        centerPanel.add(updateButton);

        container.add(nameLabel, BorderLayout.NORTH);
        container.add(centerPanel, BorderLayout.CENTER);

        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(600, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateStaffView();
    }
}
