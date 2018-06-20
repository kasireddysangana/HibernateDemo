import com.wavelabs.hib.entity.Employee;
import com.wavelabs.hib.dao.EmployeeDAO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int empid = Integer.parseInt(request.getParameter("empid"));
		String ename = request.getParameter("ename");
		double salary = Double.parseDouble(request.getParameter("salary"));
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		Employee emp = new Employee(empid,ename,salary,deptno);
		
		if(new EmployeeDAO().createEmployee(emp))
			out.print("Employee Record Saved Successfully");
		else
			out.print("Sorry Record Could not be Saved");
		
	}
}
