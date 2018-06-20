import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import com.wavelabs.hib.dao.EmployeeDAO;
import com.wavelabs.hib.entity.Employee;
import javax.servlet.ServletException;
import java.io.PrintWriter;
@WebServlet("/ShowEmployeeServlet")
public class ShowEmployeeServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		List<Employee> elist = new EmployeeDAO().getAllEmployees();
		request.setAttribute("elist", elist);
		request.getRequestDispatcher("DisplayEmployees.jsp").forward(request, response);
	}
}
