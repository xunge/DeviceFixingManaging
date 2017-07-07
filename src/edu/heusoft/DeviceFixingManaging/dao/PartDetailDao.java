//gongyuxin
//MODIFIED BY SLIAN ON 20160726
package edu.heusoft.DeviceFixingManaging.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.heusoft.DeviceFixingManaging.common.DBUtil;
import edu.heusoft.DeviceFixingManaging.javabean.Part;
import edu.heusoft.DeviceFixingManaging.javabean.PartDetail;


public class PartDetailDao {
   
	public boolean addPartDetail(PartDetail pd)
	{
		boolean result=true;
		
		Connection con=null;
		PreparedStatement st=null;
		con=DBUtil.getConnection();
		try {
			st=con.prepareStatement("insert into "
					+ "part_detail(part_no,part_detail_num,part_detail_status,repair_record_no) "
					+ "values(?,?,?,?)");
			st.setInt(1, pd.getPart_no());
			st.setInt(2, pd.getPart_detail_num());
			st.setString(3, pd.getPart_detail_status());
			st.setInt(4, pd.getRepair_record_no());
			
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
	
	public ArrayList<PartDetail> queryPartDetail(PartDetail pd,int start,int size)
	{
		ArrayList<PartDetail> result=new ArrayList<PartDetail>();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUtil.getConnection();
		
		try {
			StringBuilder sql=new StringBuilder();
			sql.append(" select * from part_detail where 1=1 ");

			if(pd.getPart_detail_no()!=-1)
			{
				sql.append(" and part_detail_no=? ");
			}
			if(pd.getPart_no()!=-1)
			{
				sql.append(" and  part_no= ? ");
			}
			if(pd.getPart_detail_num()!=-1)
			{
				sql.append(" and part_detail_num=? ");
			}
			if(!pd.getPart_detail_status().equals(""))
			{
				sql.append(" and part_detail_status = ? ");
			}
			if(pd.getRepair_record_no()!=-1){
				sql.append(" and repair_record_no=? ");
			}


			sql.append(" limit ?,? ");

			st=con.prepareStatement(sql.toString());
			int index=1;
			if(pd.getPart_detail_no()!=-1)
			{
				st.setInt(index++,pd.getPart_detail_no());
			}
			if(pd.getPart_no()!=-1)
			{
				st.setInt(index++,pd.getPart_no());
			}
			if(pd.getPart_detail_num()!=-1)
			{
				st.setInt(index++,pd.getPart_detail_num());
			}  
			if(!pd.getPart_detail_status().equals(""))
			{
				st.setString(index++, pd.getPart_detail_status());
			}
			if(pd.getRepair_record_no()!=-1){
				st.setInt(index++, pd.getRepair_record_no());
			}

			st.setInt(index++, start);
			st.setInt(index++, size);

			rs=st.executeQuery();

			while(rs.next())
			{
				PartDetail pd1=new PartDetail();
				pd1.setPart_detail_no(rs.getInt("part_detail_no"));
				pd1.setPart_no(rs.getInt("part_no"));
				pd1.setPart_detail_num(rs.getInt("part_detail_num"));
				pd1.setPart_detail_status(rs.getString("part_detail_status"));
				pd1.setRepair_record_no(rs.getInt("repair_record_no"));
				result.add(pd1);
			}    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			DBUtil.closeResource(rs, st,con);
		}
		return result;
	}
	
	
	
	public int queryPartDetailTotalRows(PartDetail pd)
	{
		int result=0;
		
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUtil.getConnection();
		
		try {
			StringBuilder sql=new StringBuilder();
			sql.append(" select count(*) from part_detail where 1=1 ");

			if(pd.getPart_detail_no()!=-1)
			{
				sql.append(" and part_detail_no=? ");
			}
			if(pd.getPart_no()!=-1)
			{
				sql.append(" and  part_no= ? ");
			}
			if(pd.getPart_detail_num()!=-1)
			{
				sql.append(" and part_detail_num=? ");
			}
			if(!pd.getPart_detail_status().equals(""))
			{
				sql.append(" and part_detail_status = ? ");
			}
			if(pd.getRepair_record_no()!=-1){
				sql.append(" and repair_record_no=? ");
			}
			
			st=con.prepareStatement(sql.toString());
			int index=1;
			if(pd.getPart_detail_no()!=-1)
			{
				st.setInt(index++,pd.getPart_detail_no());
			}
			if(pd.getPart_no()!=-1)
			{
				st.setInt(index++,pd.getPart_no());
			}
			if(pd.getPart_detail_num()!=-1)
			{
				st.setInt(index++,pd.getPart_detail_num());
			}  
			if(!pd.getPart_detail_status().equals(""))
			{
				st.setString(index++, pd.getPart_detail_status());
			}
			if(pd.getRepair_record_no()!=-1){
				st.setInt(index++, pd.getRepair_record_no());
			}
			
			rs=st.executeQuery();

			if(rs.next())
			{
				result=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally
		{
			DBUtil.closeResource(rs, st,con);
		}
		return result;
	}
	
	public boolean updatePartDetail(int part_detail_no, String part_detail_status){
		boolean result=false;
		//若未指定主键直接返回false
		if(part_detail_no<=-1){
			return false;
		}
		Connection con=null;
		PreparedStatement st=null;
		
		con=DBUtil.getConnection();
		StringBuilder sql=new StringBuilder();
		
		//Auto-renew Part_warn_num column
//		if(part.getPart_num()>part.getPart_warn_num()){
//			part.setPart_status("正常");
//		} else if(part.getPart_num()==part.getPart_warn_num()) {
//			part.setPart_status("警戒");
//		} else if(part.getPart_num()<part.getPart_warn_num()&&part.getPart_num()!=0){
//			part.setPart_status("警示");
//		} else if(part.getPart_num()==0){
//			part.setPart_status("缺货");
//		} else {
//			System.out.println("PartDao : part_num<0 when adding!");
//		}
		
		sql.append(" update part_detail set part_detail_no=part_detail_no ");
		sql.append(" , part_detail_status=? ");
//		if(!part.getPart_size().equals("")) sql.append(" , part_size=? ");
//		if(part.getPart_price()!=-1) sql.append(" , part_price=? ");
//		if(part.getPart_num()!=-1) sql.append(" , part_num=? ");
//		if(!part.getPart_status().equals("")) sql.append(" , part_status=? ");
//		if(part.getPart_warn_num()!=-1)sql.append(" , part_warn_num=? ");
		sql.append(" where part_detail_no=? ");
		//System.out.println(sql.toString());
		
		try {
			st=con.prepareStatement(sql.toString());
			
			int index=1;
			st.setString(index++, part_detail_status);
			st.setInt(index++, part_detail_no);
			
			
			
			int r=st.executeUpdate();
			if(r!=0){
				result=true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			result=false;
		} finally {
			DBUtil.closeResource(st, con);
		}
		return result;
	}
}
