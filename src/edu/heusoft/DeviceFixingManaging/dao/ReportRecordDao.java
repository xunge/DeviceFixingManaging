package edu.heusoft.DeviceFixingManaging.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.heusoft.DeviceFixingManaging.common.DBUtil;
import edu.heusoft.DeviceFixingManaging.javabean.ReportRecord;

public class ReportRecordDao {
	public boolean addReportRecord(ReportRecord user)
	{
		boolean result = true;
		
		Connection con = DBUtil.getConnection();
		PreparedStatement st = null;
		
		try {
			st = con.prepareStatement("insert into report_record (customer_idno ,report_equip_no ,report_time,predict_price,predict_complete_time,report_status) values(?,?,?,?,?,?);");

			st.setString(1,user.getCustomer_idno());
			st.setInt(2, user.getReport_equip_no());
			st.setDate(3,new java.sql.Date(user.getReport_time().getTime()) );
			st.setInt(4, user.getPredict_price());
			st.setDate(5, new java.sql.Date(user.getPredict_complete_time().getTime()));
			st.setString(6, user.getReport_status());
			
			
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

	public boolean updateReportRecord(ReportRecord user)
	{
		boolean result = true;
		
		Connection con = DBUtil.getConnection();
		PreparedStatement st = null;
		int no = user.getReport_record_no();
		
		if(no == -1)
			return false;
			
		StringBuilder sql = new StringBuilder();
		sql.append("update report_record set report_record_no = ? ");
// 判断插入的值,从2开始
		sql.append(SQLGen(user," , "));
		
		sql.append(" where report_record_no = ? ");
		
		try {
			st = con.prepareStatement(sql.toString());
			st.setInt(1, no);
			int index = setSQL(st,user,2);
			
			st.setInt(index++, no);

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

	public ArrayList<ReportRecord> queryReportRecord(ReportRecord user,int startPosition,int pageSize)
	{
		ArrayList<ReportRecord> result = new ArrayList<ReportRecord>();
		
		Connection con = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			StringBuilder sql = new StringBuilder();
			sql.append("select * from report_record where 1=1 ");

			if(user.getReport_record_no() != -1)
			{
				sql.append(" and ");
				sql.append("  report_record_no = ? ");		
			}
			
			sql.append(SQLGen(user," and "));
	
				
			sql.append(" limit ? , ? ");
//			System.out.println(sql);
			
			try {
				st = con.prepareStatement(sql.toString());
				int index = 1;
				if(user.getReport_record_no() != -1){
					st.setInt(index++,user.getReport_record_no());
				}
				index=setSQL(st,user,index);
				
				st.setInt(index++, startPosition);
				st.setInt(index++, pageSize);
		
			} catch (SQLException e) {
		
				e.printStackTrace();
			}

			rs = st.executeQuery();
			
			while(rs.next())
			{
				ReportRecord u = new ReportRecord();
				u.setReport_record_no(rs.getInt("report_record_no"));
				u.setCustomer_idno(rs.getString("customer_idno"));
				u.setReport_equip_no(rs.getInt("report_equip_no"));
				u.setReport_time(rs.getDate("report_time"));
				u.setPredict_price(rs.getInt("predict_price"));
				u.setPredict_complete_time(rs.getDate("predict_complete_time"));
				u.setReport_status(rs.getString("report_status"));
				
				result.add(u);
				//System.out.println(user.toString());
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
		
	public int queryReportRecordTotalRows(ReportRecord user)
	{
		int result = 0;
		
		Connection con = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*) as cnt from report_record where 1=1 ");	
		
		if(user.getReport_record_no() != -1)
		{
			sql.append(" and ");
			sql.append("  report_record_no = ? ");		
		}
		
		sql.append(SQLGen(user," and "));

		try {
			//System.out.println(sql);
			st = con.prepareStatement(sql.toString());
			int index=1;
			if(user.getReport_record_no() != -1)
			{
				st.setInt(index++,user.getReport_record_no());
			}
			setSQL(st,user,index);
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
	
	
	private String SQLGen(ReportRecord user, String link)
	{
		StringBuilder sql = new StringBuilder();

		if(!user.getCustomer_idno().equals(""))
		{
			sql.append(link);
			sql.append("  customer_idno = ? ");		
		}
			
		if(user.getReport_equip_no() != -1)
		{
			sql.append(link);
			sql.append("  report_equip_no = ? ");		
		}
		
		if(user.getReport_time() != null)
		{
			sql.append(link);
			sql.append("  report_time = ? ");		
		}	
		
		if(user.getPredict_price() != -1)
		{
			sql.append(link);
			sql.append("  predict_price = ? ");		
		}
		
		if(user.getPredict_complete_time() != null)
		{
			sql.append(link);
			sql.append("  predict_complete_time = ? ");		
		}		
		
		if(!user.getReport_status().equals(""))
		{
			sql.append(link);
			sql.append("  report_status = ? ");		
		}
		
		return  sql.toString();
	}

	private int setSQL (PreparedStatement st, ReportRecord user,int index) throws SQLException
	{
		
		if(!user.getCustomer_idno().equals(""))
		{
			st.setString(index++,user.getCustomer_idno());
		}
			
		if(user.getReport_equip_no() != -1)
		{
			st.setInt(index++,user.getReport_equip_no());
		}
		
		if(user.getReport_time() != null)
		{
			st.setDate(index++,new java.sql.Date(user.getReport_time().getTime()));
		}
		
		if(user.getPredict_price() != -1)
		{
			st.setInt(index++,user.getPredict_price());
		}
		
		if(user.getPredict_complete_time() != null)
		{
			st.setDate(index++,new java.sql.Date(user.getPredict_complete_time().getTime()));
		}
		
		if(!user.getReport_status().equals(""))
		{
			st.setString(index++,user.getReport_status());
		}
		
		return index;
	}
	
	public int getLastId()
	{
		int result = -1;
		Connection con=DBUtil.getConnection();
		PreparedStatement st=null;
		ResultSet rs=null;

		try {
			st=con.prepareStatement(" select report_record_no AS id from report_record  order by  report_record_no DESC; ");
			rs = st.executeQuery();
			if(rs.next())
			{
				result = rs.getInt("id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("id-ex");
			e.printStackTrace();
		}
		
		finally
		{
			DBUtil.closeResource(rs, st, con);
		}
		
		return result;
	}
}
