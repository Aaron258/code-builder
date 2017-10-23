package com.hzcf.insurancesale.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CarInsurePolicy extends Entity implements Serializable {
    private Long carinsurepolicyid;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 保单支付金额
     */
    private BigDecimal payAmount;

    /**
     * 推广费比例
     */
    private BigDecimal promotionRate;

    /**
     * 推广费金额
     */
    private BigDecimal promotionExpenses;

    /**
     * 投保地区编码
     */
    private String insureareacode;

    private String productName;

    /**
     * 任务号
     */
    private Long taskid;

    /**
     * 供应商id
     */
    private String prvid;

    /**
     * 保险公司简称
     */
    private String prvname;

    /**
     * 错误消息以及备注信息
     */
    private String errormsg;

    /**
     * 推荐用户
     */
    private String channeluserid;

    /**
     * 任务状态代码,参考车险文档
     */
    private String taskstate;

    /**
     * 任务状态描述
     */
    private String taskstatedescription;

    private static final long serialVersionUID = 1L;

    public Long getCarinsurepolicyid() {
        return carinsurepolicyid;
    }

    public void setCarinsurepolicyid(Long carinsurepolicyid) {
        this.carinsurepolicyid = carinsurepolicyid;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getPromotionRate() {
        return promotionRate;
    }

    public void setPromotionRate(BigDecimal promotionRate) {
        this.promotionRate = promotionRate;
    }

    public BigDecimal getPromotionExpenses() {
        return promotionExpenses;
    }

    public void setPromotionExpenses(BigDecimal promotionExpenses) {
        this.promotionExpenses = promotionExpenses;
    }

    public String getInsureareacode() {
        return insureareacode;
    }

    public void setInsureareacode(String insureareacode) {
        this.insureareacode = insureareacode == null ? null : insureareacode.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Long getTaskid() {
        return taskid;
    }

    public void setTaskid(Long taskid) {
        this.taskid = taskid;
    }

    public String getPrvid() {
        return prvid;
    }

    public void setPrvid(String prvid) {
        this.prvid = prvid == null ? null : prvid.trim();
    }

    public String getPrvname() {
        return prvname;
    }

    public void setPrvname(String prvname) {
        this.prvname = prvname == null ? null : prvname.trim();
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg == null ? null : errormsg.trim();
    }

    public String getChanneluserid() {
        return channeluserid;
    }

    public void setChanneluserid(String channeluserid) {
        this.channeluserid = channeluserid == null ? null : channeluserid.trim();
    }

    public String getTaskstate() {
        return taskstate;
    }

    public void setTaskstate(String taskstate) {
        this.taskstate = taskstate == null ? null : taskstate.trim();
    }

    public String getTaskstatedescription() {
        return taskstatedescription;
    }

    public void setTaskstatedescription(String taskstatedescription) {
        this.taskstatedescription = taskstatedescription == null ? null : taskstatedescription.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", carinsurepolicyid=").append(carinsurepolicyid);
        sb.append(", orderId=").append(orderId);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", promotionRate=").append(promotionRate);
        sb.append(", promotionExpenses=").append(promotionExpenses);
        sb.append(", insureareacode=").append(insureareacode);
        sb.append(", productName=").append(productName);
        sb.append(", taskid=").append(taskid);
        sb.append(", prvid=").append(prvid);
        sb.append(", prvname=").append(prvname);
        sb.append(", errormsg=").append(errormsg);
        sb.append(", channeluserid=").append(channeluserid);
        sb.append(", taskstate=").append(taskstate);
        sb.append(", taskstatedescription=").append(taskstatedescription);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}