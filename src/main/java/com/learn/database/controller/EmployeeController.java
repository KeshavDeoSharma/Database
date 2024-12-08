package com.learn.database.controller;

import com.learn.database.Entity.Address;
import com.learn.database.Entity.Employee;
import com.learn.database.dao.IAddressRepository;
import com.learn.database.dao.IEmployeeRepository;
import com.learn.database.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    private IAddressRepository addressRepository;




    @GetMapping("/getEmployees")
    public List<Employee> getAllEmployee() {
        return employeeService.getEmployees();
    }

    @GetMapping("/getAddress")
    public List<Address> getAllAddress() {
        List<Address> address = addressRepository.findAll();
        return address;
    }

    @DeleteMapping("/deleteAddressById/{addressId}")
    public void deleteAddressById(@PathVariable("addressId") Long addressId) {
        Address address =  addressRepository.getReferenceById(addressId);
        employeeService.deleteAddress(address);
    }

}
