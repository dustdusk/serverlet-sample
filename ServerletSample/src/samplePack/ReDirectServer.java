package samplePack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class reDirectServer
 */
@WebServlet("/ReDirectServer")
public class ReDirectServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReDirectServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HtmlTemplate htmlTemplate = new HtmlTemplate();
		//設定編碼
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//設定頁面資訊
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(htmlTemplate.genHeader(this.getServletName()));
		// 網頁內容 - start
		out.println(request.getParameter("inputGet"));
		// 網頁內容 - end
		out.println(htmlTemplate.genfonter());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HtmlTemplate htmlTemplate = new HtmlTemplate();
		//設定編碼
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//設定頁面資訊
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(htmlTemplate.genHeader(this.getServletName()));
		// 網頁內容 - start
		out.println(request.getParameter("input"));
		// 網頁內容 - end
		out.println(htmlTemplate.genfonter());
		out.flush();
		out.close();
	}
	
}
