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
 * 矪砞﹚web.xml纔抖穦anotation
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
		
		//砞﹚絪絏
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//砞﹚戈癟
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(htmlTemplate.genHeader(this.getServletName()));
		// 呼ず甧 - start
		// String requestUri = request.getRequestURI();
		
		//眔﹍把计 よ猭1(把计web.xml)
		String iniParammeter = getInitParameter("localParam");
		//眔﹍把计よ猭2(把计anotation)
		String iniParammeter2 = getServletConfig().getInitParameter("javaIniParam");
		//眔办跑计 
		String globleIniParammeter = getServletContext().getInitParameter("globleMsg");
		out.println(iniParammeter+"<br>");
		out.println(iniParammeter2+"<br>");
		out.println(globleIniParammeter);
		// 呼ず甧 - end
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
