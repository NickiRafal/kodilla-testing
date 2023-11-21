package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CompanyFacadeTest {

    @Autowired
    private CompanyFacade companyFacade;

    @Autowired
    private EmployeeFacade employeeFacade;

    @Autowired
    private CompanyDao companyDao;

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


    }

    @AfterEach
    void cleanup() {
        companyDao.deleteAll();
        System.out.println("Dane zostały usunięte prawidłowo");
    }

    @Test
    void shouldFindCompanyByFragmentOfName() {
        // Given
        String fragment = "ftw";
        // When
        List<Company> companies = companyFacade.findCompanyByFragmentOfName(fragment);
        // Then
        assertEquals(1, companies.size());
    }


    @Test
    void shouldFindEmployeeByFragmentOfLastName() {
        // Given
        String fragment = "Kov";
        // When
        List<Employee> employees = employeeFacade.findEmployeeByFragmentOfLastName(fragment);
        // Then
        assertTrue(employees.size() > 0);
    }
}
