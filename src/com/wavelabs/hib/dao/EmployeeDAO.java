package com.wavelabs.hib.dao;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.wavelabs.hib.entity.Employee;
import java.util.List;

public class EmployeeDAO {
	Configuration config = null;
	SessionFactory factory = null;
	public EmployeeDAO()
	{
		config = new Configuration();
		config.configure();
		this.factory = config.buildSessionFactory();
	}
	public boolean createEmployee(Employee emp)
	{
		Session session = null;
		Transaction trans = null;
		int id = 0;
		try
		{
			session = factory.openSession();
			trans = session.beginTransaction();
			id = (Integer)session.save(emp);
			trans.commit();
		}catch(HibernateException he)
		{
			he.printStackTrace();
			trans.rollback();
		}finally {
			if(session!=null)
				session.close();
		}
		return(id!=0);

	}
	public void finalize()
	{
		factory.close();
	}
	public List<Employee> getAllEmployees()
	{
		Session session = null;
		Transaction trans = null;
		
		List<Employee> elist = null;
		try
		{
			session = factory.openSession();
			SQLQuery qry = session.createSQLQuery("select * from employee");
			qry.addEntity(Employee.class);
			elist = qry.list();
		}catch(HibernateException he)
		{
			he.printStackTrace();
			
		}finally {
			if(session!=null)
				session.close();
		}
		return elist;
	}
	
	/*public Employee getEmployeeDetails(String userName)
	{
		Employee emp = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			con = DBConnect.getConnection();
			
			pst = con.prepareStatement("select empid, ename, salary, depno from employee where "
					+ "username=?");
			pst.setString(1,userName);
			rs = pst.executeQuery();
			if(rs.next())
			{
				emp = new Employee();
				emp.setEmpid(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setSalary(rs.getDouble(3));
				emp.setDeptno(rs.getInt(4));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			DBConnect.closeResultSet(rs);
			DBConnect.closeStatement(pst);
			DBConnect.closeConnection(con);
		}
		return emp;
	}*/
}
