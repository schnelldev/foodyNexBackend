package com.fm.app.components;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
public class CustomFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		  ((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin", "*");
	      ((HttpServletResponse) response).addHeader("Access-Control-Allow-Methods","*");
	      ((HttpServletResponse) response).addHeader("Access-Control-Request-Method","*");
	      ((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers","*");
	      ((HttpServletResponse) response).addHeader("Access-Control-Request-Headers","*");
	      
	        if (((HttpServletRequest)request).getMethod().equals("OPTIONS")) {
	             ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_OK);
	            return;
	        }
		chain.doFilter(request, response);
	}


}
