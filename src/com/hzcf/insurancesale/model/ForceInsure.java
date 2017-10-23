package com.hzcf.insurancesale.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ForceInsure extends Entity implements Serializable {
    private Long forceinsureid;

    /**
     * 保单Id
     */
    private Long carinsurepolicyid;

    /**
     * 交强险保单号
     */
    private String policyno;

    /**
     * 交强险保额
     */
    private BigDecimal amount;

    /**
     * 交强险保费
     */
    private BigDecimal premium;

    /**
     * 交强险折扣率
     */
    private BigDecimal discountrate;

    /**
     * 车船税滞纳金
     */
    private BigDecimal latefee;

    /**
     * 车船税金额
     */
    private BigDecimal taxfee;

    /**
     * 交强险起保日期
     */
    private Date startdate;

    /**
     * 交强险终保日期
     */
    private Date enddate;

    private static final long serialVersionUID = 1L;

    public Long getForceinsureid() {
        return forceinsureid;
    }

    public void setForceinsureid(Long forceinsureid) {
        this.forceinsureid = forceinsureid;
    }

    public Long getCarinsurepolicyid() {
        return carinsurepolicyid;
    }

    public void setCarinsurepolicyid(Long carinsurepolicyid) {
        this.carinsurepolicyid = carinsurepolicyid;
    }

    public String getPolicyno() {
        return policyno;
    }

    public void setPolicyno(String policyno) {
        this.policyno = policyno == null ? null : policyno.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public BigDecimal getDiscountrate() {
        return discountrate;
    }

    public void setDiscountrate(BigDecimal discountrate) {
        this.discountrate = discountrate;
    }

    public BigDecimal getLatefee() {
        return latefee;
    }

    public void setLatefee(BigDecimal latefee) {
        this.latefee = latefee;
    }

    public BigDecimal getTaxfee() {
        return taxfee;
    }

    public void setTaxfee(BigDecimal taxfee) {
        this.taxfee = taxfee;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", forceinsureid=").append(forceinsureid);
        sb.append(", carinsurepolicyid=").append(carinsurepolicyid);
        sb.append(", policyno=").append(policyno);
        sb.append(", amount=").append(amount);
        sb.append(", premium=").append(premium);
        sb.append(", discountrate=").append(discountrate);
        sb.append(", latefee=").append(latefee);
        sb.append(", taxfee=").append(taxfee);
        sb.append(", startdate=").append(startdate);
        sb.append(", enddate=").append(enddate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}