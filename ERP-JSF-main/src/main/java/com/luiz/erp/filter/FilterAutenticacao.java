package com.luiz.erp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.luiz.erp.util.JPAUtil;

@WebFilter(urlPatterns = {"/*"})
public class FilterAutenticacao  implements Filter{
	
	@Override
	public void destroy() {		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		System.out.println("Invocando filter...");
		chain.doFilter(request, response);
		
		
	}
	
	@Override 
	public void init(FilterConfig args0) throws ServletException{
		JPAUtil.getEntityManager();
	}

}
