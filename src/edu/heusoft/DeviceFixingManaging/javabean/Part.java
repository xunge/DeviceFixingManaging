package edu.heusoft.DeviceFixingManaging.javabean;

public class Part {
	
	private int		part_no;
	private String	part_name; 
	private String	part_size ;
	private Double	part_price ;
	private int		part_num ;
	private int		part_warn_num; 
	private String	part_status ;
	
	public void init()
	{
		this.part_no = -1;
		this.part_name=""; 
		this.part_size="";
		this.part_price=-1.0;
		this.part_num =-1;
		this.part_warn_num=-1; 
		this.part_status ="";
	}
	
	@Override
	public String toString() {
		return "Part [part_no=" + part_no + ", part_name=" + part_name
				+ ", part_size=" + part_size + ", part_price=" + part_price
				+ ", part_num=" + part_num + ", part_warn_num=" + part_warn_num
				+ ", part_status=" + part_status + "]";
	}
	public Part(int part_no, String part_name, String part_size,
			Double part_price, int part_num, int part_warn_num,
			String part_status) {
		super();
		this.part_no = part_no;
		this.part_name = part_name;
		this.part_size = part_size;
		this.part_price = part_price;
		this.part_num = part_num;
		this.part_warn_num = part_warn_num;
		this.part_status = part_status;
	}
	public Part() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPart_no() {
		return part_no;
	}
	public void setPart_no(int part_no) {
		this.part_no = part_no;
	}
	public String getPart_name() {
		return part_name;
	}
	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}
	public String getPart_size() {
		return part_size;
	}
	public void setPart_size(String part_size) {
		this.part_size = part_size;
	}
	public Double getPart_price() {
		return part_price;
	}
	public void setPart_price(Double part_price) {
		this.part_price = part_price;
	}
	public int getPart_num() {
		return part_num;
	}
	public void setPart_num(int part_num) {
		this.part_num = part_num;
	}
	public int getPart_warn_num() {
		return part_warn_num;
	}
	public void setPart_warn_num(int part_warn_num) {
		this.part_warn_num = part_warn_num;
	}
	public String getPart_status() {
		return part_status;
	}
	public void setPart_status(String part_status) {
		this.part_status = part_status;
	}
	

}
