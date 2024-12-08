package com.learn.database.service;

import com.learn.database.Entity.Address;
import com.learn.database.Entity.Employee;
import com.learn.database.dao.IEmployeeRepository;
import com.learn.database.util.LogExecutionTime;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;

    @PostConstruct
    public void init() {
        Employee employee = new Employee();
        employee.setEmployeeId(1L);
        employee.setName("keshav");

        Address ad1 = new Address();
        ad1.setAddressId(1L);
        ad1.setCity("Kol");
        ad1.setCountry("India");
        ad1.setEmployee(employee);

        Address ad2 = new Address();
        ad2.setAddressId(2L);
        ad2.setCity("Pune");
        ad2.setCountry("India");
        ad2.setEmployee(employee);

        ArrayList<Address> objects = new ArrayList<>();
        objects.add(ad1);
        objects.add(ad2);
        employee.setAddresses(objects);
        employeeRepository.save(employee);
    }
    @LogExecutionTime()
    public List<Employee> getEmployees(){
     //return employeeRepository.findAll();
        return null;
    }

    @LogExecutionTime
    public void deleteAddress(Address address) {
        Employee employee = employeeRepository.findEmployeeByAddressesAddressId(address.getAddressId()).get();
        employee.getAddresses().remove(address);
        employeeRepository.save(employee);
    }
}
