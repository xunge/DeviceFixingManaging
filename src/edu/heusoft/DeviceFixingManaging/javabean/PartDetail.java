package edu.heusoft.DeviceFixingManaging.javabean;

public class PartDetail {
			
	private int part_detail_no ;
	private int part_no;
	private int part_detail_num;
	private String part_detail_status;
	private int repair_record_no;
	
	public void init()
	{
		this.part_detail_no =-1;
		this.part_no=-1;
		this.part_detail_num=-1 ;
		this.part_detail_status="";
		this.repair_record_no=-1;
	}

	public PartDetail() {
		
	}

	public PartDetail(int part_detail_no, int part_no, int part_detail_num,
			String part_detail_status, int repair_record_no) {
		
		this.part_detail_no = part_detail_no;
		this.part_no = part_no;
		this.part_detail_num = part_detail_num;
		this.part_detail_status = part_detail_status;
		this.repair_record_no = repair_record_no;
	}

	public int getPart_detail_no() {
		return part_detail_no;
	}

	public void setPart_detail_no(int part_detail_no) {
		this.part_detail_no = part_detail_no;
	}

	public int getPart_no() {
		return part_no;
	}

	public void setPart_no(int part_no) {
		this.part_no = part_no;
	}

	public int getPart_detail_num() {
		return part_detail_num;
	}

	public void setPart_detail_num(int part_detail_num) {
		this.part_detail_num = part_detail_num;
	}

	public String getPart_detail_status() {
		return part_detail_status;
	}

	public void setPart_detail_status(String part_detail_status) {
		this.part_detail_status = part_detail_status;
	}

	public int getRepair_record_no() {
		return repair_record_no;
	}

	public void setRepair_record_no(int repair_record_no) {
		this.repair_record_no = repair_record_no;
	}

	@Override
	public String toString() {
		return "PartDetail [part_detail_no=" + part_detail_no + ", part_no="
				+ part_no + ", part_detail_num=" + part_detail_num
				+ ", part_detail_status=" + part_detail_status
				+ ", repair_record_no=" + repair_record_no + "]";
	}
	
}

	