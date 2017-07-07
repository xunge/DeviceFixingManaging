//SLIAN
//��ַδ�� �ݲ��ϴ�
package edu.heusoft.DeviceFixingManaging.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.heusoft.DeviceFixingManaging.dao.StaffDao;
import edu.heusoft.DeviceFixingManaging.javabean.Staff;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3631455116059749047L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		Staff sf=new Staff();
		sf.setStaffName(name);
		sf.setStaffPassword(pwd);
		
		StaffDao dao=new StaffDao();
		Staff bean=dao.login(sf);
		String result=null;
		if(bean!=null) {
			result=bean.getStaffCharacter();
		}
		String url=null;
		if(result!=null){
			if(result.equals("客服")){
				url="/index/ServiceIndex.jsp";
			}else if(result.equals("任务调度")){
				url="/index/TaskIndex.jsp";
			}else if(result.equals("技术工程师")){
				url="/index/EngineerIndex.jsp";
			}else if(result.equals("库管")){
				url="/index/KeeperIndex.jsp";
			}else if(result.equals("运营监督")){
				url="/index/BossIndex.jsp";
			}else if(result.equals("财务")){
				url="/index/FinanceIndex.jsp";
			}else if(result.equals("Timer")){
				url="/login.html";         //placeholder
			}else {
				url="/login.html";
			}
			
			//将登陆信息放在session中
			HttpSession session=request.getSession();
			session.setAttribute("loginInfo", name); 
			session.setAttribute("loginType", result);
			if(bean!=null){
				session.setAttribute("loginNo", bean.getStaffNo());
			}
		}else{
			url="/login.html";
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
