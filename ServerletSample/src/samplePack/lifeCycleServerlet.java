package samplePack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class lifeCycleServerlet
 */
@WebServlet(
		name="lifeCycleServerlet",
		urlPatterns = {"/lifeCycleServerlet"},
		loadOnStartup=0
)
public class lifeCycleServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lifeCycleServerlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// ���JContainer��|�I�s�@��
    	super.init();
    }
    
    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
    		throws ServletException, IOException {
    	// ��C�@��request �o�� Serverlet, �L��get �٬Opost ���|���
    	super.service(arg0, arg1);
    }
    
    @Override
    public void destroy() {
    	// ��Container �����e�|�I�s�@��
    	super.destroy();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
