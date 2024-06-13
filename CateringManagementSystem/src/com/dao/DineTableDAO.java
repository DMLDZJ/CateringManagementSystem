package com.dao;

import com.entity.DineTable;

public interface DineTableDAO {
    Object[][] findAll();
    void addTable(DineTable dt);
}
