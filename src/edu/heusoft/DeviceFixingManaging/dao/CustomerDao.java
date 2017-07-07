//MJRT
package edu.heusoft.DeviceFixingManaging.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import edu.heusoft.DeviceFixingManaging.common.DBUtil;
import edu.heusoft.DeviceFixingManaging.javabean.Customer;


public class CustomerDao {
		
	public boolean addCustomer(Customer user)
	{
		boolean result = true;
		
		Connection con = DBUtil.getConnection();
		PreparedStatement st = null;
		
		try {
			st = con.prepareStatement("insert into Customer (customer_idno,customer_visittime ,customer_character ,customer_companyname,customer_housephone,customer_mobilephone,customer_address,customer_postcode,customer_linkman,customer_email) values(?,?,?,?,?,?,?,?,?,?);");

			st.setString(1,user.getCustomer_idno());
			st.setDate(2,new java.sql.Date(user.getCustomer_visittime().getTime()));
			st.setString(3, user.getCustomer_character());
			st.setString(4, user.getCustomer_companyname());
			st.setString(5, user.getCustomer_housephone());
			st.setString(6, user.getCustomer_mobilephone());
			st.setString(7, user.getCustomer_address());
			st.setString(8, user.getCustomer_postcode());
			st.setString(9, user.getCustomer_linkman());
			st.setString(10, user.getCustomer_email());

			if( st.executeUpdate() < 1)	return false;
			
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
		
		finally
		{
			DBUtil.closeResource(st, con);
		}
		
		return result;
	}

	public boolean deleteCustomer(String no)
	{
		boolean result = true;
		
		Connection con = DBUtil.getConnection();
		PreparedStatement st = null;
		
		try {
			st = con.prepareStatement("delete from Customer where customer_idno = ? ");

			st.setString(1, no);
			if( st.executeUpdate() < 1)	return false;
			
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
		
		finally
		{
			DBUtil.closeResource(st, con);
		}
		
		return result;
	}

	public boolean updateCustomer(Customer user)
	{
		boolean result = true;
		
		Connection con = DBUtil.getConnection();
		PreparedStatement st = null;
		String no = user.getCustomer_idno();
		
		StringBuilder sql = new StringBuilder();
		sql.append("update customer set customer_idno = ? ");
// 判断插入的值,从2开始
		
		sql.append(SQLGen(user," , "));
		
		sql.append(" where customer_idno = ? ");
		
		try {
			st = con.prepareStatement(sql.toString());
			st.setString(1, no);
			int index = setSQL(st,user,2);
			
			st.setString(index++, no);

			if( st.executeUpdate() < 1)	return false;
			
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
		
		finally
		{
			DBUtil.closeResource(st, con);
		}
		
		return result;
	}
	
	public ArrayList<Customer> queryCustomer(Customer user,int startPosition,int pageSize)
	{
		ArrayList<Customer> result = new ArrayList<Customer>();
		
		Connection con = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			StringBuilder sql = new StringBuilder();
			sql.append("select * from customer where 1=1 ");
			
			sql.append(SQLGen(user," and "));

				
			sql.append(" limit ? , ? ");
			//System.out.println(sql);
//shang
			try {
				st = con.prepareStatement(sql.toString());
				int index = setSQL(st,user,1);
				
				st.setInt(index++, startPosition);
				st.setInt(index++, pageSize);
		
			} catch (SQLException e) {
		
				e.printStackTrace();
			}

			rs = st.executeQuery();
			
			while(rs.next())
			{
				
				Customer u = new Customer();
				u.setCustomer_idno(rs.getString("customer_idno"));
				u.setCustomer_visittime(rs.getDate("customer_visittime"));
				u.setCustomer_character(rs.getString("customer_character"));
				u.setCustomer_companyname(rs.getString("customer_companyname"));
				u.setCustomer_housephone(rs.getString("customer_housephone"));
				u.setCustomer_mobilephone(rs.getString("customer_mobilephone"));
				u.setCustomer_address(rs.getString("customer_address"));
				u.setCustomer_postcode(rs.getString("customer_postcode"));
				u.setCustomer_linkman(rs.getString("customer_linkman"));
				u.setCustomer_email(rs.getString("customer_email"));
				
				result.add(u);
				//System.out.println(user.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			DBUtil.closeResource(rs, st, con);
		}

		return result;
	}
		
	public int queryCustomerTotalRows(Customer user)
	{
		int result = 0;
		
		Connection con = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*) as cnt from Customer where 1=1 ");		
		sql.append(SQLGen(user," and "));

		try {
			//System.out.println(sql);
			st = con.prepareStatement(sql.toString());
			
			setSQL(st,user,1);
//			System.out.println(u.getName());
			rs = st.executeQuery();
			
			if(rs.next())
			{
				result = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		finally
		{
			DBUtil.closeResource(rs, st, con);
		}

		return result;
	}
	
	private String SQLGen(Customer user, String link)
	{
		StringBuilder sql = new StringBuilder();

		if(!user.getCustomer_idno().equals(""))
		{
			sql.append(link);
			sql.append("  customer_idno = ? ");		
		}
		
		if(user.getCustomer_visittime() != null)
		{
			sql.append(link);
			sql.append("  customer_visittime = ? ");		
		}
		
		if(!user.getCustomer_character().equals(""))
		{
			sql.append(link);
			sql.append("  customer_character = ? ");		
		}
			
		if(!user.getCustomer_companyname().equals(""))
		{
			sql.append(link);
			sql.append("  customer_companyname = ? ");		
		}
		
		if(!user.getCustomer_housephone().equals(""))
		{
			sql.append(link);
			sql.append("  customer_housephone = ? ");		
		}
		
		if(!user.getCustomer_mobilephone().equals(""))
		{
			sql.append(link);
			sql.append("  customer_mobilephone = ? ");		
		}
		
		if(!user.getCustomer_address().equals(""))
		{
			sql.append(link);
			sql.append("  customer_address = ? ");		
		}
		
		if(!user.getCustomer_postcode().equals(""))
		{
			sql.append(link);
			sql.append("  customer_postcode = ? ");		
		}
		
		if(!user.getCustomer_linkman().equals(""))
		{
			sql.append(link);
			sql.append("  customer_linkman = ? ");		
		}
		
		if(!user.getCustomer_email().equals(""))
		{
			sql.append(link);
			sql.append("  customer_email = ? ");		
		}
		
		return  sql.toString();
	}

	private int setSQL (PreparedStatement st, Customer user,int index) throws SQLException
	{
		if(!user.getCustomer_idno().equals(""))
		{
			st.setString(index++,user.getCustomer_idno());
		}
		
		if(user.getCustomer_visittime() != null)
		{
			st.setDate(index++,new java.sql.Date(user.getCustomer_visittime().getTime()));
		}
		
		if(!user.getCustomer_character().equals(""))
		{
			st.setString(index++,user.getCustomer_character());
		}
			
		if(!user.getCustomer_companyname().equals(""))
		{
			st.setString(index++,user.getCustomer_companyname());
		}
		
		if(!user.getCustomer_housephone().equals(""))
		{
			st.setString(index++,user.getCustomer_housephone());
		}
		
		if(!user.getCustomer_mobilephone().equals(""))
		{
			st.setString(index++,user.getCustomer_mobilephone());
		}
		
		if(!user.getCustomer_address().equals(""))
		{
			st.setString(index++,user.getCustomer_address());
		}
		
		if(!user.getCustomer_postcode().equals(""))
		{
			st.setString(index++,user.getCustomer_postcode());
		}
		
		if(!user.getCustomer_linkman().equals(""))
		{
			st.setString(index++,user.getCustomer_linkman());
		}
		
		if(!user.getCustomer_email().equals(""))
		{
			st.setString(index++,user.getCustomer_email());
		}
		
		return index;
	}
	
}
