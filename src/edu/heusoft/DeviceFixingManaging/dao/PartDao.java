//SLIAN
package edu.heusoft.DeviceFixingManaging.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.heusoft.DeviceFixingManaging.common.DBUtil;
import edu.heusoft.DeviceFixingManaging.javabean.Part;

/**操作Part表的DAO。
 * 
 * @author LZMA
 *
 */
public class PartDao {
	
	/**向Part表中添加行。
	 * <p>由于part_warn_num列会自动设值，Bean中此列将忽略。
	 * 
	 * @param part
	 * @return
	 */
	public boolean addPart(Part part){
		
		boolean result = true;
		Connection con=null;
		PreparedStatement st=null;
		
		con=DBUtil.getConnection();
		try {
			st=con.prepareStatement
					(" insert into part(part_name,part_size,part_price,part_num,part_warn_num,part_status) values(?,?,?,?,?,?) ");
			st.setString(1, part.getPart_name());
			st.setString(2, part.getPart_size());
			st.setDouble(3, part.getPart_price());
			st.setInt(4, part.getPart_num());
			st.setInt(5, part.getPart_warn_num());

			//Auto-renew Part_warn_num column
			if(part.getPart_num()>part.getPart_warn_num()){
				st.setString(6, "正常");
			} else if(part.getPart_num()==part.getPart_warn_num()) {
				st.setString(6, "警戒");
			} else if(part.getPart_num()<part.getPart_warn_num()&&part.getPart_num()!=0){
				st.setString(6, "警示");
			} else if(part.getPart_num()==0){
				st.setString(6, "缺货");
			} else {
				System.out.println("PartDao : part_num<0 when adding!");
				throw new SQLException();
			}
			
			int r=st.executeUpdate();
			if(r==0){
				result=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result=false;
		} finally {
			DBUtil.closeResource(st, con);
		}
		
		return result;
	}
	
	
	public int queryPartTotalRows(Part part){
		int result=0;
		
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUtil.getConnection();
		StringBuilder sql=new StringBuilder();
		sql.append(" select count(*) from part where 1=1 ");
		if(!part.getPart_name().equals("")) sql.append(" and part_name=? ");
		if(!part.getPart_size().equals("")) sql.append(" and part_size=? ");
		if(part.getPart_price()!=-1) sql.append(" and part_price=? ");
		if(part.getPart_num()!=-1) sql.append(" and part_num=? ");
		if(!part.getPart_status().equals("")) sql.append(" and part_status=? ");
		
		try {
			st=con.prepareStatement(sql.toString());
			int index=1;
			if(!part.getPart_name().equals("")) st.setString(index++, part.getPart_name());
			if(!part.getPart_size().equals("")) st.setString(index++, part.getPart_size());
			if(part.getPart_price()!=-1) st.setDouble(index++, part.getPart_price());
			if(part.getPart_num()!=-1) st.setInt(index++, part.getPart_num());
			if(!part.getPart_status().equals("")) st.setString(index++, part.getPart_status());
			
			rs=st.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResource(rs, st, con);
		}
		
		return result;
	}
	
	/**��ҳ��ѯpart���DAO������������part_no�� part_warn_num�С�
	 * 
	 * <p>ע������ȫ����ֵ����Ĭ��ֵΪ0.���������Щ����Ҫ�ֶ�����Ϊ-1��
	 * 
	 * @param part �ṩ��ѯ������������part_no���ԡ�
	 * @param startPosition ��ʼλ�á�
	 * @param pageSize ÿҳ��ʾԪ��������
	 * @return ĳҳ��ȫ��Part���ɵ�ArrayList��
	 */
	
	public ArrayList<Part> queryPart(Part part,int startPosition,int pageSize){
		ArrayList<Part> result=new ArrayList<Part>();
		
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUtil.getConnection();
		StringBuilder sql=new StringBuilder();
		sql.append(" select part_no,part_name,part_size,part_price,part_num,part_warn_num,part_status from part where 1=1 ");
		if(!part.getPart_name().equals("")) sql.append(" and part_name=? ");
		if(!part.getPart_size().equals("")) sql.append(" and part_size=? ");
		if(part.getPart_price()!=-1) sql.append(" and part_price=? ");
		if(part.getPart_num()!=-1) sql.append(" and part_num=? ");
		if(!part.getPart_status().equals("")) sql.append(" and part_status=? ");
		sql.append(" limit ?,? ");
		
		try {
			st=con.prepareStatement(sql.toString());
			int index=1;
			if(!part.getPart_name().equals("")) st.setString(index++, part.getPart_name());
			if(!part.getPart_size().equals("")) st.setString(index++, part.getPart_size());
			if(part.getPart_price()!=-1) st.setDouble(index++, part.getPart_price());
			if(part.getPart_num()!=-1) st.setInt(index++, part.getPart_num());
			if(!part.getPart_status().equals("")) st.setString(index++, part.getPart_status());
			st.setInt(index++, startPosition);
			st.setInt(index++, pageSize);
			
			rs=st.executeQuery();
			
			while(rs.next()){
				//part_no,part_name,part_size,part_price
				//,part_num,part_warn_num,part_status
				Part pt=new Part(rs.getInt("part_no"),rs.getString("part_name"),
						rs.getString("part_size"),rs.getDouble("part_price"),
						rs.getInt("part_num"),rs.getInt("part_warn_num"),rs.getString("part_status"));
				
				result.add(pt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result=null;
		} finally {
			DBUtil.closeResource(rs, st, con);
		}

		return result;
	}
	
	/**更新part表。以Bean中的part_no属性作为唯一条件（不能为-1）。
	 * 
	 * @param part
	 * @return true成功，false失败。
	 */
	public boolean updatePart(Part part){
		boolean result=false;
		//若未指定主键直接返回false
		if(part.getPart_no()<=-1){
			return false;
		}
		Connection con=null;
		PreparedStatement st=null;
		
		con=DBUtil.getConnection();
		StringBuilder sql=new StringBuilder();
		
		//Auto-renew Part_warn_num column
		if(part.getPart_num()>part.getPart_warn_num()){
			part.setPart_status("正常");
		} else if(part.getPart_num()==part.getPart_warn_num()) {
			part.setPart_status("警戒");
		} else if(part.getPart_num()<part.getPart_warn_num()&&part.getPart_num()!=0){
			part.setPart_status("警示");
		} else if(part.getPart_num()==0){
			part.setPart_status("缺货");
		} else {
			System.out.println("PartDao : part_num<0 when adding!");
		}
		
		sql.append(" update part set part_no=part_no ");
		if(!part.getPart_name().equals("")) sql.append(" , part_name=? ");
		if(!part.getPart_size().equals("")) sql.append(" , part_size=? ");
		if(part.getPart_price()!=-1) sql.append(" , part_price=? ");
		if(part.getPart_num()!=-1) sql.append(" , part_num=? ");
		if(!part.getPart_status().equals("")) sql.append(" , part_status=? ");
		if(part.getPart_warn_num()!=-1)sql.append(" , part_warn_num=? ");
		sql.append(" where part_no=? ");
		System.out.println(sql.toString());
		
		try {
			st=con.prepareStatement(sql.toString());
			
			int index=1;
			index=setSQL(st,part,index);
			if(part.getPart_warn_num()!=-1) st.setInt(index++, part.getPart_warn_num());
			st.setInt(index++, part.getPart_no());
			
			
			
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

	
	
	/**简单增减part表中对应part_no的行的part_num属性。
	 * 
	 * @param part_no 要增减数量的part的主键part_no。
	 * @param part_inc_num 要增减的数量，可为负数。
	 * @return true成功，false失败。
	 * @since 0727
	 */
	public boolean updatePart(int part_no, int part_inc_num){
		boolean result=false;

		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null; //用于自动更新状态列时查询用
		
		
		con=DBUtil.getConnection();
		
		int oldNum=-1;
		try {
			st=con.prepareStatement(" select part_num from part where part_no=? ");
			st.setInt(1, part_no);
			rs=st.executeQuery();
			if(rs.next()){
				oldNum=rs.getInt(1);
			} else {
				result=false;
				System.out.println("PartDao:Invaild Primary Key. ");
			}
			if(oldNum+part_inc_num<0){
				DBUtil.closeResource(rs, st, con);
				System.out.println("PartDao:Insufficent parts. ");
				return false;
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		StringBuilder sql=new StringBuilder();
		sql.append(" update part set part_num = part_num+? ");
		
		
		sql.append(" where part_no=? ");
		//System.out.println(sql.toString());
		
		try {
			st=con.prepareStatement(sql.toString());
			
			
			st.setInt(1, part_inc_num);
			st.setInt(2, part_no);
			
			int r=st.executeUpdate();
			if(r!=0){
				result=true;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			result=false;
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//Auto-renew Part_warn_num column
		String newStatus=null;
		
		try {
			st=con.prepareStatement(" select part_num,part_warn_num from part where part_no=? ");
			st.setInt(1, part_no);
			
			rs=st.executeQuery();
			
			int newNum=0;
			int warnNum=0;
			
			
			
			if(rs.next()){
				newNum=rs.getInt(1);
				warnNum=rs.getInt(2);
			}
			
			if(newNum>warnNum){
				newStatus="正常";
			} else if(newNum==warnNum) {
				newStatus="警戒";
			} else if(newNum<warnNum&&newNum!=0){
				newStatus="警示";
			} else if(newNum==0){
				newStatus="缺货";
			} else {
				System.out.println("PartDao : part_num<0 when adding!");
				throw new SQLException();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {
			st=con.prepareStatement(" update part set part_status = ? where part_no=? ");
			st.setString(1, newStatus);
			st.setInt(2, part_no);
			if(st.executeUpdate()==0) result=false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResource(st, con);
		}
		
		
		return result;
	}
	//SQL
//	private String SQLGen(Part part){
//		StringBuilder sql=new StringBuilder();
//		if(!part.getPart_name().equals("")) sql.append(" and part_name=? ");
//		if(!part.getPart_size().equals("")) sql.append(" and part_size=? ");
//		if(part.getPart_price()!=-1) sql.append(" and part_price=? ");
//		if(part.getPart_num()!=-1) sql.append(" and part_num=? ");
//		if(!part.getPart_status().equals("")) sql.append(" and part_status=? ");
//		
//		return sql.toString();
//	}
	
	//PreparedStatementֵ
	private int setSQL(PreparedStatement st,Part part,int index) throws SQLException{
		if(!part.getPart_name().equals("")) st.setString(index++, part.getPart_name());
		if(!part.getPart_size().equals("")) st.setString(index++, part.getPart_size());
		if(part.getPart_price()!=-1) st.setDouble(index++, part.getPart_price());
		if(part.getPart_num()!=-1) st.setInt(index++, part.getPart_num());
		if(!part.getPart_status().equals("")) st.setString(index++, part.getPart_status());
		
		return index;
	}
}
