package com.dao.impl;

import com.dao.UserDAO;
import com.entity.User;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean haveUser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConn();
            String sql = "SELECT * FROM user WHERE user = ? AND password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUser());
            ps.setString(2,user.getPassword());
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addUser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConn();
            String sql = "SELECT * FROM user WHERE user = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUser());
            rs = ps.executeQuery();
            if (!rs.next()) {
                String sql1 = "insert into user(user, password) values(?, ?)";
                ps = conn.prepareStatement(sql1);
                ps.setString(1, user.getUser());
                ps.setString(2, user.getPassword());
                ps.executeUpdate();
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConn(conn);
            DBUtil.closePs(ps);
            DBUtil.closeRs(rs);
        }
        return false;
    }
}
