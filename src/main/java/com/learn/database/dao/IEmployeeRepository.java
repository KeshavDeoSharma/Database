package com.learn.database.dao;

import com.learn.database.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
   //Employee findEmployeeByAddressesAddressId(Long addressId);
   Optional<Employee> findEmployeeByAddressesAddressId(Long addressId);
}
