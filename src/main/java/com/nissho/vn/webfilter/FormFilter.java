package com.nissho.vn.webfilter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = {"/insert"}, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class FormFilter implements Filter {

    public FormFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
		// place your code here
		String name = (String) request.getParameter("name");
		boolean checkFilter = true;
		
		if(name == null || "".equals(name)) {
			request.setAttribute("validateName", "Tên ko được để trống !");
			checkFilter = false;
		}
		
		try {
			Integer.parseInt(request.getParameter("age"));
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			request.setAttribute("validateAge", "Chưa nhập tuổi hoặc Tuổi phải là số !");
			checkFilter = false;
		}
		
		if(checkFilter) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("/index").forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
