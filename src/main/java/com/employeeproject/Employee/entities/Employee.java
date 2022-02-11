package com.employeeproject.Employee.entities;

public class Employee {

	private String empName;
	// Must be a uniqueId
	private Integer empId;
	// Should be between 0-260 & no negative digits
	private Integer totalWorkDays;

	// 0: Hourly 1: salaried 2: manager
	private Integer empType;
	
	private Integer leaveBalance; 

	public Employee(String empName, Integer empId, Integer totalWorkDays, Integer empType, Integer leaveBalance) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.totalWorkDays = totalWorkDays;
		this.empType = empType;
		this.leaveBalance=leaveBalance;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Integer getTotalWorkDays() {
		return totalWorkDays;
	}

	public void setTotalWorkDays(Integer totalWorkDays) {
		this.totalWorkDays = totalWorkDays;
	}

	public Integer getEmpType() {
		return empType;
	}

	public void setEmpType(Integer empType) {
		this.empType = empType;
	}

	public Integer getLeaveBalance() {
		return leaveBalance;
	}

	public void setLeaveBalance(Integer leaveBalance) {
		this.leaveBalance = leaveBalance;
	}


}
