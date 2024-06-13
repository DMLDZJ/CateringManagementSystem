package com.view.MainViewComponent.DineTableView;

import com.util.BeautifyUI;
import com.util.DBUtil;
import com.view.MainViewComponent.StaffView.QueryStaffView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryDineTableView {
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
    public QueryDineTableView() {
        BeautifyUI.beautify();
        jFrame = new JFrame("查询");

        container = jFrame.getContentPane();
        container.setLayout(new BorderLayout());
        // 北方块组件
        nameLabel = new JLabel("请输入餐桌号", JLabel.CENTER);
        nameLabel.setFont(new Font("华文行楷", Font.PLAIN, 50));

        // 中间块组件
        centerPanel = new JPanel(null);
        Font centerFont = new Font("楷体", Font.PLAIN, 30);
        // 工号
        idLabel = new JLabel("餐桌号：");
        idLabel.setFont(centerFont);
        idLabel.setBounds(100,0,300,50);
        idText = new JTextField(20);
        idText.setBounds(250,10,200,30);
        // 请输入查询后的信息
        JLabel jLabel = new JLabel("餐桌信息：");
        jLabel.setFont(centerFont);
        jLabel.setBounds(100, 50, 300, 50);
        // 姓名
        userNameLabel = new JLabel("用餐人数：");
        userNameLabel.setFont(centerFont);
        userNameLabel.setBounds(100, 100, 300, 50);
        userNameText = new JTextField(20);
        userNameText.setBounds(250, 110, 200, 30);
        // 年龄
        ageLabel = new JLabel("状态：");
        ageLabel.setFont(centerFont);
        ageLabel.setBounds(100, 150, 300, 50);
        ageText = new JTextField(20);
        ageText.setBounds(250, 160, 200, 30);
        // 修改
        JButton updateButton = new JButton("查询");
        updateButton.setFont(centerFont);
        updateButton.setBounds(200, 260, 200, 50);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idText.getText());
                Connection conn = DBUtil.getConn();
                try {
                    String sql = "SELECT * FROM DineTable WHERE dineTableId = ?";
                    assert conn != null;
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();

                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "未找到该员工");

                    } else {
                        userNameText.setText(rs.getString(2));
                        ageText.setText(rs.getString(3));
                    }
                    DBUtil.closeRs(rs);
                    DBUtil.closePs(ps);
                    DBUtil.closeConn(conn);
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
        new QueryDineTableView();
    }
}
