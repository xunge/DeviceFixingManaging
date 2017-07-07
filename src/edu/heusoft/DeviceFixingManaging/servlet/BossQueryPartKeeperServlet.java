package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.heusoft.DeviceFixingManaging.dao.PartDao;
import edu.heusoft.DeviceFixingManaging.javabean.Part;

public class BossQueryPartKeeperServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

		//��ȡ��ѯ���
//		String part_no = request.getParameter("part_no");
		String part_name=request.getParameter("part_name");
		String part_size=request.getParameter("part_size");
		String part_price=request.getParameter("part_price");
		String part_num=request.getParameter("part_num");
//		String part_warn_num=request.getParameter("part_warn_num");
		String part_status=request.getParameter("part_status");
		String page=request.getParameter("page");
		
		int a = -1, b = -1, d = -1;
//		if(!part_no.equals(""))
//		{
//			a=Integer.parseInt(part_no);
//		}
		if(!part_num.equals(""))
		{
			b=Integer.parseInt(part_num);
		}
//		if(!part_warn_num.equals(""))
//		{
//			d=Integer.parseInt(part_warn_num);
//		}
		
		
		double c = -1.0;
		if(!part_price.equals(""))
		{
			c = Double.parseDouble(part_price);
		}
		
		
		Part rr = new Part();
		
		rr.setPart_no(a);
		rr.setPart_name(part_name);
		rr.setPart_size(part_size);
		rr.setPart_price(c);
		rr.setPart_num(b);
		rr.setPart_warn_num(d);
		rr.setPart_status(part_status);
		

		
		//�����ҳ չʾ�������
		int totalRows=0;//�ܵ������
		int pageSize=5;//ÿҳ�������
		int pages=0;//��ҳ�� 
		int currentPage=1;//��ǰҳ  Ĭ�ϵĵ�һҳ
		int startPosition=0;//ÿҳ����ʼλ��
		
		
		//����DAO���� ���÷�����ɲ�ѯ�߼�
		PartDao dao=new PartDao();
		totalRows = dao.queryPartTotalRows(rr);
		
		pages=(int)  Math.ceil( totalRows/(double)pageSize );
		
		if(page!=null)
		{
			currentPage=Integer.parseInt(page);
		}

		startPosition=(currentPage-1)*pageSize;
		
		//��ѯ
		ArrayList<Part> result=dao.queryPart(rr,startPosition,pageSize);
		
		//����ѯ����ݷŵ�request�й���
		request.setAttribute("data",result);
		
		//����ҳ��Ϣ�ŵ�request����
		request.setAttribute("pages",pages);
		request.setAttribute("currentPage",currentPage);
		
		
		
		//������ת����QueryResult.jspչʾ��ѯ�����Ϊչʾ�Ƕ�̬��
		//����ת����
		RequestDispatcher dis=request.getRequestDispatcher("/Boss/QueryPart.jsp");
		//ת��
		dis.forward(request, response);
		
	}

}
