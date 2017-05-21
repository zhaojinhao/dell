package com.dellDiscount.model;

public class DiscountCoupon {
    private Integer id;

    private String code;

    private Integer makeUse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getMakeUse() {
        return makeUse;
    }

    public void setMakeUse(Integer makeUse) {
        this.makeUse = makeUse;
    }
}