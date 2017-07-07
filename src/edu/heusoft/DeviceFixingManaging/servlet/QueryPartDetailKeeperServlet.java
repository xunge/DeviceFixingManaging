// gongyuxin
package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.dao.PartDetailDao;
import edu.heusoft.DeviceFixingManaging.javabean.PartDetail;

public class QueryPartDetailKeeperServlet extends HttpServlet {
	/**
	 * This method is called when the store keeper want to query the part_detail in database.
	 * the store keeper can query all data from the part_detail.
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//��ȡ��ѯ���
//		String part_detail_no = request.getParameter("part_detail_no");
//		String part_no=request.getParameter("part_no");
//		String repair_record_no=request.getParameter("repair_record_no");
//		String part_detail_num=request.getParameter("part_detail_num");
		String part_detail_status=request.getParameter("part_detail_status");
		String page=request.getParameter("page");
		
		int a = -1,b = -1,c = -1, d = -1; 
//		if(!part_detail_no.equals(""))
//		{
//			a=Integer.parseInt(part_detail_no);
//		}
//		if(!part_no.equals(""))
//		{
//			b=Integer.parseInt(part_no);
//		}
//		if(!repair_record_no.equals(""))
//		{
//			c=Integer.parseInt(repair_record_no);
//		}
//		if(!part_detail_num.equals(""))
//		{
//			d=Integer.parseInt(part_detail_num);
//		}
		
		PartDetail pd = new PartDetail();
		
    	pd.setPart_detail_no(a);
     	pd.setPart_no(b);
     	pd.setRepair_record_no(c);
     	pd.setPart_detail_num(d);
     	pd.setPart_detail_status(part_detail_status);
     	pd.setPart_detail_status("未出库");

		
		//�����ҳ չʾ�������
		int totalRows=0;//�ܵ������
		int pageSize=5;//ÿҳ�������
		int pages=0;//��ҳ�� 
		int currentPage=1;//��ǰҳ  Ĭ�ϵĵ�һҳ
		int startPosition=0;//ÿҳ����ʼλ��
		
		
		//����DAO���� ���÷�����ɲ�ѯ�߼�
		PartDetailDao dao=new PartDetailDao();
		totalRows = dao.queryPartDetailTotalRows(pd);
		
		pages=(int)  Math.ceil( totalRows/(double)pageSize );
		
		if(page!=null)
		{
			currentPage=Integer.parseInt(page);
		}

		startPosition=(currentPage-1)*pageSize;
		
		//��ѯ
		ArrayList<PartDetail> result=dao.queryPartDetail(pd,startPosition,pageSize);
		
		//����ѯ����ݷŵ�request�й���
		request.setAttribute("data",result);
		
		//����ҳ��Ϣ�ŵ�request����
		request.setAttribute("pages",pages);
		request.setAttribute("currentPage",currentPage);
		
		
		
		//������ת����QueryResult.jspչʾ��ѯ�����Ϊչʾ�Ƕ�̬��
		//����ת����
		RequestDispatcher dis=request.getRequestDispatcher("/Keeper/QueryPartDetail.jsp");
		//ת��
		dis.forward(request, response);
		
	}

}
