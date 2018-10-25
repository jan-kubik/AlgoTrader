package com.jankubik.algotrader.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class SymbolDetails {

	String pair;
	int pricePrecision;
	BigDecimal initialMargin;
	BigDecimal minimumMargin;
	BigDecimal maximumOrderSize;
	BigDecimal minimumOrderSize;
	String expiration;
	boolean margin;
	public String getPair() {
		return pair;
	}
	public void setPair(String pair) {
		this.pair = pair;
	}
	public int getPricePrecision() {
		return pricePrecision;
	}
	public void setPricePrecision(int pricePrecision) {
		this.pricePrecision = pricePrecision;
	}
	public BigDecimal getInitialMargin() {
		return initialMargin;
	}
	public void setInitialMargin(BigDecimal initialMargin) {
		this.initialMargin = initialMargin;
	}
	public BigDecimal getMinimumMargin() {
		return minimumMargin;
	}
	public void setMinimumMargin(BigDecimal minimumMargin) {
		this.minimumMargin = minimumMargin;
	}
	public BigDecimal getMaximumOrderSize() {
		return maximumOrderSize;
	}
	public void setMaximumOrderSize(BigDecimal maximumOrderSize) {
		this.maximumOrderSize = maximumOrderSize;
	}
	public BigDecimal getMinimumOrderSize() {
		return minimumOrderSize;
	}
	public void setMinimumOrderSize(BigDecimal minimumOrderSize) {
		this.minimumOrderSize = minimumOrderSize;
	}
	public String getExpiration() {
		return expiration;
	}
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
	public boolean isMargin() {
		return margin;
	}
	public void setMargin(boolean margin) {
		this.margin = margin;
	}
	public String myToString() {
		return "{" + pair + "," + pricePrecision + "," + minimumOrderSize + "," + maximumOrderSize + "}";
		
	}
	
}
