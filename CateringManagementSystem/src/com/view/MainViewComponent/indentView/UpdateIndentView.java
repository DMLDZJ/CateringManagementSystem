package com.view.MainViewComponent.indentView;

import com.util.BeautifyUI;
import com.util.DBUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateIndentView {
    public UpdateIndentView() {
        BeautifyUI.beautify();
        JLabel nameLabel = new JLabel("结账", JLabel.CENTER);
        nameLabel.setFont(new Font("华文行楷", Font.PLAIN, 50));
        JFrame jFrame = new JFrame("结账");
        Container container = jFrame.getContentPane();
        container.setLayout(new BorderLayout());

        container.add(nameLabel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(null);
        JLabel delLabel = new JLabel("订单号：");
        JTextField delText = new JTextField(20);
        JButton delButton = new JButton("结账");

        delLabel.setFont(new Font("楷体", Font.PLAIN, 30));
        delLabel.setBounds(100, 0, 300, 50);
        delText.setBounds(200, 15, 300, 30);
        delButton.setBounds(200, 60, 200, 50);

        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn = DBUtil.getConn();
                int id = Integer.parseInt(delText.getText());
                String sql = "Update indent set status = '已完成' WHERE indentId = ?";
                String sql1 = "Update dineTable set isEmpty = '空' WHERE dineTableId = (Select dineTableId FROM indent WHERE indentId = ?)";
                try {
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, id);
                    int num = ps.executeUpdate();
                    ps = conn.prepareStatement(sql1);
                    ps.setInt(1,id);
                    ps.executeUpdate();
                    if (num > 0) {
                        JOptionPane.showMessageDialog(null, "已完成");
                        jFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "未找到该订单");
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
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
}
