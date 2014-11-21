package samplePack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HellowWorld
 */
//��annotation���覡�]�w
@WebServlet("/FirstServerlet")
public class HellowWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HellowWorld() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HtmlTemplate htmlTemplate = new HtmlTemplate();
		
		//�]�w�s�X
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//�]�w������T
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(htmlTemplate.genHeader(this.getServletName()));
		// �������e - start
		String requestUri = request.getRequestURI();
		out.println("Hello World from frisrt servlet");
		out.println("<form action='" + requestUri + "' method='post'>");
		out.println("<input type='text' name='name' />");
		out.println("<input type='submit' value='submit' />");
		// �������e - end
		out.println(htmlTemplate.genfonter());
		out.flush();
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HtmlTemplate htmlTemplate = new HtmlTemplate();
		
		//�]�w�s�X
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//�]�w������T
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(htmlTemplate.genHeader(this.getServletName()));
		// �������e - start
		// ��ϥΨ�����r�ɦ۰ʾɭ���
		String name = (String) request.getParameter("name");
		if("Hidden".equals(name)){
			//��forward �~����Dweb-inf�U���F��
			request.getRequestDispatcher("/WEB-INF/hiddenPage.html").forward(request, response);
			return;
		} else if("hidden".equals(name)){
			//��forward �~����Dweb-inf�U���F��
			response.sendRedirect("hiddenPageFake.html");
			return;
		}else {
			//globle ��l�Ѽ�
			String iniParammeter = getServletContext().getInitParameter("globleMsg");
			out.println("Globle Message : "+iniParammeter+"<br>");
			out.println("the word you key in is "+name);
			out.println("It is not the right word for enter some secret page.");
		}
		// �������e - end
		out.println(htmlTemplate.genfonter());
		out.flush();
		out.close();
	}
}
