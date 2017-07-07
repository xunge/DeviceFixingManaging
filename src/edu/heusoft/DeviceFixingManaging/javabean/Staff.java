package edu.heusoft.DeviceFixingManaging.javabean;

import java.util.Date;

/**����ְ����Ϣ��Bean��
 * 
 * @author LZMA
 *
 */
public class Staff {
	private int staffNo; //PK
	private String staffName;
	private String staffPassword;
	private String staffCharacter;
	

	
	public Staff() {
	}
	
	public Staff(int staffNo, String staffName, String staffPassword,
			String staffCharacter) {
		this.staffNo = staffNo;
		this.staffName = staffName;
		this.staffPassword = staffPassword;
		this.staffCharacter = staffCharacter;
	}
	
	public void init(){
		this.staffNo=-1;
		this.staffName="";
		this.staffPassword="";
		this.staffCharacter="";
	}
	
	public int getStaffNo() {
		return staffNo;
	}
	public void setStaffNo(int staffNo) {
		this.staffNo = staffNo;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffPassword() {
		return staffPassword;
	}
	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}
	public String getStaffCharacter() {
		return staffCharacter;
	}
	public void setStaffCharacter(String staffCharacter) {
		this.staffCharacter = staffCharacter;
	}
	
	@Override
	public String toString() {
		return "StaffMember [staffNo=" + staffNo + ", staffName=" + staffName
				+ ", staffPassword=" + staffPassword + ", staffCharacter="
				+ staffCharacter + "]";
	}
}
