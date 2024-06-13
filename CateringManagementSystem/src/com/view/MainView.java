package com.view;

import com.dao.DineTableDAO;
import com.dao.DishDAO;
import com.dao.IndentDAO;
import com.dao.StaffDAO;
import com.dao.impl.*;
import com.util.BeautifyUI;
import com.view.MainViewComponent.DineTableView.AddDineTableView;
import com.view.MainViewComponent.DineTableView.DelDineTableView;
import com.view.MainViewComponent.DineTableView.QueryDineTableView;
import com.view.MainViewComponent.StaffView.DelStaffView;
import com.view.MainViewComponent.StaffView.QueryStaffView;
import com.view.MainViewComponent.StaffView.UpdateStaffView;
import com.view.MainViewComponent.StaffView.addStaffView;
import com.view.MainViewComponent.dishView.AddDishView;
import com.view.MainViewComponent.dishView.DelDishView;
import com.view.MainViewComponent.indentView.AddIndentView;
import com.view.MainViewComponent.indentView.DelIndentView;
import com.view.MainViewComponent.indentView.UpdateIndentView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView {
    JFrame jFrame = new JFrame("主界面");
    JLabel nameLabel = new JLabel("欢迎使用餐饮管理系统", JLabel.CENTER);

    private ActionListener staffAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton jButton = (JButton) e.getSource();
                String text = jButton.getText();
                switch (text) {
                    case "新增员工":
                        new addStaffView();
                        break;
                    case "删除员工":
                        new DelStaffView();
                        break;
                    case "修改信息":
                        new UpdateStaffView();
                        break;
                    case "查询信息":
                        new QueryStaffView();
                        break;
                    case "刷新":
                        new MainView();
                        jFrame.dispose();
                        break;
                }
            }
        };
    }
    private JPanel staffManagement() {

        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        // 创建表格数据
        String[] columnNames = {"Id", "Name", "Age", "Position"};
        StaffDAO sd = new StaffDAOImpl();
        Object[][] data = sd.findAll();
        // 创建表格模型
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        // 创建表格
        JTable table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("楷体", Font.PLAIN, 30));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // 将表格放入滚动窗格
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 1000, 600);
        // 按钮功能
        JButton addButton = new JButton("新增员工");
        addButton.setBounds(1000, 0, 200, 50);

        JButton delButton = new JButton("删除员工");
        delButton.setBounds(1000, 50, 200, 50);

        JButton updateButton = new JButton("修改信息" );
        updateButton.setBounds(1000, 100, 200, 50);

        JButton queryButton = new JButton("查询信息");
        queryButton.setBounds(1000, 150, 200, 50);

        JButton reset = new JButton("刷新");
        reset.setBounds(1000, 200, 200, 50);
        // 添加监听
        addButton.addActionListener(staffAction());
        delButton.addActionListener(staffAction());
        updateButton.addActionListener(staffAction());
        queryButton.addActionListener(staffAction());
        reset.addActionListener(staffAction());

        jPanel.add(addButton);
        jPanel.add(delButton);
        jPanel.add(updateButton);
        jPanel.add(queryButton);
        jPanel.add(reset);

        jPanel.add(scrollPane);

        return jPanel;
    }
    private ActionListener tableManagementAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton jButton = (JButton) e.getSource();
                String text = jButton.getText();
                switch (text) {
                    case "新增餐台":
                        new AddDineTableView();
                        break;
                    case "删除餐台":
                        new DelDineTableView();
                        break;
                    case "查询":
                        new QueryDineTableView();
                        break;
                    case "刷新":
                        new MainView();
                        jFrame.dispose();
                        break;
                }
            }
        };
    }

    // 餐桌界面
    private JPanel tableManagement() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        // 创建表格数据
        String[] columnNames = {"Id", "num", "status"};
        DineTableDAO dtd = new DineTableImpl();
        Object[][] data = dtd.findAll();
        // 创建表格模型
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        // 创建表格
        JTable table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("楷体", Font.PLAIN, 30));
        // 将表格放入滚动窗格
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 1000, 600);
        // 按钮功能
        JButton addButton = new JButton("新增餐台");
        addButton.setBounds(1000, 0, 200, 50);

        JButton delButton = new JButton("删除餐台");
        delButton.setBounds(1000, 50, 200, 50);

        JButton updateButton = new JButton("修改信息" );
        updateButton.setBounds(1000, 100, 200, 50);

        JButton queryButton = new JButton("查询");
        queryButton.setBounds(1000, 150, 200, 50);
        JButton reset = new JButton("刷新");
        reset.setBounds(1000, 200, 200, 50);
        // 添加监听
        addButton.addActionListener(tableManagementAction());
        delButton.addActionListener(tableManagementAction());
        updateButton.addActionListener(tableManagementAction());
        queryButton.addActionListener(tableManagementAction());
        reset.addActionListener(tableManagementAction());

        jPanel.add(addButton);
        jPanel.add(delButton);
