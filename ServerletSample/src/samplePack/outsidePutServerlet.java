package samplePack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class outsidePut
 * ���B���]�wweb.xml���u�����Ƿ|�j��anotation
 */
@WebServlet(
		name="outsidePutServerlet",
		urlPatterns = { "/OutsidePutServerlet" }, 
		initParams = {
		@WebInitParam(name = "javaIniParam", value = "this is a default value from .java")
})
public class outsidePutServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public outsidePutServerlet() {
        super();
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
		// String requestUri = request.getRequestURI();
		
		//���o��l�Ѽ� ��k1(���ѼƦbweb.xml)
		String iniParammeter = getInitParameter("localParam");
		//���o��l�ѼƤ�k2(���ѼƦbanotation)
		String iniParammeter2 = getServletConfig().getInitParameter("javaIniParam");
		//���o�����ܼ� 
		String globleIniParammeter = getServletContext().getInitParameter("globleMsg");
		out.println(iniParammeter+"<br>");
		out.println(iniParammeter2+"<br>");
		out.println(globleIniParammeter);
		// �������e - end
		out.println(htmlTemplate.genfonter());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
