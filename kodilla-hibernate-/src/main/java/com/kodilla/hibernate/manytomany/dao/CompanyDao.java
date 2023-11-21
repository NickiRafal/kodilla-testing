package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository< Company, Integer> {
    //List<Company> findByFirstThreeCharacters(@Param("startsWith") String startsWith); // Metoda dla porównania z named native query

    @Query(nativeQuery = true, name = "Company.findByFirstThreeCharacters")
   List<Company> findUsingNamedNativeQuery(@Param("startsWith") String startsWith);

    @Query("SELECT e FROM Company e WHERE e.name LIKE %:fragment%")
    List<Company> findByNameCompanyFragment(@Param("fragment") String fragment);
}
