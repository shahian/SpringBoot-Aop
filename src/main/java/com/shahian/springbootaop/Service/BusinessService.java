package com.shahian.springbootaop.Service;

import com.shahian.springbootaop.Model.Employee;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BusinessService {
    public void saveEmployee(){
        System.out.println("From Save Employee");
        if (new Random().nextInt(15)<10){
            throw new RuntimeException("Exception occured...");
        }
    }
    public String helloEmployye(){
        return "From helloEmployye";
    }
    public void testMethodforAroundAdvice() {
        System.out.println("Business Method is getting Executed !");
    }
    public Employee createEmployee(String name, String empId) {

        Employee emp = new Employee();
        emp.setName(name);
        emp.setEmpId(empId);
        return emp;
    }

    public void deleteEmployee(String empId) {
        System.out.println("deleteEmployee Method  !");

    }

}
