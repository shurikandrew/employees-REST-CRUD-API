package com.shurikandrew.CRUDdemo.service;

import com.shurikandrew.CRUDdemo.dao.EmployeeRepository;
import com.shurikandrew.CRUDdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee emp;

        if(result.isPresent())
            emp = result.get();
        else
            throw new RuntimeException("Did not find an employee with id - " + id);

        return emp;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
