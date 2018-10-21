package com.jankubik.algoTraderTest.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class SymbolDetails {

	String pair;
	int price_precision;
	BigDecimal initial_margin;
	BigDecimal minimum_margin;
	BigDecimal maximum_order_size;
	BigDecimal minimum_order_size;
	String expiration;
	boolean margin;
	public String getPair() {
		return pair;
	}
	public void setPair(String pair) {
		this.pair = pair;
	}
	public int getPrice_precision() {
		return price_precision;
	}
	public void setPrice_precision(int price_precision) {
		this.price_precision = price_precision;
	}
	public BigDecimal getInitial_margin() {
		return initial_margin;
	}
	public void setInitial_margin(BigDecimal initial_margin) {
		this.initial_margin = initial_margin;
	}
	public BigDecimal getMinimum_margin() {
		return minimum_margin;
	}
	public void setMinimum_margin(BigDecimal minimum_margin) {
		this.minimum_margin = minimum_margin;
	}
	public BigDecimal getMaximum_order_size() {
		return maximum_order_size;
	}
	public void setMaximum_order_size(BigDecimal maximum_order_size) {
		this.maximum_order_size = maximum_order_size;
	}
	public BigDecimal getMinimum_order_size() {
		return minimum_order_size;
	}
	public void setMinimum_order_size(BigDecimal minimum_order_size) {
		this.minimum_order_size = minimum_order_size;
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
		return "{" + pair + "," + price_precision + "," + minimum_order_size + "," + maximum_order_size + "}";
		
	}
	
}
