//SLIAN
package edu.heusoft.DeviceFixingManaging.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.heusoft.DeviceFixingManaging.common.DBUtil;
import edu.heusoft.DeviceFixingManaging.javabean.Staff;

/**
 * 
 * @author Admin
 *
 */
public class StaffDao {
	
	/**�����û���¼.
	 * 
	 * @param loginInfo ֻ�����û��������
	 * @return trueΪ��¼�ɹ���falseΪ��¼ʧ��
	 */
	public boolean loginClassic(Staff loginInfo){
		boolean result=false;
		
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUtil.getConnection();
		try {
			st=con.prepareStatement(" select count(*) as c from staff where staff_name=? and staff_password=? ");
			st.setString(1, loginInfo.getStaffName());
			st.setString(2, loginInfo.getStaffPassword());
			rs=st.executeQuery();
			if(rs.next()){
				int i=rs.getInt("c");
				if(1==i){
					result=true;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	

	public Staff login(Staff loginInfo){
		Staff result=null;
		
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUtil.getConnection();
		
		try {
			st=con.prepareStatement(" select staff_no,staff_character from staff where staff_name=? and staff_password=? ");
			st.setString(1, loginInfo.getStaffName());
			st.setString(2, loginInfo.getStaffPassword());
			rs=st.executeQuery();
			if(rs.next()){
				result=new Staff();
				result.setStaffNo(rs.getInt(1));
				result.setStaffCharacter(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

		return result;
	}
	
	public ArrayList<Staff> queryStaff(Staff staff,int startPosition,int pageSize){
		ArrayList<Staff> result=new ArrayList<Staff>();
		
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUtil.getConnection();
		StringBuilder sql=new StringBuilder();
		
		sql.append(" select staff_no,staff_name,staff_password,staff_character from staff where 1=1 ");
		if(staff.getStaffNo()!=-1) sql.append(" and staff_no=? ");
		if(!staff.getStaffName().equals("")) sql.append(" and staff_name=? ");
		if(!staff.getStaffCharacter().equals("")) sql.append(" and staff_character=? ");
		sql.append(" limit ?,? ");
		
		try {
			st=con.prepareStatement(sql.toString());
			int index=1;
			if(staff.getStaffNo()!=-1) st.setInt(index++, staff.getStaffNo());
			if(!staff.getStaffName().equals("")) st.setString(index++, staff.getStaffName());
			if(!staff.getStaffCharacter().equals("")) st.setString(index++, staff.getStaffCharacter());
			st.setInt(index++, startPosition);
			st.setInt(index++, pageSize);
			
			rs=st.executeQuery();
			
			while(rs.next()){
				Staff sb=new Staff(
						rs.getInt("staff_no"),
						rs.getString("staff_name"),
						rs.getString("staff_password"),
						rs.getString("staff_character")
						);
				
				result.add(sb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result=null;
		}
		
		return result;

	}
	
	public int queryStaffTotlRows(Staff staff){
		int result=-1;
		
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUtil.getConnection();
		StringBuilder sql=new StringBuilder();
		
		sql.append(" select count(*) from staff where 1=1 ");
		if(staff.getStaffNo()!=-1) sql.append(" and staff_no=? ");
		if(!staff.getStaffName().equals("")) sql.append(" and staff_name=? ");
		if(!staff.getStaffCharacter().equals("")) sql.append(" and staff_character=? ");
		
		try {
			st=con.prepareStatement(sql.toString());
			int index=1;
			if(staff.getStaffNo()!=-1) st.setInt(index++, staff.getStaffNo());
			if(!staff.getStaffName().equals("")) st.setString(index++, staff.getStaffName());
			if(!staff.getStaffCharacter().equals("")) st.setString(index++, staff.getStaffCharacter());
			
			rs=st.executeQuery();
			
			if(rs.next()){
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result=-1;
		}
		
		return result;

	}

}
