package com.Jheimison.dsvendas.dto;

import java.io.Serializable;

import com.Jheimison.dsvendas.entities.Seller;

public class SaleSumDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String SellerName;
	private Double Sum;
	
	public SaleSumDTO() {
	}

	public SaleSumDTO(Seller seller, Double sum) {
		SellerName = seller.getName();
		Sum = sum;
	}

	public String getSallerName() {
		return SellerName;
	}

	public void setSallerName(String sellerName) {
		SellerName = sellerName;
	}

	public Double getSum() {
		return Sum;
	}

	public void setSum(Double sum) {
		Sum = sum;
	}
}
