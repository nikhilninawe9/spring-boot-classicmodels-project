package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

	@Transactional
	@Query(value = "select * from employees where employee_number=?", nativeQuery = true)
	public Employees getEmpByNumber(Integer eNum);

	@Modifying
	@Transactional
	@Query(value = "update employees set first_name=?, last_name=? where employee_number=?", nativeQuery = true)
	public Integer updateEmp(String firstname, String lastname, Integer eNum);

}
