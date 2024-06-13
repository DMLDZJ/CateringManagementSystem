package com.view.MainViewComponent.indentView;

import com.dao.DishDAO;
import com.dao.IndentDAO;
import com.dao.StaffDAO;
import com.dao.impl.DishDAOImpl;
import com.dao.impl.IndentDAOImpl;
import com.dao.impl.StaffDAOImpl;
import com.entity.Indent;
import com.entity.Staff;
import com.util.BeautifyUI;
import com.util.DBUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddIndentView {
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
    public AddIndentView() {
        BeautifyUI.beautify();
        jFrame = new JFrame("新增订单");

        container = jFrame.getContentPane();
        container.setLayout(new BorderLayout());
        // 北方块组件
        nameLabel = new JLabel("新增订单", JLabel.CENTER);
        nameLabel.setFont(new Font("华文行楷", Font.PLAIN, 50));

        // 中间块组件
        centerPanel = new JPanel(null);
        // 姓名
        userNameLabel = new JLabel("订单号：");
        userNameLabel.setFont(new Font("楷体", Font.PLAIN, 30));
        userNameLabel.setBounds(100, 0, 300, 50);
        userNameText = new JTextField(20);
        userNameText.setBounds(250, 10, 200, 30);
        // 年龄
        ageLabel = new JLabel("餐桌号：");
        ageLabel.setFont(new Font("楷体", Font.PLAIN, 30));
        ageLabel.setBounds(100, 50, 300, 50);
        ageText = new JTextField(20);
        ageText.setBounds(250, 60, 200, 30);
        // 职位
        positionLabel = new JLabel("详细订单号：");
        positionLabel.setFont(new Font("楷体", Font.PLAIN, 30));
        positionLabel.setBounds(100, 100, 300, 50);
        positionText = new JTextField(20);
        positionText.setBounds(250, 110, 200, 30);

        // id
        idLabel = new JLabel("总消费：");
        idLabel.setFont(new Font("楷体", Font.PLAIN, 30));
        idLabel.setBounds(100, 150, 300, 50);

        JComboBox<String> comboBox = new JComboBox<>();
        DishDAO dd = new DishDAOImpl();
        Object[][] dishes = dd.findAll();
        for (Object[] dish : dishes) {
            comboBox.addItem((String) dish[1]);
        }
        comboBox.setBounds(150, 150, 300, 40);
        idText = new JTextField(20);
        idText.setBounds(250, 160, 200, 30);
        // 新增按钮
        addButton = new JButton("添加");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                int id = Integer.parseInt(userNameText.getText());
                int tableId = Integer.parseInt(ageText.getText());
//                int num = Integer.parseInt(positionText.getText());
                String d = (String) comboBox.getSelectedItem();
                DishDAO dd = new DishDAOImpl();
                int cost = dd.getCost(d);
                Indent indent = new Indent(cost, tableId, d);
                IndentDAO iDAO = new IndentDAOImpl();
                System.out.println(cost);

                Connection conn = DBUtil.getConn();
                try {

                    String sql1 = "SELECT * FROM dineTable WHERE dineTableId = ? and isEmpty = '空'";
                    assert conn != null;
                    PreparedStatement ps = conn.prepareStatement(sql1);
                    ps.setInt(1, tableId);
                    ResultSet num = ps.executeQuery();
                    if (num.next()) {
                        iDAO.addIndent(indent);
                        System.out.println("进入了这里");
                        String sql = "update dineTable set isEmpty = '在使用' where dineTableId = ? and isEmpty = '空'";
                        PreparedStatement ps1 = conn.prepareStatement(sql);

                        ps1.setInt(1, tableId);
                        ps1.executeUpdate();
                        JOptionPane.showMessageDialog(null, "添加成功");
                    } else {
                        JOptionPane.showMessageDialog(null, "未找到此餐桌或已被使用");

                        DBUtil.closePs(ps);
                        DBUtil.closeConn(conn);
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                jFrame.dispose();
            }
        });
        addButton.setBounds(200, 210, 200, 50);

//        centerPanel.add(userNameLabel);
//        centerPanel.add(userNameText);
        centerPanel.add(ageLabel);
        centerPanel.add(ageText);
//        centerPanel.add(positionLabel);
//        centerPanel.add(positionText);
//        centerPanel.add(idLabel);
//        centerPanel.add(jButton);
        centerPanel.add(comboBox);
//        centerPanel.add(idText);
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
        new AddIndentView();
    }
}
