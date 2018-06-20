package com.wavelabs.hib.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
@Entity
public class Employee {
	@Id
	int empid;
	String ename;
	double salary;
	@Column(name="depno")
	int deptno;
	public Employee() {}
	public Employee(int empid, String ename, double salary, int deptno) {
		this.empid = empid;
		this.ename = ename;
		this.salary = salary;
		this.deptno = deptno;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
