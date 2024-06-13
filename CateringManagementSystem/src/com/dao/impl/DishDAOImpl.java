package com.dao.impl;

import com.dao.DishDAO;
import com.entity.Dishes;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DishDAOImpl implements DishDAO {
    Connection conn = DBUtil.getConn();
    PreparedStatement ps = null;
    ResultSet rs = null;
    Object[][] ret = null;
    @Override
    public Object[][] findAll() {
        try {
            String sql = "SELECT * FROM dishes";
            conn = DBUtil.getConn();
            assert conn != null;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            int cols = rs.getMetaData().getColumnCount();
            int rows = 0;

            while (rs.next()) {
                rows++;
            }

            rs.beforeFirst();


            ret = new Object[rows][cols];

            for (int i = 0; i < rows; i++) {
                rs.next();
                for (int j = 0; j < cols; j++) {
                    ret[i][j] = rs.getObject(j + 1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeRs(rs);
            DBUtil.closePs(ps);
            DBUtil.closeConn(conn);
        }
        return ret;
    }

    @Override
    public int getCost(String dishName) {
        int ret = 0;
        try {
            String sql = "select dishCost FROM dishes WHERE dishName = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dishName);
            ps.executeQuery();
            rs = ps.executeQuery();
            if (rs.next()) {
                ret = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public int getDishId(String dishName) {
        return 0;
    }

}
