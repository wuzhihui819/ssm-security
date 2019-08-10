package com.huanong.lab.bean;

public class Product {
    private Integer productId;

    private String productName;

    private String presentation;

    public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", presentation=" + presentation
				+ "]";
	}

	public Product(Integer productId, String productName, String presentation) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.presentation = presentation;
	}

	public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation == null ? null : presentation.trim();
    }
}