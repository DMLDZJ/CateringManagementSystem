package com.view.MainViewComponent.StaffView;

import com.util.BeautifyUI;
import com.util.DBUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DelStaffView {
    public DelStaffView() {
        BeautifyUI.beautify();
        JLabel nameLabel = new JLabel("删除员工", JLabel.CENTER);
        nameLabel.setFont(new Font("华文行楷", Font.PLAIN, 50));
        JFrame jFrame = new JFrame("删除界面");
        Container container = jFrame.getContentPane();
        container.setLayout(new BorderLayout());

        container.add(nameLabel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(null);
        JLabel delLabel = new JLabel("工号：");
        JTextField delText = new JTextField(20);
        JButton delButton = new JButton("删除");

        delLabel.setFont(new Font("楷体", Font.PLAIN, 30));
        delLabel.setBounds(100, 0, 300, 50);
        delText.setBounds(200, 15, 300, 30);
        delButton.setBounds(200, 60, 200, 50);

        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn = DBUtil.getConn();
                int id = Integer.parseInt(delText.getText());
                String sql = "DELETE FROM staff WHERE id = ?";
                try {
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, id);
                    int num = ps.executeUpdate();
                    if (num > 0) {
                        JOptionPane.showMessageDialog(null, "删除成功");
                        jFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "未找到该员工");
                    }

                    System.out.println("共有" + num + "条数据被删除");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        centerPanel.add(delLabel);
        centerPanel.add(delText);
        centerPanel.add(delButton);
        container.add(centerPanel);

        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(600, 500);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new DelStaffView();
    }
}
