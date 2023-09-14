package com.kodilla.hibernate.manytomany;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@NamedQuery(
        name = "Employee.findByLastNameQuery",
        query = "FROM Employee WHERE lastName = :lastName"
)
@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    private int id;
    private String firstname;
    private String lastName;
    private List <Company> companies = new ArrayList<>();

    public Employee() {
    }

    public Employee(String firstname, String lastName) {
        this.firstname = firstname;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "EMPLOYEE_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "FIRSTNAME")
    public String getFirstname() {
        return firstname;
    }

    @NotNull
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_COMPANY_EMPLOYEE",
            joinColumns = {@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID")}
    )
    public List<Company> getCompanies() {
        return companies;
    }
    private void setCompanies(List<Company> companies) {
        this.companies = companies;
    }


}
