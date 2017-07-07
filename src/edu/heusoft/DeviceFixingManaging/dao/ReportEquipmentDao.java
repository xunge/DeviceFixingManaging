//MODIFIED BY SLIAN ON 20160726
package edu.heusoft.DeviceFixingManaging.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.heusoft.DeviceFixingManaging.common.DBUtil;
import edu.heusoft.DeviceFixingManaging.javabean.ReportEquipment;


public class ReportEquipmentDao {
   
	public boolean addReportEquipment(ReportEquipment user)
	{
		boolean result=true;
		
		Connection con=null;
		PreparedStatement st=null;
		con=DBUtil.getConnection();
		try {
			st=con.prepareStatement("insert into "
					+ "report_equipment("
					+ "product_type,"
					+ "report_equip_brand,"
					+ "report_equip_model,"
					+ "report_equip_series,"
					+ "report_equip_absent,"
					+ "report_equip_problem,"
					+ "report_equip_problem_type,"
					+ "report_equip_appearance,"
					+ "report_equip_password,"
					+ "report_equip_data,"
					+ "report_equip_hdd,"
					+ "report_equip_memory,"
					+ "report_equip_pc,"
					+ "report_equip_ac,"
					+ "report_equip_battery,"
					+ "report_equip_cd) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			st.setString(1, user.getProduct_type());
			st.setString(2, user.getReport_equip_brand());
			st.setString(3, user.getReport_equip_model());
			st.setString(4, user.getReport_equip_series());
			st.setString(5, user.getReport_equip_absent());
			st.setString(6, user.getReport_equip_problem());
			st.setString(7, user.getReport_equip_problem_type());
			st.setString(8, user.getReport_equip_appearance());
			st.setString(9, user.getReport_equip_password());
			st.setString(10, user.getReport_equip_data());
			st.setString(11, user.getReport_equip_hdd());
			st.setString(12, user.getReport_equip_memory());
			st.setString(13, user.getReport_equip_pc());
			st.setString(14, user.getReport_equip_ac());
			st.setString(15, user.getReport_equip_battery());
			st.setString(16, user.getReport_equip_cd());
			
			int i=st.executeUpdate();
			if(i<1)
			{
				result=false;
			}
			
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}	
		return result;
	}

	public ArrayList<ReportEquipment> queryEquipment(ReportEquipment re,int start,int size)
	{
		ArrayList<ReportEquipment> result=new ArrayList<ReportEquipment>();
		
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUtil.getConnection();
		
		try {
			StringBuilder sql=new StringBuilder();
			sql.append(" select * from report_equipment where 1=1 ");

			if(re.getReport_equip_no()!=-1){ //ADDED ON 20160726
				sql.append(" and report_equip_no=? ");
			}
			if(!re.getProduct_type().equals(""))
			{
				sql.append("and product_type=?");
			}
			if(!re.getReport_equip_brand().equals(""))
			{
				sql.append("and  report_equip_brand = ?");
			}
			if(!re.getReport_equip_model().equals(""))
			{
				sql.append("and report_equip_model = ?");
			}
			if(!re.getReport_equip_series().equals(""))
			{
				sql.append("and  report_equip_series = ?");
			}
			if(!re.getReport_equip_absent().equals(""))
			{
				sql.append("and report_equip_absent=?");
			}
			if(!re.getReport_equip_problem().equals(""))
			{
				sql.append("and  report_equip_problem = ?");
			}
			if(!re.getReport_equip_problem_type().equals(""))
			{
				sql.append("and report_equip_problem_type=?");
			}
			if(!re.getReport_equip_appearance().equals(""))
			{
				sql.append("and  report_equip_appearance = ?");
			}
			if(!re.getReport_equip_password().equals(""))
			{
				sql.append("and report_equip_password=?");
			}
			if(!re.getReport_equip_data().equals(""))
			{
				sql.append("and  report_equip_data = ?");
			}
			if(!re.getReport_equip_hdd().equals(""))
			{
				sql.append("and report_equip_hdd=?");
			}
			if(!re.getReport_equip_memory().equals(""))
			{
				sql.append("and  report_equip_memory = ?");
			}
			if(!re.getReport_equip_pc().equals(""))
			{
				sql.append("and report_equip_pc=?");
			}
			if(!re.getReport_equip_ac().equals(""))
			{
				sql.append("and  report_equip_ac = ?");
			}
			if(!re.getReport_equip_battery().equals(""))
			{
				sql.append("and report_equip_battery=?");
			}
			if(!re.getReport_equip_cd().equals(""))
			{
				sql.append("and  report_equip_cd = ?");
			}

			sql.append(" limit ?,? ");

			st=con.prepareStatement(sql.toString());
			int index=1;
			if(re.getReport_equip_no()!=-1){
				st.setInt(index++, re.getReport_equip_no());
			}
			if(!re.getProduct_type().equals(""))
			{
				st.setString(index++,re.getProduct_type());
			}
			if(!re.getReport_equip_brand().equals(""))
			{
				st.setString(index++,re.getReport_equip_brand());		      
			}
			if(!re.getReport_equip_model().equals(""))
			{
				st.setString(index++,re.getReport_equip_model());		  
			}
			if(!re.getReport_equip_series().equals(""))
			{
				st.setString(index++,re.getReport_equip_series());		      
			}
			if(!re.getReport_equip_absent().equals(""))
			{
				st.setString(index++,re.getReport_equip_absent());		      
			}
			if(!re.getReport_equip_problem().equals(""))
			{
				st.setString(index++,re.getReport_equip_problem());		      
			}
			if(!re.getReport_equip_problem_type().equals(""))
			{
				st.setString(index++,re.getReport_equip_problem_type());		      
			}
			if(!re.getReport_equip_appearance().equals(""))
			{
				st.setString(index++,re.getReport_equip_appearance());		      
			}
			if(!re.getReport_equip_password().equals(""))
			{
				st.setString(index++,re.getReport_equip_password());		      
			}
			if(!re.getReport_equip_data().equals(""))
			{
				st.setString(index++,re.getReport_equip_data());		      
			}
			if(!re.getReport_equip_hdd().equals(""))
			{
				st.setString(index++,re.getReport_equip_hdd());		      
			}
			if(!re.getReport_equip_memory().equals(""))
			{
				st.setString(index++,re.getReport_equip_memory());		      
			}
			if(!re.getReport_equip_pc().equals(""))
			{
				st.setString(index++,re.getReport_equip_pc());		      
			}
			if(!re.getReport_equip_ac().equals(""))
			{
				st.setString(index++,re.getReport_equip_ac());		      
			}
			if(!re.getReport_equip_battery().equals(""))
			{
				st.setString(index++,re.getReport_equip_battery());		      
			}
			if(!re.getReport_equip_cd().equals(""))
			{
				st.setString(index++,re.getReport_equip_cd());		      
			}


			st.setInt(index++, start);
			st.setInt(index++, size);

			rs=st.executeQuery();

			while(rs.next())
			{
				ReportEquipment re1=new ReportEquipment();
				re1.setReport_equip_no(rs.getInt("report_equip_no"));
				re1.setProduct_type(rs.getString("product_type"));
				re1.setReport_equip_brand(rs.getString("report_equip_brand"));
				re1.setReport_equip_model(rs.getString("report_equip_model"));
				re1.setReport_equip_series(rs.getString("report_equip_series"));
				re1.setReport_equip_absent(rs.getString("report_equip_absent"));
				re1.setReport_equip_problem(rs.getString("report_equip_problem"));
				re1.setReport_equip_problem_type(rs.getString("report_equip_problem_type"));
				re1.setReport_equip_appearance(rs.getString("report_equip_appearance"));
				re1.setReport_equip_password(rs.getString("report_equip_password"));
				re1.setReport_equip_data(rs.getString("report_equip_data"));
				re1.setReport_equip_hdd(rs.getString("report_equip_hdd"));
				re1.setReport_equip_memory(rs.getString("report_equip_memory"));
				re1.setReport_equip_pc(rs.getString("report_equip_pc"));
				re1.setReport_equip_ac(rs.getString("report_equip_ac"));
				re1.setReport_equip_battery(rs.getString("report_equip_battery"));
				re1.setReport_equip_cd(rs.getString("report_equip_cd"));

				result.add(re1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
		   DBUtil.closeResource(rs, st,con);
		}
		return result;
	}
	
	

	public int queryReportEquipmentTotalRows(ReportEquipment re)
	{
		int result=0;
		
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUtil.getConnection();
		
		try 
		{
			StringBuilder sql=new StringBuilder();
			sql.append(" select count(*) from report_equipment where 1=1 ");

			if(!re.getProduct_type().equals(""))
			{
				sql.append("and product_type=?");
			}
			if(!re.getReport_equip_brand().equals(""))
			{
				sql.append("and  report_equip_brand = ?");
			}
			if(!re.getReport_equip_model().equals(""))
			{
				sql.append("and report_equip_model = ?");
			}
			if(!re.getReport_equip_series().equals(""))
			{
				sql.append("and  report_equip_series = ?");
			}
			if(!re.getReport_equip_absent().equals(""))
			{
				sql.append("and report_equip_absent=?");
			}
			if(!re.getReport_equip_problem().equals(""))
			{
				sql.append("and  report_equip_problem = ?");
			}
			if(!re.getReport_equip_problem_type().equals(""))
			{
				sql.append("and report_equip_problem_type=?");
			}
			if(!re.getReport_equip_appearance().equals(""))
			{
				sql.append("and  report_equip_appearance = ?");
			}
			if(!re.getReport_equip_password().equals(""))
			{
				sql.append("and report_equip_password=?");
			}
			if(!re.getReport_equip_data().equals(""))
			{
				sql.append("and  report_equip_data = ?");
			}
			if(!re.getReport_equip_hdd().equals(""))
			{
				sql.append("and report_equip_hdd=?");
			}
			if(!re.getReport_equip_memory().equals(""))
			{
				sql.append("and  report_equip_memory = ?");
			}
			if(!re.getReport_equip_pc().equals(""))
			{
				sql.append("and report_equip_pc=?");
			}
			if(!re.getReport_equip_ac().equals(""))
			{
				sql.append("and  report_equip_ac = ?");
			}
			if(!re.getReport_equip_battery().equals(""))
			{
				sql.append("and report_equip_battery=?");
			}
			if(!re.getReport_equip_cd().equals(""))
			{
				sql.append("and  report_equip_cd = ?");
			}
			st=con.prepareStatement(sql.toString());
			int index=1;
			if(!re.getProduct_type().equals(""))
			{
				st.setString(index++,re.getProduct_type());
			}
			if(!re.getReport_equip_brand().equals(""))
			{
				st.setString(index++,re.getReport_equip_brand());		      
			}
			if(!re.getReport_equip_model().equals(""))
			{
				st.setString(index++,re.getReport_equip_model());		  
			}
			if(!re.getReport_equip_series().equals(""))
			{
				st.setString(index++,re.getReport_equip_series());		      
			}
			if(!re.getReport_equip_absent().equals(""))
			{
				st.setString(index++,re.getReport_equip_absent());		      
			}
			if(!re.getReport_equip_problem().equals(""))
			{
				st.setString(index++,re.getReport_equip_problem());		      
			}
			if(!re.getReport_equip_problem_type().equals(""))
			{
				st.setString(index++,re.getReport_equip_problem_type());		      
			}
			if(!re.getReport_equip_appearance().equals(""))
			{
				st.setString(index++,re.getReport_equip_appearance());		      
			}
			if(!re.getReport_equip_password().equals(""))
			{
				st.setString(index++,re.getReport_equip_password());		      
			}
			if(!re.getReport_equip_data().equals(""))
			{
				st.setString(index++,re.getReport_equip_data());		      
			}
			if(!re.getReport_equip_hdd().equals(""))
			{
				st.setString(index++,re.getReport_equip_hdd());		      
			}
			if(!re.getReport_equip_memory().equals(""))
			{
				st.setString(index++,re.getReport_equip_memory());		      
			}
			if(!re.getReport_equip_pc().equals(""))
			{
				st.setString(index++,re.getReport_equip_pc());		      
			}
			if(!re.getReport_equip_ac().equals(""))
			{
				st.setString(index++,re.getReport_equip_ac());		      
			}
			if(!re.getReport_equip_battery().equals(""))
			{
				st.setString(index++,re.getReport_equip_battery());		      
			}
			if(!re.getReport_equip_cd().equals(""))
			{
				st.setString(index++,re.getReport_equip_cd());		      
			}
			rs=st.executeQuery();

			if(rs.next())
			{
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally
		{
			DBUtil.closeResource(rs, st,con);
		}
		return result;
	}
	
	
	

	
	public boolean updateReportEquipment(ReportEquipment re)
	{
		boolean result = true;
		Connection con = DBUtil.getConnection();
		PreparedStatement st = null;
		
		int no = re.getReport_equip_no();
		
		if(re.getReport_equip_no() == 0)
			return false;
		
		StringBuilder sql = new StringBuilder();
		sql.append("update report_equipment set report_equip_no=report_equip_no  ");

		boolean flag = false;
		
		if(!re.getProduct_type().equals(""))
		{
			sql.append(", product_type=?");
			flag = true;
		}
		if(!re.getReport_equip_brand().equals(""))
		{
			sql.append(",  report_equip_brand = ?");
			flag = true;
		}
		if(!re.getReport_equip_model().equals(""))
		{
			sql.append(", report_equip_model = ?");
			flag = true;
		}
		if(!re.getReport_equip_series().equals(""))
		{
			sql.append(",  report_equip_series = ?");
			flag = true;
		}
		if(!re.getReport_equip_absent().equals(""))
		{
			sql.append(", report_equip_absent=?");
			flag = true;
		}
		if(!re.getReport_equip_problem().equals(""))
		{
			sql.append(",  report_equip_problem = ?");
			flag = true;
		}
		if(!re.getReport_equip_problem_type().equals(""))
		{
			sql.append(", report_equip_problem_type=?");
			flag = true;
		}
		if(!re.getReport_equip_appearance().equals(""))
		{
			sql.append(",  report_equip_appearance = ?");
			flag = true;
		}
		if(!re.getReport_equip_password().equals(""))
		{
			sql.append(", report_equip_password=?");
			flag = true;
		}
		if(!re.getReport_equip_data().equals(""))
		{
			sql.append(",  report_equip_data = ?");
			flag = true;
		}
		if(!re.getReport_equip_hdd().equals(""))
		{
			sql.append(", report_equip_hdd=?");
			flag = true;
		}
		if(!re.getReport_equip_memory().equals(""))
		{
			sql.append(",  report_equip_memory = ?");
			flag = true;
		}
		if(!re.getReport_equip_pc().equals(""))
		{
			sql.append(", report_equip_pc=?");
			flag = true;
		}
		if(!re.getReport_equip_ac().equals(""))
		{
			sql.append(",  report_equip_ac = ?");
			flag = true;
		}
		if(!re.getReport_equip_battery().equals(""))
		{
			sql.append(", report_equip_battery=?");
			flag = true;
		}
		if(!re.getReport_equip_cd().equals(""))
		{
			sql.append(",  report_equip_cd = ?");
			flag = true;
		}
		
		
		if(flag == false)
			return false;
		
		sql.append(" where report_equip_no = ? ");
		
		try {
			st = con.prepareStatement(sql.toString());
			int index = 1;
			
			if(!re.getProduct_type().equals(""))
			{
				st.setString(index++,re.getProduct_type());
			}
			if(!re.getReport_equip_brand().equals(""))
			{
				st.setString(index++,re.getReport_equip_brand());		      
			}
			if(!re.getReport_equip_model().equals(""))
			{
				st.setString(index++,re.getReport_equip_model());		  
			}
			if(!re.getReport_equip_series().equals(""))
			{
				st.setString(index++,re.getReport_equip_series());		      
			}
			if(!re.getReport_equip_absent().equals(""))
			{
				st.setString(index++,re.getReport_equip_absent());		      
			}
			if(!re.getReport_equip_problem().equals(""))
			{
				st.setString(index++,re.getReport_equip_problem());		      
			}
			if(!re.getReport_equip_problem_type().equals(""))
			{
				st.setString(index++,re.getReport_equip_problem_type());		      
			}
			if(!re.getReport_equip_appearance().equals(""))
			{
				st.setString(index++,re.getReport_equip_appearance());		      
			}
			if(!re.getReport_equip_password().equals(""))
			{
				st.setString(index++,re.getReport_equip_password());		      
			}
			if(!re.getReport_equip_data().equals(""))
			{
				st.setString(index++,re.getReport_equip_data());		      
			}
			if(!re.getReport_equip_hdd().equals(""))
			{
				st.setString(index++,re.getReport_equip_hdd());		      
			}
			if(!re.getReport_equip_memory().equals(""))
			{
				st.setString(index++,re.getReport_equip_memory());		      
			}
			if(!re.getReport_equip_pc().equals(""))
			{
				st.setString(index++,re.getReport_equip_pc());		      
			}
			if(!re.getReport_equip_ac().equals(""))
			{
				st.setString(index++,re.getReport_equip_ac());		      
			}
			if(!re.getReport_equip_battery().equals(""))
			{
				st.setString(index++,re.getReport_equip_battery());		      
			}
			if(!re.getReport_equip_cd().equals(""))
			{
				st.setString(index++,re.getReport_equip_cd());		      
			}
			
			
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
	
	public int getLastId()
	{
		int result = -1;
		Connection con=con=DBUtil.getConnection();
		PreparedStatement st=null;
		ResultSet rs=null;

		try {
			st=con.prepareStatement(" select report_equip_no AS id from Report_Equipment  order by  report_equip_no DESC; ");
			rs = st.executeQuery();
			if(rs.next())
			{
				result = rs.getInt("id");
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
}
