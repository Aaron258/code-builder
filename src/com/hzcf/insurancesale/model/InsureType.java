package com.hzcf.insurancesale.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class InsureType extends Entity implements Serializable {
    private Long insuretypeid;

    /**
     * 商业险ID
     */
    private Long businessinsureid;

    /**
     * 险种代码
     */
    private String riskcode;

    /**
     * 险种名称
     */
    private String riskname;

    /**
     * 险种保额
     */
    private BigDecimal amount;

    /**
     * 险种保费
     */
    private BigDecimal premium;

    /**
     * 是否不计免赔,Y:是,N:否
     */
    private String notdeductible;

    /**
     * 险种不计免赔保费
     */
    private BigDecimal ncfpremium;

    private static final long serialVersionUID = 1L;

    public Long getInsuretypeid() {
        return insuretypeid;
    }

    public void setInsuretypeid(Long insuretypeid) {
        this.insuretypeid = insuretypeid;
    }

    public Long getBusinessinsureid() {
        return businessinsureid;
    }

    public void setBusinessinsureid(Long businessinsureid) {
        this.businessinsureid = businessinsureid;
    }

    public String getRiskcode() {
        return riskcode;
    }

    public void setRiskcode(String riskcode) {
        this.riskcode = riskcode == null ? null : riskcode.trim();
    }

    public String getRiskname() {
        return riskname;
    }

    public void setRiskname(String riskname) {
        this.riskname = riskname == null ? null : riskname.trim();
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

    public String getNotdeductible() {
        return notdeductible;
    }

    public void setNotdeductible(String notdeductible) {
        this.notdeductible = notdeductible == null ? null : notdeductible.trim();
    }

    public BigDecimal getNcfpremium() {
        return ncfpremium;
    }

    public void setNcfpremium(BigDecimal ncfpremium) {
        this.ncfpremium = ncfpremium;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", insuretypeid=").append(insuretypeid);
        sb.append(", businessinsureid=").append(businessinsureid);
        sb.append(", riskcode=").append(riskcode);
        sb.append(", riskname=").append(riskname);
        sb.append(", amount=").append(amount);
        sb.append(", premium=").append(premium);
        sb.append(", notdeductible=").append(notdeductible);
        sb.append(", ncfpremium=").append(ncfpremium);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}