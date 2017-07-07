package edu.heusoft.DeviceFixingManaging.javabean;

import java.util.Date;

public class ReportRecord {

	private int 	report_record_no;
	private String 	customer_idno;
	private int 	report_equip_no;
	private Date	report_time ;
	private int 	predict_price ;
	private Date    predict_complete_time ;
	private String  report_status;
	
	public void init()
	{
		this.report_record_no =-1;
		this.customer_idno="";
		this.report_equip_no=-1;
		this.report_time =null;
		this.predict_price =-1;
		this.predict_complete_time =null;
		this.report_status="";
	}
	
	public ReportRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReportRecord(int report_record_no, String customer_idno,
			int report_equip_no, Date report_time, int predict_price,
			Date predict_complete_time, String report_status) {
		super();
		this.report_record_no = report_record_no;
		this.customer_idno = customer_idno;
		this.report_equip_no = report_equip_no;
		this.report_time = report_time;
		this.predict_price = predict_price;
		this.predict_complete_time = predict_complete_time;
		this.report_status = report_status;
	}
	@Override
	public String toString() {
		return "ReportRecord [report_record_no=" + report_record_no
				+ ", customer_idno=" + customer_idno + ", report_equip_no="
				+ report_equip_no + ", report_time=" + report_time
				+ ", predict_price=" + predict_price
				+ ", predict_complete_time=" + predict_complete_time
				+ ", report_status=" + report_status + "]";
	}
	public int getReport_record_no() {
		return report_record_no;
	}
	public void setReport_record_no(int report_record_no) {
		this.report_record_no = report_record_no;
	}
	public String getCustomer_idno() {
		return customer_idno;
	}
	public void setCustomer_idno(String customer_idno) {
		this.customer_idno = customer_idno;
	}
	public int getReport_equip_no() {
		return report_equip_no;
	}
	public void setReport_equip_no(int report_equip_no) {
		this.report_equip_no = report_equip_no;
	}
	public Date getReport_time() {
		return report_time;
	}
	public void setReport_time(Date report_time) {
		this.report_time = report_time;
	}
	public int getPredict_price() {
		return predict_price;
	}
	public void setPredict_price(int predict_price) {
		this.predict_price = predict_price;
	}
	public Date getPredict_complete_time() {
		return predict_complete_time;
	}
	public void setPredict_complete_time(Date predict_complete_time) {
		this.predict_complete_time = predict_complete_time;
	}
	public String getReport_status() {
		return report_status;
	}
	public void setReport_status(String report_status) {
		this.report_status = report_status;
	}
	
	
}
