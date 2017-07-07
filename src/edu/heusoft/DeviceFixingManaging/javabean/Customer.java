package edu.heusoft.DeviceFixingManaging.javabean;

import java.util.Date;

public class Customer {

		private String customer_idno;
		private Date   customer_visittime;
		private String customer_character;
		private String customer_companyname;
		private String customer_housephone;
		private String customer_mobilephone;
		private String customer_address;
		private String customer_postcode;
		private String customer_linkman;
		private String customer_email;
		
		public void init()
		{
			this.customer_idno ="";
			this.customer_visittime=null;
			this.customer_character="";
			this.customer_companyname="";
			this.customer_housephone="";
			this.customer_mobilephone="";
			this.customer_address="";
			this.customer_postcode="";
			this.customer_linkman="";
			this.customer_email="";
		}
		
		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Customer(String customer_idno, Date customer_visittime,
				String customer_character, String customer_companyname,
				String customer_housephone, String customer_mobilephone,
				String customer_address, String customer_postcode,
				String customer_linkman, String customer_email) {
			super();
			this.customer_idno = customer_idno;
			this.customer_visittime = customer_visittime;
			this.customer_character = customer_character;
			this.customer_companyname = customer_companyname;
			this.customer_housephone = customer_housephone;
			this.customer_mobilephone = customer_mobilephone;
			this.customer_address = customer_address;
			this.customer_postcode = customer_postcode;
			this.customer_linkman = customer_linkman;
			this.customer_email = customer_email;
		}
		@Override
		public String toString() {
			return "Customer [customer_idno=" + customer_idno
					+ ", customer_visittime=" + customer_visittime
					+ ", customer_character=" + customer_character
					+ ", customer_companyname=" + customer_companyname
					+ ", customer_housephone=" + customer_housephone
					+ ", customer_mobilephone=" + customer_mobilephone
					+ ", customer_address=" + customer_address
					+ ", customer_postcode=" + customer_postcode
					+ ", customer_linkman=" + customer_linkman
					+ ", customer_email=" + customer_email + "]";
		}
		public String getCustomer_idno() {
			return customer_idno;
		}
		public void setCustomer_idno(String customer_idno) {
			this.customer_idno = customer_idno;
		}
		public Date getCustomer_visittime() {
			return customer_visittime;
		}
		public void setCustomer_visittime(Date customer_visittime) {
			this.customer_visittime = customer_visittime;
		}
		public String getCustomer_character() {
			return customer_character;
		}
		public void setCustomer_character(String customer_character) {
			this.customer_character = customer_character;
		}
		public String getCustomer_companyname() {
			return customer_companyname;
		}
		public void setCustomer_companyname(String customer_companyname) {
			this.customer_companyname = customer_companyname;
		}
		public String getCustomer_housephone() {
			return customer_housephone;
		}
		public void setCustomer_housephone(String customer_housephone) {
			this.customer_housephone = customer_housephone;
		}
		public String getCustomer_mobilephone() {
			return customer_mobilephone;
		}
		public void setCustomer_mobilephone(String customer_mobilephone) {
			this.customer_mobilephone = customer_mobilephone;
		}
		public String getCustomer_address() {
			return customer_address;
		}
		public void setCustomer_address(String customer_address) {
			this.customer_address = customer_address;
		}
		public String getCustomer_postcode() {
			return customer_postcode;
		}
		public void setCustomer_postcode(String customer_postcode) {
			this.customer_postcode = customer_postcode;
		}
		public String getCustomer_linkman() {
			return customer_linkman;
		}
		public void setCustomer_linkman(String customer_linkman) {
			this.customer_linkman = customer_linkman;
		}
		public String getCustomer_email() {
			return customer_email;
		}
		public void setCustomer_email(String customer_email) {
			this.customer_email = customer_email;
		}
		
		

}
