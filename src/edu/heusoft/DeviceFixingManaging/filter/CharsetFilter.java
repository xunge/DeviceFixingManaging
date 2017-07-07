package edu.heusoft.DeviceFixingManaging.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharsetFilter implements Filter {

	public void init(FilterConfig arg0) throws ServletException {
		
		
	}
	

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//·Ö¸îÏß
		chain.doFilter(request, response);
		
		
	}

	public void destroy() {
		
		
	}
	
}
