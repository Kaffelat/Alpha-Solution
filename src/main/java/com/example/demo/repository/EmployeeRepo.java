package com.example.demo.repository;

import com.example.demo.model.Assignment;
import com.example.demo.model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//Nicolas Benjamin Kristensen
public class EmployeeRepo {
    PreparedStatement state;

    public void insertEmployeeInDB(Employee e) {
        try {
            state = DBManager.getConnection().prepareStatement("INSERT INTO heroku_3b09630b0e3ee46.employee "+" (employeeId,email, employeeName, employeeJob) VALUES " + "(?,?,?,?);");
            state.setInt(1, e.getEmployeeId());
            state.setString(2, e.getEmail());
            state.setString(3, e.getEmployeeName());
            state.setString(4, e.getEmployeeJob());
            state.executeUpdate();
        } catch (Exception ex) {
            System.out.println("couldn't insert the employee into db");
            System.out.println(ex.getMessage());
        }
    }

    public Employee getOneEmployeeFromDB(int Id){
        Employee e = new Employee();
        try {
            state = DBManager.getConnection().prepareStatement("SELECT * FROM heroku_3b09630b0e3ee46.employee WHERE assignment_id =?;");
            state.setInt(1,Id);
            ResultSet rs = state.executeQuery();

            while (rs.next()){
                Id = rs.getInt("Id");
                int employeeId = rs.getInt("employeeId");
                String email = rs.getString("email");
                String employeeName = rs.getString("employeeName");
                String employeeJob = rs.getString("employeeJob");
                System.out.printf("%s, %s, %s, %s\n", employeeId, email, employeeName, employeeJob);

                e = new Employee(employeeId, email, employeeName, employeeJob);
                e.setEmployeeId(Id);
                e.setEmail(email);
                e.setEmployeeName(employeeName);
                e.setEmployeeJob(employeeJob);
            }
            state.close();
        } catch (SQLException ex){
            System.out.println("Wasn't able to get the employee with that Id " + Id + " From the db");
            System.out.println(ex.getMessage());
        }
        return e;
    }

    public List<Employee> getAllEmployeisFromDB(int aID){
        ArrayList<Employee> allEmployeis = new ArrayList<>();
        try {

            state = DBManager.getConnection().prepareStatement("SELECT * FROM heroku_3b09630b0e3ee46.employee where projectid=?");
            state.setInt(1, aID);

            ResultSet rs = state.executeQuery();

            while(rs.next()){
                int employeeId = rs.getInt("employeeId");
                String employeeName = rs.getString("employeeName");
                String employeeEmail= rs.getString("employeeEmail");
                String employeeJob = rs.getString("employeeJob");

                Employee e = new Employee(employeeId,employeeName,employeeEmail,employeeJob);

                allEmployeis.add(e);
            }
        } catch (SQLException ex) {
            System.out.println("Couldn't get the Assignment from database");
            System.out.println(ex.getMessage());
        }
        return allEmployeis;
    }

    public void updateEmployee(Employee e){
        try{
            state = DBManager.getConnection().prepareStatement("UPDATE heroku_3b09630b0e3ee46.employee SET email = ?, employeeName = ?, employeeJob = ? WHERE (employeeId = ?);");
            state.setString(1, e.getEmail());
            state.setString(2, e.getEmployeeName());
            state.setString(3, e.getEmployeeJob());
            state.setInt(4, e.getEmployeeId());
            state.executeUpdate();

        }catch (Exception ex){
            System.out.println("Wasn't able to update employee");
            System.out.printf(ex.getMessage());
        }
    }

    public void deleteEmployeeFromDB(String Id) {
        try {
            state = DBManager.getConnection().prepareStatement
                    ("DELETE FROM heroku_3b09630b0e3ee46.employee WHERE (employeeId = " + Id + ");");
            state.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Couldn't delete the employee with that id: " + Id + " from the db");
            System.out.println(ex.getMessage());
        }

    }
}
