package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.EmployeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeFacade {

    private final EmployeDao employeDao;

    @Autowired
    public EmployeeFacade(EmployeDao employeeDao) {
        this.employeDao = employeeDao;
    }

    public List<Employee> findEmployeeByFragmentOfLastName(String fragment) {
        return employeDao.findByLastNameFragment(fragment);
    }
}
