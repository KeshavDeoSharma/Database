
package com.learn.database;

import com.learn.database.Entity.Address;
import com.learn.database.Entity.Employee;
import com.learn.database.controller.EmployeeController;
import com.learn.database.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    EmployeeController employeeController;
    @MockBean
    EmployeeService employeeService;


    @Test
    public void getEmployeeTest(){
        List<Employee> emps = getEmployees();
        Mockito.when(employeeService.getEmployees()).thenReturn(emps);
        List<Employee> employees = employeeController.getAllEmployee();
        Assert.assertFalse(employees.isEmpty());
    }

    private static List<Employee> getEmployees() {
        System.out.println("Hello Test java");
        List<Employee> emps =  new ArrayList<>();
        Employee emp = new Employee();
        emp.setEmployeeId(1L);
        emp.setName("dummyName");
        Address add = new Address(1L,"dummy", "dummyCountry", emp);
        emp.setAddresses(new ArrayList<>(Arrays.asList(add)));
        emps.add(emp);
        return emps;
    }
}

