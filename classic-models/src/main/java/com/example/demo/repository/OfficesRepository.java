package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Offices;

@Repository
public interface OfficesRepository extends JpaRepository<Offices, Integer> {
	@Modifying
	@Transactional
	@Query(value = "update offices o inner join employees e on o.office_code = e.office_code\r\n"
			+ "set o.address_line2 = ?, e.email = ? where e.office_code = 6;;", nativeQuery = true)
	public Integer updateCustomerAddressEmail(String address, String email);
}
