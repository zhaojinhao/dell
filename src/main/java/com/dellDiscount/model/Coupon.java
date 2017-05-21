package com.dellDiscount.model;

import java.io.Serializable;
import java.util.Date;

public class Coupon implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String code;

    private Integer makeUse;

    private Integer type;

    private Date createdTime;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}