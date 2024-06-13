package com.dao.impl;

import com.dao.DishDAO;
import com.dao.IndentDAO;
import com.entity.Indent;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IndentDAOImpl implements IndentDAO {
    Connection conn = DBUtil.getConn();
    PreparedStatement ps = null;
    ResultSet rs = null;
    Object[][] ret = null;
    @Override
    public Object[][] findAll() {
        try {
            String sql = "SELECT * FROM indent";
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
    public void addIndent(Indent indent) {
        String sql = "insert into indent(indentCost, dineTableId, dishName, status) values(?, ?, ?, '用餐中')";

        try {
            ps = conn.prepareStatement(sql);
//            ps.setInt(1, indent.getIndentId());
            ps.setInt(1, indent.getIndentCost());
            ps.setInt(2, indent.getDineTableId());
            ps.setString(3, indent.getDishName());
            int num = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
