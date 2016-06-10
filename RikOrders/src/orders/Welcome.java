package orders;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class Welcome extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public Welcome() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String name = req.getParameter("name");
		
		
		if(name == null || name.equals(""))
			name = "Your name goes here";
		

        req.setAttribute("message", name); // This will be available as ${message}
        //req.getRequestDispatcher("index.jsp").forward(req, resp);
        req.getRequestDispatcher("form.jsp").forward(req, resp);
        

        
        DBController dbc = new DBController("michael", "1234");
        
        if(name.equals("test")){
			try {
				dbc.select();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        dbc.close();
        
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String name = req.getParameter("firstName");
			String lName = req.getParameter("lastname");
			
			System.out.println(name + "    " + lName);
			
			DBController dbc = new DBController("michael", "1234");
			dbc.insert();
			
			dbc.close();
	}

}
