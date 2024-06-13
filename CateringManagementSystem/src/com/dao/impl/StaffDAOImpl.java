package com.dao.impl;

import com.dao.StaffDAO;
import com.entity.Staff;
import com.util.DBUtil;

import java.sql.*;
import java.util.Date;

public class StaffDAOImpl implements StaffDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Object[][] ret = null;
    @Override
    public Object[][] findAll() {
        try {
            String sql = "SELECT * FROM staff";
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
    public void addStaff(Staff staff) {
        try {

            String sql = "insert into staff(id, name, age, position) values(?, ?, ?, ?);";
            conn = DBUtil.getConn();
            assert conn != null;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, staff.getId());
            ps.setString(2, staff.getName());
            ps.setInt(3, staff.getAge());
            ps.setString(4, staff.getPosition());


            ps.executeUpdate();

            System.out.println("添加成功");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void query() {

    }
}
