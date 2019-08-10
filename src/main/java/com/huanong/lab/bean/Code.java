package com.huanong.lab.bean;

import java.util.Date;

public class Code {
    private Integer codeId;

    private String realcode;

    private Integer counter;

    private Date firsttime;

    private Integer pId;
    
    private Product product;
    

    @Override
	public String toString() {
		return "Code [codeId=" + codeId + ", realcode=" + realcode + ", counter=" + counter + ", firsttime=" + firsttime
				+ ", pId=" + pId + ", product=" + product + "]";
	}

	public Code(Integer codeId, String realcode, Integer counter, Date firsttime, Integer pId) {
		super();
		this.codeId = codeId;
		this.realcode = realcode;
		this.counter = counter;
		this.firsttime = firsttime;
		this.pId = pId;
	}

	public Code() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getCodeId() {
        return codeId;
    }

    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    public String getRealcode() {
        return realcode;
    }

    public void setRealcode(String realcode) {
        this.realcode = realcode == null ? null : realcode.trim();
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Date getFirsttime() {
        return firsttime;
    }

    public void setFirsttime(Date firsttime) {
        this.firsttime = firsttime;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }
}