package samplePack.filter;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 加強板的Serverlet
 * @author user
 *
 */
public class SampleFilter implements Filter {
	FilterConfig filterConfig;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//因為如果是當成中控的Controler使用, 那就可以直接在這邊指定所有的共用設定
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			//取出web.xml內設定的變數, 取出帳號跟密碼
			String account = filterConfig.getInitParameter("account");
			String password = filterConfig.getInitParameter("password");
			String inputAccount = request.getParameter("account");
			String inputPassword = request.getParameter("password");
			if(account.equals(inputAccount) && password.equals(inputPassword)){
				//當對的時候則繼續往下走(正常流程)
				chain.doFilter(request, response);
			}else {
				//當帳號密碼錯誤的時候導向不同的page
				request.getRequestDispatcher("FilterSampleLoginfail.jsp").forward(request, response);
			}

		}catch (Exception e){
			//可以設定當有Exception 轉到自訂的錯誤頁面
			String errorMsg = e.getMessage()+" from Server.";
			request.setAttribute("errorMsg", errorMsg);
			request.getRequestDispatcher("FilterSampleServerError.jsp").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

}
