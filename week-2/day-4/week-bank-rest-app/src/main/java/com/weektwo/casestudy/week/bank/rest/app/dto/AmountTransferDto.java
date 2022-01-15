package com.weektwo.casestudy.week.bank.rest.app.dto;

public class AmountTransferDto <T>{
    private Long srcAc;
    private Long dstAc;
    private Double amt;
    private T body;

    public Long getSrcAc() {
        return srcAc;
    }

    public void setSrcAc(Long srcAc) {
        this.srcAc = srcAc;
    }

    public Long getDstAc() {
        return dstAc;
    }

    public void setDstAc(Long dstAc) {
        this.dstAc = dstAc;
    }

    public Double getAmt() {
        return amt;
    }

    public void setAmt(Double amt) {
        this.amt = amt;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
