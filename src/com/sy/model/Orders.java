package com.sy.model;

public class Orders {
    private Integer id;
    private String oname;
    private Double price;
    private Integer uid;

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", oname='" + oname + '\'' +
                ", price=" + price +
                ", uid=" + uid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
