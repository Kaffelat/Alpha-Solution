package com.example.demo.model;

public class Employee {
    private int employeeId;
    private String email;
    private String employeeName;
    private String employeeJob;

    public Employee(int employeeId, String email, String employeeName, String employeeJob){
        this.employeeId = employeeId;
        this.email = email;
        this.employeeName = employeeName;
        this.employeeJob = employeeJob;
    }
    public int getEmployeeId(){
        return employeeId;
    }
    public String getEmail(){
        return email;
    }
    public String getEmployeeName(){
        return employeeName;
    }
    public String getEmployeeJob(){ return employeeJob;}

    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public void setEmployeeJob(String employeeJob) {
        this.employeeJob = employeeJob;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", email='" + email + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeeJob='" + employeeJob + '\'' +
                '}';
    }
}
