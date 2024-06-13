package com.entity;

public class DineTable {
    private int id;
    private String status;
    private int num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public DineTable(int id, String status, int num) {
        this.id = id;
        this.status = status;
        this.num = num;
    }


}
