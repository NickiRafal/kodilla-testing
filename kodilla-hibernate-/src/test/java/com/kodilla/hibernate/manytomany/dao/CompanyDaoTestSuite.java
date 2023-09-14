package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeDao employeeDao;

    private int softwareMachineId;
    private int dataMaestersId;
    private int greyMatterId;

    @BeforeEach
    void setup() {

        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);

        softwareMachineId = softwareMachine.getId();
        dataMaestersId = dataMaesters.getId();
        greyMatterId = greyMatter.getId();
    }

    @AfterEach
    void cleanup() {
        companyDao.deleteAll();
        System.out.println("Dane zostały usunięte prawidłowo");
    }

    @Test
    @Transactional
    void testFindCompaniesByNameFragment() {
        //When
        List<Company> companyList1 = companyDao.findUsingNamedNativeQuery("Sof");
        List<Company> companyList2 = companyDao.findUsingNamedNativeQuery("Dat");
        List<Company> companyList3 = companyDao.findUsingNamedNativeQuery("Gre");

        //Then
        assertEquals(1, companyList1.size());
        assertEquals(1, companyList2.size());
        assertEquals(1, companyList3.size());
        assertEquals("Software Machine", companyList1.get(0).getName());
        assertEquals("Data Maesters", companyList2.get(0).getName());
        assertEquals("Grey Matter", companyList3.get(0).getName());
    }

    @Test
    @Transactional
    void testFindEmployeesByLastName() {
        //When
        List<Employee> employeeList1 = employeeDao.findByLastNameQuery("Clarckson");
        List<Employee> employeeList2 = employeeDao.findByLastNameQuery("Kovalsky");
        List<Employee> employeeList3 = employeeDao.findByLastNameQuery("Smith");


        //Then
        assertEquals(1, employeeList1.size());
        assertEquals(1, employeeList2.size());
        assertEquals(1, employeeList3.size());
        assertEquals("Clarckson", employeeList1.get(0).getLastName());
        assertEquals("Kovalsky",employeeList2.get(0).getLastName());
        assertEquals("Smith",employeeList3.get(0).getLastName());
    }
}
