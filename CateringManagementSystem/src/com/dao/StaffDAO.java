package com.dao;

import com.entity.Staff;

public interface StaffDAO {
    Object[][] findAll();
    void addStaff(Staff staff);
    void update();
    void query();

}
