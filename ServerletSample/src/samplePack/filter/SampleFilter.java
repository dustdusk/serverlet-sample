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
 * �[�j�O��Serverlet
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
		//�]���p�G�O��������Controler�ϥ�, ���N�i�H�����b�o����w�Ҧ����@�γ]�w
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			//���Xweb.xml���]�w���ܼ�, ���X�b����K�X
			String account = filterConfig.getInitParameter("account");
			String password = filterConfig.getInitParameter("password");
			String inputAccount = request.getParameter("account");
			String inputPassword = request.getParameter("password");
			if(account.equals(inputAccount) && password.equals(inputPassword)){
				//��諸�ɭԫh�~�򩹤U��(���`�y�{)
				chain.doFilter(request, response);
			}else {
				//��b���K�X���~���ɭԾɦV���P��page
				request.getRequestDispatcher("FilterSampleLoginfail.jsp").forward(request, response);
			}

		}catch (Exception e){
			//�i�H�]�w��Exception ���ۭq�����~����
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
