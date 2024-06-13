package com.handler;

import com.view.MainViewComponent.DineTableView.AddDineTableView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableManagementHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        switch (text) {
            case "新增餐台":
                new AddDineTableView();
                break;
            case "删除餐台":
                System.out.println("删除餐台");
                break;
            case "修改信息":

                break;
            case "查询":

                break;
        }
    }
}
