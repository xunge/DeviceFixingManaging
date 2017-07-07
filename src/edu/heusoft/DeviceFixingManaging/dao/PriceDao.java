//xunzhi
package edu.heusoft.DeviceFixingManaging.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.heusoft.DeviceFixingManaging.common.DBUtil;
import edu.heusoft.DeviceFixingManaging.javabean.Price;


public class PriceDao {
	
	public boolean addPrice(Price price)
	{
		boolean result=true;
		
		Connection con=null;
		PreparedStatement st=null;
		con=DBUtil.getConnection();
		try {
			st=con.prepareStatement("insert into "
					+ "price(price_time,price) "
					+ "values(?,?)");
			
			
			java.sql.Date d=new java.sql.Date(price.getPrice_time().getTime());	
			
			st.setDate(1, d);
			st.setDouble(2, price.getPrice());
			
			int i=st.executeUpdate();
			if(i<1)
			{
				result=false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result=false;
			e.printStackTrace();
		}	
		return result;
	}

	public ArrayList<Price> queryPrice(Price price,int start,int size)
	{
		ArrayList<Price> result=new ArrayList<Price>();
		
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUtil.getConnection();
		
		try {
			StringBuilder sql=new StringBuilder();
			sql.append(" select * from price where 1=1 ");

			if(price.getPrice_no()!=-1)
			{
				sql.append("and price_no=?");
			}

			if(price.getPrice()!=-1)
			{
				sql.append("and price=?");
			}
			
			sql.append(" limit ?,? ");

			st=con.prepareStatement(sql.toString());
			int index=1;
			if(price.getPrice_no()!=-1)
			{
				st.setInt(index++,price.getPrice_no());
			}

			if(price.getPrice()!=-1)
			{
				st.setDouble(index++,price.getPrice());
			}
			st.setInt(index++, start);
			st.setInt(index++, size);

			rs=st.executeQuery();

			while(rs.next())
			{
				Price price1=new Price();
				price1.setPrice_no(rs.getInt("price_no"));
				price1.setPrice_time(rs.getDate("price_time"));
				price1.setPrice(rs.getDouble("price"));

				result.add(price1);
			}    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			//DBUtil.closeResource(rs, st,con);
		}
		return result;
	}
	
	
	

	public int queryPriceTotalRows(Price price)
	{
		int result=0;
		
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUtil.getConnection();
		
		try {
			StringBuilder sql=new StringBuilder();
			sql.append(" select count(*) from price where 1=1 ");

			if(price.getPrice_no()!=-1)
			{
				sql.append("and price_no=?");
			}

			if(price.getPrice()!=-1)
			{
				sql.append("and price=?");
			}


			st=con.prepareStatement(sql.toString());
			int index=1;

			if(price.getPrice_no()!=-1)
			{
				st.setInt(index++,price.getPrice_no());
			}

			if(price.getPrice()!=-1)
			{
				st.setDouble(index++,price.getPrice());
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
}
