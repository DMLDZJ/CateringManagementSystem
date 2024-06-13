package com.dao.impl;

import com.dao.DineTableDAO;
import com.entity.DineTable;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DineTableImpl implements DineTableDAO {
    Connection conn = DBUtil.getConn();
    PreparedStatement ps = null;
    ResultSet rs = null;
    Object[][] ret = null;
    @Override
    public Object[][] findAll() {
        try {
            String sql = "SELECT * FROM dineTable";
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
    public void addTable(DineTable dt) {
        PreparedStatement ps = null;
        String sql = "insert into dinetable(dineTableId, dineNum, isEmpty, indentId) values(?, ?, ?, -1)";
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,dt.getId());
            ps.setInt(2, dt.getNum());
            ps.setString(3, "空");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
