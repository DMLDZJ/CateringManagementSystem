package com.entity;

public class Indent {
    private int indentId;
    private int indentDetailId;
    private int indentCost;

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    private int dineTableId;
    private String dishName;

    public Indent(int cost, int tableId, String dishName) {

        this.indentCost = cost;
        this.dineTableId = tableId;
        this.dishName = dishName;
    }

    public int getIndentId() {
        return indentId;
    }

    public void setIndentId(int indentId) {
        this.indentId = indentId;
    }

    public int getIndentDetailId() {
        return indentDetailId;
    }

    public void setIndentDetailId(int indentDetailId) {
        this.indentDetailId = indentDetailId;
    }

    public int getIndentCost() {
        return indentCost;
    }

    public void setIndentCost(int indentCost) {
        this.indentCost = indentCost;
    }

    public int getDineTableId() {
        return dineTableId;
    }

    public void setDineTableId(int dineTableId) {
        this.dineTableId = dineTableId;
    }
}
