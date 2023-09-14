package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public interface EmployeDao extends CrudRepository <Employee , Integer> {
    List<Employee>findByLastName(String lastName);
    @Query
    List<Employee> findByLastNameQuery(String lastName);
}
