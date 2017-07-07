package edu.heusoft.DeviceFixingManaging.javabean;

import java.util.Date;

public class RepairRecord {

	
	private int  repair_record_no ;
	private int  repair_person_no ;
	private Date  repair_time ;
	private String  test_record;
	private String  repair_record;
	private Date  repair_test_time ;
	private String  work_amount ;
	private Double  person_price ;
	private Double  material_price ;
	private String  repair_promise;
	private String  attention ;
	private String  repair_status ;
	private String  repair_delay ;
	private int  report_record_no;
	
	public void init()
	{
		this.repair_record_no =-1;
		this.repair_person_no =-1;
		this.repair_time = null;
		this.test_record = "";
		this.repair_record ="";
		this.repair_test_time =null;
		this.work_amount ="";
		this.person_price =-1.0;
		this.material_price =-1.0;
		this.repair_promise = "";
		this.attention ="";
		this.repair_status ="";
		this.repair_delay = "";
		this.report_record_no = -1;
	}

	public RepairRecord() {
		
	}

	public RepairRecord(int repair_record_no, int repair_person_no,
			Date repair_time, String test_record, String repair_record,
			Date repair_test_time, String work_amount, Double person_price,
			Double material_price, String repair_promise, String attention,
			String repair_status, String repair_delay, int report_record_no) {
		
		this.repair_record_no = repair_record_no;
		this.repair_person_no = repair_person_no;
		this.repair_time = repair_time;
		this.test_record = test_record;
		this.repair_record = repair_record;
		this.repair_test_time = repair_test_time;
		this.work_amount = work_amount;
		this.person_price = person_price;
		this.material_price = material_price;
		this.repair_promise = repair_promise;
		this.attention = attention;
		this.repair_status = repair_status;
		this.repair_delay = repair_delay;
		this.report_record_no = report_record_no;
	}

	public int getRepair_record_no() {
		return repair_record_no;
	}

	public void setRepair_record_no(int repair_record_no) {
		this.repair_record_no = repair_record_no;
	}

	public int getRepair_person_no() {
		return repair_person_no;
	}

	public void setRepair_person_no(int repair_person_no) {
		this.repair_person_no = repair_person_no;
	}

	public Date getRepair_time() {
		return repair_time;
	}

	public void setRepair_time(Date repair_time) {
		this.repair_time = repair_time;
	}

	public String getTest_record() {
		return test_record;
	}

	public void setTest_record(String test_record) {
		this.test_record = test_record;
	}

	public String getRepair_record() {
		return repair_record;
	}

	public void setRepair_record(String repair_record) {
		this.repair_record = repair_record;
	}

	public Date getRepair_test_time() {
		return repair_test_time;
	}

	public void setRepair_test_time(Date repair_test_time) {
		this.repair_test_time = repair_test_time;
	}

	public String getWork_amount() {
		return work_amount;
	}

	public void setWork_amount(String work_amount) {
		this.work_amount = work_amount;
	}

	public Double getPerson_price() {
		return person_price;
	}

	public void setPerson_price(Double person_price) {
		this.person_price = person_price;
	}

	public Double getMaterial_price() {
		return material_price;
	}

	public void setMaterial_price(Double material_price) {
		this.material_price = material_price;
	}

	public String getRepair_promise() {
		return repair_promise;
	}

	public void setRepair_promise(String repair_promise) {
		this.repair_promise = repair_promise;
	}

	public String getAttention() {
		return attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public String getRepair_status() {
		return repair_status;
	}

	public void setRepair_status(String repair_status) {
		this.repair_status = repair_status;
	}

	public String getRepair_delay() {
		return repair_delay;
	}

	public void setRepair_delay(String repair_delay) {
		this.repair_delay = repair_delay;
	}

	public int getReport_record_no() {
		return report_record_no;
	}

	public void setReport_record_no(int report_record_no) {
		this.report_record_no = report_record_no;
	}

	@Override
	public String toString() {
		return "RepairRecord [repair_record_no=" + repair_record_no
				+ ", repair_person_no=" + repair_person_no + ", repair_time="
				+ repair_time + ", test_record=" + test_record
				+ ", repair_record=" + repair_record + ", repair_test_time="
				+ repair_test_time + ", work_amount=" + work_amount
				+ ", person_price=" + person_price + ", material_price="
				+ material_price + ", repair_promise=" + repair_promise
				+ ", attention=" + attention + ", repair_status="
				+ repair_status + ", repair_delay=" + repair_delay
				+ ", report_record_no=" + report_record_no + "]";
	}
	
	
}