package com.dao;

import com.entity.Indent;

public interface IndentDAO {
    Object[][] findAll();
    void addIndent(Indent indent);
}