//        jPanel.add(updateButton);
        jPanel.add(queryButton);
        jPanel.add(reset);
        jPanel.add(scrollPane);

        return jPanel;
    }

    // 订单操作
    private ActionListener indentManagementAction() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton jButton = (JButton) e.getSource();
                String text = jButton.getText();
                switch (text) {
                    case "新增订单":
                        new AddIndentView();
                        break;
                    case "删除订单":
                        new DelIndentView();
                        break;
                    case "结账":
                        new UpdateIndentView();
                        break;
                    case "查询":
                        new QueryDineTableView();
                        break;
                    case "刷新":
                        new MainView();
                        jFrame.dispose();
                        break;
                }
            }
        };
    }

    private JPanel indent() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        // 创建表格数据
        String[] columnNames = {"indentId", "indentCost", "dineTable", "dishName", "status"};
        IndentDAO idd = new IndentDAOImpl();
        Object[][] data = idd.findAll();
        // 创建表格模型
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        // 创建表格
        JTable table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("楷体", Font.PLAIN, 30));
        // 将表格放入滚动窗格
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 1000, 600);
        // 按钮功能
        JButton addButton = new JButton("新增订单");
        addButton.setBounds(1000, 0, 200, 50);

        JButton delButton = new JButton("删除订单");
        delButton.setBounds(1000, 50, 200, 50);

        JButton updateButton = new JButton("结账" );
        updateButton.setBounds(1000, 100, 200, 50);

        JButton queryButton = new JButton("查询");
        queryButton.setBounds(1000, 150, 200, 50);
        JButton reset = new JButton("刷新");
        reset.setBounds(1000, 200, 200, 50);
        // 添加监听
        addButton.addActionListener(indentManagementAction());
        delButton.addActionListener(indentManagementAction());
        updateButton.addActionListener(indentManagementAction());
        queryButton.addActionListener(indentManagementAction());
        reset.addActionListener(indentManagementAction());

        jPanel.add(addButton);
        jPanel.add(delButton);
        jPanel.add(updateButton);
        jPanel.add(queryButton);
        jPanel.add(reset);
        jPanel.add(scrollPane);

        return jPanel;
    }


    private JPanel indentDetail() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        // 创建表格数据
        String[] columnNames = {"indentDetailId", "indentId", "Cost", "dineTableId", "dishName"};
        IndentDetailDAOImpl iddi = new IndentDetailDAOImpl();
        Object[][] data = iddi.findAll();
        // 创建表格模型
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        // 创建表格
        JTable table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("楷体", Font.PLAIN, 30));
        // 将表格放入滚动窗格
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 1000, 600);
        // 按钮功能
        JButton addButton = new JButton("新增订单");
        addButton.setBounds(1000, 0, 200, 50);

        JButton delButton = new JButton("删除订单");
        delButton.setBounds(1000, 50, 200, 50);

        JButton updateButton = new JButton("修改信息" );
        updateButton.setBounds(1000, 100, 200, 50);

        JButton queryButton = new JButton("查询");
        queryButton.setBounds(1000, 150, 200, 50);
        JButton reset = new JButton("刷新");
        reset.setBounds(1000, 200, 200, 50);
        // 添加监听
        addButton.addActionListener(indentManagementAction());
        delButton.addActionListener(indentManagementAction());
        updateButton.addActionListener(indentManagementAction());
        queryButton.addActionListener(indentManagementAction());
        reset.addActionListener(indentManagementAction());

        jPanel.add(addButton);
        jPanel.add(delButton);
        jPanel.add(updateButton);
        jPanel.add(queryButton);
        jPanel.add(reset);
        jPanel.add(scrollPane);

        return jPanel;
    }

    private ActionListener dishesAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton jButton = (JButton) e.getSource();
                String text = jButton.getText();
                switch (text) {
                    case "新增菜品":
                        new AddDishView();
                        break;
                    case "删除菜品":
                        new DelDishView();
                        break;
                }
            }
        };
    }


    private JPanel dishes() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        // 创建表格数据
        String[] columnNames = {"dishId", "dishName", "indentCost"};
        DishDAO dd = new DishDAOImpl();
        Object[][] data = dd.findAll();
        // 创建表格模型
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        // 创建表格
        JTable table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("楷体", Font.PLAIN, 30));
        // 将表格放入滚动窗格
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 1000, 600);
        // 按钮功能
        JButton addButton = new JButton("新增菜品");
        addButton.setBounds(1000, 0, 200, 50);

        JButton delButton = new JButton("删除菜品");
        delButton.setBounds(1000, 50, 200, 50);

        JButton updateButton = new JButton("修改信息" );
        updateButton.setBounds(1000, 100, 200, 50);

        JButton queryButton = new JButton("查询");
        queryButton.setBounds(1000, 150, 200, 50);
        JButton reset = new JButton("刷新");
        reset.setBounds(1000, 200, 200, 50);
        // 添加监听
        addButton.addActionListener(dishesAction());
        delButton.addActionListener(dishesAction());
        updateButton.addActionListener(dishesAction());
        queryButton.addActionListener(dishesAction());
        reset.addActionListener(indentManagementAction());

        jPanel.add(addButton);
        jPanel.add(delButton);
        jPanel.add(updateButton);
        jPanel.add(queryButton);
        jPanel.add(reset);
        jPanel.add(scrollPane);

        return jPanel;
    }


    public MainView() {
        BeautifyUI.beautify();
        Container contentPane = jFrame.getContentPane();

        nameLabel.setForeground(Color.RED);
        nameLabel.setFont(new Font("华文行楷", Font.PLAIN, 60));
        nameLabel.setPreferredSize(new Dimension(0, 60));

        // 标签栏
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null);
        JTabbedPane pane = new JTabbedPane(SwingConstants.TOP);
        pane.setFont(new Font("华文行楷", Font.PLAIN, 30));
        pane.setBounds(0, 0, 1200, 700);
        pane.addTab("员工管理", staffManagement());
        pane.addTab("餐台管理", tableManagement());
        pane.addTab("订单", indent());
        pane.addTab("顾客", new JPanel(){{setBackground(Color.GREEN);}});
//        pane.addTab("订单详情", indentDetail());
        pane.addTab("菜单", dishes());
        centerPanel.add(pane);
        contentPane.add(centerPanel, BorderLayout.CENTER);
        contentPane.add(nameLabel, BorderLayout.NORTH);

        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(1200, 800);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainView();
    }
}
