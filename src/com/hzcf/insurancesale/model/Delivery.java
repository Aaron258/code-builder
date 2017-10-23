package com.hzcf.insurancesale.model;

import java.io.Serializable;

public class Delivery extends Entity implements Serializable {
    private Long deliveryid;

    /**
     * 保单Id
     */
    private Long carinsurepolicyid;

    /**
     * 配送方式,1:快递,0:邮箱
     */
    private Byte deliverytype;

    /**
     * 收件人姓名
     */
    private String name;

    /**
     * 收件人联系号码
     */
    private String phone;

    /**
     * 配送地址省编码
     */
    private String province;

    /**
     * 配送地址市编码
     */
    private String city;

    /**
     * 配送地址区编码
     */
    private String area;

    /**
     * 配送详细地址
     */
    private String address;

    /**
     * 快递公司名称
     */
    private String expresscompanyname;

    /**
     * 快递单号
     */
    private String expressnumber;

    /**
     * 商业险电子保单地址
     */
    private String syelecpolicyfilepath;

    /**
     * 交强险电子保单地址
     */
    private String jpelecpolicyfilepath;

    private static final long serialVersionUID = 1L;

    public Long getDeliveryid() {
        return deliveryid;
    }

    public void setDeliveryid(Long deliveryid) {
        this.deliveryid = deliveryid;
    }

    public Long getCarinsurepolicyid() {
        return carinsurepolicyid;
    }

    public void setCarinsurepolicyid(Long carinsurepolicyid) {
        this.carinsurepolicyid = carinsurepolicyid;
    }

    public Byte getDeliverytype() {
        return deliverytype;
    }

    public void setDeliverytype(Byte deliverytype) {
        this.deliverytype = deliverytype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getExpresscompanyname() {
        return expresscompanyname;
    }

    public void setExpresscompanyname(String expresscompanyname) {
        this.expresscompanyname = expresscompanyname == null ? null : expresscompanyname.trim();
    }

    public String getExpressnumber() {
        return expressnumber;
    }

    public void setExpressnumber(String expressnumber) {
        this.expressnumber = expressnumber == null ? null : expressnumber.trim();
    }

    public String getSyelecpolicyfilepath() {
        return syelecpolicyfilepath;
    }

    public void setSyelecpolicyfilepath(String syelecpolicyfilepath) {
        this.syelecpolicyfilepath = syelecpolicyfilepath == null ? null : syelecpolicyfilepath.trim();
    }

    public String getJpelecpolicyfilepath() {
        return jpelecpolicyfilepath;
    }

    public void setJpelecpolicyfilepath(String jpelecpolicyfilepath) {
        this.jpelecpolicyfilepath = jpelecpolicyfilepath == null ? null : jpelecpolicyfilepath.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deliveryid=").append(deliveryid);
        sb.append(", carinsurepolicyid=").append(carinsurepolicyid);
        sb.append(", deliverytype=").append(deliverytype);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", area=").append(area);
        sb.append(", address=").append(address);
        sb.append(", expresscompanyname=").append(expresscompanyname);
        sb.append(", expressnumber=").append(expressnumber);
        sb.append(", syelecpolicyfilepath=").append(syelecpolicyfilepath);
        sb.append(", jpelecpolicyfilepath=").append(jpelecpolicyfilepath);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}