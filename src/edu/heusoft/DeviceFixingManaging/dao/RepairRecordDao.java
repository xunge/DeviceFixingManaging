//SLIAN
package edu.heusoft.DeviceFixingManaging.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import edu.heusoft.DeviceFixingManaging.common.DBUtil;
import edu.heusoft.DeviceFixingManaging.javabean.RepairRecord;

/**处理repair_record的DAO
 * 
 * @author LZMA
 *
 */
public class RepairRecordDao {

	public boolean addRepairRecord(RepairRecord rr){
		boolean result=false;
		Connection con=null;
		PreparedStatement st=null;
		con=DBUtil.getConnection();
		
		try {
			st=con.prepareStatement
					(" insert into repair_record(repair_person_no,repair_time,test_record,repair_record,repair_test_time,work_amount,person_price,material_price,repair_promise,attention,repair_status,repair_delay,report_record_no) values(?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			if(rr.getRepair_person_no()!=-1){
				st.setInt(1, rr.getRepair_person_no());
			}else{
				st.setNull(1, Types.INTEGER );
			}
			st.setDate(2,new java.sql.Date(rr.getRepair_time().getTime()));
			st.setString(3, rr.getTest_record());
			st.setString(4, rr.getRepair_record());
			st.setDate(5, new java.sql.Date(rr.getRepair_test_time().getTime()));
			st.setString(6, rr.getWork_amount());
			st.setDouble(7, rr.getPerson_price());
			st.setDouble(8, rr.getMaterial_price());
			st.setString(9, rr.getRepair_promise());
			st.setString(10, rr.getAttention());
			st.setString(11, rr.getRepair_status());
			st.setString(12, rr.getRepair_delay());
			st.setInt(13, rr.getReport_record_no());
			
			int r=st.executeUpdate();
			
			if(r!=0) {
				result=true;
			}
			System.out.println(rr.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResource(st, con);
		}
		
		return result;
	}
	
	/**查询满足条件的所有列
	 * 
	 * @param rr
	 * @return
	 */
	public int queryRepairRecordTotalRows(RepairRecord rr){
		int result=-1;
		
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUtil.getConnection();
		StringBuilder sql=new StringBuilder();
		sql.append(" select count(*) from repair_record where 1=1 ");
		if(rr.getRepair_record_no()!=-1) sql.append(" and repair_record_no=? ");
		if(rr.getRepair_person_no()!=-1) sql.append(" and repair_person_no=? ");
		if(rr.getRepair_time()!=null) sql.append(" and repair_time=? ");
		if(!rr.getTest_record().equals("")) sql.append(" and test_record like ? ");
		if(!rr.getRepair_record().equals("")) sql.append(" and repair_record like ? ");
		if(rr.getRepair_test_time()!=null) sql.append(" and repair_test_time=? ");
		if(!rr.getWork_amount().equals("")) sql.append(" and work_amount like ? ");
		if(rr.getPerson_price()!=-1) sql.append(" and person_price=? ");
		if(rr.getMaterial_price()!=-1) sql.append(" and material_price=? ");
		if(!rr.getRepair_promise().equals("")) sql.append(" and repair_promise like ? ");
		if(!rr.getAttention().equals("")) sql.append(" and attention like ? ");
		if(!rr.getRepair_status().equals("")) sql.append(" and repair_status=? ");
		if(!rr.getRepair_delay().equals("")) sql.append(" and repair_delay=? ");
		if(rr.getReport_record_no()!=-1) sql.append(" and report_record_no=? ");
		System.out.println(sql);
		try {
			st=con.prepareStatement(sql.toString());
			int index=1;
			
			if(rr.getRepair_record_no()!=-1) st.setInt(index++, rr.getRepair_record_no());
			if(rr.getRepair_person_no()!=-1) st.setInt(index++, rr.getRepair_person_no());
			if(rr.getRepair_time()!=null) st.setDate(index++, new java.sql.Date(rr.getRepair_time().getTime()));
			if(!rr.getTest_record().equals("")) st.setString(index++, "%"+rr.getTest_record()+"%"); 
			if(!rr.getRepair_record().equals("")) st.setString(index++, "%"+rr.getRepair_record()+"%"); 
			if(rr.getRepair_test_time()!=null) st.setDate(index++, new java.sql.Date(rr.getRepair_test_time().getTime()));
			if(!rr.getWork_amount().equals("")) st.setString(index++, "%"+rr.getWork_amount()+"%"); 
			if(rr.getPerson_price()!=-1) st.setDouble(index++, rr.getPerson_price());
			if(rr.getMaterial_price()!=-1) st.setDouble(index++, rr.getMaterial_price());
			if(!rr.getRepair_promise().equals("")) st.setString(index++, "%"+rr.getRepair_promise()+"%"); 
			if(!rr.getAttention().equals("")) st.setString(index++, "%"+rr.getAttention()+"%"); 
			if(!rr.getRepair_status().equals("")) st.setString(index++, rr.getRepair_status());
			if(!rr.getRepair_delay().equals("")) st.setString(index++, rr.getRepair_delay());
			if(rr.getReport_record_no()!=-1)  st.setInt(index++, rr.getReport_record_no());
			
			rs=st.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result=-1;
		} finally {
			DBUtil.closeResource(rs, st, con);
		}
		
		return result;
	}
	
	/**查询repair_record表
	 * <p>精确匹配repair_record_no/repair_person_no/repair_time/repair_test_time/person_price/material_price/repair_status/repair_delay/report_record_no 
	 * <p>模糊匹配test_record/repair_record/work_amount/repair_promise/attention
	 * 
	 * @param rr 全部属性不忽略
	 * @param startPosition 起始位置
	 * @param pageSize 页面大小
	 * @return 
	 */
	public ArrayList<RepairRecord> queryRepairRecord(RepairRecord rr,int startPosition,int pageSize){
		ArrayList<RepairRecord> result=new ArrayList<RepairRecord>();
		System.out.println(rr);
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUtil.getConnection();
		StringBuilder sql=new StringBuilder();
		sql.append(" select repair_record_no,repair_person_no,repair_time,test_record,repair_record,repair_test_time,work_amount,person_price,material_price,repair_promise,attention,repair_status,repair_delay,report_record_no from repair_record where 1=1 ");
		if(rr.getRepair_record_no()!=-1) sql.append(" and repair_record_no=? ");
		if(rr.getRepair_person_no()!=-1) sql.append(" and repair_person_no=? ");
		if(rr.getRepair_time()!=null) sql.append(" and repair_time=? ");
		if(!rr.getTest_record().equals("")) sql.append(" and test_record like ? ");
		if(!rr.getRepair_record().equals("")) sql.append(" and repair_record like ? ");
		if(rr.getRepair_test_time()!=null) sql.append(" and repair_test_time=? ");
		if(!rr.getWork_amount().equals("")) sql.append(" and work_amount like ? ");
		if(rr.getPerson_price()!=-1) sql.append(" and person_price=? ");
		if(rr.getMaterial_price()!=-1) sql.append(" and material_price=? ");
		if(!rr.getRepair_promise().equals("")) sql.append(" and repair_promise like ? ");
		if(!rr.getAttention().equals("")) sql.append(" and attention like ? ");
		if(!rr.getRepair_status().equals("")) sql.append(" and repair_status=? ");
		if(!rr.getRepair_delay().equals("")) sql.append(" and repair_delay=? ");
		if(rr.getReport_record_no()!=-1) sql.append(" and report_record_no=? ");
		sql.append(" limit ?,? ");
		
		try {
			st=con.prepareStatement(sql.toString());
			int index=1;
			
			if(rr.getRepair_record_no()!=-1) st.setInt(index++, rr.getRepair_record_no());
			if(rr.getRepair_person_no()!=-1) st.setInt(index++, rr.getRepair_person_no());
			if(rr.getRepair_time()!=null) st.setDate(index++, new java.sql.Date(rr.getRepair_time().getTime()));
			if(!rr.getTest_record().equals("")) st.setString(index++, "%"+rr.getTest_record()+"%"); 
			if(!rr.getRepair_record().equals("")) st.setString(index++, "%"+rr.getRepair_record()+"%"); 
			if(rr.getRepair_test_time()!=null) st.setDate(index++, new java.sql.Date(rr.getRepair_test_time().getTime()));
			if(!rr.getWork_amount().equals("")) st.setString(index++, "%"+rr.getWork_amount()+"%"); 
			if(rr.getPerson_price()!=-1) st.setDouble(index++, rr.getPerson_price());
			if(rr.getMaterial_price()!=-1) st.setDouble(index++, rr.getMaterial_price());
			if(!rr.getRepair_promise().equals("")) st.setString(index++, "%"+rr.getRepair_promise()+"%"); 
			if(!rr.getAttention().equals("")) st.setString(index++, "%"+rr.getAttention()+"%"); 
			if(!rr.getRepair_status().equals("")) st.setString(index++, rr.getRepair_status());
			if(!rr.getRepair_delay().equals("")) st.setString(index++, rr.getRepair_delay());
			if(rr.getReport_record_no()!=-1)  st.setInt(index++, rr.getReport_record_no());
			st.setInt(index++, startPosition);
			st.setInt(index++, pageSize);
			
			rs=st.executeQuery();
			
			while(rs.next()){
				RepairRecord rb=new RepairRecord(
						rs.getInt("repair_record_no"),
						rs.getInt("repair_person_no"),
						rs.getDate("repair_time"),
						rs.getString("test_record"),
						rs.getString("repair_record"),
						rs.getDate("repair_test_time"),
						rs.getString("work_amount"),
						rs.getDouble("person_price"),
						rs.getDouble("material_price"),
						rs.getString("repair_promise"),
						rs.getString("attention"),
						rs.getString("repair_status"),
						rs.getString("repair_delay"),
						rs.getInt("report_record_no")
						);
				result.add(rb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result=null;
		} finally {
			DBUtil.closeResource(rs, st, con);
		}
		return result;
	}
	
	
	public boolean updateRepairRecord(RepairRecord rr){
		boolean result=false;
		//若缺少主键直接返回
		if(rr.getRepair_record_no()<=-1){
			System.out.println("RepairRecordDao : Primary key missed while updating.");
			return false;
		}
		
		Connection con=null;
		PreparedStatement st=null;
		
		con=DBUtil.getConnection();
		StringBuilder sql=new StringBuilder();
		sql.append(" update repair_record set repair_record_no=repair_record_no ");
		if(rr.getRepair_person_no()!=-1) sql.append(" , repair_person_no=? ");
		if(rr.getRepair_time()!=null) sql.append(" , repair_time=? ");
		if(!rr.getTest_record().equals("")) sql.append(" , test_record=? ");
		if(!rr.getRepair_record().equals("")) sql.append(" , repair_record=? ");
		if(rr.getRepair_test_time()!=null) sql.append(" , repair_test_time=? ");
		if(!rr.getWork_amount().equals("")) sql.append(" , work_amount=? ");
		if(rr.getPerson_price()!=-1) sql.append(" , person_price=? ");
		if(rr.getMaterial_price()!=-1) sql.append(" , material_price=? ");
		if(!rr.getRepair_promise().equals("")) sql.append(" , repair_promise=? ");
		if(!rr.getAttention().equals("")) sql.append(" , attention=? ");
		if(!rr.getRepair_status().equals("")) sql.append(" , repair_status=? ");
		if(!rr.getRepair_delay().equals("")) sql.append(" , repair_delay=? ");
		if(rr.getReport_record_no()!=-1) sql.append(" and report_record_no=? ");
		sql.append(" where repair_record_no=? ");
		System.out.println(sql);
		
		try {
			st=con.prepareStatement(sql.toString());
			int index=1;
			if(rr.getRepair_person_no()!=-1) st.setInt(index++, rr.getRepair_person_no());
			if(rr.getRepair_time()!=null) st.setDate(index++, new java.sql.Date(rr.getRepair_time().getTime()));
			if(!rr.getTest_record().equals("")) st.setString(index++, rr.getTest_record());
			if(!rr.getRepair_record().equals("")) st.setString(index++, rr.getRepair_record());
			if(rr.getRepair_test_time()!=null) st.setDate(index++, new java.sql.Date(rr.getRepair_test_time().getTime()));
			if(!rr.getWork_amount().equals("")) st.setString(index++, rr.getWork_amount());
			if(rr.getPerson_price()!=-1) st.setDouble(index++, rr.getPerson_price());
			if(rr.getMaterial_price()!=-1) st.setDouble(index++, rr.getMaterial_price());
			if(!rr.getRepair_promise().equals("")) st.setString(index++, rr.getRepair_promise());
			if(!rr.getAttention().equals("")) st.setString(index++, rr.getAttention());
			if(!rr.getRepair_status().equals("")) st.setString(index++, rr.getRepair_status());
			if(!rr.getRepair_delay().equals("")) st.setString(index++, rr.getRepair_delay());
			if(rr.getReport_record_no()!=-1)  st.setInt(index++, rr.getReport_record_no());
			st.setInt(index++, rr.getRepair_record_no());
			
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

	public int getLastId()
	{
		int result = -1;
		Connection con=DBUtil.getConnection();
		PreparedStatement st=null;
		ResultSet rs=null;

		try {
			st=con.prepareStatement(" select repair_record_no AS id from repair_record  order by  repair_record_no DESC; ");
			rs = st.executeQuery();
			if(rs.next())
			{
				result = rs.getInt("id");
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

}
