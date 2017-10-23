package com.hzcf.insurancesale.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BusinessInsure extends Entity implements Serializable {
    private Long businessinsureid;

    /**
     * 保单Id
     */
    private Long carinsurepolicyid;

    /**
     * 商业险保单号
     */
    private String policyno;

    /**
     * 商业险保费合计=商业险保费+商业险不计免赔保费
     */
    private BigDecimal premium;

    /**
     * 商业险不计免赔保费
     */
    private BigDecimal nfcpremium;

    /**
     * 承保成功后才有商业险折扣率
     */
    private BigDecimal discountrate;

    /**
     * 商业险起保日期
     */
    private Date startdate;

    /**
     * 商业险终保日期
     */
    private Date enddate;

    private static final long serialVersionUID = 1L;

    public Long getBusinessinsureid() {
        return businessinsureid;
    }

    public void setBusinessinsureid(Long businessinsureid) {
        this.businessinsureid = businessinsureid;
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

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public BigDecimal getNfcpremium() {
        return nfcpremium;
    }

    public void setNfcpremium(BigDecimal nfcpremium) {
        this.nfcpremium = nfcpremium;
    }

    public BigDecimal getDiscountrate() {
        return discountrate;
    }

    public void setDiscountrate(BigDecimal discountrate) {
        this.discountrate = discountrate;
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
        sb.append(", businessinsureid=").append(businessinsureid);
        sb.append(", carinsurepolicyid=").append(carinsurepolicyid);
        sb.append(", policyno=").append(policyno);
        sb.append(", premium=").append(premium);
        sb.append(", nfcpremium=").append(nfcpremium);
        sb.append(", discountrate=").append(discountrate);
        sb.append(", startdate=").append(startdate);
        sb.append(", enddate=").append(enddate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}