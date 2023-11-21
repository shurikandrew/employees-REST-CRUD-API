package com.shurikandrew.CRUDdemo.dao;

import com.shurikandrew.CRUDdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
