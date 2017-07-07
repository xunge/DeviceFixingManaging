package edu.heusoft.DeviceFixingManaging.javabean;

import java.util.Date;

public class Price {

	
	private int 	price_no ; 
	private Date 	price_time ;
	private Double 	price;
	
	public void init()
	{
		this.price_no   = -1; 
		this.price_time = null;
		this.price  = -1.0;
	}
	
	public Price() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Price(int price_no, Date price_time, Double price) {
		super();
		this.price_no = price_no;
		this.price_time = price_time;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Price [price_no=" + price_no + ", price_time=" + price_time
				+ ", price=" + price + "]";
	}
	public int getPrice_no() {
		return price_no;
	}
	public void setPrice_no(int price_no) {
		this.price_no = price_no;
	}
	public Date getPrice_time() {
		return price_time;
	}
	public void setPrice_time(Date price_time) {
		this.price_time = price_time;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
}
