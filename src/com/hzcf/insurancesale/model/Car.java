package com.hzcf.insurancesale.model;

import java.io.Serializable;

public class Car extends Entity implements Serializable {
    private Long carid;

    /**
     * 保单Id
     */
    private Long carinsurepolicyid;

    /**
     * 车牌号
     */
    private String carlicenseno;

    /**
     * 车型名称
     */
    private String vehiclename;

    /**
     * 车辆使用性质代码
     */
    private String carproperty;

    /**
     * 车主姓名
     */
    private String owner;

    /**
     * 证件号码
     */
    private String idcardno;

    /**
     * 身份证:0,户口本:1,驾驶证:2,军官士官证:3,护照:4
     */
    private String idcardtype;

    /**
     * 手机号
     */
    private String phone;

    private static final long serialVersionUID = 1L;

    public Long getCarid() {
        return carid;
    }

    public void setCarid(Long carid) {
        this.carid = carid;
    }

    public Long getCarinsurepolicyid() {
        return carinsurepolicyid;
    }

    public void setCarinsurepolicyid(Long carinsurepolicyid) {
        this.carinsurepolicyid = carinsurepolicyid;
    }

    public String getCarlicenseno() {
        return carlicenseno;
    }

    public void setCarlicenseno(String carlicenseno) {
        this.carlicenseno = carlicenseno == null ? null : carlicenseno.trim();
    }

    public String getVehiclename() {
        return vehiclename;
    }

    public void setVehiclename(String vehiclename) {
        this.vehiclename = vehiclename == null ? null : vehiclename.trim();
    }

    public String getCarproperty() {
        return carproperty;
    }

    public void setCarproperty(String carproperty) {
        this.carproperty = carproperty == null ? null : carproperty.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getIdcardno() {
        return idcardno;
    }

    public void setIdcardno(String idcardno) {
        this.idcardno = idcardno == null ? null : idcardno.trim();
    }

    public String getIdcardtype() {
        return idcardtype;
    }

    public void setIdcardtype(String idcardtype) {
        this.idcardtype = idcardtype == null ? null : idcardtype.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", carid=").append(carid);
        sb.append(", carinsurepolicyid=").append(carinsurepolicyid);
        sb.append(", carlicenseno=").append(carlicenseno);
        sb.append(", vehiclename=").append(vehiclename);
        sb.append(", carproperty=").append(carproperty);
        sb.append(", owner=").append(owner);
        sb.append(", idcardno=").append(idcardno);
        sb.append(", idcardtype=").append(idcardtype);
        sb.append(", phone=").append(phone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}